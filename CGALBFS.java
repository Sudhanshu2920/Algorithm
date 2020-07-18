import java.util.Scanner;
import java.lang.String;
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        next=null;
    }
}
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
class CGALBFS
{
    static int[] v;                 
    Queue q;
    CGALBFS(int V)
    {
        v=new int[V+1];
        for(int i=0;i<=V;i++)
           v[i]=-1;
        q=new Queue();
    }
    public int[] BFS(Node[] node,int i)
    {
        Node n=node[i];
        while((n=n.next)!=null)
        {
            if (v[n.data]!=1)
            {
               v[n.data]=1;
               q.add(n.data);
            }
        }
        int a;
        while((a=q.pull())!=-1)
            BFS(node,a);
        return v;
    } 
    public static Node[] adjacency_list(int arr[][],int v)
    {
        Node[] node=new Node[v+1];
        for(int i=1;i<=v;i++)
           node[i]=new Node(i);
        Node[] curr=new Node[v+1];
        for(int i=1;i<=v;i++)
           curr[i]=node[i];
        for(int i=0;i<arr.length;i++)
        {
            Node n1=new Node(arr[i][0]);
            Node n2=new Node(arr[i][1]);
            curr[arr[i][0]].next=n2;
            curr[arr[i][0]]=curr[arr[i][0]].next;
            curr[arr[i][1]].next=n1;
            curr[arr[i][1]]=curr[arr[i][1]].next;
        }
        return node;
    }
    public static void main(String args[])
    {
        int V=8;
        int[][] arr={{1,8},{3,4},{5,4},{1,4},{6,7}};
        Node[] node=adjacency_list(arr,V);
        int visited[]=new int[V+1];     
        for(int i=0;i<=V;i++)
           visited[i]=-1;                 
        CGALBFS obj=new CGALBFS(V);
        int count=0;
        for(int i=1;i<visited.length;i++)
        {
            if (visited[i]==-1)
            {
               v[i]=1;
               visited=obj.BFS(node,i); 
               count++;
            }
        }
        System.out.println("No of connected componenet="+count); 
    }
}
