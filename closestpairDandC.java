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

class close{

    void sortbyx(points[] arr)
    {
        int n=arr.length;
        int i,j;
        for( i=1;i<n;i++)
        {
           double key=arr[i].x;
            double temp=arr[i].y;
            j=i;
            while(j>0 && key<arr[j-1].x)
            {
                arr[j]=new points(arr[j-1].x,arr[j-1].y);
                j=j-1;
            }
            arr[j].x=key;
            arr[j].y=temp;
        }
    }


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



   points[] closest(points[] arr)
    {
        double min=distance(arr[0],arr[1]);
        points[] pair=new points[2];
        pair[0]=new points(arr[0].x,arr[0].y);
        pair[1]=new points(arr[1].x,arr[1].y);
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                 double dist=distance(arr[i],arr[j]);
                 if(dist<min)
                 {
                     min=dist;
                     pair[0]=new points(arr[i].x,arr[i].y);
                     pair[1]=new points(arr[j].x,arr[j].y);
                 }
            }
        }
        return pair;
    }

    points[] closestpair(points[] a)
    {
        if(a.length<=3)
        return closest(a);
        
        points[] sortx=new points[a.length];
        points[] sorty=new points[a.length];
        for(int i=0;i<a.length;i++)
        {
            sortx[i]=new points(a[i].x,a[i].y);
            sorty[i]=new points(a[i].x,a[i].y);
        }
        sortbyx(sortx);
        sortbyy(sorty);
        int n=sortx.length;
        points[] righthalf=new points[n-n/2];
        points[] lefthalf=new points[n/2];
        for(int i=0;i<n/2;i++)
        lefthalf[i]=new points(sortx[i].x,sortx[i].y);
        for(int i=n/2;i<n;i++)
        righthalf[i-n/2]=new points(sortx[i].x,sortx[i].y);
        
        points[] pair1=closestpair(lefthalf);
        points[] pair2=closestpair(righthalf);

        double min1=distance(pair1[0],pair1[1]);
        double min2=distance(pair2[0],pair2[1]);
        double min;
        points[] pair =new points[2];

        if(min1<min2){
            pair[0]=new points(pair1[0].x,pair1[0].y);
            pair[1]=new points(pair1[1].x,pair1[1].y);
            min=min1;
        }
        else
        {
            pair[0]=new points(pair2[0].x,pair2[0].y);
            pair[1]=new points(pair2[1].x,pair2[1].y);
            min=min2;
        }
          
        ArrayList<points> strip=new ArrayList<points>();
        double mid=sortx[n/2].x;
        double leftboundary=mid-min;
        double rightboundary=mid+min;
        for(int i=0;i<n;i++)
        {
            if(leftboundary<sorty[i].x && rightboundary>sorty[i].x)
            strip.add(sorty[i]);
        }
          
        for(int i=0;i<strip.size()-1;i++)
        {
            for(int j=i+1;j<Math.min(strip.size(),i+7);j++)
            {
                double dist=distance(strip.get(i),strip.get(j));
                if(dist<min)
                {
                    min=dist;
                    pair[0]=new points(strip.get(i).x,strip.get(i).y);
                    pair[1]=new points(strip.get(j).x,strip.get(j).y);
                }
            }
        }
        return pair;

    }

    double distance(points a,points b)
    {
        double x=a.x-b.x;
        double y=a.y-b.y;
        return Math.sqrt(x*x + y*y);
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

            close A=new close();
           points[] closes= A.closestpair(ob);
           System.out.println(closes[0].x+","+closes[0].y);
             System.out.println(closes[1].x+","+closes[1].y);
            System.out.println(" "+A.distance(closes[0],closes[1]));
        }
    
}