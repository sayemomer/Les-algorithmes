#include<iostream>
using namespace std;

int factorial(int n )
{

try{
if(n==0)
{
    throw 1;
}
}
catch(int e)
{
 cout<<"factorial is : "<<e<<endl;

}

  if(n==1)
  {
      return 1;
  }
  else
    return n*factorial(n-1);
}

int main()
{
    int n ;
       cout<<"Enter the number :"<<endl;
    cin>>n;
    cout<<"factorial is :"<<factorial(n)<<endl;
}
