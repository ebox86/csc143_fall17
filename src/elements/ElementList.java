package elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ElementList -- builds a new Doubly Linked List
 * @author evankoh
 *
 */
public class ElementList {
    private Node front;
	private Node back;
	private int size;
	
	/**
	 * default constructor -- constructs a new list, sets size to 0
	 */
	public ElementList() {
		size = 0;
	}
	
	/**
	 * Node used for Linked List
	 * @author evankoh
	 *
	 */
	public class Node {
		public Node next;
		public Node prev;
		public Element data;

		/** 
		 * Default constructor for node, accepts single element to store
		 * @param e
		 */
		public Node (Element e){
			this.data = e;
		}

	}
	
	/**
	 * loads a text file of elements into the list
	 * @param the file to load
	 * @throws FileNotFoundException
	 */
	public void loadDataFromFile(File file) throws FileNotFoundException{
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
	            String[] fileParts = line.split(",");
	            Element element = new Element(Integer.parseInt(fileParts[0]), fileParts[1], fileParts[2], Double.parseDouble(fileParts[3]));
	            sortedAdd(element);
	    	}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the size of the Element List
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns whether or not the list is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns true if the provided value is present in the list
	 */
	public boolean contains(Element e) {
		return indexOf(e) >= 0;
	}

	public LinkedIterator iterator() {
		return new LinkedIterator();
	}

    /**
     * adds element at the starting of the linked list
     * @param element
     */
    private void addFirst(Element e) {
	    Node newNode = new Node(e);
	    if( isEmpty() ){
	       back = newNode;
	       front = newNode;
	    } else {
	       front.prev = newNode;
	    }
	    newNode.next = front;
	    front = newNode;
	    size++;
    }

    /**
     * adds element at the end of the linked list
     * @param element
     */
	private void addLast(Element e) {
	  Node p = new Node(e);
	  if (front == null) {
	   front = p;
	  } else {
	   Node s = front;
	   while (s.next != null) {
	    s = s.next;
	   }
	   s.next = p;
	   p.prev = s;
	  }
	  size++;
	}

	/**
	 * adds an element to the list and sorts it to its correct place
	 * @param element
	 */
	public void sortedAdd(Element element) {

	    // new list
	    if (front == null) {
	        front = new Node(element);
	        ++size;
	        return;
	    }
	    Node current = front;
	    Node prev = null;
	    while (current != null && (element.compareTo(current.data) > 0)) {
	        prev = current;
	        current = current.next;
	    }
	    // the last
	    if (current == null) {
	        current = new Node(element);
	        current.prev = prev;
	        prev.next = current;
	        ++size;
	        return;
	    }
	    //the first
	    if (prev == null){
	        prev = new Node(element);
	        current.prev = prev;
	        prev.next = current;
	        front = prev;
	        ++size;
	        return;
	    }
	    Node temp = new Node(element);
	    temp.next = current;
	    temp.prev = current.prev;
	    current.prev.next = temp;
	    current.prev = temp;
	    ++size;
	}
	
	/**
	 * removes an element from the list
	 * @param the element to remove
	 * @return boolean as to whether the remove was successful
	 */
	public boolean remove(Element e) {
		int index = indexOf(e);
		return index != -1 ? remove(index) : false;
	}


	/**
	 * clears the linked list 
	 */
	public void clear() {
		front.next = back;
        back.prev = front;
        size = 0;
	}

	/**
	 * Retrieves the element at the specified index position
	 * @param index of list item to retrieve
	 * @return the Element at the index 
	 */
	public Element get(int index) {
        checkIndex(index);
        Node current = nodeAt(index);
        return current.data;
	}

	/**
	 * removes the element at the specified index value
	 * @param index of the element to remove
	 * @return true if removed succeeded, false if otherwise
	 */
	public boolean remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index = " + index);
		}
		// Find the corresponding node
		Node prev = null, p = front;
		for (int i = 0; i < index; i++) {
			prev = p;
			p = p.next;
		}
		// Remove it
		// Special case for the first node
		if (index == 0) {
			front = front.next;
		} else {
			prev.next = p.next;
		}
		// If the last node has been removed, update tail
		if (index == size - 1) {
			back = prev;
		}
		// update size
		size--;
		return true;
	}

	/**
	 * Returns the index of the first occurrence of a given element
	 * @param e
	 * @return
	 */
	public int indexOf(Element e) {
        int index = 0;
        Node current = front.next;
        while (current !=  back) {
            if (current.data.equals(e)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
	}
	
    // throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
    
    //		 returns the node at a specific index.  Uses the fact that the list
    //       is doubly-linked to start from the front or the back, whichever
    //       is closer.
    private Node nodeAt(int index) {
        Node current;
        if (index < size / 2) {
            current = front;
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
        } else {
            current = back;
            for (int i = size; i >= index + 1; i--) {
                current = current.prev;
            }
        }
        return current;
    }
    
	/*/////////////////////////////////////////////////////
	 * 
	 * toString methods
	 * 
	 */////////////////////////////////////////////////////
	
    /**
     * converts the element data from the list node to a string
     */
    public String toString(){
    	String result = "";
		Node current = front;
	    while (current != null) {
	        result = result + (current.data).toString() + "\n";
	        current = current.next;
	    }
		return result;
    }
    
    
    /**
     * converts the element data from the list node to a string, sorting in ascending or descending order
     */
	public String toString(String direction) throws IllegalArgumentException{
		if(direction != "asc" || direction != "desc"){
			throw new IllegalArgumentException("direction must either be 'asc' or 'desc'");
		}
        String result = "";
		switch(direction){
			case "asc": 
		        Node currentAsc = front;
		        while(currentAsc.next != null){
		        	currentAsc = currentAsc.next;
		            result += currentAsc.data.toString() + "\n ";
		        }
			case "desc":
		        Node currentDesc = front;
		        while(currentDesc.next != null){
		        	currentDesc = currentDesc.next;
		            result += currentDesc.data.toString() + "\n ";
		        }
		}
		return result;

	}
	
    /**
     * converts the element data from the list node to a string
     */
	
    class LinkedIterator implements Iterator<Element> {
    	// location of next value to return
    	private Node current;  
    	// whether it's okay to remove now
        private boolean removeOK;

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return current != back;
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public Element next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Element result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }
        
        // pre : next() has been called without a call on remove (i.e., at most
        //       one call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            Node prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}