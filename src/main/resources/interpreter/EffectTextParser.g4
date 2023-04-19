grammar EffectTextParser;
options { caseInsensitive = true; }
Number:[0-9a]+;
WHITESPACE: [ .\t\n\r]+ ->skip;
effectText: term+ ;
term:(conditionTerm? effectTerm)|effectTerm;
conditionTerm:condition conditionClass?;
effectTerm: dmgEffect | basicEffect;

condition:flipCoin;
flipCoin:'Flip' times=Number  ('coin'|'coins');
conditionClass:'if' conditionTypes;
conditionTypes: 'heads'|'Pokémon you have in play.';

dmgEffect: multipleDmgEffect;
multipleDmgEffect: 'This attack does'dmgPer= Number ' damage times the number of'conditionTypes?;

basicEffect:target executedEffect;

target:varPokemonName|defendingPokemon;
varPokemonName: 'this Pokemon';
defendingPokemon:'the Defending Pokémon';

executedEffect:statusEffect;

statusEffect:'is now' statusCondition;
statusCondition:  'SLEEP'|'Confused'| 'PARALYSED';





