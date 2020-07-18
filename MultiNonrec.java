import java.io.*;
import java.util.*;

class MultiNonrec{
     int Max(int a, int b){
        if(a>b)
            return a;
        else
			return b;
	}
	 int[] multiplication(int[]a,int[] b){
		int n=Max(a.length , b.length);
		int[] result =new int[n*2];
		int set , carry;      //set suggests where to store current result
		int product=0;
            for(int i=b.length-1;i>=0;i--){
				carry=0;
                set=result.length-1;
                for(int k=b.length-1-i;k>0;k--){
                    result[set]+=0;             //This loop sets initial zeros in multiplication
                    set--;
					}
                for(int j=a.length-1;j>=0;j--){ 
					product=(b[i]*a[j])+carry;
                if(product>=10)
					{
						carry=product/10;
						product=product%10;
						if(j==0){
							result[set]+=product;
							if(result[set]>=10){
								result[set-1]+=result[set]/10;
								result[set]=result[set]%10;
							}
						set--;
						product=carry;
						}
					}
                else{
                    carry=0;
				}
                result[set]+=product;
                if(result[set]>=10){
					result[set-1]+=result[set]/10;
					result[set]=result[set]%10;
                }
                set--;             
                }
            }
        return result;
    }
    public static void main(String args[]){
		String A="";
        String B="";
        Random n=new Random();
        for(int i=0;i<1000;i++)
        {
            A= A+Integer.toString(n.nextInt(9));
            B=B+Integer.toString(n.nextInt(9));
        }
			int a[]=new int[A.length()];
			for (int i=0; i<A.length(); i++)
						a[i]=A.charAt(i)-48;			
			int b[]=new int[B.length()];
			for (int i=0; i<B.length(); i++)
						b[i]=B.charAt(i)-48;
				  MultiNonrec ob=new MultiNonrec();
				  long St=System.nanoTime();
			   int [] r= ob.multiplication(a, b);
			   long Et=System.nanoTime();
			   System.out.println(Et-St);
              // for(int i=0;i<r.length;i++)
               //System.out.print(r[i]);
	}
}

