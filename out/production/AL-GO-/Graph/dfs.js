var color=[];
var finish_time=[];
var start_time=[];
var p=[];
  
function dfs(G)
{
  for( var i=0; i<G.length ;i++)
    {
      color[i]="white";
    }

  for( var vertex=0;vertex<G.length ;vertex++)
      {
          if( color[vertex]=="white" )
          {
            dfs_visit(vertex);
          }
      }

      p.push(vertex)
      
 return finish_time ;
}


 function dfs_visit(vertex)
{

  console.log("vertex---->",vertex);
  var time=0;
  color[vertex]="grey";
  time++;
  start_time[vertex]=time;
  for(  var edges=0 ;edges<G.length;edges++ )
  {
    if( color[edges]=="white" && G[vertex][edges]== 1 )
    {
      p[edges]=vertex;
      dfs_visit(edges);
    }
    
  }
  color[vertex]="black";
  time++;
  finish_time[vertex]=time ;
  console.log(p)

}

var G=[
  [0, 1, 0, 0],
  [1, 0, 1, 0],
  [0, 1, 0, 1],
  [0, 0, 1, 0]
];

dfs(G);

