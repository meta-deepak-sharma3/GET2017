var add = function(x,y) {
    if (x && y){
      return x + y;
    }
    else {
      return function(y) {
       return x + y; 
     };
    }
}