package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.ui.RefineryUtilities;

import benchmark.BenchmarkArrayList;
import benchmark.BenchmarkCopyArray;
import benchmark.BenchmarkHashMap;
import benchmark.BenchmarkLinkedList;
import benchmark.ICollections;
import monitor.ShowGraph;
import tests.FillTest;
import tests.SearchTest;

public class Main {

	public static ArrayList<String> readFromFile(FileReader file) {
		int c;
		StringBuilder s = new StringBuilder();
		try {
			while((c=file.read())!=-1){
			    s.append((char)c);
			}
			file.close();
			return getWords(s.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static ArrayList<String> getWords(String text){
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder word = new StringBuilder();
		for(var e : text.toCharArray()) {
			if((e >='а' && e<='я')||(e >='А' && e <='Я')) {
				word.append(e);
			}
			else {
				if(word.length()>2) {
					result.add(word.toString());
				}
				word = new StringBuilder();
			}
		}
		return result;
	}
	
	public static ArrayList<String> doCutText(ArrayList<String> text,int count) {
		ArrayList<String> cutText = new ArrayList<String>();
		for(var i = 0;i<count;i++) {
			cutText.add(text.get(i));
		}
		return cutText;
	}
	
	public static void main(String[] args) throws IOException {
		
		FileReader file = new FileReader("..\\друг.txt");
		ArrayList<String> words = readFromFile(file);
		
		ICollections[] arrays = {new BenchmarkHashMap(),
				new BenchmarkArrayList(),
				new BenchmarkLinkedList(),
				new BenchmarkCopyArray()
		};
		for(var e : arrays) {
			FillTest.doTest(e,doCutText(words,10));
			SearchTest.doTest(e, 10);
			e.show();
			FillTest.doTest(e,doCutText(words,100));
			SearchTest.doTest(e, 100);
			e.show();
			FillTest.doTest(e,doCutText(words,500));
			SearchTest.doTest(e, 500);
			e.show();
			FillTest.doTest(e,doCutText(words,1000));
			SearchTest.doTest(e, 1000);
			e.show();
			FillTest.doTest(e,doCutText(words,2000));
			SearchTest.doTest(e, 2000);
			e.show();
		}
		ShowGraph graph1 = new ShowGraph("test time fill",FillTest.getResults());
		graph1.pack();
		RefineryUtilities.centerFrameOnScreen(graph1);
		graph1.setVisible(true);
		ShowGraph graph2 = new ShowGraph("test time search",SearchTest.getResults());
		graph2.pack();
		RefineryUtilities.centerFrameOnScreen(graph2);
		graph2.setVisible(true);

		
		
	}
	
	

}
