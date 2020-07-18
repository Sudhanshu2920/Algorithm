import java.io.*;
import java.util.*;
class selectionsort
{
    void sort(int arr[])
  {
     int n=arr.length;
     int i,j;
     for(i=0;i<n-1;i++)
     {

        int imin=i;
        for(j=i+1;j<n;j++)
        {
            if(arr[j]<arr[imin])
           {
               imin=j;
           }

        }
        int temp=arr[imin];
        arr[imin]=arr[i];
        arr[i]=temp;
     }
    }
    void print(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(" "+arr[i]);
            //System.out.println();
        }
      
    }
    public static void main(String[] args) throws Exception
    {
        FileReader file=new FileReader("/C:/Users/ASUS/Desktop/Codes/Algorithm/File 5.txt");
        ArrayList<Integer> list=new ArrayList<Integer>();
        Scanner sc=new Scanner(file);
        int count=0;
        while(sc.hasNext())
        {
            list.add(sc.nextInt());
            count++;
        }
        long time=0;
        int arr[][]=new int[10][count];
        for(int j=0;j<10;j++)
        {
        for(int i=0;i<count;i++)
        {
            arr[j][i]=list.get(i);
           // System.out.print("  "+arr[i]);
        }
    }
        
           selectionsort ob = new selectionsort();
           
           //System.out.println("Start time is "+St);
           long St=System.nanoTime();
           for(int i=0;i<10;i++)
           {
            
           ob.sort(arr[i]);
           
           

        }
        long Et=System.nanoTime();
        System.out.println(" Excecution time is "+(Et-St)/10);
        
    }
    }
