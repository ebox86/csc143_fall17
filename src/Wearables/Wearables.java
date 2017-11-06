package Wearables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import elements.Element;

public class Wearables {

	public static Node root;
	public static Wearable[] wearArr;
	
	public Wearables() {
		Wearables.root = null;
	}
	
	public void loadDataFromFile(File file) throws FileNotFoundException{
		int size;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			size = Integer.parseInt(br.readLine()); // first line
			br.readLine(); // second line
		    String line;
		    int pos = 0;
		    wearArr = new Wearable[size];
			while ((line = br.readLine()) != null){
	            String[] fileParts = line.split("@");
	            Wearable w = new Wearable(fileParts[0], fileParts[1], Double.parseDouble(fileParts[2]), fileParts[3], fileParts[4], fileParts[5],
	            		fileParts[6], fileParts[7], fileParts[8], fileParts[9], fileParts[10]);
	            wearArr[pos] = w;
	            pos++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class Node {
		Wearable data;
		Node left;
		Node right;
		
		public Node(Wearable data){
			this.data = data;
			left = null;
			right = null;
			
		}

	}
}
