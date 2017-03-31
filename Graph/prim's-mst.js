function prim(graph,cost)

{
   var t=[];
   t[0]=0; // t= a spanning tree containing a single node s;
   var edges=[];
   var least_cost=[];
    var counterForT =0;
    
  for( var j=0;j<graph.length;j++ ) 
  {
    if( graph[0][j]==1 )
    {
      edges.push(j); //E = set of edges adjacent to s;
    }
  }
  
 while( t.length !== graph.length ) //while T does not contain all the nodes
 {
     
     
    
    // comparing and swaping cost and edges parally 
  for( var k=0 ;k<edges.length ;k++)
    {
      for(var j=1 ;j<edges.length;j++)
                    {
                      if( cost[t[ counterForT ]] [ edges[k] ] > cost[t[ counterForT ]] [ edges[j] ]    )
                       {
                                    var temp;
  
                                      temp=edges[k];
                                      edges[k]=edges[j];
                                      edges[j]=temp;
                          
                                        
                                 }
               
                         }
           
      
    }
  
         lc=edges.shift(); //remove an edge  of lowest cost from e
         
         for( var m=0 ;m<t.length;m++)  
         {
           if(t[m]==lc)
          {
            lc=edges.shift(); //if edge is already in t then discard edge
          }
         }
       
         
         
         counterForT++;
         
         t[counterForT]=lc; //storing the current node
       //  least_cost.push( c.shift() ); //storing current cost
         
         //add to E the edges adjacent to w
              for( var j=0;j<graph.length;j++)
                 {
                    if( graph[lc][j]==1)
                         {
                           edges.push(j);
                         }
                }
                
 }
  
  
  return t ;  
  
}

var graph=[
  [0,1,0,1,0,0,0,0,0,0],
  [1,0,1,1,0,0,0,0,0,1],
  [0,1,0,0,1,1,0,0,0,0],
  [1,1,0,0,0,0,0,1,0,1],
  [0,0,1,0,0,0,1,0,0,0],
  [0,0,1,0,0,0,1,0,1,0],
  [0,0,0,0,1,1,0,0,1,1],
  [0,0,0,1,0,0,0,0,0,1],
  [0,0,0,0,0,1,1,0,0,1],
  [0,1,0,1,0,0,1,1,1,0],
  ];
var cost=[
  [0,4,0,1,0,0,0,0,0,0],
  [4,0,4,4,0,0,0,0,0,10],
  [0,4,0,0,2,1,0,0,0,0],
  [1,4,0,0,0,0,0,5,0,6],
  [0,0,2,0,0,0,2,0,0,0],
  [0,0,1,0,0,0,3,0,5,0],
  [0,0,0,0,2,3,0,0,3,4],
  [0,0,0,5,0,0,0,0,0,2],
  [0,0,0,0,0,5,3,0,0,3],
  [0,10,0,6,0,0,4,2,3,0],
  
];

console.log( prim(graph,cost) );
