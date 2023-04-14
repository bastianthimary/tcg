grammar MultiplyDmgParser;
doDmgPerTime:flip_coin dmg_condition;

flip_coin:'Flip ' times=Number  ' coins.';
Number:[0-9]+;
dmg_condition: ' This attack does 'dmg_per= Number ' damage times the number of heads';

