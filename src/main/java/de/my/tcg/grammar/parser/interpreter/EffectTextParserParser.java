// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\EffectTextParser.g4 by ANTLR 4.12.0
package de.my.tcg.grammar.parser.interpreter;

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
public class EffectTextParserParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, Number = 15, WHITESPACE = 16;
    public static final int
            RULE_effectText = 0, RULE_term = 1, RULE_conditionTerm = 2, RULE_effectTerm = 3,
            RULE_condition = 4, RULE_flipCoin = 5, RULE_conditionClass = 6, RULE_conditionTypes = 7,
            RULE_dmgEffect = 8, RULE_multipleDmgEffect = 9, RULE_basicEffect = 10,
            RULE_target = 11, RULE_varPokemonName = 12, RULE_defendingPokemon = 13,
            RULE_executedEffect = 14, RULE_statusEffect = 15, RULE_statusCondition = 16;

    private static String[] makeRuleNames() {
        return new String[]{
                "effectText", "term", "conditionTerm", "effectTerm", "condition", "flipCoin",
                "conditionClass", "conditionTypes", "dmgEffect", "multipleDmgEffect",
                "basicEffect", "target", "varPokemonName", "defendingPokemon", "executedEffect",
                "statusEffect", "statusCondition"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'Flip'", "'coin'", "'coins'", "'if'", "'heads'", "'Pok\\u00E9mon you have in play.'",
                "'This attack does'", "' damage times the number of'", "'this Pokemon'",
                "'the Defending Pok\\u00E9mon'", "'is now'", "'SLEEP'", "'Confused'",
                "'PARALYSED'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, "Number", "WHITESPACE"
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
        return "EffectTextParser.g4";
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

    public EffectTextParserParser(TokenStream input) {
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
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterEffectText(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitEffectText(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitEffectText(this);
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
                setState(35);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(34);
                            term();
                        }
                    }
                    setState(37);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1666L) != 0));
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
        public EffectTermContext effectTerm() {
            return getRuleContext(EffectTermContext.class, 0);
        }

        public ConditionTermContext conditionTerm() {
            return getRuleContext(ConditionTermContext.class, 0);
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
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).enterTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).exitTerm(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitTerm(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TermContext term() throws RecognitionException {
        TermContext _localctx = new TermContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_term);
        int _la;
        try {
            setState(44);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    {
                        setState(40);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__0) {
                            {
                                setState(39);
                                conditionTerm();
                            }
                        }

                        setState(42);
                        effectTerm();
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(43);
                    effectTerm();
                }
                break;
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
    public static class ConditionTermContext extends ParserRuleContext {
        public ConditionContext condition() {
            return getRuleContext(ConditionContext.class, 0);
        }

        public ConditionClassContext conditionClass() {
            return getRuleContext(ConditionClassContext.class, 0);
        }

        public ConditionTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditionTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterConditionTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitConditionTerm(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitConditionTerm(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ConditionTermContext conditionTerm() throws RecognitionException {
        ConditionTermContext _localctx = new ConditionTermContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_conditionTerm);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(46);
                condition();
                setState(48);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__3) {
                    {
                        setState(47);
                        conditionClass();
                    }
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
    public static class EffectTermContext extends ParserRuleContext {
        public DmgEffectContext dmgEffect() {
            return getRuleContext(DmgEffectContext.class, 0);
        }

        public BasicEffectContext basicEffect() {
            return getRuleContext(BasicEffectContext.class, 0);
        }

        public EffectTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_effectTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterEffectTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitEffectTerm(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitEffectTerm(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EffectTermContext effectTerm() throws RecognitionException {
        EffectTermContext _localctx = new EffectTermContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_effectTerm);
        try {
            setState(52);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__6:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(50);
                    dmgEffect();
                }
                break;
                case T__8:
                case T__9:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(51);
                    basicEffect();
                }
                break;
                default:
                    throw new NoViableAltException(this);
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
        public FlipCoinContext flipCoin() {
            return getRuleContext(FlipCoinContext.class, 0);
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
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).exitCondition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitCondition(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ConditionContext condition() throws RecognitionException {
        ConditionContext _localctx = new ConditionContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_condition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(54);
                flipCoin();
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
    public static class FlipCoinContext extends ParserRuleContext {
        public Token times;

        public TerminalNode Number() {
            return getToken(EffectTextParserParser.Number, 0);
        }

        public FlipCoinContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_flipCoin;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).enterFlipCoin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).exitFlipCoin(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitFlipCoin(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FlipCoinContext flipCoin() throws RecognitionException {
        FlipCoinContext _localctx = new FlipCoinContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_flipCoin);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(56);
                match(T__0);
                setState(57);
                ((FlipCoinContext) _localctx).times = match(Number);
                setState(58);
                _la = _input.LA(1);
                if (!(_la == T__1 || _la == T__2)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
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
    public static class ConditionClassContext extends ParserRuleContext {
        public ConditionTypesContext conditionTypes() {
            return getRuleContext(ConditionTypesContext.class, 0);
        }

        public ConditionClassContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditionClass;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterConditionClass(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitConditionClass(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitConditionClass(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ConditionClassContext conditionClass() throws RecognitionException {
        ConditionClassContext _localctx = new ConditionClassContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_conditionClass);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(60);
                match(T__3);
                setState(61);
                conditionTypes();
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
    public static class ConditionTypesContext extends ParserRuleContext {
        public ConditionTypesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditionTypes;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterConditionTypes(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitConditionTypes(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitConditionTypes(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ConditionTypesContext conditionTypes() throws RecognitionException {
        ConditionTypesContext _localctx = new ConditionTypesContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_conditionTypes);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(63);
                _la = _input.LA(1);
                if (!(_la == T__4 || _la == T__5)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
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
    public static class DmgEffectContext extends ParserRuleContext {
        public MultipleDmgEffectContext multipleDmgEffect() {
            return getRuleContext(MultipleDmgEffectContext.class, 0);
        }

        public DmgEffectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dmgEffect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterDmgEffect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).exitDmgEffect(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitDmgEffect(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DmgEffectContext dmgEffect() throws RecognitionException {
        DmgEffectContext _localctx = new DmgEffectContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_dmgEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(65);
                multipleDmgEffect();
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
    public static class MultipleDmgEffectContext extends ParserRuleContext {
        public Token dmgPer;

        public TerminalNode Number() {
            return getToken(EffectTextParserParser.Number, 0);
        }

        public ConditionTypesContext conditionTypes() {
            return getRuleContext(ConditionTypesContext.class, 0);
        }

        public MultipleDmgEffectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_multipleDmgEffect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterMultipleDmgEffect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitMultipleDmgEffect(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitMultipleDmgEffect(this);
            else return visitor.visitChildren(this);
        }
    }

    public final MultipleDmgEffectContext multipleDmgEffect() throws RecognitionException {
        MultipleDmgEffectContext _localctx = new MultipleDmgEffectContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_multipleDmgEffect);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(67);
                match(T__6);
                setState(68);
                ((MultipleDmgEffectContext) _localctx).dmgPer = match(Number);
                setState(69);
                match(T__7);
                setState(71);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__4 || _la == T__5) {
                    {
                        setState(70);
                        conditionTypes();
                    }
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
    public static class BasicEffectContext extends ParserRuleContext {
        public TargetContext target() {
            return getRuleContext(TargetContext.class, 0);
        }

        public ExecutedEffectContext executedEffect() {
            return getRuleContext(ExecutedEffectContext.class, 0);
        }

        public BasicEffectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_basicEffect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterBasicEffect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitBasicEffect(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitBasicEffect(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BasicEffectContext basicEffect() throws RecognitionException {
        BasicEffectContext _localctx = new BasicEffectContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_basicEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(73);
                target();
                setState(74);
                executedEffect();
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
    public static class TargetContext extends ParserRuleContext {
        public VarPokemonNameContext varPokemonName() {
            return getRuleContext(VarPokemonNameContext.class, 0);
        }

        public DefendingPokemonContext defendingPokemon() {
            return getRuleContext(DefendingPokemonContext.class, 0);
        }

        public TargetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_target;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).enterTarget(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).exitTarget(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitTarget(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TargetContext target() throws RecognitionException {
        TargetContext _localctx = new TargetContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_target);
        try {
            setState(78);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__8:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(76);
                    varPokemonName();
                }
                break;
                case T__9:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(77);
                    defendingPokemon();
                }
                break;
                default:
                    throw new NoViableAltException(this);
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
    public static class VarPokemonNameContext extends ParserRuleContext {
        public VarPokemonNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_varPokemonName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterVarPokemonName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitVarPokemonName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitVarPokemonName(this);
            else return visitor.visitChildren(this);
        }
    }

    public final VarPokemonNameContext varPokemonName() throws RecognitionException {
        VarPokemonNameContext _localctx = new VarPokemonNameContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_varPokemonName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(80);
                match(T__8);
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
    public static class DefendingPokemonContext extends ParserRuleContext {
        public DefendingPokemonContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_defendingPokemon;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterDefendingPokemon(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitDefendingPokemon(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitDefendingPokemon(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DefendingPokemonContext defendingPokemon() throws RecognitionException {
        DefendingPokemonContext _localctx = new DefendingPokemonContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_defendingPokemon);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(82);
                match(T__9);
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
    public static class ExecutedEffectContext extends ParserRuleContext {
        public StatusEffectContext statusEffect() {
            return getRuleContext(StatusEffectContext.class, 0);
        }

        public ExecutedEffectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_executedEffect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterExecutedEffect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitExecutedEffect(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitExecutedEffect(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExecutedEffectContext executedEffect() throws RecognitionException {
        ExecutedEffectContext _localctx = new ExecutedEffectContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_executedEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(84);
                statusEffect();
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
    public static class StatusEffectContext extends ParserRuleContext {
        public StatusConditionContext statusCondition() {
            return getRuleContext(StatusConditionContext.class, 0);
        }

        public StatusEffectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statusEffect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterStatusEffect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitStatusEffect(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitStatusEffect(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatusEffectContext statusEffect() throws RecognitionException {
        StatusEffectContext _localctx = new StatusEffectContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_statusEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(86);
                match(T__10);
                setState(87);
                statusCondition();
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
    public static class StatusConditionContext extends ParserRuleContext {
        public StatusConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statusCondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterStatusCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitStatusCondition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitStatusCondition(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatusConditionContext statusCondition() throws RecognitionException {
        StatusConditionContext _localctx = new StatusConditionContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_statusCondition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(89);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
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

    public static final String _serializedATN =
            "\u0004\u0001\u0010\\\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
                    "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
                    "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f" +
                    "\u0002\u0010\u0007\u0010\u0001\u0000\u0004\u0000$\b\u0000\u000b\u0000" +
                    "\f\u0000%\u0001\u0001\u0003\u0001)\b\u0001\u0001\u0001\u0001\u0001\u0003" +
                    "\u0001-\b\u0001\u0001\u0002\u0001\u0002\u0003\u00021\b\u0002\u0001\u0003" +
                    "\u0001\u0003\u0003\u00035\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001" +
                    "\t\u0003\tH\b\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003" +
                    "\u000bO\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e" +
                    "\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010" +
                    "\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014" +
                    "\u0016\u0018\u001a\u001c\u001e \u0000\u0003\u0001\u0000\u0002\u0003\u0001" +
                    "\u0000\u0005\u0006\u0001\u0000\f\u000eQ\u0000#\u0001\u0000\u0000\u0000" +
                    "\u0002,\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u00064" +
                    "\u0001\u0000\u0000\u0000\b6\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000" +
                    "\u0000\f<\u0001\u0000\u0000\u0000\u000e?\u0001\u0000\u0000\u0000\u0010" +
                    "A\u0001\u0000\u0000\u0000\u0012C\u0001\u0000\u0000\u0000\u0014I\u0001" +
                    "\u0000\u0000\u0000\u0016N\u0001\u0000\u0000\u0000\u0018P\u0001\u0000\u0000" +
                    "\u0000\u001aR\u0001\u0000\u0000\u0000\u001cT\u0001\u0000\u0000\u0000\u001e" +
                    "V\u0001\u0000\u0000\u0000 Y\u0001\u0000\u0000\u0000\"$\u0003\u0002\u0001" +
                    "\u0000#\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%#\u0001\u0000" +
                    "\u0000\u0000%&\u0001\u0000\u0000\u0000&\u0001\u0001\u0000\u0000\u0000" +
                    "\')\u0003\u0004\u0002\u0000(\'\u0001\u0000\u0000\u0000()\u0001\u0000\u0000" +
                    "\u0000)*\u0001\u0000\u0000\u0000*-\u0003\u0006\u0003\u0000+-\u0003\u0006" +
                    "\u0003\u0000,(\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000-\u0003" +
                    "\u0001\u0000\u0000\u0000.0\u0003\b\u0004\u0000/1\u0003\f\u0006\u00000" +
                    "/\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001\u0005\u0001\u0000" +
                    "\u0000\u000025\u0003\u0010\b\u000035\u0003\u0014\n\u000042\u0001\u0000" +
                    "\u0000\u000043\u0001\u0000\u0000\u00005\u0007\u0001\u0000\u0000\u0000" +
                    "67\u0003\n\u0005\u00007\t\u0001\u0000\u0000\u000089\u0005\u0001\u0000" +
                    "\u00009:\u0005\u000f\u0000\u0000:;\u0007\u0000\u0000\u0000;\u000b\u0001" +
                    "\u0000\u0000\u0000<=\u0005\u0004\u0000\u0000=>\u0003\u000e\u0007\u0000" +
                    ">\r\u0001\u0000\u0000\u0000?@\u0007\u0001\u0000\u0000@\u000f\u0001\u0000" +
                    "\u0000\u0000AB\u0003\u0012\t\u0000B\u0011\u0001\u0000\u0000\u0000CD\u0005" +
                    "\u0007\u0000\u0000DE\u0005\u000f\u0000\u0000EG\u0005\b\u0000\u0000FH\u0003" +
                    "\u000e\u0007\u0000GF\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000" +
                    "H\u0013\u0001\u0000\u0000\u0000IJ\u0003\u0016\u000b\u0000JK\u0003\u001c" +
                    "\u000e\u0000K\u0015\u0001\u0000\u0000\u0000LO\u0003\u0018\f\u0000MO\u0003" +
                    "\u001a\r\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000O\u0017" +
                    "\u0001\u0000\u0000\u0000PQ\u0005\t\u0000\u0000Q\u0019\u0001\u0000\u0000" +
                    "\u0000RS\u0005\n\u0000\u0000S\u001b\u0001\u0000\u0000\u0000TU\u0003\u001e" +
                    "\u000f\u0000U\u001d\u0001\u0000\u0000\u0000VW\u0005\u000b\u0000\u0000" +
                    "WX\u0003 \u0010\u0000X\u001f\u0001\u0000\u0000\u0000YZ\u0007\u0002\u0000" +
                    "\u0000Z!\u0001\u0000\u0000\u0000\u0007%(,04GN";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}