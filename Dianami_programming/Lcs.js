 function max_lcs( x,y  )
{
  var b=[[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0]];
  var c=[[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0]];

  for( var i=1;i<x.length;i++)
  {
       for( var j=1; j<y.length ;j++)
          {
            if(x[j]==y[i])
              {
                c[i][j] = c[i-1][j-1] + 1;
                 b[i][j]="copy"
              }
                 else if( c[i-1][j]>=c[i][j-1])
      
                  {
                      c[i][j]=c[i-1][j];
                      b[i][j]="skipX";
                      
                    }
                       else
                         {c[i][j]=c[i][j-1];
                         b[i][j]="skipY";}
                         
        }
  }
  
  return c  ;

}


console.log( max_lcs( ["g","a","b","c","d","g","h"],["g","a","e","d","f","h","r"] ) );