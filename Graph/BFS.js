function bfs(G,s)
{
  var color=[];
  var queue=[];
  var d=[0];
  var p=[];
  
  
    var u ;
    
     queue.push(s);
  
                          for(var i=0;i<G.length;i++)
                          {
                            color[i]="white";
                          }
                                      
                                     while( queue.length !== 0 )
                                     {
                                       
                                     
                                      u=queue.shift();
                                     
                                        for( var i=0;i<G.length ;i++)
                                            {
                                                if( G[i].vertex == u)
                                                    {
                                                      var j=i;
                                                     }     
                                            }
                                    
                                      for( var i=0 ;i<G[j].edges.length;i++)
                                        {
                                          for(var k=0 ;k<G.length;k++)
                                          {
                                            if( G[j].edges[i]== G[k].vertex )
                                            {
                                              var woo= k;
                                            }
                                          }
                                          
                                          
                                          if( color[woo] == "white" )
                                            {
                                              color[woo]="gray";
                                              d[woo]=d[j]+1;
                                              p[i]=u; 
                                              queue.push( G[j].edges[i] );
                                            }
                                        }
                                       
                                        color[j]="Black";
                                     }
 return  p;
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
