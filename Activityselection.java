class Activity_Selection 
{ 
    public void  Activity_Maximum(int start[],int finish[],int n ) 
    { 
        System.out.println("Maximum number of activities which can be held at a single time :"); 
        int i=0; 
        System.out.print(i+" ");       
          for(int j=1;j<n;j++) 
        { 
         if(start[j]>=finish[i]) 
         { 
             System.out.print(j+" "); 
             i=j; 
         } 
        } 
    } 
    public static void main(String[] args) 
    { 
    int begin[]={5,3,11,12};  
       int end[]={10,7,15,18};   
         int n=begin.length; 
      Activity_Selection ob=new Activity_Selection();  
       ob.Activity_Maximum(begin,end,n); 
     
} 
} 

