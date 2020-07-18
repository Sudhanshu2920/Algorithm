import java.io.*;
import java.util.*;
class linearsearch
{
   public static void main(String[] args) throws Exception
   {
       FileReader file=new FileReader("/C:/Users/ASUS/Desktop/Codes/Algorithm/File 4.txt");
       Scanner sc=new Scanner(file);
       ArrayList<Integer> list=new ArrayList<Integer>();
       int count=0;
       
       
       
       while(sc.hasNext())
       {
           count++;
           list.add(sc.nextInt());

       }
       int arr[]=new int[count];

       for(int i=0;i<count;i++)
       {

           arr[i]=list.get(i);
       }
       System.out.println("Enter the number you want to search");
       Scanner wr =new Scanner(System.in);
       int x=wr.nextInt();
       int flag=0;
       int i=0;
       long St=System.nanoTime();
       for( i=0;i<count;i++)
       {
           if(x==arr[i])
           {
               
               
               flag=1;
               break;
           }
       }
       long Et=System.nanoTime();
       if(flag==0)
       
       System.out.println("Number is not found");
       else
       System.out.println(" number is found at index :"+i);
       System.out.println(Et-St);
      
   }

}