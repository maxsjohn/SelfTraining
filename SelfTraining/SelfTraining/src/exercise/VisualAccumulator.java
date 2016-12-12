package exercise;

import libs.StdDraw;
import libs.StdOut;

public class VisualAccumulator
{
private double total;
private int N;
static  int i = 0; 
public VisualAccumulator(int trials, double max)
{
StdDraw.setXscale(0, trials);
StdDraw.setYscale(-1, max);
StdDraw.setPenRadius(.005);
}
public void addDataValue(double val)
{
N++;
i++;
total += val;
StdDraw.setPenColor(StdDraw.DARK_GRAY);
StdDraw.point(N, val);
StdDraw.setPenColor(StdDraw.RED);
StdDraw.point(N, total/N);

}
public double mean()
{ return total/N; }
public String toString()
{ return "Mean (" + N + " values): "
+ String.format("%7.5f", mean()); }

public static void main(String[] args)
{
int T = Integer.parseInt(args[0]);
VisualAccumulator a = new VisualAccumulator(T, 1);
VisualAccumulator b =new VisualAccumulator(T, 1);
for (int t = 0; t < T; t++)
{
	a.addDataValue(Math.sin(Math.toRadians(t)));
	b.addDataValue(Math.cos(Math.toRadians(t)));
}
	

StdOut.println(a);
}


}