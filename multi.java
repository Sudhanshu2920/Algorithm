import java.util.*;
import java.io.*;
class A
{
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
        
         
            

            
            
            String al=a.substring(0,N/2);
            String ar=a.substring(N/2,N);
            String bl=b.substring(0,N/2);
            String br=b.substring(N/2,N);
           
           
        

         String p1=multiply(al,bl);
         String p2=multiply(al,br);
         String p3=multiply(ar,bl);
         String p4=multiply(ar,br);
         String k=digitadder(p2,p3);
         N=N/2+N%2;
         for(int i=0;i<2*N;i++)
         {
             p1+="0";
         }
         for(int i=0;i<N;i++)
         {
             k+="0";
         }
         String temp=digitadder(p1,p4);
         return digitadder(temp,k);
         
          }
          
    }

    String digitadder(String a1, String a2) {
        int S1 = a1.length();
        int S2 = a2.length();
        int size = max(S1, S2);
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
            int size = Math.abs(a.length() - b.length());
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
        A ob=new A();
        String a="";
        String b="";
        Random n=new Random();
        for(int i=0;i<10;i++)
        {
            a= a+Integer.toString(n.nextInt(9));
            b=b+Integer.toString(n.nextInt(9));
        }
       // System.out.println("a="+a);
        //System.out.println("b="+b);
        long St=System.nanoTime();
      String R= ob.multiply(a,b);
      long Et=System.nanoTime();
       //System.out.println(R);
       System.out.println(Et-St);

    }

}