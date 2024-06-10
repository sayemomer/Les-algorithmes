
#include<iostream>
#define infy 123456789
using namespace std;
int cost[100][100],n,d[100],p[100],s[100];

int extractMin()
{
    int Min=infy,mini=-1;
    for(int i=1;i<=n;i++)
    {
        if(s[i]<Min && s[i]!=-2)
        {
            Min=s[i];
            mini=i;

        }
    }
    s[mini]=-2;
    return mini;
}
int dijkstra(int source)
{
    int k=0,u;
    for(int i=1;i<=n;i++)
    {
        d[i]=infy;
        p[i]=-1;
        s[i]=0;
    }
    d[source]=0;
    s[source]=0;

    while(k<n)
    {
        u=extractMin();
        for(int v=1;v<=n;v++)
        {
            if(cost[u][v]!=0)
            {
                if(d[u]+cost[u][v]<d[v])
                {
                    d[v]=d[u]+cost[u][v];
                    if(s[v]!=-2)
                        s[v]=d[u]+cost[u][v];
                    p[v]=u;
                }
            }
        }
        k++;
    }
    for(int i=1;i<=n;i++)
        cout<<d[i]<<" ";
}
int main()
{
    int i,j,s;

	cout<<"\n Enter the number of nodes:";
    cin>>n;
	cout<<"\n Enter the adjacency matrix:\n";
	for (i=1;i<=n;i++)
    {
        for (j=1;j<=n;j++)
        {
            cin>>cost[i][j];

        }
	}
	cout<<"Enter source vertex : ";
	cin>>s;
	dijkstra(s);
}


/*
5
0 10 0 5 0
0 0 1 2 0
0 0 0 0 4
0 3 9 0 2
7 0 6 0 0
*/

