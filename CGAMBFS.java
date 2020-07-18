
import java.util.*;
class Queue
{
    int[] arr;
    int l,size;
    Queue()
    {
        arr=new int[5];
        l=0;
        size=5;
    }
    public int[] double_length(int[] arr)
    {
         int a[]=new int[2*arr.length];
         for(int i=0;i<arr.length;i++)
            a[i]=arr[i];
        return a;
    }
    public void add(int a) {
        arr[l]=a;
        l++;
        if (l==size)
        {
            arr=double_length(arr);
            size=size*2;
        }
    }
    public int pull()
    {
         if (l==0)
             return -1;
         int a=arr[0];
         for(int i=0;i<l-1;i++)
             arr[i]=arr[i+1];
         l--;
         return a;
    }
}
class CGAMBFS
{
    static int[] v;                 
    static Queue q;
    CGAMBFS(int V)
    {
        v=new int[V+1];
        for(int i=0;i<=V;i++)
           v[i]=-1;
        q=new Queue();
    }
     int[] BFS(int[][] arr,int n)
    {
        for(int i=1;i<arr.length;i++)
        {
            int f=0;
            if (v[i]==1)
               continue;
            else if (arr[n][i]!=0)
            {
               v[i]=1;
               q.add(i);
            }
        }
        int a;
        while((a=q.pull())!=-1)
        {
            BFS(arr,a);   
        }
        return v;
    }
     static int[][] adjacency_matrix(int a[][],int v)
    {
        int[][] arr=new int[v+1][v+1];
        for(int i=0;i<a.length;i++)
        {
            arr[a[i][0]][a[i][1]]++;
            arr[a[i][1]][a[i][0]]++;
        }
        return arr;
    }
    public static void main(String args[])
    {
        int V=8;
        int[][] a={{1,8},{3,4},{5,4},{1,4},{6,7}};
        int[][] arr=adjacency_matrix(a,V);
        int visited[]=new int[V+1];     
        for(int i=0;i<=V;i++)
           visited[i]=-1;           
        CGAMBFS obj=new CGAMBFS(V);
        int count=0;
        for(int i=1;i<visited.length;i++)
        {
            if (visited[i]==-1)
            {
               v[i]=1;
               visited=obj.BFS(arr,i); 
               count++;
            }
        }

        System.out.println("No of connected Componenet="+count);
    }
}
