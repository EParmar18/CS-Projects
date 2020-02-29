  //Eshan Parmar
//CS 445
import java.util.*;
import TreePackage.*;

public class Assig4 implements BinarySearchTree<T>
{
    private BinaryNode<Character> root;
    private BinarySearchTree<Character> tree = new BinarySearchTree();
    public static void main(String args[])
    {
        ArrayList<String> file = new ArrayList<String>();
        File inFile = new File(args[0]);
        Scanner input = new Scanner(inFile);
        while(input.nextLine().equals(" ") == false)
        {
          file.add(input.nextLine());
        }
    }
}