var crossoverPartner=[];
var crossoverPoint=[];
var _ = require('lodash');

function binaryToDecimal(population){
  
  var decimalPopulation=[];
  for( let i=0; i< population.length ;i++){
    decimalPopulation.push( parseInt( population[i],2) );
  }
  return decimalPopulation ;
  
}

function crossOver(population){
  
    for( let i=0 ;i< population.length ;i++){
      crossoverPartner[i]=_.random(0, 3);
      crossoverPoint[i]=_.random(0, 3);
    }
}

function flip(dna){
  
  for(let i=0 ;i<dna.length;i++){
    if(dna[i]==="1"){
      dna[i]="0";
    }
    else if( dna[i]==="0"){
      dna[i]="1";
    }
  }
  return dna;
}


function mutationHelper(dna1,dna2,crosspoint){
  
  var sliceDna1=_.slice(dna1,0,crosspoint);
  var sliceDna2=_.slice(dna2,crosspoint);
  var mutedDna= sliceDna1.concat( flip(sliceDna2) );
  return mutedDna;
    
}


function mutation(population){
  
  var mutedDna=[];
  for( let i=0 ;i< population.length ;i++){
     mutedDna.push(mutationHelper( population[i], population[crossoverPartner[i]] , crossoverPoint[i]).join("") );
  }
   return mutedDna;
}


(function main(){
  
var population = ["01101","11000","01000","10011"];
var count=0;
 for( ; ; ){
  count++;
  console.log(count);
  crossOver(population); 
  var newPopulation=binaryToDecimal( mutation(population) );
  if(_.indexOf(newPopulation,31)!== -1){
    console.log(count);
    console.log(newPopulation);
    break;
  }
 }
  
})();
