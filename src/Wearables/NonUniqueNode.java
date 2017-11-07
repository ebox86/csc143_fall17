package Wearables;

public class NonUniqueNode<T> {
		public T data;
		public NonUniqueNode<Integer> left;
		public NonUniqueNode<Integer> right;
		public int arrayIndex;
		public NonUniqueNode dupe;
		
		public NonUniqueNode(T data, int idx, NonUniqueNode n){
			this.data = data;
			this.arrayIndex = idx;
			this.dupe = n;
			left = null;
			right = null;
			
		}

	}