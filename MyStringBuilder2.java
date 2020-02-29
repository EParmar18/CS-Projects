// CS 0445 Spring 2019
// Read this class and its comments very carefully to make sure you implement
// the class properly.  The data and public methods in this class are identical
// to those MyStringBuilder, with the exception of the two additional methods
// shown at the end.  You cannot change the data or add any instance
// variables.  However, you may (and will need to) add some private methods.
// No iteration is allowed in this implementation. 

// For more details on the general functionality of most of these methods, 
// see the specifications of the similar method in the StringBuilder class.  
public class MyStringBuilder2
{
	// These are the only three instance variables you are allowed to have.
	// See details of CNode class below.  In other words, you MAY NOT add
	// any additional instance variables to this class.  However, you may
	// use any method variables that you need within individual methods.
	// But remember that you may NOT use any variables of any other
	// linked list class or of the predefined StringBuilder or 
	// or StringBuffer class in any place in your code.  You may only use the
	// String class where it is an argument or return type in a method.
	private CNode firstC;	// reference to front of list.  This reference is necessary
							// to keep track of the list
	private CNode lastC; 	// reference to last node of list.  This reference is
							// necessary to improve the efficiency of the append()
							// method
	private int length;  	// number of characters in the list

	// You may also add any additional private methods that you need to
	// help with your implementation of the public methods.

	// Create a new MyStringBuilder2 initialized with the chars in String s
	public MyStringBuilder2(String s)
	{
		if(s == null || s.length() == 0)
		{
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			makeBuilder(s, 0);
		}
	}

	private void makeBuilder(String s, int pos)
	{
		// Recursive case – we have not finished going through the String
		if (pos < s.length()-1)
		{
			// Note how this is done – we make the recursive call FIRST, then
			// add the node before it.  In this way the LAST node we add is
			// the front node, and it enables us to avoid having to make a
			// special test for the front node.  However, many of your
			// methods will proceed in the normal front to back way.
			makeBuilder(s, pos+1);
			firstC = new CNode(s.charAt(pos), firstC);
			length++;
		}
		else if (pos == s.length()-1) // Special case for last char in String
		{                             // This is needed since lastC must be set to point to this node
			firstC = new CNode(s.charAt(pos));
			lastC = firstC;
			length = 1;
		} 
		// This case should never be reached, due to the way the
		// constructor is set up.  However, I included it as a safeguard (in case some other method calls this one)
		else
		{  
			length = 0;
			firstC = null;
			lastC = null;
		}
	}

	// Create a new MyStringBuilder2 initialized with the chars in array s
	public MyStringBuilder2(char [] s)
	{
		if(s == null || s.size == 0)
		{
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			makeBuilder(s, 0);
		}
	}

	private void makeBuilder(char [] s, int pos)
	{
		// Recursive case – we have not finished going through the String
		if (pos < s.size-1)
		{
			// Note how this is done – we make the recursive call FIRST, then
			// add the node before it.  In this way the LAST node we add is
			// the front node, and it enables us to avoid having to make a
			// special test for the front node.  However, many of your
			// methods will proceed in the normal front to back way.
			makeBuilder(s, pos+1);
			firstC = new CNode(s[pos], firstC);
			length++;
		}
		else if (pos == s.size-1) // Special case for last char in String
		{                             // This is needed since lastC must be set to point to this node
			firstC = new CNode(s[pos]);
			lastC = firstC;
			length = 1;
		} 
		// This case should never be reached, due to the way the
		// constructor is set up.  However, I included it as a safeguard (in case some other method calls this one)
		else
		{  
			length = 0;
			firstC = null;
			lastC = null;
		}
	}
	

	// Create a new empty MyStringBuilder2
	public MyStringBuilder2()
	{
		firstC = null;
		lastC = null;
		length = 0;
	}

	// Append MyStringBuilder2 b to the end of the current MyStringBuilder2, and
	// return the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(MyStringBuilder2 b)
	{
		if(length == 0)
		{
			makeBuilder(s, 0);
		}
		else if(b != null && b.length != 0)
		{
			CNode curr = lastC;
			CNode currBNode = b.firstC;
			appendMyStringBuilder(b, curr, currBNode);
		}
		return this;   
	}
	
	private void appendMyStringBuilder(MyStringBuilder2 b, CNode curr, CNode currBNode)
	{
		if(currBNode.next == null)
		{
			CNode newNode = new Cnode(currBNode.data);
			curr.next = newNode;
			curr = newNode;
			length++;
			lastC = curr;
		}
		else if(curr != null)
		{
			CNode newNode = new CNode(currBNode.data);
			curr.next = newNode;
			length++;
			appendMyStringBuilder(b, curr.next, currBNode.next);
		}
	}


