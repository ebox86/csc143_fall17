package Wearables;

public class UniqueIndex<T extends Comparable<T>> {
	private UniqueNode<T> root;
	private T[] uniqueArr;
	
	public UniqueIndex(T[] rankingsArr) {
		this.root = null;
		this.uniqueArr = rankingsArr;
		for(int i = 0; i < rankingsArr.length; i++){
			this.insert(rankingsArr[i], i);
		}
	}

	private int search(T t) {
		UniqueNode<T> current = root;
		int compareResult = current.data.compareTo(t);
		while(current!=null){
			if(current.data==t){
				return current.index;
			}else if(compareResult == -1){
				System.out.println(t.toString() + "going to the left");
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return -1;
	}
	
	public int[] getArrayIndicies(){
		int[] returnArr = new int[uniqueArr.length];
		for(int i = 0; i < uniqueArr.length; i++){
			returnArr[i] = search((T)uniqueArr[i]);
		}
		return returnArr;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	private void insert(T t, int pos){
		UniqueNode<T> newNode = new UniqueNode<T>(t, pos);
		if(root==null){
			root = newNode;
			return;
		}
		UniqueNode<T> current = root;
		UniqueNode<T> parent = null;
		int compareResult = current.data.compareTo(t);
		while(true){
			parent = current;
			if(compareResult == -1){
				System.out.println(t.toString() + "going to the left");
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
			} else {
				System.out.println(t.toString() + "going to the right");
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
}
