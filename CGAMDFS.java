import java.util.*;
class CGAMDFS
{
    int[] v;                
    CGAMDFS(int V)
    {
        v=new int[V+1];
        for(int i=0;i<=V;i++)
           v[i]=-1;
    }
    int[] DFS(int[][] arr,int n)
    {
        v[n]=1;
        for(int i=1;i<arr.length;i++)
        {
            if (v[i]==1)
               continue;
            else if (arr[n][i]!=0)
               DFS(arr,i);
        }
        
        return v;
    }
    public static int[][] adjacency_matrix(int a[][],int v)
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
        CGAMDFS obj=new CGAMDFS(V);
        int count=0;
        for(int i=1;i<visited.length;i++)
        {
            if (visited[i]==-1)
            {
               visited=obj.DFS(arr,i); 
              count++;
            }
        }
        System.out.println("No of connected componenet="+count);
    }
}
