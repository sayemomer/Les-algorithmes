function mcm(d)
{
  var m=[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]];
   
var n = d.length-1;
var j ;
var q ;


          for( var i=0 ; i<=n ;i++)
        {
          j=i+len-1;
        
                q=m[i][k]+m[k+1][j]+ d[i]*d[j]*d[k-1];
                m[i][j]=q;
                  
              } 
              
        }




return m ;
  
}


console.log( mcm([10,100,5,50]) )
