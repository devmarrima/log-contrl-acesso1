package com.devmarrima.log_contrl_acesso1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmarrima.log_contrl_acesso1.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
