#include<iostream>

using namespace std;

void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}
void Maxactivityselection(int s[],int f[],int index[],int n)
{
int i, j;

    cout<<"selected activities : ";

    i = 0;
    cout<<" "<<index[i];
    for (j = 1; j < n; j++)
    {
      if (s[j] >= f[i])
      {
          cout<<""<<index[j];
          i = j;
      }
    }

}
int main()
{
    int n,small;
    cout<<"enter the size of the array"<<endl;
    cin>>n;
    int s[n],f[n],index[n];

    cout<<"Enter start times :"<<endl;

    for(int i=0;i<n;i++)
    {
        cin>>s[i];
    }
    cout<<"Enter finish times :"<<endl;
    for (int i=0;i<n;i++)
    {
        cin>>f[i];

    }

    cout<<endl;
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
          if (f[j]<f[small])
            small=j;
        swap(&f[small],&f[i]);
        swap(&s[small],&s[i]);
        swap(&index[small],&index[i]);
    }
    cout<<"the sorted array"<<endl;
     for (int i=0;i<n;i++)
    {
        cout<<s[i]<<" ";

    }
     cout<<endl;

    for (int i=0;i<n;i++)
    {
        cout<<f[i]<<" ";

    }
       cout<<endl;
    for (int i=0;i<n;i++)
    {
        cout<<index[i]<<" ";

    }
    cout<<endl;
Maxactivityselection(s,f,index,n);
    return 0;
}
