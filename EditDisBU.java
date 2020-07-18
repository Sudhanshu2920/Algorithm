import java.io.*;
import java.util.*;
class EditDisBU {
	int min(int a, int b, int c)
	{
		return a<b?a<c?a:c:b<c?b:c;
	} 

	 int editDist(String X,  int m,String Y, int n) 
	 { 
		int r[][] = new int[m+1][n+1]; 
		for (int i=0; i<=m; i++) { 
			for (int j=0; j<=n; j++) {  
				if (i==0) 
					r[i][j] = i;
				else if (j==0) 
					r[i][j] = j;
				else if (X.charAt(i-1) == Y.charAt(j-1)) 
					r[i][j] = r[i-1][j-1]; 
				else
					r[i][j] = 1 + min(r[i][j-1], r[i-1][j],  r[i-1][j-1]);
			} 
		} 
		return r[m][n]; 
	} 
	public static void main(String args[]) 
	{ 
		String X = "ComputerScience"; 
		String Y = "xyzabScience"; 	
		EditDisBU ob = new EditDisBU();
		
		System.out.println( ob.editDist( X,X.length(),Y,Y.length())); 
	} 
}