	// Append String s to the end of the current MyStringBuilder2, and return
	// the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(String s)
	{
		if(length == 0)
		{
			firstC = b.firstC;
			lastC = b.lastC;
			length = b.length;
		}
		else if(s != null && b.length != 0)
		{
			int pos = length;
			CNode curr = lastC;
			MyStringBuilder2 temp = new MyStringBuilder2(s);
			CNode currTempNode = temp.firstC;
			appendString(s, curr, currTempNode);
		}
		return this;
	}

	private void appendString(String s, CNode curr, CNode currTempNode)
	{
		if(currTempNode.next == null)
		{
			CNode newNode = new Cnode(currBNode.data);
			curr.next = newNode;
			curr = newNode;
			length++;
			lastC = curr;
		}
		else if(curr != null)
		{
			CNode newNode = new CNode(currTempNode.data);
			curr.next = newNode;
			length++;
			appendString(s, curr.next, currTempNode.next);
		}
	}

	// Append char array c to the end of the current MyStringBuilder2, and
	// return the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(char [] c)
	{
		if(length == 0)
		{
			firstC = b.firstC;
			lastC = b.lastC;
			length = b.length;
		}
		else if(s != null && b.length != 0)
		{
			int pos = length;
			CNode curr = lastC;
			MyStringBuilder2 temp = new MyStringBuilder2(c);
			CNode currTempNode = temp.firstC;
			appendCharArray(c, curr, currTempNode);
		}
		return this;
	}

	private void appendCharArray(char [] c, CNode curr, CNode currTempNode)
	{
		if(currTempNode.next == null)
		{
			CNode newNode = new Cnode(currBNode.data);
			curr.next = newNode;
			curr = newNode;
			length++;
			lastC = curr;
		}
		else if(curr != null)
		{
			CNode newNode = new CNode(currTempNode.data);
			curr.next = newNode;
			length++;
			appendCharArray(c, curr.next, currTempNode.next);
		}
	}

	// Append char c to the end of the current MyStringBuilder2, and
	// return the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(char c)
	{
		if(length == 0)
		{
			firstC = b.firstC;
			lastC = b.lastC;
			length = b.length;
		}
		else if(s != null && b.length != 0)
		{
			char [] c1 = new char[] {c};
			int pos = length;
			CNode curr = lastC;
			MyStringBuilder2 temp = new MyStringBuilder2(c1);
			CNode currTempNode = temp.firstC;
			appendCharArray(c1, curr, currTempNode);
		}
		return this;
	}

