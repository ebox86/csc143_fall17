package Wearables;

public class UniqueNode<T> {
		public T data;
		public UniqueNode<T> left;
		public UniqueNode<T> right;
		public int arrayIndex;
		
		public UniqueNode(T rankingsArr, int idx){
			this.data = rankingsArr;
			this.arrayIndex = idx;
			left = null;
			right = null;
			
		}


	}