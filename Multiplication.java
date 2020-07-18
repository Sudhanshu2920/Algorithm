import java.util.*;
import java.io.*;
class A
{
    long multiply(long a,long b)
    {
        
        int S1=size(a);
        int S2=size(b);
        int N=max(S1,S2);
        if(N<=1)
            return a*b;
          
         N=(N/2)+(N%2);
        long D=(long) Math.pow(10,N);
        long al=a/D;
        long ar=a-al*D;
        long bl=b/D;
        long br=b-bl*D;

        long p1=multiply(al,bl);
        long p2=multiply(al,br);
        long p3=multiply(ar,bl);
        long p4=multiply(ar,br);
         
        long P=p1*(long)Math.pow(10,2*N)+(p2+p3)*(long)Math.pow(10,N)+p4;

        return P;
          }
    }

    int size(long a)
    {
        int count=0;
        while(a!=0)
        {
             a=a/10;
             count++;
        }
        return count;
    }

    int max(int x,int y)
    {
        return (x>y?x:y);
    }

    public static void main(String[] args)
    {
        A ob=new A();
       long R= ob.multiply(74213623,23456583);
       System.out.println(R);

    }

}