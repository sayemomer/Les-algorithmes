#include<iostream>
using namespace std;

int color[50],time,d[50],p[50],u,v,f[50],n,graph[50][50],transpose[50][50];

int DFS_Visit(int u)
{
    int GREY=1,WHITE=0,BLACK=-1;
    color[u] = GREY;
    time = time+1;
    d[u] = time; // compute d[]
    for(int i=0;i<n;i++)
    {
       if(graph[u][i]==1)
       {
            if (color[i] == WHITE)
            {
                p[i]= u; // build tree
                DFS_Visit(i);
            }
       }
    }
    color[u] = BLACK;
    time = time+1;
    f[u] = time; // compute f[]
}


int DFS(int G[50][50])
{
    int GREY=1,WHITE=0,BLACK=-1;
    for (int i=0;i<n;i++)
    {
        color[i] = WHITE;
    }
    time = 0;
    for (int i=0;i<n;i++)
    {
        if (color[i] == WHITE)
        {
            DFS_Visit(i);
        }
        cout<<"node "<<i<<" start time :"<<d[i]<<" and finish time : "<<f[i]<<endl;
    }
}

void bubblesort(int a[],int n)
{
    int counter=0;
    for(int i=1;i<n;i++)
    {
        int s=0;
        for(int j=0;j<n-i;j++)
        {
            if(a[j]>a[j+1])
            {
                int temp;
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                s=s+1;
                counter++;
            }
        }
        if(s==0)
            break;
    }
    cout<<"Sorted Array is "<<endl;
    for(int i=0;i<n;i++)
    {
        cout<<a[i]<<" ";
    }
    cout<<"total loop counter "<<counter;
}

int main()
{
    cout << "Enter the number of nodes: "<<endl;
    //int n;
    cin >> n;
   // int graph[n][n];
    int i,j;
    cout<<"enter the value:"<<endl;
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            cout<<"enter value "<<i+1<<"and"<<j+1<<":";
            int value;
            cin>>value;
            graph[i][j]=value;
            cout<<endl;
        }

    }
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            cout<<graph[i][j]<<"  ";
        }
        cout<<endl;

    }
    DFS(graph);

    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            cout<<graph[i][j]<<"  ";
        }
        cout<<endl;

    }


}
/*
4
0 1 0 1
0 0 1 0
0 0 0 1
0 0 0 0
*/
