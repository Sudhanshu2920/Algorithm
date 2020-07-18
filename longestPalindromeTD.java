import java.util.*;
import java.io.*;
class LongestPalindromeTD
{
   int longestpalindrome(String a)
    {
        int n=a.length();
        int [][] m=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                m[i][j]=Integer.MIN_VALUE;
            }
        }

        return Look_up_palindrome(a,0,n-1,m);
    }

   int Look_up_palindrome(String a,int i,int j,int[][]m)
    {
       if(m[i][j]>Integer.MIN_VALUE)
       return m[i][j];
       if(i==j)
       m[i][j]=1;
       else
       if(i>j)
       m[i][j]=0;
      else if(a.charAt(i)==a.charAt(j))
       m[i][j]=2+Look_up_palindrome(a, i+1, j-1, m);
       else 
       m[i][j]=max(Look_up_palindrome(a, i+1, j, m),Look_up_palindrome(a, i, j-1, m));

       return m[i][j];
    }

    int max(int a,int b)
{
    return a>b?a:b;
}

public static void main(String[] args)
    {
        String a="ascdwwqqasd";
        LongestPalindromeTD ob=new LongestPalindromeTD();
        System.out.println(ob.longestpalindrome(a));
    }

}