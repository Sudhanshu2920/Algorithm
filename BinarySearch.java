import java.util.*;
import java.io.*;
class BinarySearch
{
int search(int a[],int b,int low,int high)
{
if(high>=low)
{
int mid=(low+high)/2;
if(a[mid]==b)
return 1;
if(b<a[mid])
return search(a,b,low,mid-1);
if(b>a[mid])
return search(a,b,mid+1,high);
else return -1;
}
else
return -1;
}
public static void main(String[] args) throws Exception
{
FileReader file=new FileReader("/C:/Users/ASUS/Desktop/Codes/Algorithm/File 10.txt");
ArrayList<Integer> list=new ArrayList<Integer>();
Scanner br=new Scanner(file);
int count=0;
while(br.hasNext())
{
    list.add(br.nextInt());
    count++;
}
int[] y=new int[count];

for(int i=0;i<count;i++)
{
y[i]=list.get(i);
}
Arrays.sort(y);

System.out.println("Enter the element you want to search");
Scanner sc=new Scanner(System.in);
int z=sc.nextInt();

BinarySearch ob=new BinarySearch();
long St=System.nanoTime();

int a=ob.search(y,-1,z,y.length-1);


long Et=System.nanoTime();
System.out.println((Et-St));

}
}
