// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\MultiplyDmgParser.g4 by ANTLR 4.12.0
package interpreter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MultiplyDmgParserLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, Number = 5;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "Number"
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


    public MultiplyDmgParserLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
            "\u0004\u0000\u0005S\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001" +
                    "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004" +
                    "\u0007\u0004\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000" +
                    "\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004P\b\u0004\u000b\u0004" +
                    "\f\u0004Q\u0000\u0000\u0005\u0001\u0001\u0003\u0002\u0005\u0003\u0007" +
                    "\u0004\t\u0005\u0001\u0000\u0001\u0001\u000009S\u0000\u0001\u0001\u0000" +
                    "\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000" +
                    "\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000" +
                    "\u0000\u0001\u000b\u0001\u0000\u0000\u0000\u0003\u0011\u0001\u0000\u0000" +
                    "\u0000\u0005\u0019\u0001\u0000\u0000\u0000\u0007,\u0001\u0000\u0000\u0000" +
                    "\tO\u0001\u0000\u0000\u0000\u000b\f\u0005F\u0000\u0000\f\r\u0005l\u0000" +
                    "\u0000\r\u000e\u0005i\u0000\u0000\u000e\u000f\u0005p\u0000\u0000\u000f" +
                    "\u0010\u0005 \u0000\u0000\u0010\u0002\u0001\u0000\u0000\u0000\u0011\u0012" +
                    "\u0005 \u0000\u0000\u0012\u0013\u0005c\u0000\u0000\u0013\u0014\u0005o" +
                    "\u0000\u0000\u0014\u0015\u0005i\u0000\u0000\u0015\u0016\u0005n\u0000\u0000" +
                    "\u0016\u0017\u0005s\u0000\u0000\u0017\u0018\u0005.\u0000\u0000\u0018\u0004" +
                    "\u0001\u0000\u0000\u0000\u0019\u001a\u0005 \u0000\u0000\u001a\u001b\u0005" +
                    "T\u0000\u0000\u001b\u001c\u0005h\u0000\u0000\u001c\u001d\u0005i\u0000" +
                    "\u0000\u001d\u001e\u0005s\u0000\u0000\u001e\u001f\u0005 \u0000\u0000\u001f" +
                    " \u0005a\u0000\u0000 !\u0005t\u0000\u0000!\"\u0005t\u0000\u0000\"#\u0005" +
                    "a\u0000\u0000#$\u0005c\u0000\u0000$%\u0005k\u0000\u0000%&\u0005 \u0000" +
                    "\u0000&\'\u0005d\u0000\u0000\'(\u0005o\u0000\u0000()\u0005e\u0000\u0000" +
                    ")*\u0005s\u0000\u0000*+\u0005 \u0000\u0000+\u0006\u0001\u0000\u0000\u0000" +
                    ",-\u0005 \u0000\u0000-.\u0005d\u0000\u0000./\u0005a\u0000\u0000/0\u0005" +
                    "m\u0000\u000001\u0005a\u0000\u000012\u0005g\u0000\u000023\u0005e\u0000" +
                    "\u000034\u0005 \u0000\u000045\u0005t\u0000\u000056\u0005i\u0000\u0000" +
                    "67\u0005m\u0000\u000078\u0005e\u0000\u000089\u0005s\u0000\u00009:\u0005" +
                    " \u0000\u0000:;\u0005t\u0000\u0000;<\u0005h\u0000\u0000<=\u0005e\u0000" +
                    "\u0000=>\u0005 \u0000\u0000>?\u0005n\u0000\u0000?@\u0005u\u0000\u0000" +
                    "@A\u0005m\u0000\u0000AB\u0005b\u0000\u0000BC\u0005e\u0000\u0000CD\u0005" +
                    "r\u0000\u0000DE\u0005 \u0000\u0000EF\u0005o\u0000\u0000FG\u0005f\u0000" +
                    "\u0000GH\u0005 \u0000\u0000HI\u0005h\u0000\u0000IJ\u0005e\u0000\u0000" +
                    "JK\u0005a\u0000\u0000KL\u0005d\u0000\u0000LM\u0005s\u0000\u0000M\b\u0001" +
                    "\u0000\u0000\u0000NP\u0007\u0000\u0000\u0000ON\u0001\u0000\u0000\u0000" +
                    "PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000" +
                    "\u0000R\n\u0001\u0000\u0000\u0000\u0002\u0000Q\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}