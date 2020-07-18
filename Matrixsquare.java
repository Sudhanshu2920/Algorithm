import java.util.*;
import java.io.*;
class Matrixsquare
{
   int[][] multiply(int[][] a,int[][] b)
    {
       int n=a.length;
        if(n==1)
        {
          int[][] c=new int[1][1];
          c[0][0]= a[0][0]*b[0][0];
          return c;
        }
        
        
       int[][] a11=new int[n/2][n/2];
       int[][] a12=new int[n/2][n/2];
       int[][] a21=new int[n/2][n/2];
       int[][] a22=new int[n/2][n/2];
       int[][] b11=new int[n/2][n/2];
       int[][] b12=new int[n/2][n/2];
       int[][] b21=new int[n/2][n/2];
       int[][] b22=new int[n/2][n/2];
         //dividing the matrix
       for(int i=0;i<n/2;i++)
       {
           for(int j=0;j<n/2;j++)
           {
               a11[i][j]=a[i][j];
               a12[i][j]=a[i][j+n/2];
               a21[i][j]=a[i+n/2][j];
               a22[i][j]=a[i+n/2][j+n/2];
               b11[i][j]=b[i][j];
               b12[i][j]=b[i][j+n/2];
               b21[i][j]=b[i+n/2][j];
               b22[i][j]=b[i+n/2][j+n/2];

           }
       }

       //performing of different multiplication
       int[][] c11=matrixadd(multiply(a11,b11),multiply(a12,b21));
       int[][] c12=matrixadd(multiply(a11,b12),multiply(a12,b22));
       int[][] c21=matrixadd(multiply(a21,b11),multiply(a22,b21));
       int[][] c22=matrixadd(multiply(a21,b12),multiply(a22,b22));

       int[][] M=new int[n][n];
       //combining the matix
       for(int i=0;i<n/2;i++)
       {
           for(int j=0;j<n/2;j++)
           {
               M[i][j]=c11[i][j];
               M[i][j+n/2]=c12[i][j];
               M[i+n/2][j]=c21[i][j];
               M[i+n/2][j+n/2]=c22[i][j];
           }
       }

       return M;
       
       
       
    }
    int[][] matrixadd(int[][] a,int[][] b)
    {
       int n=a.length;
       int[][] Ad=new int[n][n];
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
              Ad[i][j]=a[i][j]+b[i][j];
           }
       }
       return Ad;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of first square matrix ");
        int n=sc.nextInt();
        int[][] x=new int[n][n];
        int[][] y=new int[n][n];
        System.out.println("Enter the  first  matrix ");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                x[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the  second  matrix ");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                y[i][j]=sc.nextInt();
            }
        }

        Matrixsquare ob=new Matrixsquare();
        int z[][]=ob.multiply(x,y);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(z[i][j]+"  ");
            }
           System.out.println("");
        }
    }
}