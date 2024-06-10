#include<iostream>
using namespace std;
int main()
{
    int v,e,v1,v2,flag=0;
    cout<<"enter size: "<<endl;
    cin>>v;
    int a[v][v],d[v];
     for(int i=1;i<=v;i++)
    {
    cin>>d[i];
    }
    for(int i=1;i<=v;i++)
    {
        for(int j=1;j<=d[i];j++)
        {
            cin>>a[i][j];
        }
    }
    cout<<"matrix :"<<endl;
     for(int i=1;i<=v;i++)
    {
        cout<<i<<"->";
        for(int j=1;j<=d[i];j++)
        {
            cout<<a[i][j]<<" ";
        }
        cout<<endl;
    }
    cin>>v1>>v2;
    
 cout << " enter vertex's to check :"<<endl;
    for(int i=1;i<=d[v1];i++)
    {
         if(a[v1][i]==v2)
         {

    cout<<"connected";
        flag=1;
        break;
    }
    }
    if(flag==0)
    cout<<"not connected";


return 0;
}
/*
6
3
3
2
3
2
3
2 5 6
1 3 6
2 4
3 5 6
1 4
1 2 4*/
