grammar AdditionalDmgParser;

options { caseInsensitive = true; }
Number:[0-9a]+;
WHITESPACE: [ .\t\n\r]+ ->skip;
Do:'Does';
Dont:('doesn\'t'|'don\'t');


effectText: term+ ;
term:additionalDmgEffect;
additionalDmgEffect:dmgData condition limitation;
dmgData:Do( dmg=Number ' damage plus' additionalDmg=Number'more damage');
condition:'for each' type=PokeType 'Energy attached to' target=Target' but not used to pay for this attacks Energy cost';
limitation:EnergyAfter;
EnergyAfter:EnergyAfter_Var1|EnergyAfter_Var2;
EnergyAfter_Var1:'Extra'  PokeType 'Energy after the' LimitationCounter Dont 'count';
EnergyAfter_Var2:'You can\'t add more than ' Number ' damage in this way';


Target:VarPokemonName|DefendingPokemon;
VarPokemonName: 'this Pokemon';
DefendingPokemon:'the Defending Pokémon';
StatusCondition:  'Asleep'|'Confused'| 'Paralyzed';
PokeType:'Water'| 'Fire';
ConditionTypes: 'heads'|'Pokémon you have in play.'|'tails';
LimitationCounter:Number|NumberAsText;
NumberAsText:'2nd'|'second';
