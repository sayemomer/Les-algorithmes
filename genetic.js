var decimalPopulation =[];
var squaredPopulation=[];
var population = ["01101","11000","01000","10011"];
var crossoverPartner=[];
var crossoverPoint=[];
var _ = require('lodash');

function binaryToDecimal(){
  
  
  for( let i=0; i< population.length ;i++){
    decimalPopulation.push( parseInt( population[i],2) );
  }
  return decimalPopulation ;
  
}



function squarePopulation( ){
  
  for( let i=0; i< decimalPopulation.length ;i++){
    
    squaredPopulation.push( Math.pow(decimalPopulation[i],2) );
  }
  
  return squaredPopulation;
  
}




function fitnessCalculator(squaredPopulation){
  
  var avarage = _.sum(squaredPopulation) / population.length ;
  var populationFitness=[];
  
  for( let i=0 ;i<squaredPopulation.length ;i++){
    
    populationFitness.push( _.round(squaredPopulation[i]/ avarage) );
  }

  
  return populationFitness;
  
}


function crossOver(){
    
    
    for( let i=0 ;i< population.length ;i++){
      
      crossoverPartner[i]=_.random(0, 3);
    }
    
    for( let i=0 ;i< population.length ;i++){
      
      crossoverPoint[i]=_.random(0, 3);
    }
    
  //   console.log(population);  
  // console.log(crossoverPartner);
  // console.log(crossoverPoint);
  
}


function mutationHelper(dna1,dna2,crosspoint){
  
  var sliceDna1=_.slice(dna1,0,crosspoint);
  
  var sliceDna2=_.slice(dna2,crosspoint);
  
    var mutedDna= sliceDna1.concat( sliceDna2);
    
    
    return mutedDna;
  
}


function mutation(){
  
  var mutedDna=[];
  
  for( let i=0 ;i< population.length ;i++){
    
     mutedDna.push(mutationHelper( population[i], population[crossoverPartner[i]] , crossoverPoint[i]).join("") );
    
  }
  
   console.log(mutedDna);
  
  // console.log(binaryToDecimal(mutedDna));
  
  
}


function main(){
  
  
  
 console.log (binaryToDecimal());
 console.log(squarePopulation() );
 console.log ( fitnessCalculator(squaredPopulation) );
 console.log (crossOver() );
 console.log (mutation() );
  
}

main();


