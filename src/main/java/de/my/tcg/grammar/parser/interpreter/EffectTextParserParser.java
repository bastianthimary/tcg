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
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24,
            T__24 = 25, T__25 = 26, Number = 27, WHITESPACE = 28, VarPokemonName = 29, DefendingPokemon = 30,
            AllBenchMons = 31, MyBenchMons = 32, PokeType = 33;
    public static final int
            RULE_target = 0, RULE_benchTarget = 1, RULE_statusCondition = 2, RULE_conditionTypes = 3,
            RULE_effectText = 4, RULE_term = 5, RULE_conditionTerm = 6, RULE_effectTerm = 7,
            RULE_condition = 8, RULE_flipCoin = 9, RULE_conditionClass = 10, RULE_dmgEffect = 11,
            RULE_multipleDmgEffect = 12, RULE_basicEffect = 13, RULE_executedEffect = 14,
            RULE_hurtEffect = 15, RULE_statusEffect = 16, RULE_discardEnergy = 17,
            RULE_benchDmgEffect = 18;

    private static String[] makeRuleNames() {
        return new String[]{
                "target", "benchTarget", "statusCondition", "conditionTypes", "effectText",
                "term", "conditionTerm", "effectTerm", "condition", "flipCoin", "conditionClass",
                "dmgEffect", "multipleDmgEffect", "basicEffect", "executedEffect", "hurtEffect",
                "statusEffect", "discardEnergy", "benchDmgEffect"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'Asleep'", "'Confused'", "'Paralyzed'", "'Poisoned'", "'Burned'",
                "'heads'", "'Pok\\u00E9mon you have in play.'", "'tails'", "'Flip'",
                "'coin'", "'coins'", "'if'", "'This attack does'", "' damage times the number of'",
                "'does '", "'damage to itself'", "'is now'", "'Discard'", "'all'", "'Energy'",
                "'card'", "'cards'", "' attached to'", "' in order to use this attack.'",
                "'damage to '", "'. Dont apply Weakness and Resistance for Benched Pok\\u00E9mon.'",
                null, null, "'this Pokemon'", "'the Defending Pok\\u00E9mon'", "'each Pok\\u00E9mon on each players Bench'",
                "'each of your own Benched Pok\\u00E9mon'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, "Number", "WHITESPACE", "VarPokemonName", "DefendingPokemon",
                "AllBenchMons", "MyBenchMons", "PokeType"
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
    public static class TargetContext extends ParserRuleContext {
        public TerminalNode VarPokemonName() {
            return getToken(EffectTextParserParser.VarPokemonName, 0);
        }

        public TerminalNode DefendingPokemon() {
            return getToken(EffectTextParserParser.DefendingPokemon, 0);
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
        enterRule(_localctx, 0, RULE_target);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(38);
                _la = _input.LA(1);
                if (!(_la == VarPokemonName || _la == DefendingPokemon)) {
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
    public static class BenchTargetContext extends ParserRuleContext {
        public TerminalNode AllBenchMons() {
            return getToken(EffectTextParserParser.AllBenchMons, 0);
        }

        public TerminalNode MyBenchMons() {
            return getToken(EffectTextParserParser.MyBenchMons, 0);
        }

        public BenchTargetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_benchTarget;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterBenchTarget(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitBenchTarget(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitBenchTarget(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BenchTargetContext benchTarget() throws RecognitionException {
        BenchTargetContext _localctx = new BenchTargetContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_benchTarget);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(40);
                _la = _input.LA(1);
                if (!(_la == AllBenchMons || _la == MyBenchMons)) {
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
        enterRule(_localctx, 4, RULE_statusCondition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(42);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0))) {
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
        enterRule(_localctx, 6, RULE_conditionTypes);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(44);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0))) {
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
        enterRule(_localctx, 8, RULE_effectText);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(47);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(46);
                            term();
                        }
                    }
                    setState(49);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1611047424L) != 0));
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
        enterRule(_localctx, 10, RULE_term);
        int _la;
        try {
            setState(56);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    {
                        setState(52);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__8) {
                            {
                                setState(51);
                                conditionTerm();
                            }
                        }

                        setState(54);
                        effectTerm();
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(55);
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
        enterRule(_localctx, 12, RULE_conditionTerm);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(58);
                condition();
                setState(60);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__11) {
                    {
                        setState(59);
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
        enterRule(_localctx, 14, RULE_effectTerm);
        try {
            setState(64);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__12:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(62);
                    dmgEffect();
                }
                break;
                case T__14:
                case T__16:
                case T__17:
                case VarPokemonName:
                case DefendingPokemon:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(63);
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
        enterRule(_localctx, 16, RULE_condition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(66);
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
        enterRule(_localctx, 18, RULE_flipCoin);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(68);
                match(T__8);
                setState(69);
                ((FlipCoinContext) _localctx).times = match(Number);
                setState(70);
                _la = _input.LA(1);
                if (!(_la == T__9 || _la == T__10)) {
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
        enterRule(_localctx, 20, RULE_conditionClass);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(72);
                match(T__11);
                setState(73);
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
        enterRule(_localctx, 22, RULE_dmgEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(75);
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
        enterRule(_localctx, 24, RULE_multipleDmgEffect);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(77);
                match(T__12);
                setState(78);
                ((MultipleDmgEffectContext) _localctx).dmgPer = match(Number);
                setState(79);
                match(T__13);
                setState(81);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) {
                    {
                        setState(80);
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
        enterRule(_localctx, 26, RULE_basicEffect);
        try {
            setState(87);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case VarPokemonName:
                case DefendingPokemon:
                    enterOuterAlt(_localctx, 1);
                {
                    {
                        setState(83);
                        target();
                        setState(84);
                        executedEffect();
                    }
                }
                break;
                case T__14:
                case T__16:
                case T__17:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(86);
                    executedEffect();
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
    public static class ExecutedEffectContext extends ParserRuleContext {
        public StatusEffectContext statusEffect() {
            return getRuleContext(StatusEffectContext.class, 0);
        }

        public HurtEffectContext hurtEffect() {
            return getRuleContext(HurtEffectContext.class, 0);
        }

        public DiscardEnergyContext discardEnergy() {
            return getRuleContext(DiscardEnergyContext.class, 0);
        }

        public BenchDmgEffectContext benchDmgEffect() {
            return getRuleContext(BenchDmgEffectContext.class, 0);
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
            setState(93);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(89);
                    statusEffect();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(90);
                    hurtEffect();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(91);
                    discardEnergy();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(92);
                    benchDmgEffect();
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
    public static class HurtEffectContext extends ParserRuleContext {
        public Token dmg;

        public TerminalNode Number() {
            return getToken(EffectTextParserParser.Number, 0);
        }

        public HurtEffectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_hurtEffect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterHurtEffect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitHurtEffect(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitHurtEffect(this);
            else return visitor.visitChildren(this);
        }
    }

    public final HurtEffectContext hurtEffect() throws RecognitionException {
        HurtEffectContext _localctx = new HurtEffectContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_hurtEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(95);
                match(T__14);
                setState(96);
                ((HurtEffectContext) _localctx).dmg = match(Number);
                setState(97);
                match(T__15);
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
        enterRule(_localctx, 32, RULE_statusEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(99);
                match(T__16);
                setState(100);
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
    public static class DiscardEnergyContext extends ParserRuleContext {
        public Token numberOfCards;

        public TargetContext target() {
            return getRuleContext(TargetContext.class, 0);
        }

        public TerminalNode PokeType() {
            return getToken(EffectTextParserParser.PokeType, 0);
        }

        public TerminalNode Number() {
            return getToken(EffectTextParserParser.Number, 0);
        }

        public DiscardEnergyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_discardEnergy;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterDiscardEnergy(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitDiscardEnergy(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitDiscardEnergy(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DiscardEnergyContext discardEnergy() throws RecognitionException {
        DiscardEnergyContext _localctx = new DiscardEnergyContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_discardEnergy);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(102);
                match(T__17);
                setState(106);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case Number: {
                        {
                            setState(103);
                            ((DiscardEnergyContext) _localctx).numberOfCards = match(Number);
                            setState(104);
                            match(PokeType);
                        }
                    }
                    break;
                    case T__18: {
                        setState(105);
                        ((DiscardEnergyContext) _localctx).numberOfCards = match(T__18);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(108);
                match(T__19);
                setState(109);
                _la = _input.LA(1);
                if (!(_la == T__20 || _la == T__21)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(110);
                match(T__22);
                setState(111);
                target();
                setState(112);
                match(T__23);
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
    public static class BenchDmgEffectContext extends ParserRuleContext {
        public Token dmg;

        public BenchTargetContext benchTarget() {
            return getRuleContext(BenchTargetContext.class, 0);
        }

        public TerminalNode Number() {
            return getToken(EffectTextParserParser.Number, 0);
        }

        public BenchDmgEffectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_benchDmgEffect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterBenchDmgEffect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitBenchDmgEffect(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitBenchDmgEffect(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BenchDmgEffectContext benchDmgEffect() throws RecognitionException {
        BenchDmgEffectContext _localctx = new BenchDmgEffectContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_benchDmgEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(114);
                match(T__14);
                setState(115);
                ((BenchDmgEffectContext) _localctx).dmg = match(Number);
                setState(116);
                match(T__24);
                setState(117);
                benchTarget();
                setState(118);
                match(T__25);
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
            "\u0004\u0001!y\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002" +
                    "\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005" +
                    "\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007" +
                    "\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007" +
                    "\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002" +
                    "\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0001" +
                    "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001" +
                    "\u0003\u0001\u0003\u0001\u0004\u0004\u00040\b\u0004\u000b\u0004\f\u0004" +
                    "1\u0001\u0005\u0003\u00055\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005" +
                    "9\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006=\b\u0006\u0001\u0007\u0001" +
                    "\u0007\u0003\u0007A\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001" +
                    "\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001" +
                    "\f\u0001\f\u0003\fR\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\rX\b\r\u0001" +
                    "\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e^\b\u000e\u0001" +
                    "\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001" +
                    "\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011k\b" +
                    "\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001" +
                    "\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001" +
                    "\u0012\u0001\u0012\u0000\u0000\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e" +
                    "\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0006\u0001" +
                    "\u0000\u001d\u001e\u0001\u0000\u001f \u0001\u0000\u0001\u0005\u0001\u0000" +
                    "\u0006\b\u0001\u0000\n\u000b\u0001\u0000\u0015\u0016p\u0000&\u0001\u0000" +
                    "\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000" +
                    "\u0006,\u0001\u0000\u0000\u0000\b/\u0001\u0000\u0000\u0000\n8\u0001\u0000" +
                    "\u0000\u0000\f:\u0001\u0000\u0000\u0000\u000e@\u0001\u0000\u0000\u0000" +
                    "\u0010B\u0001\u0000\u0000\u0000\u0012D\u0001\u0000\u0000\u0000\u0014H" +
                    "\u0001\u0000\u0000\u0000\u0016K\u0001\u0000\u0000\u0000\u0018M\u0001\u0000" +
                    "\u0000\u0000\u001aW\u0001\u0000\u0000\u0000\u001c]\u0001\u0000\u0000\u0000" +
                    "\u001e_\u0001\u0000\u0000\u0000 c\u0001\u0000\u0000\u0000\"f\u0001\u0000" +
                    "\u0000\u0000$r\u0001\u0000\u0000\u0000&\'\u0007\u0000\u0000\u0000\'\u0001" +
                    "\u0001\u0000\u0000\u0000()\u0007\u0001\u0000\u0000)\u0003\u0001\u0000" +
                    "\u0000\u0000*+\u0007\u0002\u0000\u0000+\u0005\u0001\u0000\u0000\u0000" +
                    ",-\u0007\u0003\u0000\u0000-\u0007\u0001\u0000\u0000\u0000.0\u0003\n\u0005" +
                    "\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001/\u0001\u0000" +
                    "\u0000\u000012\u0001\u0000\u0000\u00002\t\u0001\u0000\u0000\u000035\u0003" +
                    "\f\u0006\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0001" +
                    "\u0000\u0000\u000069\u0003\u000e\u0007\u000079\u0003\u000e\u0007\u0000" +
                    "84\u0001\u0000\u0000\u000087\u0001\u0000\u0000\u00009\u000b\u0001\u0000" +
                    "\u0000\u0000:<\u0003\u0010\b\u0000;=\u0003\u0014\n\u0000<;\u0001\u0000" +
                    "\u0000\u0000<=\u0001\u0000\u0000\u0000=\r\u0001\u0000\u0000\u0000>A\u0003" +
                    "\u0016\u000b\u0000?A\u0003\u001a\r\u0000@>\u0001\u0000\u0000\u0000@?\u0001" +
                    "\u0000\u0000\u0000A\u000f\u0001\u0000\u0000\u0000BC\u0003\u0012\t\u0000" +
                    "C\u0011\u0001\u0000\u0000\u0000DE\u0005\t\u0000\u0000EF\u0005\u001b\u0000" +
                    "\u0000FG\u0007\u0004\u0000\u0000G\u0013\u0001\u0000\u0000\u0000HI\u0005" +
                    "\f\u0000\u0000IJ\u0003\u0006\u0003\u0000J\u0015\u0001\u0000\u0000\u0000" +
                    "KL\u0003\u0018\f\u0000L\u0017\u0001\u0000\u0000\u0000MN\u0005\r\u0000" +
                    "\u0000NO\u0005\u001b\u0000\u0000OQ\u0005\u000e\u0000\u0000PR\u0003\u0006" +
                    "\u0003\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\u0019" +
                    "\u0001\u0000\u0000\u0000ST\u0003\u0000\u0000\u0000TU\u0003\u001c\u000e" +
                    "\u0000UX\u0001\u0000\u0000\u0000VX\u0003\u001c\u000e\u0000WS\u0001\u0000" +
                    "\u0000\u0000WV\u0001\u0000\u0000\u0000X\u001b\u0001\u0000\u0000\u0000" +
                    "Y^\u0003 \u0010\u0000Z^\u0003\u001e\u000f\u0000[^\u0003\"\u0011\u0000" +
                    "\\^\u0003$\u0012\u0000]Y\u0001\u0000\u0000\u0000]Z\u0001\u0000\u0000\u0000" +
                    "][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000^\u001d\u0001\u0000" +
                    "\u0000\u0000_`\u0005\u000f\u0000\u0000`a\u0005\u001b\u0000\u0000ab\u0005" +
                    "\u0010\u0000\u0000b\u001f\u0001\u0000\u0000\u0000cd\u0005\u0011\u0000" +
                    "\u0000de\u0003\u0004\u0002\u0000e!\u0001\u0000\u0000\u0000fj\u0005\u0012" +
                    "\u0000\u0000gh\u0005\u001b\u0000\u0000hk\u0005!\u0000\u0000ik\u0005\u0013" +
                    "\u0000\u0000jg\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000kl\u0001" +
                    "\u0000\u0000\u0000lm\u0005\u0014\u0000\u0000mn\u0007\u0005\u0000\u0000" +
                    "no\u0005\u0017\u0000\u0000op\u0003\u0000\u0000\u0000pq\u0005\u0018\u0000" +
                    "\u0000q#\u0001\u0000\u0000\u0000rs\u0005\u000f\u0000\u0000st\u0005\u001b" +
                    "\u0000\u0000tu\u0005\u0019\u0000\u0000uv\u0003\u0002\u0001\u0000vw\u0005" +
                    "\u001a\u0000\u0000w%\u0001\u0000\u0000\u0000\t148<@QW]j";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}