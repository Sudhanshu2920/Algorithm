import java.util.*;
import java.io.*;

class MergeSort3 
{
    void sort(int[] arr) 
    {
        int n = arr.length;
        if (n > 1) 
        {
            int d=arr.length/3;
            int[] arr1=new int[d];
            int[] arr2=new int[d+1];
            int[] arr3=new int[n-2*d-1];
            for(int i=0;i<d;i++)
                   arr1[i]=arr[i];
            for(int i=d;i<2*d+1;i++)
                    arr2[i-d]=arr[i];
            for(int i=2*d+1;i<n;i++)
                  arr3[i-2*d-1]=arr[i];
            

                sort(arr1);
                 sort(arr2);
               sort(arr3);
                merge(arr1, arr2, arr3, arr);

        }
    }

    void merge(int[] arr1, int[] arr2, int[] arr3, int[] arr) 
    {
        int a1 = arr1.length;
        int a2 = arr2.length;
        int a3 = arr3.length;
        int i = 0,j=0,k=0,l=0;
        
        while (i < a1 && j < a2 && k < a3) 
        {
            if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) 
            {
                arr[l] = arr1[i];
                i++;
            } 
            else  if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k])

                  {
                       arr[l] = arr2[j];
                       j++;
                  } 
                  else 
                 {
                      arr[l] = arr3[k];
                       k++;

                  }
        
            l++;
    }
            while(i<a1 && j<a2)
            {
                if(arr1[i]<=arr2[j])
                {
                   arr[l]=arr1[i];
                   i++;
                }
                else
                {
                    arr[l]=arr2[j];
                    j++;
                }
                l++;
            }
            while(i<a1 && k<a3)
            {
                if(arr1[i]<=arr3[k])
                {
                    arr[l]=arr1[i];
                    i++;
                }
                else
                {
                    arr[l]=arr3[k];
                    k++;
                }
                l++;
            }
            while(j<a2 && k<a3)
            {
                if(arr2[j]<=arr3[k])
                {
                    arr[l]=arr2[j];
                    j++;
                }
                else
                {
                    arr[l]=arr3[k];
                    k++;
                }
                l++;
            }
            while(i<a1)
            {
                arr[l]=arr1[i];
                i++;
                l++;
            }
            while(j<a2)
            {
                arr[l]=arr2[j];
                j++;
                l++;
            }
            while(k<a3)
            {
                arr[l]=arr3[k];
                k++;
                l++;
            }


        

    }

    public static void main(String[] args) throws Exception
    {
        FileReader file=new FileReader("/C:/Users/ASUS/Desktop/Codes/Algorithm/Worst case/File 10.txt");
        Scanner sc=new Scanner(file);
        int count=0;
        ArrayList<Integer> list=new ArrayList<Integer>();

        while(sc.hasNextInt())
        {
          list.add(sc.nextInt());
          count++;
        }
        int[] arr =new int[count];
        for(int i=0;i<count;i++)
        {
            arr[i]=list.get(i);
        }
        MergeSort3 ob=new MergeSort3();
        long St=System.nanoTime();
        ob.sort(arr);
        Long Et=System.nanoTime();
            System.out.println(" "+(Et-St));
            
        
    }

}