package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modl.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
