package benchmark;

import java.util.Collections;

import main.CopyArrayList;
import main.DataFile;

public class BenchmarkCopyArray implements ICollections{
	private CopyArrayList<DataFile> collection = new CopyArrayList<DataFile>();
	private CopyArrayList<DataFile> result = new CopyArrayList<DataFile>();
	private String name = "CopyArray";
	public void putCollection(String word) {
		DataFile data = new DataFile(word);
		if(collection.size() == 0) {
			collection.add(data);
		}
		else {
			for (int i=0; i<collection.size(); i++) {
				if (data.getKey().equals(collection.get(i).getKey())) {
					collection.get(i).setValue(collection.get(i).getValue()+1);
					collection.set(i, collection.get(i));
					return;
				}
			}
			collection.add(data);
		}
	}
	
	public void searchWords(String prefix) {
		
		for(var i = 0;i<collection.size();i++) {
			if(collection.get(i).getKey().startsWith(prefix)) {
				result.add(collection.get(i));
			}
		}
		sort(result);
	}
	public CopyArrayList<DataFile> getResult(){
		return result;
	}
	private void sort(CopyArrayList<DataFile> result) {
		DataFile tmp;
		boolean b = true;
		int s = result.size();
		while(b) {
			b = false;
			for(var i = 0;i+1<s;i++) {
				if(Math.abs(result.get(i).getValue()-result.get(i+1).getValue())<0.1) {
					if(result.get(i).compareTo(result.get(i+1))>0) {
						tmp = result.get(i);
						result.set(i, result.get(i+1));
						result.set(i+1, tmp);
						b = true;
						s--;
						continue;
					}
				}
				if(result.get(i).getValue()<result.get(i+1).getValue()) {
					tmp = result.get(i);
					result.set(i, result.get(i+1));
					result.set(i+1, tmp);
					b = true;
				}
			}
			s--;
		}
	}
	
	public void show() {
		for(var i = 0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}

	@Override
	public void resetFill() {
		collection = new CopyArrayList<DataFile>();
		
	}

	@Override
	public void resetSearch() {
		result = new CopyArrayList<DataFile>();
		
	}

	public void doShow() {
		System.out.println("CopyArray:");
		
	}

	public String getName() {
		return name;
	}
}
