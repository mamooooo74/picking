package com.example.config;

import java.util.ArrayList;
import java.util.List;

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
		List<String> nameList = getNameList();
		Product product;
		for(String name : nameList) {
			product = new Product();
			product.setName(name);
			repository.save(product);
		}
	}

	private List<String> getNameList(){
		List<String> nameList = new ArrayList<String>();
		nameList.add("S1977-1987688");
		nameList.add("S1977-1987777");
		nameList.add("B2004-0000765");
		nameList.add("B4098-9045911");
		nameList.add("B4098-9045002");
		nameList.add("N2014-0305011");
		nameList.add("W5002-4658856");
		nameList.add("B2004-0000897");
		nameList.add("A1999-9042986");
		nameList.add("B2004-0000222");
		nameList.add("Z1977-9040053");
		nameList.add("B4098-9045564");
		nameList.add("Z1977-9046541");
		nameList.add("N1982-9042322");
		nameList.add("A1999-9042777");
		nameList.add("A1977-1987000");
		nameList.add("W5002-4658822");
		nameList.add("A1977-1987022");
		nameList.add("A1999-9042339");
		nameList.add("N1982-9042339");
		nameList.add("N2014-0305001");
		nameList.add("B4098-9045753");
		nameList.add("N2014-0305556");
		nameList.add("N1982-9042777");
		nameList.add("A1999-9045332");
		nameList.add("Z1977-9049006");
		nameList.add("B2004-0000429");
		nameList.add("N2014-0305044");
		nameList.add("Z1977-9044443");
		nameList.add("N1982-9042986");
		nameList.add("W5002-4651110");
		nameList.add("W5002-4658806");
		return nameList;
	}

}
