package com.example.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.modl.Product;
import com.example.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Controller
@Scope("session")
@RequiredArgsConstructor
public class ProductController {
	private final ProductRepository repository;

	private List<Map<Product, Integer>> keepProductsMap;
	int count = 0;
	Long start = null;


	@GetMapping("/")
	public String getTop() {
		return "index";
	}

	@GetMapping("/list")
	public String getProductList(Model model) {
		model.addAttribute("product", repository.findAll());
		return "product/list";
	}

	@GetMapping("/create")
	public String getCreateProduct(@ModelAttribute Product product) {
		return "product/create";
	}

	@PostMapping("/create")
	public String addProduct(@Validated @ModelAttribute Product product,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "product/create";
		}
		repository.save(product);
		return "redirect:/list";
	}

	@GetMapping("/comp")
	public  String getComplete(Model model) {
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

	private String getElapsedTime() {
		int time = (int)(System.currentTimeMillis() - start) / 1000;
		int sec = time % 60;
		int min = time / 60;
		return min + "分" + sec + "秒";
	}

	private Map<Product, Integer> getProductsMap(List<Integer> random){
		Map<Product, Integer> productMap = new HashMap<>();
		List<Product> products = repository.getRandomSix();
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
}
