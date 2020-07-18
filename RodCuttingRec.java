import java.io.*;
import java.util.*;
class RodCuttingRec
{
   int Cut_Rod(int[] p,int n)
    {
         if(n==0)
         return 0;
         int q=0;
         for(int i=0;i<n;i++)
         {
             q=max(q,p[i]+Cut_Rod(p,n-i-1));
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
        RodCuttingRec ob=new RodCuttingRec();
        System.out.println(ob.Cut_Rod(p,x));

    }
}
