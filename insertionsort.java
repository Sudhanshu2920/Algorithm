import java.io.*;
import java.util.*;
class insertionsort
{
    void sort(int arr[])
    {
        int n=arr.length;
        int i,j;
        for(i=1;i<n;i++)
        {
            int value=arr[i];
            j=i; //hole
            while(j>0 && arr[j-1]>value)
            {
                arr[j]=arr[j-1];//shifting the greater number
                j=j-1;//change of hole
            }
            arr[j]=value;

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
        FileReader file=new FileReader("/C:/Users/ASUS/Desktop/Codes/Algorithm/File 4.txt");
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
        
           insertionsort ob = new insertionsort();
           
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