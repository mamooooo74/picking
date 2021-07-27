package com.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.modl.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(value="SELECT * FROM PRODUCT ORDER BY RAND() LIMIT 6",  nativeQuery = true)
	List<Product> getRandomSix();
}
