#include<iostream>
#include <queue>
using namespace std;
int graph[1000][1000];
int vertices , start, finish;
string color[100];
int d[50];
int p[50];


void print_path(int start , int finish)
{
   if( start == finish )
   {
       cout<<" "<<start;
   }
   else if( p[finish]<0  ) {
        cout<<"No path from:"<<start<<"to"<<finish<<"exits";
   }
   else
   {
    print_path( start , p[finish]);
    cout<<" "<<finish;
   }




}

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
        myqueue.pop();

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
    int row,col,source,v1,v2;
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

        for( int i=0;i<vertices;i++)
  {
     cout<<"Distance from: "<<source<<" to "<<i<<" is "<<d[i]<<endl ;
  }

  for( int i=0 ;i< vertices ;i++)
   {

      cout<<""<<p[i];
   }

  cout<<"Enter the start and end vertex to print path :"<<endl;
  cin>>start>>finish;

  print_path( start ,finish );

cout<<endl;
cout<<"Enter vertices to find distance:"<<endl;
cin>>v1>>v2;
  bfs(v1);
   cout<<"Distance from: "<<v1<<" to "<<v2<<" is "<<d[v2];



    return 0;
}

/*
9
0 1 0 1 0 0 0 0 0
0 0 1 0 1 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 0 0 1 0 0 0 0
0 0 1 0 0 0 1 0 1
0 0 0 1 0 0 0 1 0
0 0 0 0 0 1 0 0 1
0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 0 1 0
*/
