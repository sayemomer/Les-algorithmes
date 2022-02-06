#include<iostream>
using namespace std;
string print_lcs() ;

int max_lcs( string x[],string y[] ,int n  )
{
  int c[n][n];
  string b[n][n];

  for( int i=0;i<n ;i++)
  {
      c[0][i]=0;
  }
   for( int i=0;i<n ;i++)
  {
      c[i][0]=0;
  }


  for( int i=1;i<n;i++)
  {
       for( int j=1; j<n ;j++)
          {
            if(x[j]==y[i])
              {
                c[i][j] = c[i-1][j-1] + 1;
                b[i][j]="COPY";
              }
                 else if( c[i-1][j]>=c[i][j-1])

                  {
                      c[i][j]=c[i-1][j];
                      b[i][j]="skipX";

                    }
                       else
                        {
                          c[i][j]=c[i][j-1];
                         b[i][j]="skipY";
                        }

        }
  }

  cout<<"Lcs length is : "<<c[n-1][n-1]<<endl;

cout<<"LCS sequence is :";

 for(int i=0 ;i<n ;i++)
    {
     for(int j=0;j<n ;j++)
     {
         if(b[i][j]=="COPY")
         {
             cout<<" "<<x[j];
         }
     }
    }

}



int main()
{
     int n ;
    cout<<"Enter sequence length :";
    cin>> n;

    string x[n];
    string y[n];
   x[0]="0";
   y[0]="0";

   cout<<" Sequence no 1 :"<<endl;
   for( int i=1 ; i<n ;i++)
   {
       cin>>x[i] ;
   }

   cout<<" Sequence no 2 : "<<endl;
   for( int i=1 ; i<n ;i++)
   {
       cin>>y[i];
   }


  max_lcs( x,y , n);


}
