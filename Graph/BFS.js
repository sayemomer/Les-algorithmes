function bfs(G,s)
{
  var color=[];
  var queue=[];
  var d=[];
  var p=[];
  
    var u ;
    
     queue.push(s);
  
        for(var i=0;i<G.length;i++)
        {
          color[i]="white";
        }

while ( queue.length !==0)
{
  u=queue.shift();
  
    for( var i=0;i<G.length ;i++)
        {
            if( G[i].vertex == u)
                {
                  var j=i;
                 }     
        }

  for( var i=1 ;i<=G[j].edges.length;i++)
    {
      if(color[i] == "white")
        {
          color[i]="gray";
          
          d[i]= d[0]+1;
          p[i] =u;
          queue.push( G[j].edges[i] );
        }
    }
    
    color[0]="Black";

}



 return p;
}



function data(vertex,edges)
{
  this.vertex=vertex;
  this.edges=edges;
}

var G=[
  
 new data("a",["b","d"]),
  new data("b",["a","d","e"]),
  new data("d",["b","g","f"]),
  new data("e",["b","g","i"]),
  new data("f",["d","g","h"]),
  new data("g",["d","e","i","f","h"]),
  new data("h",["f","g","i"]),
  new data("i",["e","g","h"])
  
];

console.log(bfs(G,"a"));
