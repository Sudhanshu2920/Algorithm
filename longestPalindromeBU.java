    import java.io.*;
import java.util.*;
class LongestPalindromeBU
{
    int longestPalindrome(String a,int x,int y)
    {
        int n=a.length();
        int[][] m=new int[n][n];
        for(int i=0;i<n;i++)
        {
            m[i][i]=1;
        }
        for(int length=2;length<=n;length++)
        {
            for(int i=0;i<n-length+1;i++)
            {
                int j=i+length-1;
                if(a.charAt(i)==a.charAt(j)&&length==2)
                m[i][j]=2;
                else
                if(a.charAt(i)==a.charAt(j))
                m[i][j]=2+m[i+1][j-1];
                else 
                m[i][j]=max(m[i+1][j],m[i][j-1]);
            }

        }

        return m[x][y];
    }

       int max(int a,int b)
{
    return a>b?a:b;
}

public static void main(String[] args)
    {
        String a="ascdwwqqasd";
        LongestPalindromeBU ob=new LongestPalindromeBU();
        System.out.println(ob.longestPalindrome(a,0,a.length()-1));
    }

}