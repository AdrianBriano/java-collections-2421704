package com.linkedin.collections;

import java.util.*;

public class Application {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(500, 1500, 2500, 1000, 3000, 2000);

        NavigableSet<Integer> treeSet = new TreeSet<>(numbers);

		treeSet.subSet(1750,2750).forEach(System.out::println);

		System.out.println(treeSet.ceiling(1750));
	}
}
