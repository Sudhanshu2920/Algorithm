import java.util.*;
import java.io.*;
class S3{
    String fib(String n)
    {
        String[] f=new String[Integer.parseInt(n)+2];
        f[0]="0";
        f[1]="1";
        String a="1";
        if(Integer.parseInt(n)>1)
        {
            while(!n.equals(a))
            {
                f[Integer.parseInt(a)+1]= digitadder(f[Integer.parseInt(a)],f[Integer.parseInt(a)-1]);
                a=digitadder(a,"1");
            }
        }
       
        return f[Integer.parseInt(n)];
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

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        String n=sc.nextLine();
        S3 ob=new S3();
        long St=System.nanoTime();
        ob.fib(n);
        Long Et=System.nanoTime();
        System.out.println(Et-St);

    }

}