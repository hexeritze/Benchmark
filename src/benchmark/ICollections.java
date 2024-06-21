package benchmark;

public interface ICollections {
	
	public String getName();
	public void putCollection(String word);
	public void searchWords(String prefix);
	public void resetFill();
	public void resetSearch();
	public void show();
	public void doShow();
}
