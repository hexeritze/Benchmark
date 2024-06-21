package main;


public class CopyArrayList<T>{
	
	public CopyArrayList() {}
	
	private final int Start_SIZE = 16;
	private Object[] array = new Object[Start_SIZE];
	private int pointer = 0;

	public void add(Object item) {
		if(pointer == array.length-1)
			resize(array.length*2);
			array[pointer++] = item;
			}
	
	public void set(int index,Object item) {
		array[index] = item;
	}

	public T get(int index) {
		return (T)array[index];
      	}

	public int size() {
		return pointer;
		}
	
	private void resize(int size) {
		Object[] newArray = new Object[size];
		System.arraycopy(array, 0, newArray, 0, pointer);
		array = newArray;
		}
}
