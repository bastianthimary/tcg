grammar EffectTextParser;
options { caseInsensitive = true; }

Number:[0-9]+;
WHITESPACE: [ .\t\n\r]+ ->skip;
target:VarPokemonName|DefendingPokemon;
VarPokemonName: 'this Pokemon';
DefendingPokemon:'the Defending Pokémon';
benchTarget:AllBenchMons|MyBenchMons;
AllBenchMons:'each Pokémon on each players Bench';
MyBenchMons:'each of your own Benched Pokémon';
statusCondition:  'Asleep'|'Confused'| 'Paralyzed'|'Poisoned'|'Burned';
PokeType:'Water'| 'Fire'|'Lightning';
conditionTypes: 'heads'|'Pokémon you have in play.'|'tails';

effectText: term+ ;
term:(conditionTerm? effectTerm)|effectTerm;
conditionTerm:condition conditionClass?;
effectTerm: dmgEffect | basicEffect;

condition:flipCoin;
flipCoin:'Flip' times=Number  ('coin'|'coins');
conditionClass:'if' conditionTypes;


dmgEffect: multipleDmgEffect|doNothing;
multipleDmgEffect: 'This attack does'dmgPer= Number ' damage times the number of'conditionTypes?;
doNothing:'this attack does nothing';

basicEffect:(target executedEffect)|executedEffect;


executedEffect:statusEffect|hurtEffect|discardEnergy|benchDmgEffect|prevent;
hurtEffect:'does 'dmg=Number'damage to itself';
statusEffect:'is now' statusCondition;
discardEnergy:'Discard'((numberOfCards=Number PokeType)|numberOfCards='all') 'Energy'('card'|'cards') ' attached to' target' in order to use this attack.';
benchDmgEffect:'does ' dmg=Number'damage to 'benchTarget '. Dont apply Weakness and Resistance for Benched Pokémon.';
prevent:preventAllDmg|preventEffectAndDmg|preventDmgReduction|preventRetreat;
preventAllDmg:'prevent all damage done to' target 'during your opponents next turn. Any other effects of attacks still happen.';
preventEffectAndDmg: 'during your opponents next turn, prevent all effects of attacks, including damage, done to' target;
preventDmgReduction: 'During your opponents next turn, whenever' reduce=Number' or less damage is done to' target' after applying Weakness and Resistance';
preventRetreat:target 'cant retreat during your opponents next turn';

