#include<iostream>
using namespace std;
string color[1000];
int vertices,time,d[1000],p[1000],f[1000];
int Graph[1000][1000];
void DFS();
void DFS_Visit(int u);

int main()
{
    cout<<"How many verticses: "<<endl;
    cin>>vertices;
    int i,j;
    for( i=0; i<vertices; i++)
    {
        for( j=0; j<vertices; j++)
        {
            cin>>Graph[i][j];
        }
    }
    cout<<"The adjacency matrix is : "<<endl;
    for( i=0; i<vertices; i++)
    {
        for( j=0; j<vertices; j++)
        {
            cout<<Graph[i][j]<<" ";
        }
        cout<<endl;

    }
    cout<<endl;
    DFS();
    for(int i=1; i<=vertices; i++)
        cout<<"For "<<i<<": "<<d[i]<<"/"<<f[i]<<endl;
return 0;
}
void DFS_Visit(int i)
{
 color[i]="grey" ;
  time=time+1;
   d[i]=time;

   for( int j=0 ;j<vertices;j++)
   {
       if(Graph[i][j]==1)
       {
           if( color[j] == "white")
      {
          p[j]=i;
          DFS_Visit(j);
          }
       color[i]="black";
       time++;
       f[i]=time;
   }
       }

}
void DFS()
{
     for( int i=0;i<vertices;i++)
     {
         color[i]="string";
     }


     for(int i=0 ;i<vertices;i++)
     {
         if(color[i]=="white")
            {
               DFS_Visit(i);
            }
     }


}
//Sample input 1:
//4
//0 1 0 1
//0 0 1 0
//0 0 0 1
//0 0 0 0
//sample input 2:
//
//6
//0 1 0 1 0 0
//0 0 0 0 1 0
//0 0 0 0 1 1
//0 1 0 0 0 0
//0 0 0 1 0 0
//0 0 0 0 0 1
