function partition(array,start,end)
{
  
  var pivot =array[end];
  var pindex=start;
  var temp;
  
  
  
   for(var i=pindex ; i<end ;i++)
   {
    
      if(array[i]<=pivot)
        {
          temp=array[i];
          array[i]=array[pindex];
          array[pindex]=temp;
          
          pindex++;
        }
      
   }

  temp=pivot;
  array[end]=array[pindex];
  array[pindex]=temp;
  
  return pindex ;
  
}

function quick_sort(array,start,end)
{
  if(start<end)
    {
      var pindex =partition(array,start,end);
      quick_sort(array,start,pindex-1);
      quick_sort(array,pindex+1 ,end);
      
    }
  return array;
}

console.log( quick_sort( [7,2,1,6,8,5,3,4] ,0,7 ) );
