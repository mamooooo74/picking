package com.example.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.modl.Product;
import com.example.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductRepository repository;

	private List<Map<Product, Integer>> keepProductsMap;
	int count = 0;


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

	@GetMapping("/senior")
	public String getSenior(@RequestParam(value = "stratTime", defaultValue = "") Long start,
							Model model) {
		count++;
		if(keepProductsMap == null) {
			keepProductsMap = new ArrayList<>();
		}

		if(start == null) {
			start = System.currentTimeMillis();
		}
		if(count == 25) {
			int time = (int)(System.currentTimeMillis() - start) / 1000;
			int sec = time % 60;
			int min = time / 60;
			String timeStr = min + "分" + sec + "秒";
			model.addAttribute("keepProductMap",keepProductsMap);
			model.addAttribute("time",timeStr);
			keepProductsMap = null;
			count = 0;
			return "product/complete";
		}
		List<Product> products = repository.findAll();
		Collections.shuffle(products);
		products = products.subList(0, 6);
		List<Integer> random = randomnumbers();
		int sum = 0;
		for(int i : random) {
			sum += i;
		}
		Map<Product, Integer> productMap = new HashMap<>();

		for(int i = 0; i < 6; i++) {
			productMap.put(products.get(i),random.get(i)) ;
		}
		keepProductsMap.add(productMap);
		model.addAttribute("start", start);
		model.addAttribute("count",count);
		model.addAttribute("productsMap", productMap );
		model.addAttribute("sum", sum );
		return "product/senior";

	}





	private List<Integer> randomnumbers(){
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
}
