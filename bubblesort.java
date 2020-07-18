import java.io.*;
import java.util.*;
class bubblesort
{
    void sort(int arr[])
    {
        int n=arr.length,i,j;
        for(i=0;i<n-1;i++)
        {
            
           for(j=0;j<n-i-1;j++)
           {
               if(arr[j]>arr[j+1])
               {
                   int temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
                  

               }
           }
           
           
        }
    }
    void print(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(" "+arr[i]);

        }
        System.out.println("");
    }
    public static void main(String[] args) throws Exception
    {
        FileReader file=new FileReader("/C:/Users/ASUS/Desktop/Codes/Algorithm/Worst case/File 4.txt");
        ArrayList<Integer> list=new ArrayList<Integer>();
        Scanner sc=new Scanner(file);
        int count=0;
        while(sc.hasNext())
        {
            list.add(sc.nextInt());
            count++;
        }

        int arr[][]=new int[10][count];
        for(int j=0;j<10;j++)
        {
        for(int i=0;i<count;i++)
        {
            arr[j][i]=list.get(i);
           
        }
        
    }
        
           bubblesort ob = new bubblesort();
           
           
           long St=System.nanoTime();
           for(int i=0;i<10;i++)
           {
            
           ob.sort(arr[i]);
           
           
        

        }
        long Et=System.nanoTime();
        System.out.println(" Excecution time is "+(Et-St)/10);
        
    }
}