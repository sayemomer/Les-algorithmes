#include<iostream>
#include <queue>
using namespace std;
int graph[1000][1000];
int vertices ;
string color[100];
int d[50];
int p[50];

int bfs( int source)
{

  queue<int> myqueue;
  int u ;
  d[0]=0;

  myqueue.push(source);


  for(int i=0;i<vertices;i++)
    {
      color[i]="white";
    }


  while( !myqueue.empty() )
    {
        u =myqueue.front();
            for( int v=0 ;v<vertices ;v++)
                {
                    if( graph[u][v]==1 && color[v]=="white")
                        {
                            color[v]="gray";
                            d[v]=d[u]+1;
                            p[v]=u;
                            myqueue.push(v);

                        }
                }
        color[u]="black";
   }


}

int main()
{
    int row,col,source;
    cout<<"Enter the number of vertices : "<<endl;
    cin>>vertices;
    row=vertices;
    col=row;


        for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                    {
                        cin>>graph[i][j];
                    }
            }

    cout<<"  The graph  is :"<<endl;

        for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                    {
                        cout<<graph[i][j]<<" ";
                    }
                cout<<endl;
            }

        cout<<"Enter the source vertex for BFS operation :"<<endl;
        cin>>source ;

        bfs(source);

    for(int i=0;i<vertices;i++)
    {
       cout<<" "<<color[i];
    }
    return 0;
}
