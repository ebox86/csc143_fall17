package Wearables;

public class UniqueNode<T extends Comparable<T>> {
		public T data;
		public UniqueNode<T> left;
		public UniqueNode<T> right;
		public int index;
		
		public UniqueNode(T rankingsArr, int idx){
			this.data = rankingsArr;
			this.index = idx;
			left = null;
			right = null;
			
		}
		
		public int compareTo(T that) {
	        String temp1 = this.toString();
	        String temp2 = that.toString();
	        return temp1.compareTo(temp2);
		}
	}