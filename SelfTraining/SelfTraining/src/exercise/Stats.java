package exercise;

import java.util.Random;

import libs.StdArrayIO;
import libs.StdDraw;
import libs.StdIn;
import libs.StdOut;
import libs.StdRandom;

public class Stats
{
public static void main(String[] args)
{
BagArray<Double> numbers = new BagArray<Double>();
int loop = StdRandom.uniform(1, 100);

while (loop !=0 )
{
	loop--;
	numbers.add(StdRandom.uniform(1, 10000) * StdRandom.uniform());

}
	
	for (double x : numbers)
		System.out.println(x);

	int N = numbers.size();
	double sum = 0.0;
	for (double x : numbers)
	sum += x;
	double mean = sum/N;
	sum = 0.0;
	for (double x : numbers)
		sum += (x - mean)*(x - mean);
	
	double std = Math.sqrt(sum/(N-1));
	StdOut.printf("Mean: %.2f   N = %d\n", mean,N);
	StdOut.printf("Std dev: %.2f\n", std);
	
	plot(N ,10000,numbers ,mean);
	

	
	}

	static void plot(int loop , int max ,BagArray<Double> number  , double mean )
	{
		StdDraw.setXscale(0, loop);
		StdDraw.setYscale(-1, max);
		StdDraw.setPenRadius(.005);
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
	
		double y =number.getElement(0) ;
		int i=0;
		for (double x : number)
		{
			StdDraw.line(i-1,y , i, x);
			StdDraw.point(i++, x);	

			y=x ;
			
		}
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		 i=0;
		for (double x : number)
		{
			StdDraw.point(i++, mean);	
			
		}		
		
	}
}
