import java.util.*;
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

    void sortbyx(points[] arr,int n)
    {
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


    void sortbyy(points[] arr,int n)
    {
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



   points[] closest(points[] arr,int n)
    {
        double min=distance(arr[0],arr[1]);
        points[] pair=new points[2];
        pair[0]=new points(arr[0].x,arr[0].y);
        pair[1]=new points(arr[1].x,arr[1].y);
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
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

    points[] closestpair(points[] a,int n)
    {
        if(n<=3)
        return closest(a,n);
        
        points[] sortx=new points[a.length];
        points[] sorty=new points[a.length];
        for(int i=0;i<n;i++)
        {
            sortx[i]=new points(a[i].x,a[i].y);
            sorty[i]=new points(a[i].x,a[i].y);
        }
        sortbyx(sortx,n);
        sortbyy(sorty,n);
        points[] righthalf=new points[n-n/2];
        points[] lefthalf=new points[n/2];
        for(int i=0;i<n/2;i++)
        lefthalf[i]=new points(sortx[i].x,sortx[i].y);
        for(int i=n/2;i<n;i++)
        righthalf[i-n/2]=new points(sortx[i].x,sortx[i].y);
        
        points[] pair1=closestpair(lefthalf,n/2);
        points[] pair2=closestpair(righthalf,n-n/2);

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
            for(int j=i+1;j< min(strip.size(),i+7);j++)
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

    int min(int a,int b)
    {
        return a>b?b:a;
    }
     public static void main(String[] args)
        {
            
            points[] ob=new points[30];
            ob[0]=new points(95,89);
            ob[1]=new points(12,83);
            ob[2]=new points(58,56);
            ob[3]=new points(34,7);
            ob[4]=new points(8,47);
            ob[5]=new points(51,15);
            ob[6]=new points(47,39);
            ob[7]=new points(33,61);
            ob[8]=new points(18,1);
            ob[9]=new points(11,9);
            ob[10]=new points(56,37);
            ob[11]=new points(60,26);
            ob[12]=new points(52,66);
            ob[13]=new points(86,2);
            ob[14]=new points(99,30);
            ob[15]=new points(22,50);
            ob[16]=new points(30,34);
            ob[17]=new points(27,65);
            ob[18]=new points(5,42);
            ob[19]=new points(63,35);
            ob[20]=new points(28,11);
            ob[21]=new points(82,67);
            ob[22]=new points(7,46);
            ob[23]=new points(10,97);
            ob[24]=new points(14,12);
            ob[25]=new points(90,41);
            ob[26]=new points(31,54);
            ob[27]=new points(20,38);
            ob[28]=new points(42,18);
            ob[29]=new points(87,22);
            
            close A=new close();
           points[] closes= A.closestpair(ob,30);
           System.out.println(closes[0].x+","+closes[0].y);
             System.out.println(closes[1].x+","+closes[1].y);
            System.out.println(" "+A.distance(closes[0],closes[1]));
        }
    
}