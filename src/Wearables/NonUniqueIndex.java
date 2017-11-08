package Wearables;

/**
 * Used to create an index of nonunique items, with duplicates, and sorts them
 * @author evan kohout
 *
 * @param <T>
 */
public class NonUniqueIndex<T extends Comparable<T>> {
	private NonUniqueNode<T> root;
	private T[] nonUniqueArr;
	
	/**
	 * creates a new non-unique index using a ternary search tree, adds items to the tree
	 * @param arr -- the items to be added to the tree
	 */
	public NonUniqueIndex(T[] arr) {
		this.root = null;
		this.nonUniqueArr = arr;
		for(int i = 0; i < arr.length; i++){
			this.add(arr[i], i);
		}
	}

	/**
	 * Used to retrieve a list of array ind
	 * @return
	 */
	public Object getArrayIndices() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Returns an array index for a given data value
	 * @param t -- the value to be found
	 * @return an int -- the index of the node for the given data
	 */
	public int search(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*
	 * used to add an item to the tree
	 */
	private void add(T t, int i) {
		// TODO Auto-generated method stub
		
	}





}
