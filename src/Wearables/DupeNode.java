package Wearables;

public class DupeNode {
		public DupeNode u;
		public int index;
		
		public DupeNode(int idx){
			this.u = this;
			this.index = idx;
		}

	}