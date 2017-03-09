#include<iostream>
#include <time.h>
using namespace std;

int binary_re(int array[],int value,int low, int high)
{
    int mid;
   if(high<low)
        return -1;
        mid= high+low/2 ;
   if (array[mid]>value)
    return binary_re(array,value,low,mid-1);
    else if (array[mid]<value)
        return binary_re(array,value,mid+1,high);
    else
        return mid;
}

int  binary_ie(int array[],int value,int low, int high)
{
    int mid ;

   while(low<=high)
   {
       mid=(low+high)/2;

       if(array[mid]>value)
        high=mid-1;
       else if(array[mid]<value)
        low=mid+1 ;
       else
        return mid;
   }
   return -1 ;

}





int main()
{
    int n ,x;
    clock_t t;
t = clock();

    int array[100];
    cout<<"Enter the array size :" ;
    cin>>n;

    int value  , low=0 ,high=n-1;


   cout<<"Enter the array values  : "<<endl;
    for(int i=0 ;i<n ;i++)
    {
        cin>>array[i];
    }
    cout<<"Enter the value to find :"<<endl;
    cin >>value;

  //x=binary_ie(array,value,low,high);

  x=binary_re(array,value,low,high);

  t = clock() - t;
  if(x==-1)
  {
      cout<<"Not found !! :("<<endl;
  }
   else
    cout <<"Found :)"<<endl;

    cout<<"This process takes :"<< ((float)t)/CLOCKS_PER_SEC <<"seconds"<<endl;

    return 0;
}
