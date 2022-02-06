function mcm(d)
{
  var m=[[0,0,0],
  [0,0,0],
  [0,0,0]];
  
  
  var n = d.length-1 ;
   
for( var len =2 ;len<=n ;len++)
  {
    for( var i=1;i<n-len+1 ;i++)
      {
         j=i+len-1;
         m[i][j]= 1/0 ;
           
           for( var k=i;k<=j; k++)
            {
              q=m[i][k]+m[k+1][j]+d[i]*d[k]*d[j];
              if( q<m[i][j])
              {
                m[i][j]=q  ;
              }
            
            }
      }
  
  
  }

return m;
    
}



console.log( mcm([10,100,5,50]) )
