package appscripprep.javaprep.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPI {
	
//	Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
	public static void solve1(List<Product> products) {
		List<Product> list = products.stream()
		.filter(p-> p.getCategory().equalsIgnoreCase("Book"))
		.filter(p->p.getPrice() > 1000)
		.collect(Collectors.toList());
		System.out.println(list);
	}
	
	//Exercise 2 — Obtain a list of order with products belong to category “Baby”
	public static void solve2(List<Order> orders) {
		orders
		.stream()
		.filter(o->
		o.getProducts()
		.stream()
		.anyMatch(p->p.getCategory().equalsIgnoreCase("Baby"))
					)
		.collect(Collectors.toList());
	}
	public static void solve() {
		
	}
	public static void main(String[] args) {
		List<Product> prodList = new ArrayList<>();
		prodList.add(new Product(1l, "ThinkPad 550", "Laptop", 50000.00));
		prodList.add(new Product(2l, "HP Pavilion", "Laptop", 60000.00));
		prodList.add(new Product(3l, "Iphone 14 pro", "Mobile", 50000.00));
		prodList.add(new Product(4l, "DSA", "Book", 1000.00));
		prodList.add(new Product(5l, "Rich guy poor dad.", "Book", 2000.00));
		prodList.add(new Product(6l, "Pursuit of Happines", "Book", 500.00));
		prodList.add(new Product(7l, "Twilight saga II", "Book", 1500.00));
		prodList.add(new Product(8l, "samsung HQ OLED", "Tv", 50000.00));
		
		//solve2
		Set<Product> hashSet = new HashSet<>();
		hashSet.add(new Product(1l, "ThinkPad 550", "Laptop", 50000.00));
		hashSet.add(new Product(2l, "HP Pavilion", "Laptop", 60000.00));
		hashSet.add(new Product(3l, "Iphone 14 pro", "Mobile", 50000.00));
		hashSet.add(new Product(4l, "DSA", "Book", 1000.00));
		hashSet.add(new Product(5l, "Rich guy poor dad.", "Book", 2000.00));
		hashSet.add(new Product(6l, "Pursuit of Happines", "Book", 500.00));
		hashSet.add(new Product(7l, "Twilight saga II", "Book", 1500.00));
		hashSet.add(new Product(8l, "samsung HQ OLED", "Tv", 50000.00));
		List<Order> orderList=new ArrayList<>();
		
		solve1(prodList);
	}
}
