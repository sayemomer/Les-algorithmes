function prim(cost_graph)

{
   var t=[];
   t[3]=0; // t= a spanning tree containing a single node s;
   var k=[];   // for verfying each node
   var distance=[]; // measuring mst distance
   distance[3]=0;
    
  
  k[3]="true";
  
    
  for(let i=0;i<cost_graph.length;i++ ) 
  {
    if( cost_graph[3][i] > 0 )
    {
       t[i]=3;//E = set of edges adjacent to s;
       distance[i]=3;
    }
  }
  
 while( k.length !== cost_graph.length ) //while T does not contain all the nodes
 {
     
                
 }
 
  
  return p;  
  
}

var cost_graph=[
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

console.log( prim(cost_graph) );
