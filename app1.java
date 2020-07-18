import java.io.*;
import java.util.*;

class temp1
{ public double get()
{double value=10.0; // Local variable
value = value + this.value;
return value;
}
private String name;
public double value=100.0; // Field with the same name
}
 class temp2
{ public static void main(String args[])
{
temp1 a=new temp1();
System.out.println(a.get());
System.out.println(a.value);
}}