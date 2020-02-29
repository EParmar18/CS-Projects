  //Eshan Parmar
//CS 445
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;
//import TreePackage.*;

public class Assig4 
{
    private static BinaryNode<Character> root = new BinaryNode('0');
    private static ArrayList<String> file = new ArrayList<String>();
    private static Scanner inFile;
    private String curr ;
    //private BinarySearchTree<Character> tree = new BinarySearchTree();
    public static void main(String args[]) throws IOException
    { 
        File read = new File(args[0]);
        inFile = new Scanner(read);
        createTree(root, inFile.nextLine());
        root.inOrder();

        System.out.println("The Huffman Tree has been restored"); 
        Scanner input = new Scanner(System.in);
        int n = 0;
        String s = "";
        while(n != 3)
        {
          System.out.println("Please choose from the following:");
          System.out.println("1) Encode a text string");
          System.out.println("2) Decode a Huffman string");
          System.out.println("3) Quit");
          n = input.nextInt();
          input.nextLine();
          if(n < 1 || n > 3)
          {
            continue;
          }
          else if(n == 1)
          {
            //createTable();
            System.out.println("Please enter a Huffman string (one line, no spaces)");
            s = input.nextLine();
            StringBuilder code = new StringBuilder();
            //encodeHuffman(root, s, 0, code);
          }
          else if(n == 2)
          {
            System.out.println("Enter a String from the following characters:");
            //showChar();
            s = input.nextLine();
            StringBuilder in = new StringBuilder(s);
            StringBuilder code = new StringBuilder();
            //decodeHuffman(root, in, code);
          } 
          else if(n == 3)
          {
            System.out.println("Have a nice day");
          }
        }
    }
    public static void createTree(BinaryNode<Character> r, String s)
    {
      char c = s.charAt(0);
      if(c == 'I')
      {
        BinaryNode<Character> temp = new BinaryNode<Character>('1');
        BinaryNode<Character> temp2 = new BinaryNode<Character>('0');
        r.setRightChild(temp);
        r.setLeftChild(temp2);
        createTree(r.getLeftChild(), inFile.nextLine());
        createTree(r.getRightChild(), inFile.nextLine());
      }
      else if(c == 'L')
      {
        char letter = s.charAt(2);
        r.setData(letter);
      }
    }
    public static void createTable()
    {
      System.out.println("");
    }
    
    public static StringBuilder decodeHuffman(BinaryNode<Character> r, StringBuilder s, StringBuilder code)
    {
      char c = s.charAt(0); 
      if(r.isLeaf() == true)
      {
          code.append(r.getData());
          decodeHuffman(root, s, code);
      }
      else if(c != '1' || c != '0')
      {
        return code;
      }
      else if(c == '1')
      {
        s.deleteCharAt(0);
        decodeHuffman(r.getRightChild(), s, code);
      }
      else if(c == '0')
      {
        s.deleteCharAt(0);
        decodeHuffman(r.getLeftChild(), s, code);
      }
      return code;
    }
    
    public static String encodeHuffman(BinaryNode<Character> r, StringBuilder s, StringBuilder code)
    {
      return null;
    }
    public static String showChar()
    {
      return null;
    }
}