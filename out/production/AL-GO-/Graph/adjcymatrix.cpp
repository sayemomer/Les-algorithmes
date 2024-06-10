#include<iostream>
using namespace std;

int main()
{
    int row,col,v1,v2;
    cout<<"enter size: "<<endl;
    cin>>row;
    col=row;
     int a[row][col];
    for(int i=1;i<=row;i++)
    {
        for(int j=1;j<=col;j++)
        {
            cin>>a[i][j];
        }
    }
    cout<<"matrix :";
     for(int i=1;i<=row;i++)
    {
        for(int j=1;j<=col;j++)
        {
            cout<<a[i][j]<<" ";
        }
        cout<<endl;
    }

    cout << " enter vertex's to check :"<<endl;
    cin>>v1>>v2;

    if(v1>0&&v2>0&&v1<=row&&v2<=col)
    {
    if(a[v1][v2]==1)
        cout<<"connected";
    else
        cout<<"not conected";
    }
    else
        cout<<"invalid"<<endl;
    return 0;
}
/*
6
0 1 0 0 1 1
1 0 1 0 1 0
0 1 0 1 0 0
0 0 1 0 1 1
1 0 0 1 0 0
1 1 0 0 0 0
*/

