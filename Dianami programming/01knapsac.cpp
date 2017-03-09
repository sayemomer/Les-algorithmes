#include<iostream>
#include<vector>
using namespace std;
#define HEIGHT 6
#define WIDTH 5

int knapsack(int weight[],vector<vector<double> > taka,int n, int limit)
{
  vector<vector<double> > B;

  B.resize(HEIGHT);
  for (int i = 0; i < HEIGHT; ++i)
{
  B[i].resize(WIDTH);
}

    for(int i=0;i<=limit;i++)
    {
        B[0][i]=0;
    }
    for(int i=0;i<=n;i++)
    {
        B[i][0]=0;
    }
    int x ;

   for(int i=1 ;i<=limit;i++)
    {
         for(int w=1 ;w<=n;w++)

        {

             if(weight[i]<w)
        {

                if ( taka[i] + B[i-1,w-weight[i]] > B[i-1,w] )
                {

                 B[i,w] = taka[i] + B[i-1,w-weight[i]];
                }

			else
				B[i,w] = B[i-1,w];
        }
		else B[i,w] =B[i-1,w]  ;

        }



    }


}


int main()
{
     int n,small,limit,v;
    cout<<"enter the size of the array"<<endl;
    cin>>n;
    int weight[4] ;
     vector<vector<double> >taka;

    cout<<"Enter weights :"<<endl;

    for(int i=0;i<4;i++)
    {
        cin>>weight[i];
    }
    cout<<"Enter taka :"<<endl;
    for (int i=0;i<4;i++)
    {
        cin>>v;
        taka[i].push_back(v);

    }
    cout<<"Enter the max weight limit :"<<endl;
    cin>>limit ;

    knapsack(weight,taka,n,limit);

}
