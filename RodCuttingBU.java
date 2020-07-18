import java.util.*;
import java.io.*;
class RodCuttingBU
{
    int Rod_Cut(int[] p,int n)
    {
           int[] r=new int[n+1];
           if(n==0)
           r[n]=0;
           for(int j=1;j<=n;j++)
           {
              int q=-19;
               for(int i=0;i<j;i++)
               {
                   q=max(q,p[i]+r[j-i-1]);
               }
               r[j]=q;
           }
           return r[n];
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