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
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, Number = 24,
            WHITESPACE = 25, DoOrDont = 26, Do = 27, Dont = 28, Target = 29, VarPokemonName = 30,
            DefendingPokemon = 31, PokeType = 32, ConditionTypes = 33, LimitationCounter = 34,
            NumberAsText = 35;
    public static final int
            RULE_effectText = 0, RULE_term = 1, RULE_additionalDmgEffect = 2, RULE_dmgData = 3,
            RULE_condition = 4, RULE_energyNotUsed = 5, RULE_dmgCounter = 6, RULE_limitation = 7,
            RULE_energyAfter = 8, RULE_energyAfter_Var1 = 9, RULE_energyAfter_Var2 = 10,
            RULE_coinFlipEffect = 11, RULE_flipCoin = 12, RULE_conditionClass = 13,
            RULE_attackIfDoes = 14, RULE_attackElseDoes = 15, RULE_pokemonStatusCondition = 16;

    private static String[] makeRuleNames() {
        return new String[]{
                "effectText", "term", "additionalDmgEffect", "dmgData", "condition",
                "energyNotUsed", "dmgCounter", "limitation", "energyAfter", "energyAfter_Var1",
                "energyAfter_Var2", "coinFlipEffect", "flipCoin", "conditionClass", "attackIfDoes",
                "attackElseDoes", "pokemonStatusCondition"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "' damage plus '", "' more damage'", "'for each'", "'Energy attached to'",
                "'but not used to pay for this attacks Energy cost'", "'for each damage counter on'",
                "'Extra '", "'Energy after the'", "' count.'", "'You cant add more than '",
                "' damage in this way'", "'Flip'", "'coin'", "'coins'", "'if'", "'this attack does'",
                "'more damage'", "' damage'", "'Asleep'", "'Confused'", "'Paralyzed'",
                "'Poisoned'", "'Burned'", null, null, null, "'Does'", null, null, "'this Pokemon'",
                "'the Defending Pok\\u00E9mon'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                "Number", "WHITESPACE", "DoOrDont", "Do", "Dont", "Target", "VarPokemonName",
                "DefendingPokemon", "PokeType", "ConditionTypes", "LimitationCounter",
                "NumberAsText"
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
                } while (_la == T__11 || _la == DoOrDont);
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

        public CoinFlipEffectContext coinFlipEffect() {
            return getRuleContext(CoinFlipEffectContext.class, 0);
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
            setState(41);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case DoOrDont:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(39);
                    additionalDmgEffect();
                }
                break;
                case T__11:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(40);
                    coinFlipEffect();
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
    public static class AdditionalDmgEffectContext extends ParserRuleContext {
        public DmgDataContext dmgData() {
            return getRuleContext(DmgDataContext.class, 0);
        }

        public ConditionContext condition() {
            return getRuleContext(ConditionContext.class, 0);
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
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(43);
                dmgData();
                setState(45);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__2 || _la == T__5) {
                    {
                        setState(44);
                        condition();
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
    public static class DmgDataContext extends ParserRuleContext {
        public Token dmg;
        public Token additionalDmg;

        public TerminalNode DoOrDont() {
            return getToken(AdditionalDmgParserParser.DoOrDont, 0);
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
                setState(47);
                match(DoOrDont);
                setState(48);
                ((DmgDataContext) _localctx).dmg = match(Number);
                setState(49);
                match(T__0);
                setState(50);
                ((DmgDataContext) _localctx).additionalDmg = match(Number);
                setState(51);
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
    public static class ConditionContext extends ParserRuleContext {
        public EnergyNotUsedContext energyNotUsed() {
            return getRuleContext(EnergyNotUsedContext.class, 0);
        }

        public LimitationContext limitation() {
            return getRuleContext(LimitationContext.class, 0);
        }

        public DmgCounterContext dmgCounter() {
            return getRuleContext(DmgCounterContext.class, 0);
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
            setState(57);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__2:
                    enterOuterAlt(_localctx, 1);
                {
                    {
                        setState(53);
                        energyNotUsed();
                        setState(54);
                        limitation();
                    }
                }
                break;
                case T__5:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(56);
                    dmgCounter();
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
    public static class EnergyNotUsedContext extends ParserRuleContext {
        public Token type;
        public Token target;

        public TerminalNode PokeType() {
            return getToken(AdditionalDmgParserParser.PokeType, 0);
        }

        public TerminalNode Target() {
            return getToken(AdditionalDmgParserParser.Target, 0);
        }

        public EnergyNotUsedContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_energyNotUsed;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterEnergyNotUsed(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitEnergyNotUsed(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitEnergyNotUsed(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EnergyNotUsedContext energyNotUsed() throws RecognitionException {
        EnergyNotUsedContext _localctx = new EnergyNotUsedContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_energyNotUsed);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(59);
                match(T__2);
                setState(60);
                ((EnergyNotUsedContext) _localctx).type = match(PokeType);
                setState(61);
                match(T__3);
                setState(62);
                ((EnergyNotUsedContext) _localctx).target = match(Target);
                setState(63);
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
    public static class DmgCounterContext extends ParserRuleContext {
        public Token target;

        public TerminalNode Target() {
            return getToken(AdditionalDmgParserParser.Target, 0);
        }

        public DmgCounterContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dmgCounter;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterDmgCounter(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitDmgCounter(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitDmgCounter(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DmgCounterContext dmgCounter() throws RecognitionException {
        DmgCounterContext _localctx = new DmgCounterContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_dmgCounter);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(65);
                match(T__5);
                setState(66);
                ((DmgCounterContext) _localctx).target = match(Target);
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
        public EnergyAfterContext energyAfter() {
            return getRuleContext(EnergyAfterContext.class, 0);
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
        enterRule(_localctx, 14, RULE_limitation);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(68);
                energyAfter();
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
    public static class EnergyAfterContext extends ParserRuleContext {
        public EnergyAfter_Var1Context energyAfter_Var1() {
            return getRuleContext(EnergyAfter_Var1Context.class, 0);
        }

        public EnergyAfter_Var2Context energyAfter_Var2() {
            return getRuleContext(EnergyAfter_Var2Context.class, 0);
        }

        public EnergyAfterContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_energyAfter;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterEnergyAfter(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitEnergyAfter(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitEnergyAfter(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EnergyAfterContext energyAfter() throws RecognitionException {
        EnergyAfterContext _localctx = new EnergyAfterContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_energyAfter);
        try {
            setState(72);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__6:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(70);
                    energyAfter_Var1();
                }
                break;
                case T__9:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(71);
                    energyAfter_Var2();
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
    public static class EnergyAfter_Var1Context extends ParserRuleContext {
        public TerminalNode PokeType() {
            return getToken(AdditionalDmgParserParser.PokeType, 0);
        }

        public TerminalNode LimitationCounter() {
            return getToken(AdditionalDmgParserParser.LimitationCounter, 0);
        }

        public TerminalNode DoOrDont() {
            return getToken(AdditionalDmgParserParser.DoOrDont, 0);
        }

        public EnergyAfter_Var1Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_energyAfter_Var1;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterEnergyAfter_Var1(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitEnergyAfter_Var1(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitEnergyAfter_Var1(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EnergyAfter_Var1Context energyAfter_Var1() throws RecognitionException {
        EnergyAfter_Var1Context _localctx = new EnergyAfter_Var1Context(_ctx, getState());
        enterRule(_localctx, 18, RULE_energyAfter_Var1);
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    {
                        setState(74);
                        match(T__6);
                    }
                    setState(75);
                    match(PokeType);
                    {
                        setState(76);
                        match(T__7);
                    }
                    setState(77);
                    match(LimitationCounter);
                    setState(78);
                    match(DoOrDont);
                    {
                        setState(79);
                        match(T__8);
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
    public static class EnergyAfter_Var2Context extends ParserRuleContext {
        public Token dmgLimit;

        public TerminalNode Number() {
            return getToken(AdditionalDmgParserParser.Number, 0);
        }

        public EnergyAfter_Var2Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_energyAfter_Var2;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterEnergyAfter_Var2(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitEnergyAfter_Var2(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitEnergyAfter_Var2(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EnergyAfter_Var2Context energyAfter_Var2() throws RecognitionException {
        EnergyAfter_Var2Context _localctx = new EnergyAfter_Var2Context(_ctx, getState());
        enterRule(_localctx, 20, RULE_energyAfter_Var2);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(81);
                match(T__9);
                setState(82);
                ((EnergyAfter_Var2Context) _localctx).dmgLimit = match(Number);
                setState(83);
                match(T__10);
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
    public static class CoinFlipEffectContext extends ParserRuleContext {
        public FlipCoinContext flipCoin() {
            return getRuleContext(FlipCoinContext.class, 0);
        }

        public List<ConditionClassContext> conditionClass() {
            return getRuleContexts(ConditionClassContext.class);
        }

        public ConditionClassContext conditionClass(int i) {
            return getRuleContext(ConditionClassContext.class, i);
        }

        public AttackIfDoesContext attackIfDoes() {
            return getRuleContext(AttackIfDoesContext.class, 0);
        }

        public AttackElseDoesContext attackElseDoes() {
            return getRuleContext(AttackElseDoesContext.class, 0);
        }

        public CoinFlipEffectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_coinFlipEffect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterCoinFlipEffect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitCoinFlipEffect(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitCoinFlipEffect(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CoinFlipEffectContext coinFlipEffect() throws RecognitionException {
        CoinFlipEffectContext _localctx = new CoinFlipEffectContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_coinFlipEffect);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(85);
                flipCoin();
                setState(86);
                conditionClass();
                setState(87);
                attackIfDoes();
                setState(91);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__14) {
                    {
                        setState(88);
                        conditionClass();
                        setState(89);
                        attackElseDoes();
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
    public static class FlipCoinContext extends ParserRuleContext {
        public Token times;

        public TerminalNode Number() {
            return getToken(AdditionalDmgParserParser.Number, 0);
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
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterFlipCoin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitFlipCoin(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitFlipCoin(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FlipCoinContext flipCoin() throws RecognitionException {
        FlipCoinContext _localctx = new FlipCoinContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_flipCoin);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(93);
                match(T__11);
                setState(94);
                ((FlipCoinContext) _localctx).times = match(Number);
                setState(95);
                _la = _input.LA(1);
                if (!(_la == T__12 || _la == T__13)) {
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
        public TerminalNode ConditionTypes() {
            return getToken(AdditionalDmgParserParser.ConditionTypes, 0);
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
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterConditionClass(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitConditionClass(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitConditionClass(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ConditionClassContext conditionClass() throws RecognitionException {
        ConditionClassContext _localctx = new ConditionClassContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_conditionClass);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(97);
                match(T__14);
                setState(98);
                match(ConditionTypes);
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
    public static class AttackIfDoesContext extends ParserRuleContext {
        public Token dmg;
        public Token addDmg;

        public List<TerminalNode> Number() {
            return getTokens(AdditionalDmgParserParser.Number);
        }

        public TerminalNode Number(int i) {
            return getToken(AdditionalDmgParserParser.Number, i);
        }

        public AttackIfDoesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_attackIfDoes;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterAttackIfDoes(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitAttackIfDoes(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitAttackIfDoes(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AttackIfDoesContext attackIfDoes() throws RecognitionException {
        AttackIfDoesContext _localctx = new AttackIfDoesContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_attackIfDoes);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(100);
                match(T__15);
                setState(101);
                ((AttackIfDoesContext) _localctx).dmg = match(Number);
                setState(102);
                match(T__0);
                setState(103);
                ((AttackIfDoesContext) _localctx).addDmg = match(Number);
                setState(104);
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
    public static class AttackElseDoesContext extends ParserRuleContext {
        public Token elseDmg;

        public TerminalNode Number() {
            return getToken(AdditionalDmgParserParser.Number, 0);
        }

        public AttackElseDoesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_attackElseDoes;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterAttackElseDoes(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitAttackElseDoes(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitAttackElseDoes(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AttackElseDoesContext attackElseDoes() throws RecognitionException {
        AttackElseDoesContext _localctx = new AttackElseDoesContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_attackElseDoes);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(106);
                match(T__15);
                setState(107);
                ((AttackElseDoesContext) _localctx).elseDmg = match(Number);
                setState(108);
                match(T__17);
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
    public static class PokemonStatusConditionContext extends ParserRuleContext {
        public PokemonStatusConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pokemonStatusCondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).enterPokemonStatusCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AdditionalDmgParserListener)
                ((AdditionalDmgParserListener) listener).exitPokemonStatusCondition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AdditionalDmgParserVisitor)
                return ((AdditionalDmgParserVisitor<? extends T>) visitor).visitPokemonStatusCondition(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PokemonStatusConditionContext pokemonStatusCondition() throws RecognitionException {
        PokemonStatusConditionContext _localctx = new PokemonStatusConditionContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_pokemonStatusCondition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(110);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 16252928L) != 0))) {
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
            "\u0004\u0001#q\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002" +
                    "\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005" +
                    "\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007" +
                    "\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007" +
                    "\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002" +
                    "\u0010\u0007\u0010\u0001\u0000\u0004\u0000$\b\u0000\u000b\u0000\f\u0000" +
                    "%\u0001\u0001\u0001\u0001\u0003\u0001*\b\u0001\u0001\u0002\u0001\u0002" +
                    "\u0003\u0002.\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0003\u0004:\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007" +
                    "\u0001\u0007\u0001\b\u0001\b\u0003\bI\b\b\u0001\t\u0001\t\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b" +
                    "\\\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001" +
                    "\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001" +
                    "\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001" +
                    "\u0010\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012" +
                    "\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0002\u0001\u0000\r\u000e" +
                    "\u0001\u0000\u0013\u0017e\u0000#\u0001\u0000\u0000\u0000\u0002)\u0001" +
                    "\u0000\u0000\u0000\u0004+\u0001\u0000\u0000\u0000\u0006/\u0001\u0000\u0000" +
                    "\u0000\b9\u0001\u0000\u0000\u0000\n;\u0001\u0000\u0000\u0000\fA\u0001" +
                    "\u0000\u0000\u0000\u000eD\u0001\u0000\u0000\u0000\u0010H\u0001\u0000\u0000" +
                    "\u0000\u0012J\u0001\u0000\u0000\u0000\u0014Q\u0001\u0000\u0000\u0000\u0016" +
                    "U\u0001\u0000\u0000\u0000\u0018]\u0001\u0000\u0000\u0000\u001aa\u0001" +
                    "\u0000\u0000\u0000\u001cd\u0001\u0000\u0000\u0000\u001ej\u0001\u0000\u0000" +
                    "\u0000 n\u0001\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000" +
                    "\u0000\u0000$%\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001" +
                    "\u0000\u0000\u0000&\u0001\u0001\u0000\u0000\u0000\'*\u0003\u0004\u0002" +
                    "\u0000(*\u0003\u0016\u000b\u0000)\'\u0001\u0000\u0000\u0000)(\u0001\u0000" +
                    "\u0000\u0000*\u0003\u0001\u0000\u0000\u0000+-\u0003\u0006\u0003\u0000" +
                    ",.\u0003\b\u0004\u0000-,\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000" +
                    ".\u0005\u0001\u0000\u0000\u0000/0\u0005\u001a\u0000\u000001\u0005\u0018" +
                    "\u0000\u000012\u0005\u0001\u0000\u000023\u0005\u0018\u0000\u000034\u0005" +
                    "\u0002\u0000\u00004\u0007\u0001\u0000\u0000\u000056\u0003\n\u0005\u0000" +
                    "67\u0003\u000e\u0007\u00007:\u0001\u0000\u0000\u00008:\u0003\f\u0006\u0000" +
                    "95\u0001\u0000\u0000\u000098\u0001\u0000\u0000\u0000:\t\u0001\u0000\u0000" +
                    "\u0000;<\u0005\u0003\u0000\u0000<=\u0005 \u0000\u0000=>\u0005\u0004\u0000" +
                    "\u0000>?\u0005\u001d\u0000\u0000?@\u0005\u0005\u0000\u0000@\u000b\u0001" +
                    "\u0000\u0000\u0000AB\u0005\u0006\u0000\u0000BC\u0005\u001d\u0000\u0000" +
                    "C\r\u0001\u0000\u0000\u0000DE\u0003\u0010\b\u0000E\u000f\u0001\u0000\u0000" +
                    "\u0000FI\u0003\u0012\t\u0000GI\u0003\u0014\n\u0000HF\u0001\u0000\u0000" +
                    "\u0000HG\u0001\u0000\u0000\u0000I\u0011\u0001\u0000\u0000\u0000JK\u0005" +
                    "\u0007\u0000\u0000KL\u0005 \u0000\u0000LM\u0005\b\u0000\u0000MN\u0005" +
                    "\"\u0000\u0000NO\u0005\u001a\u0000\u0000OP\u0005\t\u0000\u0000P\u0013" +
                    "\u0001\u0000\u0000\u0000QR\u0005\n\u0000\u0000RS\u0005\u0018\u0000\u0000" +
                    "ST\u0005\u000b\u0000\u0000T\u0015\u0001\u0000\u0000\u0000UV\u0003\u0018" +
                    "\f\u0000VW\u0003\u001a\r\u0000W[\u0003\u001c\u000e\u0000XY\u0003\u001a" +
                    "\r\u0000YZ\u0003\u001e\u000f\u0000Z\\\u0001\u0000\u0000\u0000[X\u0001" +
                    "\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u0017\u0001\u0000\u0000" +
                    "\u0000]^\u0005\f\u0000\u0000^_\u0005\u0018\u0000\u0000_`\u0007\u0000\u0000" +
                    "\u0000`\u0019\u0001\u0000\u0000\u0000ab\u0005\u000f\u0000\u0000bc\u0005" +
                    "!\u0000\u0000c\u001b\u0001\u0000\u0000\u0000de\u0005\u0010\u0000\u0000" +
                    "ef\u0005\u0018\u0000\u0000fg\u0005\u0001\u0000\u0000gh\u0005\u0018\u0000" +
                    "\u0000hi\u0005\u0011\u0000\u0000i\u001d\u0001\u0000\u0000\u0000jk\u0005" +
                    "\u0010\u0000\u0000kl\u0005\u0018\u0000\u0000lm\u0005\u0012\u0000\u0000" +
                    "m\u001f\u0001\u0000\u0000\u0000no\u0007\u0001\u0000\u0000o!\u0001\u0000" +
                    "\u0000\u0000\u0006%)-9H[";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}