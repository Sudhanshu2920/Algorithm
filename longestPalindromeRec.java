import java.io.*;
import java.util.*;
class longestPalindromeRec
{
    int longestPalindrome(String a,int i,int j)
    {
      if(i>j)
      return 0;
      if(i==j)
      return 1;
      if(a.charAt(i)==a.charAt(j))
      return 2+longestPalindrome(a,i+1,j-1);
      else
      return 
      max(longestPalindrome(a,i,j-1),longestPalindrome(a,i+1,j));
    }

    int max(int a,int b)
    {
        return a>b?a:b;
       }
    public static void main(String[] args)
    {
        String a="ascdwwqqasd";
        longestPalindromeRec ob=new longestPalindromeRec();
        System.out.println(ob.longestPalindrome(a,0,a.length()-1));
    }
}