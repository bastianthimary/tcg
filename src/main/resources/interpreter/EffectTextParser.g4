grammar EffectTextParser;
options { caseInsensitive = true; }

Number:[0-9]+;
WHITESPACE: [ .\t\n\r]+ ->skip;
target:VarPokemonName|DefendingPokemon;
VarPokemonName: 'this Pokemon';
DefendingPokemon:'the Defending Pokémon';
AllBenchMons:'each Pokémon on each players Bench';
statusCondition:  'Asleep'|'Confused'| 'Paralyzed';
PokeType:'Water'| 'Fire';
conditionTypes: 'heads'|'Pokémon you have in play.'|'tails';


effectText: term+ ;
term:(conditionTerm? effectTerm)|effectTerm;
conditionTerm:condition conditionClass?;
effectTerm: dmgEffect | basicEffect;

condition:flipCoin;
flipCoin:'Flip' times=Number  ('coin'|'coins');
conditionClass:'if' conditionTypes;


dmgEffect: multipleDmgEffect;
multipleDmgEffect: 'This attack does'dmgPer= Number ' damage times the number of'conditionTypes?;

basicEffect:(target executedEffect)|executedEffect;


executedEffect:statusEffect|hurtEffect|discardEnergy|benchDmgEffect;
hurtEffect:'does 'dmg=Number'damage to itself';
statusEffect:'is now' statusCondition;
discardEnergy:'Discard'numberOfCards=Number PokeType 'Energy'('card'|'cards') ' attached to' target' in order to use this attack.';
benchDmgEffect:'does ' dmg=Number'damage to 'AllBenchMons '. Dont apply Weakness and Resistance for Benched Pokémon.';




