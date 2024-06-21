package tests;

import java.util.ArrayList;
import java.util.List;

import benchmark.ICollections;

public class FillTest {
	
	public static long time;
	private static ArrayList<ChartData> results = new ArrayList<>();
	private static int countTest = 100;
	public FillTest() {	}
	
	public static void doTest(ICollections collection, ArrayList<String> text) {
		System.out.println("Fill test time");
		collection.doShow();
		System.out.println("count word: "+text.size());
		time = 0;
		for(var i = 0;i<countTest;i++) {
			collection.resetFill();
			long start = System.nanoTime();
			for(var word : text) {
				collection.putCollection(word);
			}
			time+=(System.nanoTime()-start)/1000;
			
		}
		time/=countTest;
		System.out.println("Average time: " +time);
		results.add(new ChartData(time,collection.getName(),Integer.toString(text.size())));
		time = 0;
	}
	public static List<ChartData> getResults(){
		return results;
	}
	public static void clearResults() {
		results = new ArrayList<ChartData>();
	}
}
