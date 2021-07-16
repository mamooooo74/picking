package com.example.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.modl.Product;
import com.example.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
	private final ProductRepository repository;

	@Override
	public void run(String... args) throws Exception {
		Product product;
		for(int i = 1; i < 9; i++) {
			product  = new Product();
			product.setName("A-" + i *1111 + "-" + i * 1111);
			repository.save(product);
			product  = new Product();
			product.setName("Z-" + i *1111 + "-" + i * 1111);
			repository.save(product);
			product  = new Product();
			product.setName("F-" + i *1111 + "-" + i * 1111);
			repository.save(product);
		}
	}

}
