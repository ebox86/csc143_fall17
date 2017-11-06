package elements;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElementListTest {
	String path;
	File f;
	
	/**
	 * Default constructor used to test elementList
	 */
	public ElementListTest() {
	}
	
    /**
     * Sets up test
     */
    @Before
    public void setUp() {
		 path = Paths.get(".").toString() + "/src/elements/";
		 f = new File(path + "elements.txt");
    }

    /**
     * Tears down test
     */
    @After
    public void tearDown() {
    }
    
    /**
     * Tests the constructor and setters/getters
     */
    @Test
    public void testConstructor() {
    	ElementList el = new ElementList();
    	assertEquals(0, el.size());
    	assertEquals(true, el.isEmpty());
    }
    
    /**
     * Tests reading elements from a file
     * @throws FileNotFoundException
     */
    @Test
    public void testReadFile() throws FileNotFoundException{
    	ElementList el = new ElementList();
		el.loadDataFromFile(f);
		
		assertEquals(118, el.size());
		
    }

}
