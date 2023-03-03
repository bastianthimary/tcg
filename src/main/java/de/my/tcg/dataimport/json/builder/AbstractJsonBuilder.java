package de.my.tcg.dataimport.json.builder;

public abstract class AbstractJsonBuilder {
    String QUOTESTRING = "\"";

    protected String surroundWithQuoteStrings(String string){
        return QUOTESTRING +string+ QUOTESTRING;
    }
}
