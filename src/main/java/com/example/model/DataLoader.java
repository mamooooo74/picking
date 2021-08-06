package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class DataLoader{

	public List<Product> GetRandomsix() {


		List<Product> producttList  = getProductList();
		Collections.shuffle(producttList);
//		producttList.subList(0, 5);
		return producttList;
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
