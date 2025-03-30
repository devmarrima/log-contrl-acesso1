package com.devmarrima.log_contrl_acesso1.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devmarrima.log_contrl_acesso1.entities.Role;
import com.devmarrima.log_contrl_acesso1.entities.User;
import com.devmarrima.log_contrl_acesso1.projections.UserDetailsProjection;
import com.devmarrima.log_contrl_acesso1.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> projections = userRepository.findByEmail(username);
        if (projections.size() == 0) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = new User();
        user.setEmail(username);
        user.setPassword(projections.get(0).getPassword());
        for (UserDetailsProjection list : projections) {
            user.addRole(new Role(list.getRoleId(), list.getAuthority()));

        }
        return user;
    }
}
