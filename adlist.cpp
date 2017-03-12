#include<iostream>
using namespace std;

int main()
{
    int vertices,edges,v1,v2,flag=0 ;
    cin>>vertices ;

    int graph[vertices][vertices];
    int d[vertices];

    for( int i=1 ;i<=vertices ;i++)
    {
      cin>>d[i];

    }
                        for(int i=1;i<=vertices;i++)
                        {
                            for(int j=1;j<=d[i];j++)
                            {
                                cin>>graph[i][j];
                            }
                        }

    cout<<"The ad list is : "<<endl;
                                                        for(int i=1;i<=vertices;i++)
                                                        {
                                                            cout<<i<<"->";
                                                            for(int j=1;j<=d[i];j++)
                                                            {
                                                                cout<<graph[i][j]<<" ";
                                                            }
                                                            cout<<endl;
                                                        }


   cout<<"Enter two vertex number to check whether they are connected or not?  "<<endl;


    cin>>v1>>v2;


       for(int i=1;i<=d[v1];i++)
       {
        if(graph[v1][i]== v2)
        {
           cout<<"connected";
           flag=1;
           break;
        }
       }
       if(flag==0)
              cout<<"Not connected";

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
1 2 4

 */



