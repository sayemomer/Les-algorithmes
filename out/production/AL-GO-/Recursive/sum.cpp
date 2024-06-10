#include<iostream>
using namespace std;

int sum(int n)
{
  if(n==1)
  {
      return 1;
  }
  else
    return n+sum(n-1);


}

int main()
{
    int n ;
    cout<<"Enter the range to sum :"<<endl;
    cin>>n;

    cout<<"Sum is :"<<sum(n)<<endl;

    return 0;

}
