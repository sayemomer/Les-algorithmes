function prim(cost_graph)

{
   var t=[];
   t[3]=0; // t= a spanning tree containing a single node s;
   var k=[];   // for verfying each node
   var distance=[]; // measuring mst distance
   distance[3]=0;
   k[3]="true";
   var min_item;
   var min_index;
   
   
   for( let i=0;i<cost_graph.length;i++  ){
     
     distance[i]=999;
   }
  
    
  for(let i=0;i<cost_graph.length;i++ ) 
  {
    if( cost_graph[3][i] > 0 )
    {
       t[i]=3;//E = set of edges adjacent to s;
       distance[i]=cost_graph[3][i];
    }
  }
  
// while( k.length !== cost_graph.length ) //while T does not contain all the nodes
 //{
            min_item = Math.min(...distance);
       min_index= distance.indexOf( Math.min(...distance) ) ;//find the index of min array ;
      k[min_index]="true";
      distance[min_index]=999;
      
   for(let i=0;i<cost_graph.length;i++ ) 
 // {
    if( cost_graph[min_index][5] > 0 && cost_graph[min_index][5]<distance[5])
    {
       t[5]= min_index;//E = set of edges adjacent to s;
       distance[5]=cost_graph[3][5];
    }
 // }
 
  
                
// }

  
  return  distance ;  
  
}

var cost_graph=[
  
[0, 8 ,0 ,0 ,0 ,10 ,0, 4],
[8 ,0 ,4 ,0 ,10 ,7 ,0 ,9],
[0, 4 ,0, 3 ,0 ,3 ,0 ,0],
[0 ,0 ,3 ,0 ,25 ,18 ,2 ,0],
[0 ,10 ,0 ,25 ,0 ,2 ,7 ,0],
[10, 7, 3 ,18 ,2 ,0 ,0 ,0],
[0 ,0 ,0 ,2 ,7 , 0 ,0 ,0],
[4, 9 ,0 ,0, 0, 0 ,3 ,0],
  
];

console.log( prim(cost_graph) );
