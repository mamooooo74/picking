package com.example.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.model.Product;
import com.example.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
	private final ProductRepository repository;

	@Override
	public void run(String... args) throws Exception {
		Product product;
		Map<String, Integer> nameMap = getNameMap();
		for(String name : getNameMap().keySet()) {
			product = new Product();
			product.setName(name);
			product.setColor(nameMap.get(name));
			repository.save(product);
		}
	}

	private Map<String, Integer> getNameMap(){
		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		nameMap.put("S1977-1987688",0);
		nameMap.put("S1977-1987777",0);
		nameMap.put("B2004-0000765",0);
		nameMap.put("B4098-9045911",0);
		nameMap.put("B4098-9045002",0);
		nameMap.put("N2014-0305011",0);
		nameMap.put("W5002-4658856",0);
		nameMap.put("B2004-0000897",0);
		nameMap.put("A1999-9042986",1);
		nameMap.put("B2004-0000222",1);
		nameMap.put("Z1977-9040053",1);
		nameMap.put("B4098-9045564",1);
		nameMap.put("Z1977-9046541",1);
		nameMap.put("N1982-9042322",1);
		nameMap.put("A1999-9042777",1);
		nameMap.put("A1977-1987000",1);
		nameMap.put("W5002-4658822",2);
		nameMap.put("A1977-1987022",2);
		nameMap.put("A1999-9042339",2);
		nameMap.put("N1982-9042339",2);
		nameMap.put("N2014-0305001",2);
		nameMap.put("B4098-9045753",2);
		nameMap.put("N2014-0305556",2);
		nameMap.put("N1982-9042777",2);
		nameMap.put("A1999-9045332",3);
		nameMap.put("Z1977-9049006",3);
		nameMap.put("B2004-0000429",3);
		nameMap.put("N2014-0305044",3);
		nameMap.put("Z1977-9044443",3);
		nameMap.put("N1982-9042986",3);
		nameMap.put("W5002-4651110",3);
		nameMap.put("W5002-4658806",3);
		return nameMap;
	}

}
