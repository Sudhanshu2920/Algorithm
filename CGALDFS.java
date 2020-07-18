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

class CGALDFS
{
    int[] v;                 
    CGALDFS(int V)
    {
        v=new int[V+1];
        for(int i=0;i<=V;i++)
           v[i]=-1;
    }
    public int[] DFS(Node[] node,int i)
    {
        v[i]=1;
        Node n=node[i];
        while((n=n.next)!=null)
        {
            if (v[n.data]!=1)
               DFS(node,n.data);
        }
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
        CGALDFS obj=new CGALDFS(V);
        int count=0;
        for(int i=1;i<visited.length;i++)
        {
            if (visited[i]==-1)
            {
               visited=obj.DFS(node,i); 
               count++;
            }
        }
        System.out.println("No of connected componenet="+count); 
    }
}
