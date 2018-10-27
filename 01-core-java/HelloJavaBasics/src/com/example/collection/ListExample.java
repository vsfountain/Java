package com.example.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ListExample {

	public static void main(String[] args) {

		// HASHMAP

		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(4, "Jerry");
		hashMap.put(2, "Alex");
		hashMap.put(17, "Luke");
		hashMap.put(5, "Matt");
		hashMap.put(10, "Aaron");
		hashMap.put(10, "Najib"); // overwrites value
		// hashMap.put(null, "Trevin"); //can have a null key

		System.out.println("HashMap: " + hashMap);
		System.out.println("HashMap size: " + hashMap.size());
		System.out.println("HashMap value: " + hashMap.get(5));
		System.out.println("HashMap value: " + hashMap.get(99)); // null

		// Loop
		// You can iterate over the key set, value set, of the entry set (both)
		for (Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}

		// TREEMAP
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.putAll(hashMap);

		System.out.println("\nTreeMap Loop: ");
		for (Entry<Integer, String> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		
		//sorting, threads, junit, maven, generics, reflection, serialization, object
	}

}
