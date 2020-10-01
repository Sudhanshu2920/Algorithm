import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc=new Scanner(System.in);
        String input[]=sc.nextLine().split(" ");
        Double N=Double.parseDouble(input[0]);
        int X=Integer.parseInt(input[1]);
        Double temp=N/2;
        temp=Math.ceil(temp);
        System.out.println(temp);
        double check=temp/2;
        if(check<=X)
          System.out.println("1");
          else
          System.out.println("0");
    }
}