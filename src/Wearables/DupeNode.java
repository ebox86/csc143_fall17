package Wearables;

/**
 * creates a duplicate node used to store items of the same data
 * @author evankoh
 *
 */
public class DupeNode {
		public DupeNode u;
		public int index;
		
		/**
		 * creates a new duplicate node
		 * @param idx
		 */
		public DupeNode(int idx){
			this.u = this;
			this.index = idx;
		}

	}