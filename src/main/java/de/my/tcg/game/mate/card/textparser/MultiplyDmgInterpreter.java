package de.my.tcg.game.mate.card.textparser;

import de.my.tcg.game.coin.CoinFlipper;
import interpreter.MultiplyDmgParserBaseVisitor;
import interpreter.MultiplyDmgParserLexer;
import interpreter.MultiplyDmgParserParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MultiplyDmgInterpreter extends MultiplyDmgParserBaseVisitor<Integer> {
    int times;
    int dmg;

    public Integer parse(String parseString) {
        CharStream inputStream = CharStreams.fromString(parseString);
        MultiplyDmgParserLexer lexer = new MultiplyDmgParserLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MultiplyDmgParserParser parser = new MultiplyDmgParserParser(tokens);
        ParseTree tree = parser.doDmgPerTime();
        return this.visit(tree);
    }

    @Override
    public Integer visitDoDmgPerTime(MultiplyDmgParserParser.DoDmgPerTimeContext ctx) {

        int coinFlips = Integer.parseInt(ctx.flip_coin().times.getText());
        CoinFlipper coinFlipper = new CoinFlipper();
        coinFlipper.flipCoinMultiplyTimes(coinFlips);
        int dmg_per = Integer.parseInt(ctx.dmg_condition().dmg_per.getText());
        return coinFlipper.getHeadCounter() * dmg_per;
    }

}
