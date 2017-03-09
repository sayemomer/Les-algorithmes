#include<iostream>
using namespace std;

int powerr(int base , int power )
{

    if (power==0)
    {
        return 1;
    }
    else
       return base*powerr(base,power-1);
}

int main()
{
    int n ,x  ;
       cout<<"Enter the base :"<<endl;
    cin>>n;
    cout<<"Enter the power :"<<endl;
    cin>>x;

    cout<<""<<powerr(n,x)<<endl;
    return 0;
}
