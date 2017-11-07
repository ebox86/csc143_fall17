package Wearables;

public class UniqueIndex<T> implements Index<T> {
	private  UniqueNode<T> root;
	private  T[] uniqueArr;
	
	public UniqueIndex(T[] rankingsArr) {
		this.root = null;
		this.uniqueArr = rankingsArr;
		for(int i = 0; i < rankingsArr.length; i++){
			this.insert(rankingsArr[i], i);
		}
	}

	@Override
	public int search(T rank) {
		UniqueNode<T> current = root;
		while(current!=null){
			if(current.data==rank){
				return current.arrayIndex;
			}else if(current.data > rank){
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

	
	
	public void insert(T rank, int pos){
		UniqueNode<T> newNode = new UniqueNode<T>(rank, pos);
		if(root==null){
			root = newNode;
			return;
		}
		UniqueNode<T> current = root;
		UniqueNode<T> parent = null;
		while(true){
			parent = current;
			if(rank < current.data){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
}
