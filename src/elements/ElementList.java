package elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ElementList<E> implements MyList<E> {
    private Node<E> front;
	private Node<E> back; 
	private int size;
	private static ElementList<Node> list;
	
	public ElementList() {
		front = new Node<E>(null);
		back = new Node<E>(null);
		clear();
	}
	
	public void loadDataFromFile(File file) throws FileNotFoundException{
		try {
			Scanner s = new Scanner(file);
			
		} catch (FileNotFoundException e) {
			throw e;
		}
		
	}
	
	/**
	 * Returns the size of the Element List
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Returns whether or not the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns true if the provided value is present in the list
	 */
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedIterator();
	}


	@Override
	public boolean add(E e) {
		if (front == null) {
			back = new Node(e);
		} else {
			Node node = front;
			// loop until the last node
			for ( ; node.next != null; node = node.next) {}
			node.next = new Node(e);
		}
		size++;
		return true;
	
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		return index != -1 ? remove(index) : false;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(int index, E element) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
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


	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

    private class LinkedIterator implements Iterator<E> {
    	// location of next value to return
    	private Node<E> current;  
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
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
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
            Node<E> prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}