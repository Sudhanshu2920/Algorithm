import java.io.*;
import java.util.*;
class S1
{
    String fibbonacci(String n)
    {
        if(Integer.parseInt(n)<=1)
        return n;
        else
        {
          return digitadder(fibbonacci(digitsubtracter(n,"1")),fibbonacci(digitsubtracter(n,"2"))); 
        }
    }
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


    String digitsubtracter(String a,String b)
         {
            int a1 = a.length();
            int b1 = b.length();
            int n = max(a1,b1);
            //making no of digit equal
            if (a1 > b1)
            b = digitequal(a, b);
            else if (a1 < b1)
            a = digitequal(b, a);
            
            String result = "";
            String[] a_carry_board = a.split(""); 
            for (int i = n - 1; i >= 0; i--) 
            {
                int a_digit = Integer.parseInt(a_carry_board[i]);
                int b_digit = Integer.parseInt( Character.toString( b.charAt(i) ) );
                int temp_sub;
                if (b_digit > a_digit) 
                {
        
                     a_digit += 10;
                     int j = i - 1;
                        //setting preceding 0s to 9
                      while (a_carry_board[j].equals("0")) 
                      {
                          a_carry_board[j] = "9";
                            j--;
                        }
                    a_carry_board[j] = Integer.toString(Integer.parseInt(a_carry_board[j]) - 1); //subtracting previous digit by 1
                }
            temp_sub = a_digit - b_digit;
            result = Integer.toString(temp_sub) + result;
            }
            return result;
         }



    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the Value of n");
       String n=sc.nextLine();
       S1 ob=new S1();
       long St=System.nanoTime();
       ob.fibbonacci(n);
       Long Et=System.nanoTime();
       System.out.println(Et-St);
    }
}