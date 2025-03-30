package com.devmarrima.log_contrl_acesso1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LogContrlAcesso1Application implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(LogContrlAcesso1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ENCODE: " + passwordEncoder.encode("123456"));
Boolean r = passwordEncoder.matches("12345621", "$2a$10$MSqCmBMX1lb2GsGwxdr90OXbaFfOn6WbvKgICm56.iJl2Q5ufs4za");
System.out.println(r);
	}

}
