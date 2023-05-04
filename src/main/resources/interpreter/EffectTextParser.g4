grammar EffectTextParser;
options { caseInsensitive = true; }

Number:[0-9]+;
WHITESPACE: [ .\t\n\r]+ ->skip;
Target:VarPokemonName|DefendingPokemon;
VarPokemonName: 'this Pokemon';
DefendingPokemon:'the Defending Pokémon';
StatusCondition:  'Asleep'|'Confused'| 'Paralyzed';
PokeType:'Water'| 'Fire';
ConditionTypes: 'heads'|'Pokémon you have in play.'|'tails';


effectText: term+ ;
term:(conditionTerm? effectTerm)|effectTerm;
conditionTerm:condition conditionClass?;
effectTerm: dmgEffect | basicEffect;

condition:flipCoin;
flipCoin:'Flip' times=Number  ('coin'|'coins');
conditionClass:'if' ConditionTypes;


dmgEffect: multipleDmgEffect;
multipleDmgEffect: 'This attack does'dmgPer= Number ' damage times the number of'ConditionTypes?;

basicEffect:(Target executedEffect)|executedEffect;


executedEffect:statusEffect|hurtEffect|discardEnergy;
hurtEffect:'does 'dmg=Number'damage to itself';
statusEffect:'is now' StatusCondition;
discardEnergy:'Discard'numberOfCards=Number PokeType 'Energy'('card'|'cards') ' attached to' Target' in order to use this attack.';





