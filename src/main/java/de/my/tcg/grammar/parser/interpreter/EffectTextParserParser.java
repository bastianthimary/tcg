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
            T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31,
            T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, Number = 36, WHITESPACE = 37, VarPokemonName = 38,
            DefendingPokemon = 39, AllBenchMons = 40, MyBenchMons = 41, PokeType = 42;
    public static final int
            RULE_target = 0, RULE_benchTarget = 1, RULE_statusCondition = 2, RULE_conditionTypes = 3,
            RULE_effectText = 4, RULE_term = 5, RULE_conditionTerm = 6, RULE_effectTerm = 7,
            RULE_condition = 8, RULE_flipCoin = 9, RULE_conditionClass = 10, RULE_dmgEffect = 11,
            RULE_multipleDmgEffect = 12, RULE_doNothing = 13, RULE_basicEffect = 14,
            RULE_executedEffect = 15, RULE_hurtEffect = 16, RULE_statusEffect = 17,
            RULE_discardEnergy = 18, RULE_benchDmgEffect = 19, RULE_prevent = 20,
            RULE_preventAllDmg = 21, RULE_preventEffectAndDmg = 22, RULE_preventDmgReduction = 23,
            RULE_preventRetreat = 24, RULE_draw = 25;

    private static String[] makeRuleNames() {
        return new String[]{
                "target", "benchTarget", "statusCondition", "conditionTypes", "effectText",
                "term", "conditionTerm", "effectTerm", "condition", "flipCoin", "conditionClass",
                "dmgEffect", "multipleDmgEffect", "doNothing", "basicEffect", "executedEffect",
                "hurtEffect", "statusEffect", "discardEnergy", "benchDmgEffect", "prevent",
                "preventAllDmg", "preventEffectAndDmg", "preventDmgReduction", "preventRetreat",
                "draw"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'Asleep'", "'Confused'", "'Paralyzed'", "'Poisoned'", "'Burned'",
                "'heads'", "'Pok\\u00E9mon you have in play.'", "'tails'", "'Flip'",
                "'coin'", "'coins'", "'if'", "'This attack does'", "' damage times the number of'",
                "'this attack does nothing'", "'does '", "'damage to itself'", "'is now'",
                "'Discard'", "'all'", "'Energy'", "'card'", "'cards'", "' attached to'",
                "' in order to use this attack.'", "'damage to '", "'. Dont apply Weakness and Resistance for Benched Pok\\u00E9mon.'",
                "'prevent all damage done to'", "'during your opponents next turn. Any other effects of attacks still happen.'",
                "'during your opponents next turn, prevent all effects of attacks, including damage, done to'",
                "'During your opponents next turn, whenever'", "' or less damage is done to'",
                "' after applying Weakness and Resistance'", "'cant retreat during your opponents next turn'",
                "'draw'", null, null, "'this Pokemon'", "'the Defending Pok\\u00E9mon'",
                "'each Pok\\u00E9mon on each players Bench'", "'each of your own Benched Pok\\u00E9mon'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                "Number", "WHITESPACE", "VarPokemonName", "DefendingPokemon", "AllBenchMons",
                "MyBenchMons", "PokeType"
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
                setState(52);
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
                setState(54);
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
                setState(56);
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
                setState(58);
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
                setState(61);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(60);
                            term();
                        }
                    }
                    setState(63);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 862484013568L) != 0));
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
            setState(70);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    {
                        setState(66);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__8) {
                            {
                                setState(65);
                                conditionTerm();
                            }
                        }

                        setState(68);
                        effectTerm();
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(69);
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
                setState(72);
                condition();
                setState(74);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__11) {
                    {
                        setState(73);
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
            setState(78);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__12:
                case T__14:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(76);
                    dmgEffect();
                }
                break;
                case T__15:
                case T__17:
                case T__18:
                case T__27:
                case T__29:
                case T__30:
                case T__34:
                case VarPokemonName:
                case DefendingPokemon:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(77);
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
                setState(80);
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
                setState(82);
                match(T__8);
                setState(83);
                ((FlipCoinContext) _localctx).times = match(Number);
                setState(84);
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
                setState(86);
                match(T__11);
                setState(87);
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

        public DoNothingContext doNothing() {
            return getRuleContext(DoNothingContext.class, 0);
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
            setState(91);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__12:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(89);
                    multipleDmgEffect();
                }
                break;
                case T__14:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(90);
                    doNothing();
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
                setState(93);
                match(T__12);
                setState(94);
                ((MultipleDmgEffectContext) _localctx).dmgPer = match(Number);
                setState(95);
                match(T__13);
                setState(97);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) {
                    {
                        setState(96);
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
    public static class DoNothingContext extends ParserRuleContext {
        public DoNothingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_doNothing;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterDoNothing(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).exitDoNothing(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitDoNothing(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DoNothingContext doNothing() throws RecognitionException {
        DoNothingContext _localctx = new DoNothingContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_doNothing);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(99);
                match(T__14);
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
        enterRule(_localctx, 28, RULE_basicEffect);
        try {
            setState(105);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    {
                        setState(101);
                        target();
                        setState(102);
                        executedEffect();
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(104);
                    executedEffect();
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

        public PreventContext prevent() {
            return getRuleContext(PreventContext.class, 0);
        }

        public DrawContext draw() {
            return getRuleContext(DrawContext.class, 0);
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
        enterRule(_localctx, 30, RULE_executedEffect);
        try {
            setState(113);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(107);
                    statusEffect();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(108);
                    hurtEffect();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(109);
                    discardEnergy();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(110);
                    benchDmgEffect();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(111);
                    prevent();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(112);
                    draw();
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
        enterRule(_localctx, 32, RULE_hurtEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(115);
                match(T__15);
                setState(116);
                ((HurtEffectContext) _localctx).dmg = match(Number);
                setState(117);
                match(T__16);
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
        enterRule(_localctx, 34, RULE_statusEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(119);
                match(T__17);
                setState(120);
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
        enterRule(_localctx, 36, RULE_discardEnergy);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(122);
                match(T__18);
                setState(126);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case Number: {
                        {
                            setState(123);
                            ((DiscardEnergyContext) _localctx).numberOfCards = match(Number);
                            setState(124);
                            match(PokeType);
                        }
                    }
                    break;
                    case T__19: {
                        setState(125);
                        ((DiscardEnergyContext) _localctx).numberOfCards = match(T__19);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(128);
                match(T__20);
                setState(129);
                _la = _input.LA(1);
                if (!(_la == T__21 || _la == T__22)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(130);
                match(T__23);
                setState(131);
                target();
                setState(132);
                match(T__24);
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
        enterRule(_localctx, 38, RULE_benchDmgEffect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(134);
                match(T__15);
                setState(135);
                ((BenchDmgEffectContext) _localctx).dmg = match(Number);
                setState(136);
                match(T__25);
                setState(137);
                benchTarget();
                setState(138);
                match(T__26);
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
    public static class PreventContext extends ParserRuleContext {
        public PreventAllDmgContext preventAllDmg() {
            return getRuleContext(PreventAllDmgContext.class, 0);
        }

        public PreventEffectAndDmgContext preventEffectAndDmg() {
            return getRuleContext(PreventEffectAndDmgContext.class, 0);
        }

        public PreventDmgReductionContext preventDmgReduction() {
            return getRuleContext(PreventDmgReductionContext.class, 0);
        }

        public PreventRetreatContext preventRetreat() {
            return getRuleContext(PreventRetreatContext.class, 0);
        }

        public PreventContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prevent;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).enterPrevent(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).exitPrevent(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitPrevent(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PreventContext prevent() throws RecognitionException {
        PreventContext _localctx = new PreventContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_prevent);
        try {
            setState(144);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__27:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(140);
                    preventAllDmg();
                }
                break;
                case T__29:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(141);
                    preventEffectAndDmg();
                }
                break;
                case T__30:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(142);
                    preventDmgReduction();
                }
                break;
                case VarPokemonName:
                case DefendingPokemon:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(143);
                    preventRetreat();
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
    public static class PreventAllDmgContext extends ParserRuleContext {
        public TargetContext target() {
            return getRuleContext(TargetContext.class, 0);
        }

        public PreventAllDmgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_preventAllDmg;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterPreventAllDmg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitPreventAllDmg(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitPreventAllDmg(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PreventAllDmgContext preventAllDmg() throws RecognitionException {
        PreventAllDmgContext _localctx = new PreventAllDmgContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_preventAllDmg);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(146);
                match(T__27);
                setState(147);
                target();
                setState(148);
                match(T__28);
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
    public static class PreventEffectAndDmgContext extends ParserRuleContext {
        public TargetContext target() {
            return getRuleContext(TargetContext.class, 0);
        }

        public PreventEffectAndDmgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_preventEffectAndDmg;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterPreventEffectAndDmg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitPreventEffectAndDmg(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitPreventEffectAndDmg(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PreventEffectAndDmgContext preventEffectAndDmg() throws RecognitionException {
        PreventEffectAndDmgContext _localctx = new PreventEffectAndDmgContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_preventEffectAndDmg);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(150);
                match(T__29);
                setState(151);
                target();
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
    public static class PreventDmgReductionContext extends ParserRuleContext {
        public Token reduce;

        public TargetContext target() {
            return getRuleContext(TargetContext.class, 0);
        }

        public TerminalNode Number() {
            return getToken(EffectTextParserParser.Number, 0);
        }

        public PreventDmgReductionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_preventDmgReduction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterPreventDmgReduction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitPreventDmgReduction(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitPreventDmgReduction(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PreventDmgReductionContext preventDmgReduction() throws RecognitionException {
        PreventDmgReductionContext _localctx = new PreventDmgReductionContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_preventDmgReduction);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(153);
                match(T__30);
                setState(154);
                ((PreventDmgReductionContext) _localctx).reduce = match(Number);
                setState(155);
                match(T__31);
                setState(156);
                target();
                setState(157);
                match(T__32);
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
    public static class PreventRetreatContext extends ParserRuleContext {
        public TargetContext target() {
            return getRuleContext(TargetContext.class, 0);
        }

        public PreventRetreatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_preventRetreat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).enterPreventRetreat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener)
                ((EffectTextParserListener) listener).exitPreventRetreat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitPreventRetreat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PreventRetreatContext preventRetreat() throws RecognitionException {
        PreventRetreatContext _localctx = new PreventRetreatContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_preventRetreat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(159);
                target();
                setState(160);
                match(T__33);
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
    public static class DrawContext extends ParserRuleContext {
        public Token count;

        public TerminalNode Number() {
            return getToken(EffectTextParserParser.Number, 0);
        }

        public DrawContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_draw;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).enterDraw(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof EffectTextParserListener) ((EffectTextParserListener) listener).exitDraw(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof EffectTextParserVisitor)
                return ((EffectTextParserVisitor<? extends T>) visitor).visitDraw(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DrawContext draw() throws RecognitionException {
        DrawContext _localctx = new DrawContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_draw);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(162);
                match(T__34);
                setState(163);
                ((DrawContext) _localctx).count = match(Number);
                setState(164);
                _la = _input.LA(1);
                if (!(_la == T__21 || _la == T__22)) {
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
            "\u0004\u0001*\u00a7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
                    "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
                    "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f" +
                    "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012" +
                    "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015" +
                    "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018" +
                    "\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001" +
                    "\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004" +
                    ">\b\u0004\u000b\u0004\f\u0004?\u0001\u0005\u0003\u0005C\b\u0005\u0001" +
                    "\u0005\u0001\u0005\u0003\u0005G\b\u0005\u0001\u0006\u0001\u0006\u0003" +
                    "\u0006K\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007O\b\u0007\u0001\b\u0001" +
                    "\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b" +
                    "\u0001\u000b\u0003\u000b\\\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003" +
                    "\fb\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
                    "\u0003\u000ej\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f" +
                    "\u0001\u000f\u0001\u000f\u0003\u000fr\b\u000f\u0001\u0010\u0001\u0010" +
                    "\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012" +
                    "\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u007f\b\u0012\u0001\u0012" +
                    "\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013" +
                    "\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014" +
                    "\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0091\b\u0014\u0001\u0015" +
                    "\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016" +
                    "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017" +
                    "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019" +
                    "\u0001\u0019\u0001\u0019\u0000\u0000\u001a\u0000\u0002\u0004\u0006\b\n" +
                    "\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02\u0000" +
                    "\u0006\u0001\u0000&\'\u0001\u0000()\u0001\u0000\u0001\u0005\u0001\u0000" +
                    "\u0006\b\u0001\u0000\n\u000b\u0001\u0000\u0016\u0017\u009d\u00004\u0001" +
                    "\u0000\u0000\u0000\u00026\u0001\u0000\u0000\u0000\u00048\u0001\u0000\u0000" +
                    "\u0000\u0006:\u0001\u0000\u0000\u0000\b=\u0001\u0000\u0000\u0000\nF\u0001" +
                    "\u0000\u0000\u0000\fH\u0001\u0000\u0000\u0000\u000eN\u0001\u0000\u0000" +
                    "\u0000\u0010P\u0001\u0000\u0000\u0000\u0012R\u0001\u0000\u0000\u0000\u0014" +
                    "V\u0001\u0000\u0000\u0000\u0016[\u0001\u0000\u0000\u0000\u0018]\u0001" +
                    "\u0000\u0000\u0000\u001ac\u0001\u0000\u0000\u0000\u001ci\u0001\u0000\u0000" +
                    "\u0000\u001eq\u0001\u0000\u0000\u0000 s\u0001\u0000\u0000\u0000\"w\u0001" +
                    "\u0000\u0000\u0000$z\u0001\u0000\u0000\u0000&\u0086\u0001\u0000\u0000" +
                    "\u0000(\u0090\u0001\u0000\u0000\u0000*\u0092\u0001\u0000\u0000\u0000," +
                    "\u0096\u0001\u0000\u0000\u0000.\u0099\u0001\u0000\u0000\u00000\u009f\u0001" +
                    "\u0000\u0000\u00002\u00a2\u0001\u0000\u0000\u000045\u0007\u0000\u0000" +
                    "\u00005\u0001\u0001\u0000\u0000\u000067\u0007\u0001\u0000\u00007\u0003" +
                    "\u0001\u0000\u0000\u000089\u0007\u0002\u0000\u00009\u0005\u0001\u0000" +
                    "\u0000\u0000:;\u0007\u0003\u0000\u0000;\u0007\u0001\u0000\u0000\u0000" +
                    "<>\u0003\n\u0005\u0000=<\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000" +
                    "?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@\t\u0001\u0000\u0000" +
                    "\u0000AC\u0003\f\u0006\u0000BA\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000" +
                    "\u0000CD\u0001\u0000\u0000\u0000DG\u0003\u000e\u0007\u0000EG\u0003\u000e" +
                    "\u0007\u0000FB\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000G\u000b" +
                    "\u0001\u0000\u0000\u0000HJ\u0003\u0010\b\u0000IK\u0003\u0014\n\u0000J" +
                    "I\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\r\u0001\u0000\u0000" +
                    "\u0000LO\u0003\u0016\u000b\u0000MO\u0003\u001c\u000e\u0000NL\u0001\u0000" +
                    "\u0000\u0000NM\u0001\u0000\u0000\u0000O\u000f\u0001\u0000\u0000\u0000" +
                    "PQ\u0003\u0012\t\u0000Q\u0011\u0001\u0000\u0000\u0000RS\u0005\t\u0000" +
                    "\u0000ST\u0005$\u0000\u0000TU\u0007\u0004\u0000\u0000U\u0013\u0001\u0000" +
                    "\u0000\u0000VW\u0005\f\u0000\u0000WX\u0003\u0006\u0003\u0000X\u0015\u0001" +
                    "\u0000\u0000\u0000Y\\\u0003\u0018\f\u0000Z\\\u0003\u001a\r\u0000[Y\u0001" +
                    "\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\\u0017\u0001\u0000\u0000" +
                    "\u0000]^\u0005\r\u0000\u0000^_\u0005$\u0000\u0000_a\u0005\u000e\u0000" +
                    "\u0000`b\u0003\u0006\u0003\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000" +
                    "\u0000\u0000b\u0019\u0001\u0000\u0000\u0000cd\u0005\u000f\u0000\u0000" +
                    "d\u001b\u0001\u0000\u0000\u0000ef\u0003\u0000\u0000\u0000fg\u0003\u001e" +
                    "\u000f\u0000gj\u0001\u0000\u0000\u0000hj\u0003\u001e\u000f\u0000ie\u0001" +
                    "\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000j\u001d\u0001\u0000\u0000" +
                    "\u0000kr\u0003\"\u0011\u0000lr\u0003 \u0010\u0000mr\u0003$\u0012\u0000" +
                    "nr\u0003&\u0013\u0000or\u0003(\u0014\u0000pr\u00032\u0019\u0000qk\u0001" +
                    "\u0000\u0000\u0000ql\u0001\u0000\u0000\u0000qm\u0001\u0000\u0000\u0000" +
                    "qn\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qp\u0001\u0000\u0000" +
                    "\u0000r\u001f\u0001\u0000\u0000\u0000st\u0005\u0010\u0000\u0000tu\u0005" +
                    "$\u0000\u0000uv\u0005\u0011\u0000\u0000v!\u0001\u0000\u0000\u0000wx\u0005" +
                    "\u0012\u0000\u0000xy\u0003\u0004\u0002\u0000y#\u0001\u0000\u0000\u0000" +
                    "z~\u0005\u0013\u0000\u0000{|\u0005$\u0000\u0000|\u007f\u0005*\u0000\u0000" +
                    "}\u007f\u0005\u0014\u0000\u0000~{\u0001\u0000\u0000\u0000~}\u0001\u0000" +
                    "\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0015" +
                    "\u0000\u0000\u0081\u0082\u0007\u0005\u0000\u0000\u0082\u0083\u0005\u0018" +
                    "\u0000\u0000\u0083\u0084\u0003\u0000\u0000\u0000\u0084\u0085\u0005\u0019" +
                    "\u0000\u0000\u0085%\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0010\u0000" +
                    "\u0000\u0087\u0088\u0005$\u0000\u0000\u0088\u0089\u0005\u001a\u0000\u0000" +
                    "\u0089\u008a\u0003\u0002\u0001\u0000\u008a\u008b\u0005\u001b\u0000\u0000" +
                    "\u008b\'\u0001\u0000\u0000\u0000\u008c\u0091\u0003*\u0015\u0000\u008d" +
                    "\u0091\u0003,\u0016\u0000\u008e\u0091\u0003.\u0017\u0000\u008f\u0091\u0003" +
                    "0\u0018\u0000\u0090\u008c\u0001\u0000\u0000\u0000\u0090\u008d\u0001\u0000" +
                    "\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u008f\u0001\u0000" +
                    "\u0000\u0000\u0091)\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u001c\u0000" +
                    "\u0000\u0093\u0094\u0003\u0000\u0000\u0000\u0094\u0095\u0005\u001d\u0000" +
                    "\u0000\u0095+\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u001e\u0000\u0000" +
                    "\u0097\u0098\u0003\u0000\u0000\u0000\u0098-\u0001\u0000\u0000\u0000\u0099" +
                    "\u009a\u0005\u001f\u0000\u0000\u009a\u009b\u0005$\u0000\u0000\u009b\u009c" +
                    "\u0005 \u0000\u0000\u009c\u009d\u0003\u0000\u0000\u0000\u009d\u009e\u0005" +
                    "!\u0000\u0000\u009e/\u0001\u0000\u0000\u0000\u009f\u00a0\u0003\u0000\u0000" +
                    "\u0000\u00a0\u00a1\u0005\"\u0000\u0000\u00a11\u0001\u0000\u0000\u0000" +
                    "\u00a2\u00a3\u0005#\u0000\u0000\u00a3\u00a4\u0005$\u0000\u0000\u00a4\u00a5" +
                    "\u0007\u0005\u0000\u0000\u00a53\u0001\u0000\u0000\u0000\u000b?BFJN[ai" +
                    "q~\u0090";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}