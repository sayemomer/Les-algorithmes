function prim( cost_graph , start )

{
   var t=[];
   t[start]=0; // t= a spanning tree containing a single node s;
   var k=[];   // for verfying each node
   k[start]="true";
   var distance=[]; // measuring mst distance
   distance[start]=0;
   
   var min_item;
   var min_index;
   var min_cost=0;
   var ne=0;
   
   
  for( let i=0;i<cost_graph.length;i++  ){
     
      distance[i]=999;
   }
  
    
  for(let i=0;i<cost_graph.length;i++ ) 
 {
      if( cost_graph[start][i] > 0 )
          {
              t[i]=3;//E = set of edges adjacent to s;
               distance[i]=cost_graph[start][i];
          }
 }
  
while( ne !== cost_graph.length-1 ) //while T does not contain all the nodes

     {
        min_item = Math.min(...distance);
        min_cost+=min_item;
        min_index= distance.indexOf( Math.min(...distance) ) ;//find the index of min array ;
        k[min_index]="true";
        distance[min_index]=999;
      
            for(let i=0;i<cost_graph.length;i++ ) 
                 {
                    if( cost_graph[min_index][i] > 0 && cost_graph[min_index][i]<distance[i] && k[i] != "true")
                     {
                       t[i]= min_index;//E = set of edges adjacent to s;
                        distance[i]=cost_graph[min_index][i];
                      }
                 }
        ne++;
                 
      }

  
  return  min_cost;  
  
}

var cost_graph=[
  
[0, 8 ,0 ,0 ,0 ,10 ,0, 4],
[8 ,0 ,4 ,0 ,10 ,7 ,0 ,9],
[0, 4 ,0, 3 ,0 ,3 ,0 ,0],
[0 ,0 ,3 ,0 ,25 ,18 ,2 ,0],
[0 ,10 ,0 ,25 ,0 ,2 ,7 ,0],
[10, 7, 3 ,18 ,2 ,0 ,0 ,0],
[0 ,0 ,0 ,2 ,7 , 0 ,0 ,3],
[4, 9 ,0 ,0, 0, 0 ,3 ,0],
  
];

console.log( prim(cost_graph, 3) );
