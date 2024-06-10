function  linear(array,value )
{
  
 for( var i=0 ;i<array.length;i++)
  {
   
     if(array[i]==value)
      {
     return i;
      }
  
 }
 return "not found";
 
 
  
} 


console.log( linear([1,2,3,4,5,6],7) );
