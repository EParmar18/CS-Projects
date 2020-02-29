// CS 0445 Spring 2019
// Simple demonstration of some operations on binary trees.

import TreePackage.*;  // The author put all of the files associated with 
			// binary trees into his own TreePackage, so I am keeping that
			// structure here.  To use this, we must import that classes
			// as shown above, and we must put them into a file called
			// TreePackage that is within the class search path for compilation
			// (making this directory a subdirectory of your current directory
			// will work fine for the purposes of this course)
public class Example12
{
	public static void main(String [] args)
	{
		BinaryNode<Integer> T1, T2;
		T1 = init1();
		System.out.print("T1 Pre:  ");
		T1.preOrder();
		System.out.println();
		System.out.print("T1 In:   ");
		T1.inOrder();
		System.out.println();
		System.out.print("T1 Post: ");
		T1.postOrder();
		System.out.println();
		int h = T1.getHeight();
		int n = T1.getNumberOfNodes();
		System.out.println("T1 Height: " + h + "  Nodes: " + n);
		T2 = init2();
		System.out.print("T2 In:   ");
		T2.inOrder();
		System.out.println();
		h = T2.getHeight();
		n = T2.getNumberOfNodes();
		System.out.println("T2 Height: " + h + "  Nodes: " + n);
		BinaryNode<Integer> T3 = (BinaryNode<Integer>)T2.copy();
		System.out.print("T3 In:   ");
		T3.inOrder();
		System.out.println();
	}

	// These trees are built in kind of a "hack" way just to give us examples with
	// which to test our operations.  We will see better ways of building trees
	// soon.  To see a visual depiction of these trees, please see document:
	// Ex12Data.docx

	public static BinaryNode<Integer> init1()
	{
		BinaryNode<Integer> temp1 = new BinaryNode<Integer>(new Integer(60));
		BinaryNode<Integer> temp2 = new BinaryNode<Integer>(new Integer(30));
		BinaryNode<Integer> temp3 = new BinaryNode<Integer>(new Integer(80), temp1, temp2);
		temp1 = new BinaryNode<Integer>(new Integer(20));
		temp2 = new BinaryNode<Integer>(new Integer(15), temp1, temp3);
		temp3 = temp2;
		temp2 = new BinaryNode<Integer>(new Integer(50));
		temp1 = new BinaryNode<Integer>(new Integer(40), null, temp2);
		temp2 = new BinaryNode<Integer>(new Integer(75));
		BinaryNode<Integer> temp4 = new BinaryNode<Integer>(new Integer(65), temp1, temp2);
		temp1 = new BinaryNode<Integer>(new Integer(90), temp4, temp3);
		return temp1;
	}

	// This tree will be a binary search tree (BST).  We will discuss BSTs in more
	// detail soon.
	public static BinaryNode<Integer> init2()
	{
		BinaryNode<Integer> temp1 = new BinaryNode<Integer>(new Integer(17));
		BinaryNode<Integer> temp2 = new BinaryNode<Integer>(new Integer(20), temp1, null);
		temp1 = new BinaryNode<Integer>(new Integer(10));
		BinaryNode<Integer> temp3 = new BinaryNode<Integer>(new Integer(15), temp1, temp2);
		temp2 = new BinaryNode<Integer>(new Integer(30));
		temp1 = new BinaryNode<Integer>(new Integer(25), temp3, temp2);
		temp3 = temp1;

		temp1 = new BinaryNode<Integer>(new Integer(55));
		temp2 = new BinaryNode<Integer>(new Integer(70));
		BinaryNode<Integer> temp4 = new BinaryNode<Integer>(new Integer(60), temp1, temp2);
		temp1 = new BinaryNode<Integer>(new Integer(80));
		temp2 = new BinaryNode<Integer>(new Integer(85), temp1, null);
		temp1 = new BinaryNode<Integer>(new Integer(75), temp4, temp2);

		temp4 = new BinaryNode<Integer>(new Integer(50), temp3, temp1);
		return temp4;
	}
}



