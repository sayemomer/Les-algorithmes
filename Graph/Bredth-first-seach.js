function bfs(graph,source)
{
  var color=[];
   var queqe=[];
   var d=[];
   var p=[];
   var u ;
   d[0]=0;
    queqe.push(source);
 
  
  for(var i=0;i<graph.length;i++)
    {
      color[i]="white";
    }
  
  
  while( queqe.length !== 0)
    {
        u =queqe.shift();
       for( var v=0 ;v<graph.length ;v++)
       {
         if( graph[u][v]==1 &&color[v]=="white")
         {
           color[v]="gray";
           d[v]=d[u]+1;
           p[v]=u;
           queqe.push(v);
           
         }
       }
     color[u]="black";  
   }
  
   
  
print(d);
 
}

var graph=[
  [0,1,0,1,0,0,0,0,0],
  [0,0,1,0,1,0,0,0,0],
  [0,0,0,0,0,0,0,0,0],
  [0,1,0,0,1,0,0,0,0],
  [0,0,1,0,0,0,1,0,1],
  [0,0,0,1,0,0,0,1,0],
  [0,0,0,0,0,1,0,0,1],
  [0,0,0,0,0,0,1,0,0],
  [0,0,0,0,0,0,0,1,0]
  
];

console.log(bfs(graph,0));
