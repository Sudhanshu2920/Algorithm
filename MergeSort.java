import java.io.*;
import java.util.*;

class MergeSort
{
    void sort(int arr[])
    {
        int n=arr.length;
        
        if(n>1)
        {
            int mid=n/2;
            int i;
            int left[]=new int[mid];
           int right[]=new int[n-mid];
           for(i=0;i<mid;i++)
           left[i]=arr[i];
           for(i=mid;i<n;i++)
           right[i-mid]=arr[i];

           sort(left);
           sort(right);
           merge(left,right,arr);
        }

    }

    void merge(int L[],int R[], int arr[])
    {
         int nl=L.length;
        int nr=R.length;
        int i=0,j=0,k=0;
        while(i<nl && j<nr)
        {
            if(L[i]<=R[j])
            {
                arr[k]=L[i];
                i++;
            }
            else
            {
                arr[k]=R[j];
               j++;
            }
            k++;
            
        }
        while(i<nl)
        {
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<nr)
        {
            arr[k]=R[j];
           j++;
           k++;
            
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
    int i;
    long n=0;
    FileReader file =new FileReader("/C:/Users/ASUS/Desktop/Codes/Algorithm/Worst case/File 2.txt");
    Scanner sc=new Scanner(file);
    ArrayList<Integer> list=new ArrayList<Integer>();
    int count=0;
    while(sc.hasNextInt())
    {
            list.add(sc.nextInt());
            count++;
    }
    int[] arr=new int[count];
    for( i=0;i<count;i++)
    {
         arr[i]=list.get(i);
    }
    MergeSort ob=new MergeSort();
    
    
    
   long ST=System.nanoTime();
    ob.sort(arr);
    long ET=System.nanoTime();
    System.out.println(ET-ST);
    
    

    }
}