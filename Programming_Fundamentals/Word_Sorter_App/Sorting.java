// Week 8 Assignment Word Sorting			Author: Joe Cruz
//08Mar2020
//Part 2_Sorting Class
//
//This code is meant to take in either manual input user words or a file of words and sort them.
//This portion of the code houses the Sorting class, which is basically the class that everything required for the code to run happens.
//The main portion of this class that is really important is the tree_generation_view, as this is what creates the binary tree
//based of the input the user used. The values were previously put into an arraylist, now this uses that arraylist to begin the tree and create the nodes.
import java.io.FileNotFoundException;
public class Sorting extends Input{
	
	
//Method for when the class is instantiated. Runs the input then generates the binary tree as well as the traversal of the binary tree in the console
	Sorting () throws FileNotFoundException {
		Input();
		tree_generation_view ();
	}
	
	//method to create the binary tree based off the arraylist previously made. Also this outputs the sorted words in the console.
	private void tree_generation_view () {
		stringvalue=to_sort_list.get(0);
		StringTree tree = new StringTree(stringvalue);
		for(int i=1; i < to_sort_list.size(); i++) {
			stringvalue = to_sort_list.get(i);
			tree.insert_Word_node(tree.node, stringvalue);}
		tree.Trav_order(tree.node);
	
		}
	
}
