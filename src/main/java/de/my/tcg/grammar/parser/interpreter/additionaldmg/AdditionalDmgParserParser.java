// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\AdditionalDmgParser.g4 by ANTLR 4.12.0
package de.my.tcg.grammar.parser.interpreter.additionaldmg;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AdditionalDmgParserParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, Number = 6, WHITESPACE = 7, Do = 8,
            Dont = 9, EnergyAfter = 10, EnergyAfter_Var1 = 11, EnergyAfter_Var2 = 12, Target = 13,
            VarPokemonName = 14, DefendingPokemon = 15, StatusCondition = 16, PokeType = 17,
            ConditionTypes = 18, LimitationCounter = 19, NumberAsText = 20;
    public static final int
            RULE_effectText = 0, RULE_term = 1, RULE_additionalDmgEffect = 2, RULE_dmgData = 3,
            RULE_condition = 4, RULE_limitation = 5;

    private static String[] makeRuleNames() {
        return new String[]{
                "effectText", "term", "additionalDmgEffect", "dmgData", "condition",
                "limitation"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "' damage plus'", "'more damage'", "'for each'", "'Energy attached to'",
                "' but not used to pay for this attacks Energy cost'", null, null, "'Does'",
                null, null, null, null, null, "'this Pokemon'", "'the Defending Pok\\u00E9mon'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, "Number", "WHITESPACE", "Do", "Dont",
                "EnergyAfter", "EnergyAfter_Var1", "EnergyAfter_Var2", "Target", "VarPokemonName",
                "DefendingPokemon", "StatusCondition", "PokeType", "ConditionTypes",
                "LimitationCounter", "NumberAsText"
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
        return "AdditionalDmgParser.g4";
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

    public AdditionalDmgParserParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EffectTextContext extends ParserRuleContext {
        public List<TermContext> term() {
            return getRuleContexts(TermContext.class);
        }

        public TermContext term(int i) {
            return getRuleContext(TermContext.class, i);
        }

        public EffectTextContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_effectText;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterEffectText(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitEffectText(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitEffectText(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EffectTextContext effectText() throws RecognitionException {
        EffectTextContext _localctx = new EffectTextContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_effectText);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(13);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(12);
                            term();
                        }
                    }
                    setState(15);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == Do);
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
    public static class TermContext extends ParserRuleContext {
        public AdditionalDmgEffectContext additionalDmgEffect() {
            return getRuleContext(AdditionalDmgEffectContext.class, 0);
        }

        public TermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_term;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitTerm(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitTerm(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TermContext term() throws RecognitionException {
        TermContext _localctx = new TermContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_term);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(17);
                additionalDmgEffect();
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
    public static class AdditionalDmgEffectContext extends ParserRuleContext {
        public DmgDataContext dmgData() {
            return getRuleContext(DmgDataContext.class, 0);
        }

        public ConditionContext condition() {
            return getRuleContext(ConditionContext.class, 0);
        }

        public LimitationContext limitation() {
            return getRuleContext(LimitationContext.class, 0);
        }

        public AdditionalDmgEffectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_additionalDmgEffect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterAdditionalDmgEffect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitAdditionalDmgEffect(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitAdditionalDmgEffect(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AdditionalDmgEffectContext additionalDmgEffect() throws RecognitionException {
        AdditionalDmgEffectContext _localctx = new AdditionalDmgEffectContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_additionalDmgEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(19);
                dmgData();
                setState(20);
                condition();
                setState(21);
                limitation();
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
    public static class DmgDataContext extends ParserRuleContext {
        public Token dmg;
        public Token additionalDmg;

        public TerminalNode Do() {
            return getToken(AdditionalDmgParserParser.Do, 0);
        }

        public List<TerminalNode> Number() {
            return getTokens(AdditionalDmgParserParser.Number);
        }

        public TerminalNode Number(int i) {
            return getToken(AdditionalDmgParserParser.Number, i);
        }

        public DmgDataContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dmgData;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterDmgData(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitDmgData(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitDmgData(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DmgDataContext dmgData() throws RecognitionException {
        DmgDataContext _localctx = new DmgDataContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_dmgData);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(23);
                match(Do);
                {
                    setState(24);
                    ((DmgDataContext) _localctx).dmg = match(Number);
                    setState(25);
                    match(T__0);
                    setState(26);
                    ((DmgDataContext) _localctx).additionalDmg = match(Number);
                    setState(27);
                    match(T__1);
                }
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
    public static class ConditionContext extends ParserRuleContext {
        public Token type;
        public Token target;

        public TerminalNode PokeType() {
            return getToken(AdditionalDmgParserParser.PokeType, 0);
        }

        public TerminalNode Target() {
            return getToken(AdditionalDmgParserParser.Target, 0);
        }

        public ConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_condition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitCondition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitCondition(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ConditionContext condition() throws RecognitionException {
        ConditionContext _localctx = new ConditionContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_condition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(29);
                match(T__2);
                setState(30);
                ((ConditionContext) _localctx).type = match(PokeType);
                setState(31);
                match(T__3);
                setState(32);
                ((ConditionContext) _localctx).target = match(Target);
                setState(33);
                match(T__4);
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
    public static class LimitationContext extends ParserRuleContext {
        public TerminalNode EnergyAfter() {
            return getToken(AdditionalDmgParserParser.EnergyAfter, 0);
        }

        public LimitationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_limitation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterLimitation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitLimitation(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitLimitation(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LimitationContext limitation() throws RecognitionException {
        LimitationContext _localctx = new LimitationContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_limitation);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(35);
                match(EnergyAfter);
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
            "\u0004\u0001\u0014&\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f" +
                    "\u0000\u000f\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000" +
                    "\u0002\u0004\u0006\b\n\u0000\u0000 \u0000\r\u0001\u0000\u0000\u0000\u0002" +
                    "\u0011\u0001\u0000\u0000\u0000\u0004\u0013\u0001\u0000\u0000\u0000\u0006" +
                    "\u0017\u0001\u0000\u0000\u0000\b\u001d\u0001\u0000\u0000\u0000\n#\u0001" +
                    "\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001\u0000\u0000" +
                    "\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000" +
                    "\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0001\u0001\u0000\u0000\u0000" +
                    "\u0011\u0012\u0003\u0004\u0002\u0000\u0012\u0003\u0001\u0000\u0000\u0000" +
                    "\u0013\u0014\u0003\u0006\u0003\u0000\u0014\u0015\u0003\b\u0004\u0000\u0015" +
                    "\u0016\u0003\n\u0005\u0000\u0016\u0005\u0001\u0000\u0000\u0000\u0017\u0018" +
                    "\u0005\b\u0000\u0000\u0018\u0019\u0005\u0006\u0000\u0000\u0019\u001a\u0005" +
                    "\u0001\u0000\u0000\u001a\u001b\u0005\u0006\u0000\u0000\u001b\u001c\u0005" +
                    "\u0002\u0000\u0000\u001c\u0007\u0001\u0000\u0000\u0000\u001d\u001e\u0005" +
                    "\u0003\u0000\u0000\u001e\u001f\u0005\u0011\u0000\u0000\u001f \u0005\u0004" +
                    "\u0000\u0000 !\u0005\r\u0000\u0000!\"\u0005\u0005\u0000\u0000\"\t\u0001" +
                    "\u0000\u0000\u0000#$\u0005\n\u0000\u0000$\u000b\u0001\u0000\u0000\u0000" +
                    "\u0001\u000f";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}