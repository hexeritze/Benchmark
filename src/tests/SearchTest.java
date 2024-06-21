package tests;

import java.util.ArrayList;
import java.util.List;

import benchmark.ICollections;

public class SearchTest {
	public static long time;
	private static int countTest = 100;
	private static ArrayList<ChartData> results = new ArrayList<>();
	public SearchTest() {	}
	
	public static void doTest(ICollections collection, int count) {
		System.out.println("Search test time");
		collection.doShow();
		time = 0;
		for(var i = 0;i<countTest;i++) {
			collection.resetSearch();
			long start = System.nanoTime();
			collection.searchWords("кот");
			time+=(System.nanoTime()-start)/1000;
		}
		time/=countTest;
		System.out.println("Average time: " +time);
		results.add(new ChartData(time,collection.getName(),Integer.toString(count)));
		time = 0;
	}
	public static List<ChartData> getResults(){
		return results;
	}
	public static void clearResults() {
		results = new ArrayList<ChartData>();
	}
}
