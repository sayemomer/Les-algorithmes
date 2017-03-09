function mergesort(left,right,array)
{
  var i=0,j=0,k=0;
  var nl=left.length ;
  var nr=right.length;
  
 while(i<nl && j<nr)
    {
      if(left[i]<=right[j])
        {
          array[k]=left[i];
          i++;
          k++;
          
        }
      else
     {   array[k]=right[j];
      j++;
      k++;}
    }
  
  
  while(i<nl)
    {
      array[k]=left[i];
      i++;
      k++;
    }
  while(j<nr)
    {
      array[k]=right[j];
      j++;
      k++;
    }
  
return array ;
}

function merge(array)
{
   var n = array.length;
  
   if(n<2)
     {
       return array;
     }
  else 
  
    var mid = Math.floor(n/2) ;
  var left=new Array(mid);;
  var right=new Array(n-mid);
  
 for(var i=0 ;i<mid ;i++)
{
  left[i]=array[i];
}
  for(var j=mid ; j<=n-1 ;j++)
{
  right[j-mid]=array[j];
}
  merge(left);
  merge(right);
  
 var x = mergesort(left,right ,array );
return   ;  

}

console.log(merge( [2,5,3,7,4] ));