	// Return the character at location "index" in the current MyStringBuilder2.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		if(index < 0 || index > length)
		{
			throw IndexOutOfBoundsException();
		}
		else if(length == 0)
		{
			return null;
		}
		else if(length != 0 & index < length)
		{
			CNode curr = firstC;
			return (getNodeAt(index, curr).data);
		}
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder2, and return the current MyStringBuilder2.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder2 as is).  If "end" is past the end of the MyStringBuilder2, 
	// only remove up until the end of the MyStringBuilder2. Be careful for 
	// special cases!
	public MyStringBuilder2 delete(int start, int end)
	{
		if(length == 0 || end > length || start < 0)
		{
			return this;
		}
		else if(length != 0)
		{
			CNode curr = firstC;
			int pos = 0;
			CNode startN = new CNode();
			CNode endN = new CNode();
			deleteString(pos, start, end, curr, startN, endN);
		}
		return this;
	}

	private void deleteString(int pos, int start, int end, CNode curr, CNode startN, CNode endN)
	{
		if(pos == start)
		{
			startN = curr;
			deleteString(pos + 1, start, end, curr, startN, endN);
		}
		else if(pos == end)
		{
			endN = curr;
			startN.next = endN;
		}
		else if(curr.next == null)
		{
			startN.next = curr;
		}
		else if(curr != null)
		{
			deleteString(pos + 1, start, end, curr.next, startN, endN);
		}
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder2 and return the current MyStringBuilder2.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder2 as is).
	// Be careful for special cases!
	public MyStringBuilder2 deleteCharAt(int index)
	{
		if(index < 0 || index > length || length == 0)
		{
			return this;
		}
		else if(index > 0 && index < length)
		{
			CNode currNode = firstC;
			CNode befNode = getNodeAt(index - 1, currNode);
			CNode aftNod = getNodeAt(index + 1, currNode);
			befNode.next = aftNode;
		}
		return this;
	}

	// Find and return the index within the current MyStringBuilder2 where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder2.  If str does not match any sequence of characters
	// within the current MyStringBuilder2, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
	}

	// Insert String str into the current MyStringBuilder2 starting at index
	// "offset" and return the current MyStringBuilder2.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder2 insert(int offset, String str)
	{
		if(offset < 0 || offset > length || length == 0)
		{
			return this;
		}
		else if(offset == length)
		{
			append(str);
			return this;
		}
		else if(offset < length && offset > 0)
		{
			CNode curr = firstC;
			CNode startN = new CNode();
			startN = getNodeAt(offset, curr);
			MyStringBuilder2 temp = new MyStringBuilder2(str);
			CNode currTempNode = temp.firstC;

			appendString(str, curr, currTemp);
		}
		return this;
	}

	// Insert character c into the current MyStringBuilder2 at index
	// "offset" and return the current MyStringBuilder2.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder2 insert(int offset, char c)
	{
		if(offset < 0 || offset > length || length == 0)
		{
			return this;
		}
		else if(offset == length)
		{
			append(c);
			return this;
		}
		else if(offset < length && offset > 0)
		{
			char [] c1 = new char[] {c};
			CNode curr = lastC;
			MyStringBuilder2 temp = new MyStringBuilder2(c1);
			CNode currTempNode = temp.firstC;
			appendCharArray(c1, curr, currTempNode);
		}
		return this;
	}

	// Insert char array c into the current MyStringBuilder2 starting at index
	// index "offset" and return the current MyStringBuilder2.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder2 insert(int offset, char [] c)
	{
		if(offset < 0 || offset > length || length == 0)
		{
			return this;
		}
		else if(offset == length)
		{
			append(c);
			return this;
		}
		else if(offset < length && offset > 0)
		{
			CNode curr = lastC;
			MyStringBuilder2 temp = new MyStringBuilder2(c);
			CNode currTempNode = temp.firstC;
			appendCharArray(c, curr, currTempNode);
		}
		return this;
	}

	// Return the length of the current MyStringBuilder2
	public int length()
	{
		return length;
	}

	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder2, then insert String "str" into the current
	// MyStringBuilder2 starting at index "start", then return the current
	// MyStringBuilder2.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder2, only delete until the
	// end of the MyStringBuilder2, then insert.  This method should be done
	// as efficiently as possible.  In particular, you may NOT simply call
	// the delete() method followed by the insert() method, since that will
	// require an extra traversal of the linked list.
	public MyStringBuilder2 replace(int start, int end, String str)
	{
	}

	// Reverse the characters in the current MyStringBuilder2 and then
	// return the current MyStringBuilder2.
	public MyStringBuilder2 reverse()
	{
		
	}
	
	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder2
	public String substring(int start, int end)
	{
	}

	// Return the entire contents of the current MyStringBuilder2 as a String
	public String toString()
	{
      char [] c = new char[length];
      getString(c, 0, firstC);
      return (new String(c));
	}

	private void getString(char [] c, int pos, CNode curr)
	{
      if (curr != null)
      {
            c[pos] = curr.data;
            getString(c, pos+1, curr.next);
      }
	}

	private void getString(char [] c, int pos, int end, CNode curr)
	{
      if (curr != null)
      {
            c[pos] = curr.data;
            getString(c, pos+1, curr.next);
      }
	}

	private CNode getNodeAt(int index, CNode curr)
	{
		if(index == 0)
		{
			return curr;
		}
		else if(index < length && index >= 0)
		{
			curr = curr.next;
			getNodeAt(index-1, curr);
		}
		return curr;
	}


	// Find and return the index within the current MyStringBuilder2 where
	// String str LAST matches a sequence of characters within the current
	// MyStringBuilder2.  If str does not match any sequence of characters
	// within the current MyStringBuilder2, return -1.  Think carefully about
	// what you need to do for this method before implementing it.  For some
	// help with this see the Assignment 3 specifications.
	public int lastIndexOf(String str)
	{
	}
	
	// Find and return an array of MyStringBuilder2, where each MyStringBuilder2
	// in the return array corresponds to a part of the match of the array of
	// patterns in the argument.  If the overall match does not succeed, return
	// null.  For much more detail on the requirements of this method, see the
	// Assignment 3 specifications.
	public MyStringBuilder2 [] regMatch(String [] pats)
	{
	}
	
	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder2 class MAY access the
	// data and next fields directly.
	private class CNode
	{
		private char data;
		private CNode next;

		public CNode(char c)
		{
			data = c;
			next = null;
		}

		public CNode(char c, CNode n)
		{
			data = c;
			next = n;
		}
	}
}

