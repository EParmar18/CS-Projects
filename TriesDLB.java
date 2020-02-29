// CS 1501
// Project 1 Create a
// Your SimBank class must run with this program as is, with no alterations.
// For more information on the particulars of the SimBank requirements, see
// comments below and also see the Assignment 1 specifications.

import java.util.*;

public class TriesDLB implements DInterface
{

    private final char END = ",";
    private Node root;

    public TriesDLB()
    {
        root = new Node();
    }

    public TriesDLB(String s)
    {
        root = new Node();
        add(s);
    }

    public TriesDLB(char c)
    {
        root = new Node();
        String s = c;
        add(s);
    }

    public boolean contains(Char key)
    {
        if(key == null) throw new IllegalArgumentException("Argument to contains() is null");
        return get(key) != null;
    }

    public boolean add(String word)
    {
        Node curr;
        char letter;
        word = word + END;

        for(int x = 0; x < word.length(); x++)
        {
            letter = word.charAt(x);
            curr = createChildN(parent, letter);

            if(curr == null)
            {
                curr = createPeerN(parent, letter);
            }
        }

        if(curr != null)
        {
            return true;
        }
        return false;
    }

    public Node createChildN(Node parent, char val)
    {
        
        if(parent.childN == null)
        {
            Node child = new Node(val);
            parent.childN = child;
            return child;
        }
        return null;
    }

    public Node createPeerN(Node parent, char val)
    {
        Node curr = new Node(val);

        if(parent == null)
        {
            parent = curr;
            return parent;
        }
        else if(parent != null)
        {
            while(parent.peerN != null)
            {
                if(parent.val == val)
                {
                    return parent;
                }
                parent = parent.peerN;
            }
            parent.peerN = curr;
        }
        return parent;

    }

    public boolean hasChild(Node parent)
    {
        if(parent.childN == null)
        {
            return false;
        }
        return true;
    }

    public boolean hasPeer(Node parent)
    {
        if(parent.peerN == null)
        {
            return false;
        }
        return true;
    }

    public int findKey(String key)
    {
        Node curr = rootNode;
        Node end;
        char letter; 

        for(int x = 0; x < key.length(); x++)
        {
            letter = key.charAt(x); 
            curr = getChild(curr, letter);

            if(curr == null)
            {
                return 0;
            }
        }

        end = getChild(curr, END);
        if(end == null)
        {
            return 1;
        }
        else if(end.peerN == null)
        {
            return 2;
        }
        else
        {
            return 3;
        }

    }

    public Node getChild(Node parent, char val)
    {
        return getPeer(parent.childN, val);
    }

    public Node getPeer(Node parent, char val)
    {
        Node curr = parent;

        while(curr != null)
        {
            if(curr.val == val)
                {
                    return curr;
                }
            curr = curr.peerN;
        }

        return curr;
    }
    class Node
    {
        Node childN;
        Node peerN; 
        char val;

        public Node()
        {}

        public Node(char val)
        {
            this.val = val;
        }

        public Node(char val, Node childN, Node peerN)
        {
            this.val = val;
            this.childN = childN;
            this.peerN = peerN;
        }
    }
