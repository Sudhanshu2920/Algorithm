import java.util.*;
import java.io.*;
class ranstring
{
    public static void main(String[] args)
    {

    
        String a="";
        String b="";
        Random n=new Random();
        for(int i=0;i<1000;i++)
        {
            a= a+Integer.toString(n.nextInt(9));
            b=b+Integer.toString(n.nextInt(9));
        }
        System.out.println("a="+a);
        System.out.println("b="+b);
}

}