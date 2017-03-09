#include<iostream>
using namespace std;
int top=4, status;


 void swap(double *x, double *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

int pop (double  stack[])
{
    int ret;
    if (top == -1)
    {   ret = 0;
	status = 0;
    }
    else
    {   status = 1;
	ret = stack [top];
	--top;
    }
return ret;
}

int knapsack(double *weight,double *index,int n,int limit)
{

   double x[n];
  int curr_weight=0; // current weight in limit

  for( int i =0 ; i<n ; i++)
    {
       x[i]=0;

       int  j=pop(index);

                 if(curr_weight+weight[j]<limit)
            {
              x[i]=1;
              curr_weight+=weight[j]; // updating current weight
            }
          else

          x[i]=(limit-curr_weight)/weight[j];

        }
    curr_weight=limit;

    cout<<"boooooooom !!!:"<<endl;
    for(int i=0 ;i<n ;i++)
   {
     cout<<""<<x[i]<<endl;

   }

  return 0  ;

}

  int main()
{
    int n,small,limit;
    cout<<"enter the size of the array"<<endl;
    cin>>n;  // size of total element
    double weight[n],taka[n],index[n] , profit[n],x[n];

    cout<<"Enter weights :"<<endl;

                    for(int i=0;i<n;i++)
                        {
                            cin>>weight[i];
                        }

    cout<<"Enter taka :"<<endl;

                        for (int i=0;i<n;i++)
                            {
                                cin>>taka[i];

                            }
    cout<<"Enter the max weight limit :"<<endl;
    cin>>limit ;

                            for(int i=0;i<n;i++)
                                {
                                    profit[i]=(taka[i]/weight[i]);
                                }

                for (int i=0;i<n;i++)
                    {
                        index[i]=i;

                    }
    cout<<endl;
                        for (int i=0;i<n;i++)
                            {
                                cout<<index[i]<<" ";

                            }
    cout<<endl;
    for (int i=0;i<n-1;i++)
    {
       small = i;
        for (int j=i+1;j<n;j++)
          if (profit[j]<profit[small])
            small=j;
        swap(&profit[small],&profit[i]);
        swap(&index[small],&index[i]);
    }
    cout<<"the sorted array"<<endl;

     for (int i=0;i<n;i++)
    {
        cout<<profit[i]<<" ";

    }
     cout<<endl;

    for (int i=0;i<n;i++)
    {
        cout<<index[i]<<" ";

    }
    cout<<endl;


  knapsack( weight, index ,n,limit);




    return 0;
}
