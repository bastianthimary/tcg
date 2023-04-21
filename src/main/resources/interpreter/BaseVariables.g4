grammar BaseVariables;
options { caseInsensitive = true; }
Number:[0-9a]+;
WHITESPACE: [ .\t\n\r]+ ->skip;
StatusCondition:  'SLEEP'|'Confused'| 'PARALYSED';
ConditionTypes: 'heads'|'Pokémon you have in play.'|'tails';
Target:VarPokemonName|DefendingPokemon;
VarPokemonName: 'this Pokemon';
DefendingPokemon:'the Defending Pokémon';
PokeType:'Water'| 'Fire';