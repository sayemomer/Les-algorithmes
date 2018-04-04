#include<iostream>
#include<stdlib.h>
using namespace std;

int board[30],count=0;

int place(int position )
{
     for( int i=1;i<position;i++)
     {      if((board[i]==board[position]) || ((abs(board[i]-board[position])==abs(i-position))) )
               return 0;
     }
     return 1;
}

void printSolution(int n)
{     int i,j;
     count++;
     cout<<"\n\nSolution:"<<count<<endl;
     for(i=1;i<=n;i++)
     {    for(j=1;j<=n;j++)
          {
               if(board[i]==j)
                cout<<"Q\t";
               else
                cout<<"-\t";
          }
          cout<<"\n";
     }
}

void queen(int n)
{
     int queenNumber=1;
     board[queenNumber]=0;
     while(queenNumber!=0)
     {
          do
          {
            board[queenNumber]=board[queenNumber]+1;
          } while((board[queenNumber]<=n)&&!place(queenNumber));
          if(board[queenNumber]<=n)
          {
               if(queenNumber==n)
                printSolution(n);
               else
               {
                queenNumber++;
                board[queenNumber]=0;
               }
          }
          else
               queenNumber--;
     }
}
int main ()
{
     queen(8);
     cout<<"\nTotal solutions="<<count;
}

