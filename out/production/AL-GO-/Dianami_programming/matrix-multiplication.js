function matrixmultiply( A, B)
{
  var c =[[0,0],[0,0]];
  if( A[0].length !=B.length ) // if col[A]!=row[B] // CR soman hobe
  
  return " Incompatible dimension";
  
  else
  
  {
    for( var i=0;i<A.length;i++) //  array A er row  ,matrix mul:RC
    {
      for(var j=0;j<B[0].length;j++) // array B er column
      {
         
          for( var k=0; k<A[0].length;k++)
        {
          c[i][j]= c[i][j] + A[i][k]*B[k][j];
        }
      }
    }
  }
  
  return c;

}

 var A=[
    [2,3],
    [2,4]
  ];
  
 var  B=[
    [4,3],
    [2,1]
    ];
    
    
console.log(matrixmultiply(A,B));
