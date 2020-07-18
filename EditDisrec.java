import java.util.*;
import java.io.*;
class EditDisrec
{
	
	 int min(int a, int b, int c)
	{
		return a<b?a<c?a:c:b<c?b:c;
	}

	
	 int dist(String X, int m, String Y, int n)
	{
		
        if(m==0 || n==0)
        return 0;
        else
        if(X.charAt(m-1)== Y.charAt(n-1))
        return dist(X,m-1,Y,n-1);
        else
		return 1+min(dist(X,m-1,Y,n),dist(X,m,Y,n-1),dist(X,m-1,Y,n-1)); 
	}

    
	public static void main(String[] args)
	{
		String X = "computerscience", Y = "xyzabscience";
        EditDisrec ob=new EditDisrec();
		System.out.print(ob.dist(X, X.length(), Y, Y.length()));
	}
}