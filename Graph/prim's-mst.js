function prim()
{
  var t=[];
  var e=[];
  var c=[];
  var p=[];
  var lc ;
  
  t.push(0);
  
  for( var j=0;j<graph.length;j++)
  {
    if( graph[0][j]==1)
    {
      e.push(j);
    }
  }
  
   while( t.length !== g.length )
     {
       
       for( var i=0 ;i<e.length ;i++)
         {
           c[i]=cost[0][e[0]];
           
         }
       
                 for( var k=0 ;k<c.length;k++)
                     {
                         for(var j=1 ;j<c.length;j++)
                       {
                             if( c[k]>c[j])
                                 {
                   
                                    var temp;
  
                                      temp=c[k];
                                       c[k]=c[j];
                                      c[j]=temp;
                          
                                        temp=0;
  
                                    temp=e[k];
                                   e[k]=e[j];
                                   e[j]=temp;
                                 }
               
                         }
           
                       }
       
        
      lc=e.shift();
       
       for( var m=0 ;m<t.length;m++)
         {
           if(t[m]==lc)
          {
            lc=e.shift();
          }
         }
       
      t.push(lc);
      p.push(c.shift());
       
      for( var j=0;j<graph.length;j++)
  {
    if( graph[lc][j]==1)
    {
      e.push(j);
    }
  }
       
           
}
      
  return ;
}

var graph=[
  [0,1,0,1,0],
  [0,0,1,0,1],
  [0,0,0,0,0],
  [0,1,0,0,1],
  [0,0,0,0,0] 
];
var cost=[
  [0,2,0,1,0],
  [0,0,3,0,2],
  [0,0,0,0,0],
  [0,1,0,0,2],
  [0,0,0,0,0]
  
];

console.log( prim(graph, cost) );
