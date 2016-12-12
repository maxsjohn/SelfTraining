package exercise;

import libs.In;
import libs.StdDraw;
import libs.StdIn;
import libs.StdOut;
import libs.StdRandom;

public class exer {

	
	static void shuffle(int[] a)
	{
		int temp ;
		int rand;
		for(int i =0 ; i<a.length;i++)
		{
			temp = a[i];
			rand = StdRandom.uniform(a.length);
			a[i] = a[rand];
			a[rand] = temp;
		}
	}
	
	public static class Whitelist
	{
	public static void main(String[] args)
	{
		int[] w = In.readInts(args[0]);
	StaticSETofInts set = new StaticSETofInts(w);
	while (!StdIn.isEmpty())
	{ // Read key, print if not in whitelist.
	int key = StdIn.readInt();
	if (set.rank(key) == -1)
	StdOut.println(key);
	}
	}
	}
}