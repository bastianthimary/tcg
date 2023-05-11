grammar AdditionalDmgParser;

options { caseInsensitive = true; }
Number: [0-9]+ ;
WHITESPACE: [ .\t\n\r]+ ->skip;
DoOrDont: Dont|Do;
Do:'Does';
Dont:('doesnt'|'dont');


effectText: term+ ;
term:additionalDmgEffect|coinFlipEffect;

additionalDmgEffect:dmgData condition? ;
dmgData:DoOrDont dmg=Number ' damage plus ' additionalDmg=Number' more damage';
condition:(energyNotUsed limitation)|dmgCounter;
energyNotUsed:'for each' type=PokeType 'Energy attached to' target=Target 'but not used to pay for this attacks Energy cost';
dmgCounter:'for each damage counter on' target=Target;
limitation:energyAfter;
energyAfter:energyAfter_Var1|energyAfter_Var2;
energyAfter_Var1:(('Extra ')  PokeType ('Energy after the') LimitationCounter DoOrDont (' count.'));
energyAfter_Var2:'You cant add more than 'dmgLimit= Number ' damage in this way';

coinFlipEffect:flipCoin conditionClass attackIfDoes (conditionClass attackElseDoes)?;
flipCoin:'Flip' times=Number  ('coin'|'coins');
conditionClass:'if' ConditionTypes;
attackIfDoes:'this attack does' dmg=Number ' damage plus ' addDmg=Number 'more damage';
attackElseDoes:'this attack does' elseDmg=Number' damage';
Target:VarPokemonName|DefendingPokemon;
VarPokemonName: 'this Pokemon';
DefendingPokemon:'the Defending Pokémon';
pokemonStatusCondition:  'Asleep'|'Confused'| 'Paralyzed'|'Poisoned'|'Burned';
PokeType:'Water'| 'Fire'| 'Lightning';
ConditionTypes: 'heads'|'Pokémon you have in play.'|'tails';
LimitationCounter:Number|NumberAsText;
NumberAsText:'2nd'|'second';
