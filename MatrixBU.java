import java.io.*;
import java.util.*;
class MatrixBU
{
   int Matrix_memorized_BU(int[] p,int x,int y)
    {
     int n=p.length;
      int[][] m = new int[n][n];
      for(int i=1;i<n;i++)
      {
          m[i][i]=0;
      }
      for(int length=2;length<n;length++)
      {
          for(int i=1;i<n-length+1;i++)
          {
              int j=i+length-1;
                 m[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++)
                {
                    int q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(q<m[i][j])
                    m[i][j]=q;
                }
                 
               
          }
      }

      return m[x][y];
    }

      public static void main(String[] args)
 {
     int x[]={5,7,3,4,8,12,4};
     MatrixBU ob=new MatrixBU();
     System.out.println(ob.Matrix_memorized_BU(x,1,6));
 }
}