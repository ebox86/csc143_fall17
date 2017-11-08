package Wearables;

/**
 * used to create new nonunique node objects for a Ternary search tree
 * @author evankoh
 *
 * @param <T> the type to be used
 */
public class NonUniqueNode<T extends Comparable<T>> {
		public T data;
		public NonUniqueNode<T> left, right;
		public DupeNode dupe;
		public int arrayIndex;

		/**
		 * creates a new NonUniqueNode object
		 * @param t
		 * @param idx
		 */
		public NonUniqueNode(T t, int idx){
			this.data = t;
			this.arrayIndex = idx;
			this.left = null;
			this.right = null;
			this.dupe = null;
			
		}
		
		/**
		 * Adds a new item to the TST
		 * @param t -- the data to add
		 * @param pos -- the index position
		 * @return
		 */
		public boolean add(T t, int pos){
			if (t.compareTo(this.data) == 0){
				return false;
			} else if (t.compareTo(this.data) < 0){
				if(left == null){
					left = new NonUniqueNode<T>(t, pos);
					return true;
				} else {
					return left.add(t, pos);
				}
			} else if (t.compareTo(this.data) > 0) {
				if (right == null){
					right = new NonUniqueNode<T>(t, pos);
					return true;
				} else {
					return right.add(t, pos);
				}
			} 
			return false;
		}
		
		/**
		 * used to compare this node's data against other nodes
		 * @param that
		 * @return
		 */
		public int compareTo(T that) {
	        String temp1 = this.toString();
	        String temp2 = that.toString();
	        return temp1.compareTo(temp2);
		}

	}