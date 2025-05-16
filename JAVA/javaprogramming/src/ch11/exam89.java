package ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class exam89
{

	public static void main(String[] args)
	{
		HashSet hs = new HashSet();
		
		hs.add("demon");
		hs.add("banana");
		hs.add("tomato");
		hs.add("apple");
		hs.add("cargo");
		
		TreeSet ts = new TreeSet();
		
		ts.add("demon");
		ts.add("banana");
		ts.add("tomato");
		ts.add("apple");
		ts.add("cargo");
		
		Iterator it = hs.iterator();
		System.out.println("<HashSet 출력>");
		
		while(it.hasNext())
		{
			System.out.println(""+it.next());
		}
		
		Iterator it2 = ts.iterator();
		System.out.println("\n<TreeSet 출력>");
		
		while(it2.hasNext())
		{
			System.out.println(""+it2.next());
		}
		
		System.out.println("\n 현재 TreeSet의 크기: "+ts.size());
	}

}
