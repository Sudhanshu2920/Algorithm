import java.util.*;
import java.io.*;
class MatrixTD
{
    int Matrix_memorized(int[] p)
    {
        int n=p.length;
        int[][] m=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                m[i][j]=Integer.MAX_VALUE;
            }
        }
        return Look_up(p,1,n-1,m);
    }

   int Look_up(int[] p,int i,int j,int[][] m)
    {
         if(m[i][j]<Integer.MAX_VALUE)
         return m[i][j];
         if(i==j)
         m[i][j]=0;
         for(int k=i;k<j;k++)
         {
             int q=Look_up(p, i, k, m) +Look_up(p, k+1, j, m) +p[i-1]*p[k]*p[j];
             if(q<m[i][j])
             {
                 m[i][j]=q;
             }
         }
         return m[i][j];
    }

    public static void main(String[] args)
 {
     int x[]={5,7,3,4,8,12,4};
     MatrixTD ob=new MatrixTD();
     System.out.println(ob.Matrix_memorized(x));
 }
}