import java.util.*;
import java.io.*;
class points
{ 
    double x,y;
    points(double x,double y)
    {
        this.x=x;
        this.y=y;
    }
}
class A{
    void sortbyy(points[] arr)
    {
        int n=arr.length;
        int i,j;
        for( i=1;i<n;i++)
        {
           double key=arr[i].y;
            double temp=arr[i].x;
            j=i;
            while(j>0 && key<arr[j-1].y)
            {
                arr[j].x=arr[j-1].x;
                arr[j].y=arr[j-1].y;
                j=j-1;
            }
            arr[j].y=key;
            arr[j].x=temp;
        }
    }

    void print(points[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i].x+","+arr[i].y);
        }
    }
    
        public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the value of n");
           int n=sc.nextInt();
            points ob[]=new points[n];
            for(int i=0;i<n;i++)
            {
                double x=sc.nextDouble();
                double y=sc.nextDouble();
                ob[i]=new points(x,y);
            }

            A obj=new A();
             
            obj.sortbyy(ob);
            obj.print(ob);
        }

    }
