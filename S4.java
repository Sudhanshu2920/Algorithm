import java.io.*;
import java.util.*;
class S4
{
    String digitadder(String a1, String a2) {
        int S1 = a1.length();
        int S2 = a2.length();
        int size = max(S1, S2);
        //making digit equal
        if (S1 > S2)
        a2 = digitequal(a1, a2);
        else if (S1 < S2)
        a1 = digitequal(a2, a1);
        
        int carry = 0;
        String result = ""; 
        int last_idx = 0; 
        for (int i = size - 1; i >= 0 ; i--) {
        
        int temp_sum = Integer.parseInt( Character.toString( a1.charAt(i) ) ) +
        Integer.parseInt( Character.toString( a2.charAt(i) ) ) +
        carry;
        if (temp_sum >= 10) {
        carry = 1;
        last_idx = 1; 
        } else {
        carry = 0;
        last_idx = 0;
        }
        result = Integer.toString(temp_sum).substring(last_idx) + result;
        }
        if (carry != 0) result = "1" + result; 
        return result;
        }

         String digitequal(String a, String b)
         {
            int size = a.length() - b.length();
            for (int i = 1; i <= size; i++)
            b = "0" + b;
            return b;
            }

            int max(int x,int y)
    {
        return (x>y?x:y);
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
         
        S4 ob=new S4();
        String s1="1";
        String sa="0";
        String sb="1";
        String sc="";
       long St=System.nanoTime();
        while(!s.equals(s1))
        { 
            sc=ob.digitadder(sa,sb);
            sa=sb;
            sb=sc;
            
            s1=ob.digitadder(s1,"1");

        }
        
        long Et=System.nanoTime();
        System.out.println(Et-St);
        
        
    }


}