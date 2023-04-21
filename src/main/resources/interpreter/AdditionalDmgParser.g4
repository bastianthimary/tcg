grammar AdditionalDmgParser;

options { caseInsensitive = true; }


effectText: term+ ;
term:additionalDmgEffect;
additionalDmgEffect:dmgData condition limitation;
dmgData:'Does' dmg=Number ' damage plus' additionalDmg=Number'more damage';
condition:'for each' PokeType 'Energy attached to' Target' but not used to pay for this attack\'s Energy cost';
limitation:'Extra' PokeType 'Energy after the 2nd doesn\'t count';



Number:[0-9a]+;
WHITESPACE: [ .\t\n\r]+ ->skip;
StatusCondition:  'SLEEP'|'Confused'| 'PARALYSED';
ConditionTypes: 'heads'|'Pokémon you have in play.'|'tails';
Target:VarPokemonName|DefendingPokemon;
VarPokemonName: 'this Pokemon';
DefendingPokemon:'the Defending Pokémon';
PokeType:'Water'| 'Fire';
