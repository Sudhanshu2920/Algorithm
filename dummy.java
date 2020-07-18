import java.util.*;
class dummy
{
    public static void main(String[] args)
    {
        int[][] x=new int[3][3];
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                x[i][j]=i+1;
            }
        }
            

        int[][] y=new int[x.length+1][x.length+1];
        for(int i=0;i<x.length;i++)
        {
            for(int j=0;j<x[0].length;j++)
            {
                y[i][j]=x[i][j];
            }
            
        }
        for(int i=0;i<y.length;i++)
        {
            for(int j=0;j<y.length;j++)
            {
                System.out.print(" "+y[i][j]);
            }
            System.out.println();
        }
        

    }

}
    