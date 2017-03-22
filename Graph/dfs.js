  var color=[];
  var finish_time=[];
  var start_time=[];
  var p=[];
  
function dfs(G)
{
  for( var i=1; i<=G.length ;i++)
    {
      color[i]="white";
    }
  for( var vertex=1;vertex<=G.length ;vertex++)
      {
          if( color[vertex]=="white" )
          {
            dfs_visit(vertex);
          }
      }
 return finish_time ;
}


 function dfs_visit( vertex)
{
  var time=0;
  
  color[vertex]="grey";
  time++;
  start_time[vertex]=time;
  for(  var edges=1 ;edges<=G.length;G++)
  {
    if(G[vertex][edges]== 1 && color[edges]=="white" )
    {
      p[edges]=vertex;
    dfs_visit(edges);
    }
  }
  color[vertex]="black";
  time++;
  finish_time[vertex]=time ;
  
}

var G=[
  [0,1,0,0,1],
  [1,0,1,1,1],
  [0,1,0,1,0],
  [0,1,1,0,1],
  [1,1,0,1,0],
];


console.log(dfs(G));
