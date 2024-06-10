
#include<iostream>
using namespace std;

int prim(int visited[],int cost[][100],int n)
{
    int a,b,i,j,ne=1,MIN,MINcost=0;
    while(ne<n)
    {
         MIN=999;
		for (i=1;i<=n;i++)
		{
		    for (j=1;j<=n;j++)
            {
                if(cost[i][j]<MIN && visited[i]!=0)
                {
                    MIN=cost[i][j];
                    a=i; // to store the parent 
                    b=j;
                }
            }
		}
		if(visited[a]==0 || visited[b]==0) {  //to visit the edes 
			cout<<"\n Edge :"<<ne++<<" cost: "<<a<<" "<<b<<" "<<MIN<<" "; // adding the min cost 
			MINcost+=MIN; 
			visited[b]=1;
		}
		cost[a][b]=cost[b][a]=999; //to not consider the taken edges wieght
	}
	return MINcost;
}
int main()
{
    int n,i,j;
    int visited[100]={0},cost[100][100];
	cout<<"\n Enter the number of nodes:";
    cin>>n;
	cout<<"\n Enter the adjacency matrix:\n";
	for (i=1;i<=n;i++)
    {
        for (j=1;j<=n;j++)
        {
            cin>>cost[i][j];
            if(cost[i][j]==0)
                cost[i][j]=999;
        }
	}
	visited[1]=1;
	int mc=prim(visited,cost,n);
	cout<<"\n Minimun cost : "<<mc;
    cout<<endl;
}

//Smaple input 1:
/*
10
0 4 0 1 0 0 0 0 0 0
4 0 4 4 0 0 0 0 0 10
0 4 0 0 2 1 0 0 0 0
1 4 0 0 0 0 0 5 0 6
0 0 2 0 0 0 2 0 0 0
0 0 1 0 0 0 3 0 5 0
0 0 0 0 2 3 0 0 3 4
0 0 0 5 0 0 0 0 0 2
0 0 0 0 0 5 3 0 0 3
0 10 0 6 0 0 4 2 3 0
*/

//Smaple input 2:
/*
8
0 8 0 0 0 10 0 4
8 0 4 0 10 7 0 9
0 4 0 3 0 3 0 0
0 0 3 0 25 18 2 0
0 10 0 25 0 2 7 0
10 7 3 18 2 0 0 0
0 0 0 2 7  0 0 0
4 9 0 0 0 0 3 0

