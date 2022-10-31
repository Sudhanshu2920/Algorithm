// Find peak element - Binary Search on answer

#include <iostream>
using namespace std;

int solve(int a[],int size){
    int start=0,end=size-1;
    while(start<=end){
        int mid= start+(end-start)/2;
        //ignoring the boundary cases
        if(mid>0 and mid<size-1){
            if(a[mid]> a[mid-1] and a[mid]>a[mid+1])
                return mid;
            else if (a[mid]> a[mid-1])
                start= mid+1;
            else 
                end= mid-1;
        }

        if(mid==0 && a[0]>a[1])
            return 0;
        else if (mid==size-1 && a[size-1]>a[size-2])
            return size-1;
    }
    return -1;
}
int main(){
    int a[]= {3,4,3,2,1};
    cout << solve(a,7) << endl;
}