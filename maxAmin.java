class maxAmin{
    int [] maxmin(int[] a,int low,int high)
    {
            if(low==high)
            {
                int[] r=new int[2];
                r[0]=a[high];
                r[1]=a[high];
                return r;
            }

            int mid=(low+high)/2;
            int[] a1=maxmin(a,low,mid);
            int[] a2=maxmin(a,mid+1,high);
            int[] r=new int[2];
            if(a1[0]<=a2[0])
            r[0]=a1[0];
            if(a1[0]>a2[0])
            r[0]=a2[0];
            if(a1[1]<=a2[1])
            r[1]=a2[1];
            if(a1[1]>a2[1])
            r[1]=a1[1];
            return r;
    }

    public static void main(String[] args)
    {
        int[] a={5,4,3,2,1,6};
        maxAmin ob=new maxAmin();
        int[] r=ob.maxmin(a,0,5);
        System.out.println("min:"+r[0]);
        System.out.println("max:"+r[1]);
    }
}