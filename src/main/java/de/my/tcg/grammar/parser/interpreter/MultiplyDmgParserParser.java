// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\MultiplyDmgParser.g4 by ANTLR 4.12.0
package interpreter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MultiplyDmgParserParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, Number = 5;
    public static final int
            RULE_doDmgPerTime = 0, RULE_flip_coin = 1, RULE_dmg_condition = 2;

    private static String[] makeRuleNames() {
        return new String[]{
                "doDmgPerTime", "flip_coin", "dmg_condition"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'Flip '", "' coins.'", "' This attack does '", "' damage times the number of heads'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, "Number"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "MultiplyDmgParser.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public MultiplyDmgParserParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DoDmgPerTimeContext extends ParserRuleContext {
        public Flip_coinContext flip_coin() {
            return getRuleContext(Flip_coinContext.class, 0);
        }

        public Dmg_conditionContext dmg_condition() {
            return getRuleContext(Dmg_conditionContext.class, 0);
        }

        public DoDmgPerTimeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_doDmgPerTime;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MultiplyDmgParserVisitor)
                return ((MultiplyDmgParserVisitor<? extends T>) visitor).visitDoDmgPerTime(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DoDmgPerTimeContext doDmgPerTime() throws RecognitionException {
        DoDmgPerTimeContext _localctx = new DoDmgPerTimeContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_doDmgPerTime);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(6);
                flip_coin();
                setState(7);
                dmg_condition();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Flip_coinContext extends ParserRuleContext {
        public Token times;

        public TerminalNode Number() {
            return getToken(MultiplyDmgParserParser.Number, 0);
        }

        public Flip_coinContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_flip_coin;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MultiplyDmgParserVisitor)
                return ((MultiplyDmgParserVisitor<? extends T>) visitor).visitFlip_coin(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Flip_coinContext flip_coin() throws RecognitionException {
        Flip_coinContext _localctx = new Flip_coinContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_flip_coin);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(9);
                match(T__0);
                setState(10);
                ((Flip_coinContext) _localctx).times = match(Number);
                setState(11);
                match(T__1);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Dmg_conditionContext extends ParserRuleContext {
        public Token dmg_per;

        public TerminalNode Number() {
            return getToken(MultiplyDmgParserParser.Number, 0);
        }

        public Dmg_conditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dmg_condition;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MultiplyDmgParserVisitor)
                return ((MultiplyDmgParserVisitor<? extends T>) visitor).visitDmg_condition(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Dmg_conditionContext dmg_condition() throws RecognitionException {
        Dmg_conditionContext _localctx = new Dmg_conditionContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_dmg_condition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(13);
                match(T__2);
                setState(14);
                ((Dmg_conditionContext) _localctx).dmg_per = match(Number);
                setState(15);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\u0004\u0001\u0005\u0012\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001" +
                    "\u0002\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0000\u0000\u0003\u0000\u0002\u0004\u0000\u0000" +
                    "\u000e\u0000\u0006\u0001\u0000\u0000\u0000\u0002\t\u0001\u0000\u0000\u0000" +
                    "\u0004\r\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002\u0001\u0000\u0007" +
                    "\b\u0003\u0004\u0002\u0000\b\u0001\u0001\u0000\u0000\u0000\t\n\u0005\u0001" +
                    "\u0000\u0000\n\u000b\u0005\u0005\u0000\u0000\u000b\f\u0005\u0002\u0000" +
                    "\u0000\f\u0003\u0001\u0000\u0000\u0000\r\u000e\u0005\u0003\u0000\u0000" +
                    "\u000e\u000f\u0005\u0005\u0000\u0000\u000f\u0010\u0005\u0004\u0000\u0000" +
                    "\u0010\u0005\u0001\u0000\u0000\u0000\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}