// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\BaseVariables.g4 by ANTLR 4.12.0
package de.my.tcg.grammar.parser.interpreter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BaseVariablesLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            Number = 1, WHITESPACE = 2, StatusCondition = 3, ConditionTypes = 4, Target = 5,
            VarPokemonName = 6, DefendingPokemon = 7, PokeType = 8;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "Number", "WHITESPACE", "StatusCondition", "ConditionTypes", "Target",
                "VarPokemonName", "DefendingPokemon", "PokeType"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, null, null, null, null, "'this Pokemon'", "'the Defending Pok\\u00E9mon'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "Number", "WHITESPACE", "StatusCondition", "ConditionTypes", "Target",
                "VarPokemonName", "DefendingPokemon", "PokeType"
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


    public BaseVariablesLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "BaseVariables.g4";
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\u0004\u0000\b\u008c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001" +
                    "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004" +
                    "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007" +
                    "\u0007\u0007\u0001\u0000\u0004\u0000\u0013\b\u0000\u000b\u0000\f\u0000" +
                    "\u0014\u0001\u0001\u0004\u0001\u0018\b\u0001\u000b\u0001\f\u0001\u0019" +
                    "\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0003\u00024\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0003\u0003Y\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004" +
                    "]\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u008b\b\u0007\u0000\u0000" +
                    "\b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006" +
                    "\r\u0007\u000f\b\u0001\u0000\u0018\u0003\u000009AAaa\u0004\u0000\t\n\r" +
                    "\r  ..\u0002\u0000SSss\u0002\u0000LLll\u0002\u0000EEee\u0002\u0000PPp" +
                    "p\u0002\u0000CCcc\u0002\u0000OOoo\u0002\u0000NNnn\u0002\u0000FFff\u0002" +
                    "\u0000UUuu\u0002\u0000DDdd\u0002\u0000AAaa\u0002\u0000RRrr\u0002\u0000" +
                    "YYyy\u0002\u0000HHhh\u0002\u0000KKkk\u0002\u0000\u00c9\u00c9\u00e9\u00e9" +
                    "\u0002\u0000MMmm\u0002\u0000VVvv\u0002\u0000IIii\u0002\u0000TTtt\u0002" +
                    "\u0000GGgg\u0002\u0000WWww\u0093\u0000\u0001\u0001\u0000\u0000\u0000\u0000" +
                    "\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000" +
                    "\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b" +
                    "\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001" +
                    "\u0000\u0000\u0000\u0001\u0012\u0001\u0000\u0000\u0000\u0003\u0017\u0001" +
                    "\u0000\u0000\u0000\u00053\u0001\u0000\u0000\u0000\u0007X\u0001\u0000\u0000" +
                    "\u0000\t\\\u0001\u0000\u0000\u0000\u000b^\u0001\u0000\u0000\u0000\rk\u0001" +
                    "\u0000\u0000\u0000\u000f\u008a\u0001\u0000\u0000\u0000\u0011\u0013\u0007" +
                    "\u0000\u0000\u0000\u0012\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001" +
                    "\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0015\u0001" +
                    "\u0000\u0000\u0000\u0015\u0002\u0001\u0000\u0000\u0000\u0016\u0018\u0007" +
                    "\u0001\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u0019\u0001" +
                    "\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001" +
                    "\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001c\u0006" +
                    "\u0001\u0000\u0000\u001c\u0004\u0001\u0000\u0000\u0000\u001d\u001e\u0007" +
                    "\u0002\u0000\u0000\u001e\u001f\u0007\u0003\u0000\u0000\u001f \u0007\u0004" +
                    "\u0000\u0000 !\u0007\u0004\u0000\u0000!4\u0007\u0005\u0000\u0000\"#\u0007" +
                    "\u0006\u0000\u0000#$\u0007\u0007\u0000\u0000$%\u0007\b\u0000\u0000%&\u0007" +
                    "\t\u0000\u0000&\'\u0007\n\u0000\u0000\'(\u0007\u0002\u0000\u0000()\u0007" +
                    "\u0004\u0000\u0000)4\u0007\u000b\u0000\u0000*+\u0007\u0005\u0000\u0000" +
                    "+,\u0007\f\u0000\u0000,-\u0007\r\u0000\u0000-.\u0007\f\u0000\u0000./\u0007" +
                    "\u0003\u0000\u0000/0\u0007\u000e\u0000\u000001\u0007\u0002\u0000\u0000" +
                    "12\u0007\u0004\u0000\u000024\u0007\u000b\u0000\u00003\u001d\u0001\u0000" +
                    "\u0000\u00003\"\u0001\u0000\u0000\u00003*\u0001\u0000\u0000\u00004\u0006" +
                    "\u0001\u0000\u0000\u000056\u0007\u000f\u0000\u000067\u0007\u0004\u0000" +
                    "\u000078\u0007\f\u0000\u000089\u0007\u000b\u0000\u00009Y\u0007\u0002\u0000" +
                    "\u0000:;\u0007\u0005\u0000\u0000;<\u0007\u0007\u0000\u0000<=\u0007\u0010" +
                    "\u0000\u0000=>\u0007\u0011\u0000\u0000>?\u0007\u0012\u0000\u0000?@\u0007" +
                    "\u0007\u0000\u0000@A\u0007\b\u0000\u0000AB\u0005 \u0000\u0000BC\u0007" +
                    "\u000e\u0000\u0000CD\u0007\u0007\u0000\u0000DE\u0007\n\u0000\u0000EF\u0005" +
                    " \u0000\u0000FG\u0007\u000f\u0000\u0000GH\u0007\f\u0000\u0000HI\u0007" +
                    "\u0013\u0000\u0000IJ\u0007\u0004\u0000\u0000JK\u0005 \u0000\u0000KL\u0007" +
                    "\u0014\u0000\u0000LM\u0007\b\u0000\u0000MN\u0005 \u0000\u0000NO\u0007" +
                    "\u0005\u0000\u0000OP\u0007\u0003\u0000\u0000PQ\u0007\f\u0000\u0000QR\u0007" +
                    "\u000e\u0000\u0000RY\u0005.\u0000\u0000ST\u0007\u0015\u0000\u0000TU\u0007" +
                    "\f\u0000\u0000UV\u0007\u0014\u0000\u0000VW\u0007\u0003\u0000\u0000WY\u0007" +
                    "\u0002\u0000\u0000X5\u0001\u0000\u0000\u0000X:\u0001\u0000\u0000\u0000" +
                    "XS\u0001\u0000\u0000\u0000Y\b\u0001\u0000\u0000\u0000Z]\u0003\u000b\u0005" +
                    "\u0000[]\u0003\r\u0006\u0000\\Z\u0001\u0000\u0000\u0000\\[\u0001\u0000" +
                    "\u0000\u0000]\n\u0001\u0000\u0000\u0000^_\u0007\u0015\u0000\u0000_`\u0007" +
                    "\u000f\u0000\u0000`a\u0007\u0014\u0000\u0000ab\u0007\u0002\u0000\u0000" +
                    "bc\u0005 \u0000\u0000cd\u0007\u0005\u0000\u0000de\u0007\u0007\u0000\u0000" +
                    "ef\u0007\u0010\u0000\u0000fg\u0007\u0004\u0000\u0000gh\u0007\u0012\u0000" +
                    "\u0000hi\u0007\u0007\u0000\u0000ij\u0007\b\u0000\u0000j\f\u0001\u0000" +
                    "\u0000\u0000kl\u0007\u0015\u0000\u0000lm\u0007\u000f\u0000\u0000mn\u0007" +
                    "\u0004\u0000\u0000no\u0005 \u0000\u0000op\u0007\u000b\u0000\u0000pq\u0007" +
                    "\u0004\u0000\u0000qr\u0007\t\u0000\u0000rs\u0007\u0004\u0000\u0000st\u0007" +
                    "\b\u0000\u0000tu\u0007\u000b\u0000\u0000uv\u0007\u0014\u0000\u0000vw\u0007" +
                    "\b\u0000\u0000wx\u0007\u0016\u0000\u0000xy\u0005 \u0000\u0000yz\u0007" +
                    "\u0005\u0000\u0000z{\u0007\u0007\u0000\u0000{|\u0007\u0010\u0000\u0000" +
                    "|}\u0007\u0011\u0000\u0000}~\u0007\u0012\u0000\u0000~\u007f\u0007\u0007" +
                    "\u0000\u0000\u007f\u0080\u0007\b\u0000\u0000\u0080\u000e\u0001\u0000\u0000" +
                    "\u0000\u0081\u0082\u0007\u0017\u0000\u0000\u0082\u0083\u0007\f\u0000\u0000" +
                    "\u0083\u0084\u0007\u0015\u0000\u0000\u0084\u0085\u0007\u0004\u0000\u0000" +
                    "\u0085\u008b\u0007\r\u0000\u0000\u0086\u0087\u0007\t\u0000\u0000\u0087" +
                    "\u0088\u0007\u0014\u0000\u0000\u0088\u0089\u0007\r\u0000\u0000\u0089\u008b" +
                    "\u0007\u0004\u0000\u0000\u008a\u0081\u0001\u0000\u0000\u0000\u008a\u0086" +
                    "\u0001\u0000\u0000\u0000\u008b\u0010\u0001\u0000\u0000\u0000\u0007\u0000" +
                    "\u0014\u00193X\\\u008a\u0001\u0006\u0000\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}