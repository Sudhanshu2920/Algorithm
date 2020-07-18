import java.util.*;
import java.io.*;
class EditDisTD
 {
int min(int a, int b, int c)
	{
		return a<b?a<c?a:c:b<c?b:c;
	}
    

   int EditDis(String X,String Y)
   {
       int a=X.length();
       int b=Y.length();
       int [][] m=new int[a+1][b+1];
       for(int i=0;i<=a;i++)
       {
           for(int j=0;j<=b;j++)
           {
               m[i][j]=Integer.MAX_VALUE;
           }
       }

       return Look_up_Edit(X,a,Y,b,m);
 }

   int Look_up_Edit(String X,int i,String Y,int j,int[][] m )
   {
       if(m[i][j]<Integer.MAX_VALUE)
       return m[i][j];

       if(i==0 || j==0)
       m[i][j]=0;
       else
       if(X.charAt(i-1)==Y.charAt(j-1))
       m[i][j]=Look_up_Edit(X, i-1, Y, j-1,m);
       else
       m[i][j]=1+min(Look_up_Edit(X, i-1, Y, j,m),Look_up_Edit(X, i, Y, j-1,m),Look_up_Edit(X, i-1, Y, j-1,m));

       return m[i][j];
   }

  

    public static void main(String[] args)
	{
		String X = "kitten", Y = "sitting";
        EditDisTD ob=new EditDisTD();
		System.out.print(ob.EditDis(X, Y));
    }
    
}