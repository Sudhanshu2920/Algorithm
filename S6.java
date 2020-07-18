import java.util.*;
import java.io.*;
class S6
{
     String fib_matrix_recursive(String n)
     {
         if(Integer.parseInt(n)<=1)
         return n;
         String[][] M={{"1","1"},{"1","0"}};
         String[][] N={{"1"},{"0"}};
         for(int i=2;i<=Integer.parseInt(n);i++)
         {
             N=mat_multiply(M,N);
         }
         return N[0][0];
     }

     String[][] mat_multiply(String[][] a,String[][] b)
     {
         String[][] c=new String[2][1];
         c[0][0]=digitadder(multiply(a[0][0],b[0][0]),multiply(a[1][0],b[1][0]));
         c[1][0]=digitadder(multiply(a[1][0],b[0][0]),multiply(a[1][1],b[1][0]));
         return c;
     }

     String multiply(String a,String b)
    {
        
        int S1=a.length();
        
        int S2=b.length();
        int N=max(S1,S2);
        if(N==1)
          return Integer.toString(Integer.parseInt(a)*Integer.parseInt(b));
          else{
        if (S1 > S2)
          b = digitequal(a, b);
          else if (S1 < S2)
                    a = digitequal(b, a);
        //dividing the string in different parts
        String al=a.substring(0,N/2);
        String ar=a.substring(N/2,N);
        String bl=b.substring(0,N/2);
        String br=b.substring(N/2,N);
           
        
         String p1=multiply(al,bl); //al*bl
         String p2=multiply(ar,br); //ar*br
         String k1=digitadder(al,ar); //(al+ar)
         String k2=digitadder(bl,br); //(bl+br)
         String k3=multiply(k1,k2); //(al+ar)*(bl+br)
         String k4=digitadder(p1,p2); //(al*bl + ar*br)
         String temp1=digitsubtracter(k3,k4);//(al+ar)*(bl+br)-(al*bl + ar*br)

         N=N/2+N%2;
         for(int i=0;i<2*N;i++)  //al*bl*base^2*N
         {
             p1+="0";
         }
         for(int i=0;i<N;i++)//((al+ar)*(bl+br)-(al*bl + ar*br))*base^N
         {
             temp1+="0";
         }
         String temp2=digitadder(p1,p2); //al*bl*base^2*N + ar*br
         return digitadder(temp1,temp2);//((al+ar)*(bl+br)-(al*bl + ar*br))*base^N + al*bl*base^2*N + ar*br
         
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
       
        S6 ob=new S6();
        long St=System.nanoTime();
        ob.fib_matrix_recursive(n);
        Long Et=System.nanoTime();
        System.out.println(Et-St);

    }

}