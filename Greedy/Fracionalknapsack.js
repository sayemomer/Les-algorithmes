function iteams(weight,taka)
{
  this.weight=weight ;
  this.taka=taka;
}

var iteam=[
  new iteams(10,60),
  new iteams(20,100),
  new iteams(30,120)
  
];

function knapsack(weight,benifit,limit)
{
  var arr=[] ;
  
  for( var i =0 ; i<weight.length ;i++)
    {
      arr.push(benifit[i]/weight[i]);
    }
  
  var x=[];
  var curr_weight=0;
  
  for( var i =0 ; i<weight.length ; i++)
    {
       
       x[i]=0;
          if(curr_weight+weight[i]<limit)
            {
              x[i]=1;
              curr_weight+=weight[i];
            }
          else
          x[i]=(limit-curr_weight)/weight[i];
          
        }
    curr_weight=limit;
  return x  ;
  
}
console.log( knapsack([10,20,30],[60,100,120],50));
