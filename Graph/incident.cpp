#include<iostream>
using namespace std;

int main()
{
    int vertices,edges,v1,v2,flag=0;
    cin>>vertices>>edges;

    int graph[vertices][edges];
    for(int i=1;i<=vertices;i++)
    {
        for(int j=1;j<=edges;j++)
        {
            cin>>graph[i][j];
        }
    }
    cout<<"The Incidence matrix is : "<<endl;
    for(int i=1;i<=vertices;i++)
    {
        for(int j=1;j<=edges;j++)
        {
            cout<<graph[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<"Enter two vertex number to check whether they are connected or not?  "<<endl;
    cin>>v1>>v2;
    if(v1>0&&v2>0&&v1<=vertices&&v2<=vertices)
    {
       for(int i=1;i<=edges;i++)
       {
        if(graph[v1][i]==1&&graph[v2][i]==1)
        {
           cout<<"connected";
           flag=1;
           break;
        }
       }
       if(flag==0)
              cout<<"Not connected";

    }
    else
        cout<<"Invalid vertex number \n";

    return 0;
}
//6 8
//1 0 0 0 1 1 0 0
//1 1 0 0 0 0 1 0
//0 1 1 0 0 0 0 0
//0 0 1 1 0 0 0 1
//0 0 0 1 1 0 0 0
//0 0 0 0 0 1 1 1
