import java.util.*;
import java.io.*;
class MatrixIterative
{
    public static void main(String[] args)
    {
        System.out.println("enter the rows and column of first matrix");
        Scanner sc=new Scanner(System.in);
        int a1=sc.nextInt();
        int a2=sc.nextInt();
        int[][] a=new int[a1][a2];
        System.out.println("enter the element of the Matrix");
        for(int i=0;i<a1;i++)
        {
            for(int j=0;j<a2;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("enter the rows and column of second matrix");
        int b1,b2;
        do
        {
             b1=sc.nextInt();
             b2=sc.nextInt();
            if(a2!=b1)
            System.out.println("Multiplication is not possible \nRe enter the rows and column");
        }while(a2!=b1);
        
        int[][] b=new int[b1][b2];
        System.out.println("enter the element of the Matrix");
        for(int i=0;i<b1;i++)
        {
            for(int j=0;j<b2;j++)
            {
                b[i][j]=sc.nextInt();
            }
        }
        int[][] M=new int[a1][b2];
        for(int i=0;i<a1;i++)
        {
            
            for(int j=0;j<b2;j++)
            {
                int sum=0;
                for(int k=0;k<a2;k++)
                {
                     sum=sum+a[i][k]*b[k][j];
                }
                 M[i][j]=sum;
            }

        }
        System.out.println("The multiplication is:");
        for(int i=0;i<a1;i++)
        {
            for(int j=0;j<b2;j++)
            {
                System.out.print(M[i][j]+"   ");
            }
            System.out.println();
        }

    }
}