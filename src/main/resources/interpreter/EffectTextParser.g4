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
conditionTypes: 'heads'|'Pokémon you have in play.'|'tails';

dmgEffect: multipleDmgEffect;
multipleDmgEffect: 'This attack does'dmgPer= Number ' damage times the number of'conditionTypes?;

basicEffect:(target executedEffect)|executedEffect;

target:varPokemonName|defendingPokemon;
varPokemonName: 'this Pokemon';
defendingPokemon:'the Defending Pokémon';

executedEffect:statusEffect|hurtEffect|discardEnergy;
hurtEffect:'does 'dmg=Number'damage to itself';
statusEffect:'is now' statusCondition;
statusCondition:  'Asleep'|'Confused'| 'Paralyzed';
PokeType:'Water'| 'Fire';
discardEnergy:'Discard'numberOfCards=Number PokeType 'Energy'('card'|'cards') ' attached to' target' in order to use this attack.';




