import java.io.*;
import java.util.*;
class A
{
  double  probability(int[] x,int low,int high,double[] p)
    {
        if(low==high)
        {
            if(x[high]==0)
            return 1-p[high];
            else
            return p[high];
        }
        else
        {
           int mid=(low+high)/2;
            return probability(x,low,mid,p)+probability(x,mid+1,high,p);

        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=sc.nextInt();
        int[] x=new int[n];
        double[] p=new double[n];
        System.out.println("enter the value of random variable");
        for(int i=0;i<n;i++)
        {
            x[i]=sc.nextInt();
        }
        System.out.println("Enter the probability");
        for(int i=0;i<n;i++)
        {
            p[i]=sc.nextDouble();
        }
        A ob=new A();
        System.out.println("Sum of probablity of events");
       double y= ob.probability(x,0,n-1,p);
       System.out.println(y);
    }
}