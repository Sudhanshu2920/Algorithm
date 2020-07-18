import java.util.*;
import java.io.*;
class RodCuttingTD
{
    int Memorized_cut_rod(int [] p,int n)
    {
        int[] r=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            r[i]=-19;
        }
        return memorizedCut_rod_aux(p,n,r);
    }
   int memorizedCut_rod_aux(int[] p,int n,int[] r)
   {
      if(r[n]>=0)
        return r[n];
      
          if(n==0)
          r[n]=0;
          else
          {
            int q=0;
             for(int i=0;i<n;i++)
             {
                 q=max(q,p[i]+memorizedCut_rod_aux(p,n-i-1,r));
                 r[n]=q;
             }
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
        
        RodCuttingTD ob=new RodCuttingTD();
        System.out.println(ob.Memorized_cut_rod(p,x));

    }

}