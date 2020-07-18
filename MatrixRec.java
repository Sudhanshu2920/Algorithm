import java.util.*;
import java.io.*;
class MatrixRec
{
 int matrixchain(int[] p,int i,int j)
 {
     if(i==j)
     return 0;
     int minmulti=Integer.MAX_VALUE;
     for(int k=i;k<j;k++)
     {
         int q= matrixchain(p,i,k)+ matrixchain(p,k+1,j)+p[i-1]*p[k]*p[j];
         if(minmulti>q)
         {
             minmulti=q;
         }
     }

     return minmulti;
 }
 
 public static void main(String[] args)
 {
     int x[]={5,7,3,4,8,12,4};
     MatrixRec ob=new MatrixRec();
     System.out.println(ob.matrixchain(x,1,6));
 }
}