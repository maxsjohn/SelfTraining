package exercise;

import libs.StdDraw;
import libs.StdOut;
import libs.StdRandom;

public class exer {

    private static int SIDES = 6;
    
    public static double[] getExact()
    {
        double[] dist = new double[2*SIDES+1];
        
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
        
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= SIDES*SIDES;
        
        return dist; 
    }
    
    public static double[] getExperim(int n)
    {
        double[] dist = new double[2*SIDES+1];
        
        for (int i = 0; i < n; i++)
            dist[throwDice()]++;
        
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= n;
        
        return dist;
    }
    
    public static int throwDice()
    {
        return StdRandom.uniform(1, SIDES+1) + StdRandom.uniform(1, SIDES+1);
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        
        double[] exact = getExact();
        double[] x1 = new double[2*SIDES+1];
        for (int i = 2; i <= 2*SIDES; i++)
        {
        	x1[i] = i ;
            StdOut.printf("%7d", i);
        }
        StdOut.println();
        
        for (int i = 2; i <= 2*SIDES; i++)
            StdOut.printf("%7.3f", exact[i]);
        StdOut.println();
        
        double[] experim = getExperim(n); 
        
        for (int i = 2; i <= 2*SIDES; i++)
            StdOut.printf("%7.3f", experim[i]);
        StdOut.println();
        
        
        int N = 2*SIDES;
        StdDraw.setXscale(0, N+2);
        StdDraw.setYscale(0, .2);
        StdDraw.setPenRadius(.01);
        for (int i = 2; i <= N; i++)
        {
        StdDraw.point(i, exact[i]);


        }   
        
        StdDraw.setPenRadius(.05);       
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        for (int i = 2; i <= N; i++)
        {
        StdDraw.point(i, experim[i]);

        }          
//        
//        {
//            int N = 2*SIDES;
//            double[] a = new double[N];
//            for (int i = 0; i < N; i++)
//            a[i] = StdRandom.random();
//            for (int i = 0; i < N; i++)
//            {
//            double x = 1.0*x1[i]/N;
//            double y = exact[i];
//            double rw = 0.5/N;
//            double rh = exact[i];
//            StdDraw.filledRectangle(x, y, rw, rh);
//            } 
//
//        	
//        }        
//        
//        {
//            int N = 2*SIDES;
//            double[] a = new double[N];
//            for (int i = 0; i < N; i++)
//            a[i] = StdRandom.random();
//            for (int i = 0; i < N; i++)
//            {
//            double x = 1.0*x1[i]/N;
//            double y = experim[i];
//            double rw = 0.5/N;
//            double rh = experim[i];
//
//            StdDraw.filledRectangle(x, y, rw, rh);
//            } 
//
//        	

        

                

        
        // Empirical results match exact ones to 3 decimal places when
        // n >= 10,000,000  (< 1 sec.)
    }
}