function max_lcs( x,y  )
{
  var c=[[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0]];
  /*for( var i=1 ;i<=x.length;i++)
  {
   c[i,0]=0; 
  }
  for( var j=0;j<=y.length;j++)
  {
    c[0,j]=0;
  }*/
  
  for( var i=1;i<x.length;i++)
  {
    for( var j=1; j<y.length ;j++)
    {
      if(x[i]==y[j])
      {
        c[i,j]= c[i-1,j-1]+1;
      }
     /* else if( c[i-1,j]>=c[i,j-1])
      
      {
        c[i,j]=c[i-1,j];
      }
      else
      c[i,j]=c[i,j-1];
    }*/
    
    }
  
  
  return c;

}


console.log(max_lcs( ["a","b","c","d","g","h"],["a","e","d","f","h","r"] ))
