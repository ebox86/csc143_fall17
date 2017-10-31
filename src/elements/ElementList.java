package elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementList {
    private Node front;
	private Node back;
	private int size;
	
	public ElementList() {
		front = new Node(null);
		back = new Node(null);
		clear();
	}
	
	public void loadDataFromFile(File file) throws FileNotFoundException{
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
	            String[] fileParts = line.split(",");
	            Element element = new Element(Integer.parseInt(fileParts[0]), fileParts[1], fileParts[2], Double.parseDouble(fileParts[3]));
	            add(element);
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
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public LinkedIterator iterator() {
		return new LinkedIterator();
	}

	public boolean add(Element e) {
		if (front == null) {
			back = new Node(e);
		} else {
			Node node = front;
			// loop until the last node
			//for ( ; node.next != null; node = node.next) {}
	        while(node.next != null){
	            node = node.next;
	        }
			node.next = new Node(e);
		}
		size++;
		return true;
	}

	public boolean add(int index, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		int index = indexOf(o);
		return index != -1 ? remove(index) : false;
	}


	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public Element get(int index) {
        checkIndex(index);
        Node current = nodeAt(index);
        return current.data;
	}

	public boolean add(int index, Element element) {
		return false;
	}

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


	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
    
    // pre : 0 <= index < size()
    // post: returns the node at a specific index.  Uses the fact that the list
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
    
    /*
	 * toString method
     */
	
    /**
     * converts the element data from the list node to a string
     */
	public String toString() {
        String result = "";
        Node current = front;
        while(current.next != null){
            current = current.next;
            result += current.data.toString() + "\n ";
        }
        return "List: \n" + result;
	}
	
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