package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class DataLoader{
	private static DataLoader loader = new DataLoader();
	
	private DataLoader() {
	}
	public static DataLoader getInstance() {
		return loader;
	}

	public List<Product> GetRandomsix() {
		List<Product> producttList  = getProductList();
		Collections.shuffle(producttList);
		producttList = producttList.subList(0, 6);

		return producttList;
	}
	public Map<Product, Integer> getProductsMap(List<Integer> random){
		Map<Product, Integer> productMap = new HashMap<>();
		List<Product> products = GetRandomsix();
		for(int i = 0; i < 6; i++) {
			productMap.put(products.get(i),random.get(i)) ;
		}
		return productMap;
	}


	public List<Integer> randomnNumbers(){
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			if(i == 0) {
				result.add(3);
			}else if(i < 5) {
				result.add(2);
			}else {
				result.add(1);
			}
		}
		Collections.shuffle(result);
		result = result.subList(0, 6);
		return result;
	}
	
	
	private List<Product> getProductList(){
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("S1977-1987688",0));
		productList.add(new Product("S1977-1987777",0));
		productList.add(new Product("B2004-0000765",0));
		productList.add(new Product("B4098-9045911",0));
		productList.add(new Product("B4098-9045002",0));
		productList.add(new Product("N2014-0305011",0));
		productList.add(new Product("W5002-4658856",0));
		productList.add(new Product("B2004-0000897",0));
		productList.add(new Product("A1999-9042986",1));
		productList.add(new Product("B2004-0000222",1));
		productList.add(new Product("Z1977-9040053",1));
		productList.add(new Product("B4098-9045564",1));
		productList.add(new Product("Z1977-9046541",1));
		productList.add(new Product("N1982-9042322",1));
		productList.add(new Product("A1999-9042777",1));
		productList.add(new Product("A1977-1987000",1));
		productList.add(new Product("W5002-4658822",2));
		productList.add(new Product("A1977-1987022",2));
		productList.add(new Product("A1999-9042339",2));
		productList.add(new Product("N1982-9042339",2));
		productList.add(new Product("N2014-0305001",2));
		productList.add(new Product("B4098-9045753",2));
		productList.add(new Product("N2014-0305556",2));
		productList.add(new Product("N1982-9042777",2));
		productList.add(new Product("A1999-9045332",3));
		productList.add(new Product("Z1977-9049006",3));
		productList.add(new Product("B2004-0000429",3));
		productList.add(new Product("N2014-0305044",3));
		productList.add(new Product("Z1977-9044443",3));
		productList.add(new Product("N1982-9042986",3));
		productList.add(new Product("W5002-4651110",3));
		productList.add(new Product("W5002-4658806",3));
		return productList;
	}

}
