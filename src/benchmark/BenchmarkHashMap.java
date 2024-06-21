package benchmark;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class BenchmarkHashMap implements ICollections{

	private HashMap<String, Integer> collection = new HashMap<String, Integer>();
	private HashMap<String, Integer> result = new HashMap<String, Integer>();
	private String name = "HashMap";
	public BenchmarkHashMap() {}
	
	public void putCollection(String word) {
		if(collection.get(word)==null) {
			collection.put(word, 1);
		}
		else {
			collection.put(word, collection.get(word)+1);
		}
	}
	public void searchWords(String prefix) {
		for(var word: collection.keySet()) {
			if(word.startsWith(prefix)) {
				result.put(word, collection.get(word));
			}
		}
		result.entrySet().stream().sorted(Map.Entry
				.comparingByValue(Comparator.reverseOrder()));
	}
	public HashMap<String, Integer> getResult(){
		return result;
	}

	@Override
	public void resetFill() {
		collection = new HashMap<String, Integer>();
		
	}

	@Override
	public void resetSearch() {
		result = new HashMap<String, Integer>();
		
	}
	public void show() {
		
	}
	public void doShow() {
		System.out.println("HashMap:");
		
	}
	public String getName() {
		return name;
	}
	
}
