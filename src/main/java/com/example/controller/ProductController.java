package com.example.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.DataLoader;
import com.example.model.Product;

@Controller
@Scope("session")
public class ProductController {

	private DataLoader loader = DataLoader.getInstance();
	private List<Map<Product, Integer>>keepProductsMap;
	private int count = 0;
	private Long start = null;


	@GetMapping("/")
	public String getTop() {
		return "index";
	}


	@GetMapping("/comp")
	public  String getComplete(Model model) {
		model.addAttribute("colorList", getClolorList());
		model.addAttribute("sumList", getSumList());
		model.addAttribute("keepProductMap",keepProductsMap);
		model.addAttribute("time",getElapsedTime());
		return "product/complete";
	}

	@GetMapping("/senior")
	public String getSenior(Model model) {
		if(count == 0) {
			keepProductsMap = new ArrayList<>();;
			start = System.currentTimeMillis();
		}
		if(count == 24) {
			count = 0;
			return "redirect:/comp";
		}
		List<Integer> random = randomnNumbers();
		Map<Product, Integer> productMap = getProductsMap(random);
		keepProductsMap.add(productMap);

		model.addAttribute("count",++count);
		model.addAttribute("productsMap", productMap );
		model.addAttribute("sum", random.stream().reduce(0, Integer::sum));
		return "product/senior";
	}

	@GetMapping("/middle")
	public String getMiddle(Model model) {
		if(count == 0) {
			keepProductsMap = new ArrayList<>();;
			start = System.currentTimeMillis();
		}
		if(count == 24) {
			count = 0;
			return "redirect:/comp";
		}
		List<Integer> random = randomnNumbers();
		Map<Product, Integer> productMap = getProductsMap(random);
		keepProductsMap.add(productMap);
		model.addAttribute("colorList", getClolorList());
		model.addAttribute("count",++count);
		model.addAttribute("productsMap", productMap );
		model.addAttribute("sum", random.stream().reduce(0, Integer::sum));
		return "product/middle";
	}
	@GetMapping("/beginner")
	public String getbeginner(Model model) {
		if(count == 0) {
			keepProductsMap = new ArrayList<>();;
			start = System.currentTimeMillis();
		}
		if(count == 24) {
			count = 0;
			return "redirect:/comp";
		}
		List<Integer> random = randomnNumbers();
		Map<Product, Integer> productMap = getProductsMap(random);
		keepProductsMap.add(productMap);
		model.addAttribute("colorList", getClolorList());
		model.addAttribute("count",++count);
		model.addAttribute("productsMap", productMap );
		model.addAttribute("sum", random.stream().reduce(0, Integer::sum));
		return "product/beginner";
	}

	private String getElapsedTime() {
		int time = (int)(System.currentTimeMillis() - start) / 1000;
		int sec = time % 60;
		int min = time / 60;
		return min + "分" + sec + "秒";
	}

	private Map<Product, Integer> getProductsMap(List<Integer> random){
		Map<Product, Integer> productMap = new HashMap<>();
		List<Product> products = loader.GetRandomsix();
		for(int i = 0; i < 6; i++) {
			productMap.put(products.get(i),random.get(i)) ;
		}
		return productMap;
	}


	private List<Integer> randomnNumbers(){
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

	private List<Integer> getSumList() {
		List<Integer> sumList = new ArrayList<>();
		for(Map<Product, Integer> productMap : keepProductsMap) {
			int sum = 0;
			 for(int i : productMap.values()) {
				 sum += i;
			 }
			 sumList.add(sum);
		}
		return sumList;
	}

	private List<String> getClolorList(){
		List<String> colorList = new ArrayList<String>();
		colorList.add("yellow");
		colorList.add("blue");
		colorList.add("pink");
		colorList.add("green");
		return colorList;
	}
}
