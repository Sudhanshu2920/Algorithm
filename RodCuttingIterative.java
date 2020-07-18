import java.util.*;
import java.io.*;

class RodCuttingIterative
{
    int Rod_cut(int[] p,int n)
    {
        if(n==0)
        return 0;
         int q=Integer.MIN_VALUE;
        for(int j=1;j<=n;j++)
        {
           
            for(int i=0;i<j;i++)
            {
                q=max(q,p[i]+Rod_cut(p,j-i-1));
            }
        }
         return q;
    }

     int max(int a,int b)
    {
        return a>b?a:b;
    }

    public static void main(String[] args)
    {
        int[] p={1,5,8,9,10,17,17,20,24,30};
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the rod");
        int x=sc.nextInt();
        RodCuttingBU ob=new RodCuttingBU();
        System.out.println(ob.Rod_Cut(p,x));
    }
}