package elements;

public class Node {
		public Node next;
		public Node prev;
		public Element data;

		public Node (Node prev, Element e, Node next){
			this.prev = prev;
			this.data = e;
			this.next = next;
		}
		
		public Node(Element e){
			this(null, e, null);
		}
		
		public String toString(){
			return data.toString();
		}
	}