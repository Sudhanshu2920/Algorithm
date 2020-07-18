import java.util.*;
import java.io.*;
class MatrixMulti
{
    int[][] multiply(int[][] a,int[][] b)
    {
        if((a.length==b.length)&&(a[0].length==b[0].length)&&(a.length==1)&&(a[0].length==1))
        {
           int[][] c=new int[1][1];
           c[0][0]= a[0][0]*b[0][0];
           return c;
        }
        
      int[][]a1=  makesquare(a);
      int[][]b1=  makesquare(b);
      int[][]a2=  makeeven(a1);
      int[][]b2=  makeeven(b1);
      
        int[][] M2= makeequal(a2,b2);
        int[][] M1= makeequal(b2,a2);
        
      
      
      

      int n=M1.length;
        
        
        
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
               a11[i][j]=M1[i][j];
               a12[i][j]=M1[i][j+n/2];
               a21[i][j]=M1[i+n/2][j];
               a22[i][j]=M1[i+n/2][j+n/2];
               b11[i][j]=M2[i][j];
               b12[i][j]=M2[i][j+n/2];
               b21[i][j]=M2[i+n/2][j];
               b22[i][j]=M2[i+n/2][j+n/2];

           }
       }

       //performing of different multiply
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

    int[][] makesquare(int[][] a)
    {
        if(a.length==a[0].length)
        return a;
        else
        if(a.length>a[0].length)
        {
            int[][] y=new int[a.length][a.length];
            for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                y[i][j]=a[i][j];
            }
            
        }
        return y;
        }
        else
        {
            int[][] y=new int[a[0].length][a[0].length];
            for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                y[i][j]=a[i][j];
            }
            
        }
        return y;
        }

        
        
    }


    int[][] makeeven(int[][] a)
    {
        if(a.length%2==0)
        return a;
        int[][] y=new int[a.length+1][a.length+1];
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                y[i][j]=a[i][j];
            }
            
        }
        return y;

    }
    int[][] makeequal(int[][] a,int[][] b)
    {
        if(a.length<b.length)
        return b;

        int[][] y=new int[a.length][a.length];
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b.length;j++)
            {
                y[i][j]=b[i][j];
            }
        }
        return y;

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
       System.out.println("Enter the rows and column of first matrix");
       Scanner sc=new Scanner(System.in);
       int a1=sc.nextInt();
       int a2=sc.nextInt();
       int[][] a=new int[a1][a2];
       System.out.println("Enter the elements of matrix");
       for(int i=0;i<a1;i++)
       {
           for(int j=0;j<a2;j++)
           {
                  a[i][j]=sc.nextInt();
           }
       }
       System.out.println("Enter the rows and column of Second matrix");
       int b1=sc.nextInt();
       int b2=sc.nextInt();
       int[][] b=new int[b1][b2];
       System.out.println("Enter the elements of matrix");
       for(int i=0;i<b1;i++)
       {
           for(int j=0;j<b2;j++)
           {
                  b[i][j]=sc.nextInt();
           }
       }
       MatrixMulti ob=new MatrixMulti();
         int[][] R= ob.multiply(a,b);
         System.out.println("the multiplication of the matrix is:");
         for(int i=0;i<a1;i++)
         {
             for(int j=0;j<b2;j++)
             {
                 System.out.print(" "+R[i][j]);
             }
             System.out.println();
         }
   }
}