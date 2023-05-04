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
            T__9 = 10, Number = 11, WHITESPACE = 12, DoOrDont = 13, Do = 14, Dont = 15, Target = 16,
            VarPokemonName = 17, DefendingPokemon = 18, StatusCondition = 19, PokeType = 20,
            ConditionTypes = 21, LimitationCounter = 22, NumberAsText = 23;
    public static final int
            RULE_effectText = 0, RULE_term = 1, RULE_additionalDmgEffect = 2, RULE_dmgData = 3,
            RULE_condition = 4, RULE_energyNotUsed = 5, RULE_limitation = 6, RULE_energyAfter = 7,
            RULE_energyAfter_Var1 = 8, RULE_energyAfter_Var2 = 9;

    private static String[] makeRuleNames() {
        return new String[]{
                "effectText", "term", "additionalDmgEffect", "dmgData", "condition",
                "energyNotUsed", "limitation", "energyAfter", "energyAfter_Var1", "energyAfter_Var2"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "' damage plus'", "'more damage'", "'for each'", "'Energy attached to'",
                "'but not used to pay for this attacks Energy cost'", "'Extra '", "'Energy after the'",
                "' count.'", "'You cant add more than '", "' damage in this way'", null,
                null, null, "'Does'", null, null, "'this Pokemon'", "'the Defending Pok\\u00E9mon'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, "Number",
                "WHITESPACE", "DoOrDont", "Do", "Dont", "Target", "VarPokemonName", "DefendingPokemon",
                "StatusCondition", "PokeType", "ConditionTypes", "LimitationCounter",
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
                setState(21);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(20);
                            term();
                        }
                    }
                    setState(23);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == DoOrDont);
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
                setState(25);
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
                setState(27);
                dmgData();
                setState(29);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__2) {
                    {
                        setState(28);
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
                setState(31);
                match(DoOrDont);
                setState(32);
                ((DmgDataContext) _localctx).dmg = match(Number);
                setState(33);
                match(T__0);
                setState(34);
                ((DmgDataContext) _localctx).additionalDmg = match(Number);
                setState(35);
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
                setState(37);
                energyNotUsed();
                setState(38);
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
                setState(40);
                match(T__2);
                setState(41);
                ((EnergyNotUsedContext) _localctx).type = match(PokeType);
                setState(42);
                match(T__3);
                setState(43);
                ((EnergyNotUsedContext) _localctx).target = match(Target);
                setState(44);
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
        enterRule(_localctx, 12, RULE_limitation);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(46);
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
        enterRule(_localctx, 14, RULE_energyAfter);
        try {
            setState(50);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__5:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(48);
                    energyAfter_Var1();
                }
                break;
                case T__8:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(49);
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
        enterRule(_localctx, 16, RULE_energyAfter_Var1);
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    {
                        setState(52);
                        match(T__5);
                    }
                    setState(53);
                    match(PokeType);
                    {
                        setState(54);
                        match(T__6);
                    }
                    setState(55);
                    match(LimitationCounter);
                    setState(56);
                    match(DoOrDont);
                    {
                        setState(57);
                        match(T__7);
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
        enterRule(_localctx, 18, RULE_energyAfter_Var2);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(59);
                match(T__8);
                setState(60);
                ((EnergyAfter_Var2Context) _localctx).dmgLimit = match(Number);
                setState(61);
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

    public static final String _serializedATN =
            "\u0004\u0001\u0017@\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
                    "\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000\u000b" +
                    "\u0000\f\u0000\u0017\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003" +
                    "\u0002\u001e\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001" +
                    "\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001" +
                    "\u0006\u0001\u0007\u0001\u0007\u0003\u00073\b\u0007\u0001\b\u0001\b\u0001" +
                    "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
                    "\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000" +
                    "\u00008\u0000\u0015\u0001\u0000\u0000\u0000\u0002\u0019\u0001\u0000\u0000" +
                    "\u0000\u0004\u001b\u0001\u0000\u0000\u0000\u0006\u001f\u0001\u0000\u0000" +
                    "\u0000\b%\u0001\u0000\u0000\u0000\n(\u0001\u0000\u0000\u0000\f.\u0001" +
                    "\u0000\u0000\u0000\u000e2\u0001\u0000\u0000\u0000\u00104\u0001\u0000\u0000" +
                    "\u0000\u0012;\u0001\u0000\u0000\u0000\u0014\u0016\u0003\u0002\u0001\u0000" +
                    "\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000" +
                    "\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000" +
                    "\u0018\u0001\u0001\u0000\u0000\u0000\u0019\u001a\u0003\u0004\u0002\u0000" +
                    "\u001a\u0003\u0001\u0000\u0000\u0000\u001b\u001d\u0003\u0006\u0003\u0000" +
                    "\u001c\u001e\u0003\b\u0004\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d" +
                    "\u001e\u0001\u0000\u0000\u0000\u001e\u0005\u0001\u0000\u0000\u0000\u001f" +
                    " \u0005\r\u0000\u0000 !\u0005\u000b\u0000\u0000!\"\u0005\u0001\u0000\u0000" +
                    "\"#\u0005\u000b\u0000\u0000#$\u0005\u0002\u0000\u0000$\u0007\u0001\u0000" +
                    "\u0000\u0000%&\u0003\n\u0005\u0000&\'\u0003\f\u0006\u0000\'\t\u0001\u0000" +
                    "\u0000\u0000()\u0005\u0003\u0000\u0000)*\u0005\u0014\u0000\u0000*+\u0005" +
                    "\u0004\u0000\u0000+,\u0005\u0010\u0000\u0000,-\u0005\u0005\u0000\u0000" +
                    "-\u000b\u0001\u0000\u0000\u0000./\u0003\u000e\u0007\u0000/\r\u0001\u0000" +
                    "\u0000\u000003\u0003\u0010\b\u000013\u0003\u0012\t\u000020\u0001\u0000" +
                    "\u0000\u000021\u0001\u0000\u0000\u00003\u000f\u0001\u0000\u0000\u0000" +
                    "45\u0005\u0006\u0000\u000056\u0005\u0014\u0000\u000067\u0005\u0007\u0000" +
                    "\u000078\u0005\u0016\u0000\u000089\u0005\r\u0000\u00009:\u0005\b\u0000" +
                    "\u0000:\u0011\u0001\u0000\u0000\u0000;<\u0005\t\u0000\u0000<=\u0005\u000b" +
                    "\u0000\u0000=>\u0005\n\u0000\u0000>\u0013\u0001\u0000\u0000\u0000\u0003" +
                    "\u0017\u001d2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}