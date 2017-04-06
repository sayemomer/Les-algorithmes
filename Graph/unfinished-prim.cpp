#include<iostream>
using namespace std ;
int cost_graph[1000][1000];
int vertices;
int t[50]; // spanning tree
string k[50];   // for verfying each node
int distance[50]; // measuring mst distance


int prim( )
{
    int start ;
    
    cout<<"Enter the start Node:"<<endl;
    cin>> start;
   t[start]=0; //  a spanning tree containing a single node s 
   distance[start]=0;
   k[3]="t"; // check in the current node  
  
    
  for( int i=0;i<vertices;i++ ) 
  {
    if( cost_graph[start][i] > 0 )
    {
       t[i]=start ;//E = set of edges adjacent to s;
       distance[i]= cost_graph[start][i] ;
    }
  }
  
 while( (sizeof(k)/sizeof(*k)) !== vertices ) //while T does not contain all the nodes
 {
  
   int u= //min from distance array
   //find the index of min array ;
 // k[index of min array]="true";
 
  /*   for( int i=0;i<vertices;i++ ) 
  {
    if( cost_graph[start][i] > 0 )
    {
       t[i]=start ;//E = set of edges adjacent to s;
       distance[i]= cost_graph[start][i] ;
    }
  }*/
     
                
 }
 
  
return p;  
    
    
}

int main()
{
      int row,col;
    cout<<"Enter the number of vertices : "<<endl;
    cin>>vertices;
    row=vertices;
    col=row;


        for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                    {
                        cin>>cost_graph[i][j];
                    }
            }

    cout<<"  The graph and the cost is :"<<endl;

        for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                    {
                        cout<<cost_graph[i][j]<<" ";
                    }
                cout<<endl;
            }

}


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
