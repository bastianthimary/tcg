// Generated from C:/Users/Bastian Binaris/IdeaProjects/Privat/Pokemon/tcg/src/main/resources/interpreter\EffectTextParser.g4 by ANTLR 4.12.0
package de.my.tcg.grammar.parser.interpreter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EffectTextParserLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, Number = 15, WHITESPACE = 16;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
                "T__9", "T__10", "T__11", "T__12", "T__13", "Number", "WHITESPACE"
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


    public EffectTextParserLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
            "\u0004\u0000\u0010\u00d0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002" +
                    "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002" +
                    "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002" +
                    "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002" +
                    "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e" +
                    "\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000" +
                    "\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001" +
                    "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001" +
                    "\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001" +
                    "\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
                    "\r\u0001\r\u0001\u000e\u0004\u000e\u00c6\b\u000e\u000b\u000e\f\u000e\u00c7" +
                    "\u0001\u000f\u0004\u000f\u00cb\b\u000f\u000b\u000f\f\u000f\u00cc\u0001" +
                    "\u000f\u0001\u000f\u0000\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003" +
                    "\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015" +
                    "\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001\u0000" +
                    "\u0019\u0002\u0000FFff\u0002\u0000LLll\u0002\u0000IIii\u0002\u0000PPp" +
                    "p\u0002\u0000CCcc\u0002\u0000OOoo\u0002\u0000NNnn\u0002\u0000SSss\u0002" +
                    "\u0000HHhh\u0002\u0000EEee\u0002\u0000AAaa\u0002\u0000DDdd\u0002\u0000" +
                    "KKkk\u0002\u0000\u00c9\u00c9\u00e9\u00e9\u0002\u0000MMmm\u0002\u0000Y" +
                    "Yyy\u0002\u0000UUuu\u0002\u0000VVvv\u0002\u0000TTtt\u0002\u0000GGgg\u0002" +
                    "\u0000BBbb\u0002\u0000RRrr\u0002\u0000WWww\u0003\u000009AAaa\u0004\u0000" +
                    "\t\n\r\r  ..\u00d1\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001" +
                    "\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001" +
                    "\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000" +
                    "\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000" +
                    "\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000" +
                    "\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000" +
                    "\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000" +
                    "\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000" +
                    "\u0000\u0001!\u0001\u0000\u0000\u0000\u0003&\u0001\u0000\u0000\u0000\u0005" +
                    "+\u0001\u0000\u0000\u0000\u00071\u0001\u0000\u0000\u0000\t4\u0001\u0000" +
                    "\u0000\u0000\u000b:\u0001\u0000\u0000\u0000\rT\u0001\u0000\u0000\u0000" +
                    "\u000fe\u0001\u0000\u0000\u0000\u0011\u0081\u0001\u0000\u0000\u0000\u0013" +
                    "\u008e\u0001\u0000\u0000\u0000\u0015\u00a4\u0001\u0000\u0000\u0000\u0017" +
                    "\u00ab\u0001\u0000\u0000\u0000\u0019\u00b1\u0001\u0000\u0000\u0000\u001b" +
                    "\u00ba\u0001\u0000\u0000\u0000\u001d\u00c5\u0001\u0000\u0000\u0000\u001f" +
                    "\u00ca\u0001\u0000\u0000\u0000!\"\u0007\u0000\u0000\u0000\"#\u0007\u0001" +
                    "\u0000\u0000#$\u0007\u0002\u0000\u0000$%\u0007\u0003\u0000\u0000%\u0002" +
                    "\u0001\u0000\u0000\u0000&\'\u0007\u0004\u0000\u0000\'(\u0007\u0005\u0000" +
                    "\u0000()\u0007\u0002\u0000\u0000)*\u0007\u0006\u0000\u0000*\u0004\u0001" +
                    "\u0000\u0000\u0000+,\u0007\u0004\u0000\u0000,-\u0007\u0005\u0000\u0000" +
                    "-.\u0007\u0002\u0000\u0000./\u0007\u0006\u0000\u0000/0\u0007\u0007\u0000" +
                    "\u00000\u0006\u0001\u0000\u0000\u000012\u0007\u0002\u0000\u000023\u0007" +
                    "\u0000\u0000\u00003\b\u0001\u0000\u0000\u000045\u0007\b\u0000\u000056" +
                    "\u0007\t\u0000\u000067\u0007\n\u0000\u000078\u0007\u000b\u0000\u00008" +
                    "9\u0007\u0007\u0000\u00009\n\u0001\u0000\u0000\u0000:;\u0007\u0003\u0000" +
                    "\u0000;<\u0007\u0005\u0000\u0000<=\u0007\f\u0000\u0000=>\u0007\r\u0000" +
                    "\u0000>?\u0007\u000e\u0000\u0000?@\u0007\u0005\u0000\u0000@A\u0007\u0006" +
                    "\u0000\u0000AB\u0005 \u0000\u0000BC\u0007\u000f\u0000\u0000CD\u0007\u0005" +
                    "\u0000\u0000DE\u0007\u0010\u0000\u0000EF\u0005 \u0000\u0000FG\u0007\b" +
                    "\u0000\u0000GH\u0007\n\u0000\u0000HI\u0007\u0011\u0000\u0000IJ\u0007\t" +
                    "\u0000\u0000JK\u0005 \u0000\u0000KL\u0007\u0002\u0000\u0000LM\u0007\u0006" +
                    "\u0000\u0000MN\u0005 \u0000\u0000NO\u0007\u0003\u0000\u0000OP\u0007\u0001" +
                    "\u0000\u0000PQ\u0007\n\u0000\u0000QR\u0007\u000f\u0000\u0000RS\u0005." +
                    "\u0000\u0000S\f\u0001\u0000\u0000\u0000TU\u0007\u0012\u0000\u0000UV\u0007" +
                    "\b\u0000\u0000VW\u0007\u0002\u0000\u0000WX\u0007\u0007\u0000\u0000XY\u0005" +
                    " \u0000\u0000YZ\u0007\n\u0000\u0000Z[\u0007\u0012\u0000\u0000[\\\u0007" +
                    "\u0012\u0000\u0000\\]\u0007\n\u0000\u0000]^\u0007\u0004\u0000\u0000^_" +
                    "\u0007\f\u0000\u0000_`\u0005 \u0000\u0000`a\u0007\u000b\u0000\u0000ab" +
                    "\u0007\u0005\u0000\u0000bc\u0007\t\u0000\u0000cd\u0007\u0007\u0000\u0000" +
                    "d\u000e\u0001\u0000\u0000\u0000ef\u0005 \u0000\u0000fg\u0007\u000b\u0000" +
                    "\u0000gh\u0007\n\u0000\u0000hi\u0007\u000e\u0000\u0000ij\u0007\n\u0000" +
                    "\u0000jk\u0007\u0013\u0000\u0000kl\u0007\t\u0000\u0000lm\u0005 \u0000" +
                    "\u0000mn\u0007\u0012\u0000\u0000no\u0007\u0002\u0000\u0000op\u0007\u000e" +
                    "\u0000\u0000pq\u0007\t\u0000\u0000qr\u0007\u0007\u0000\u0000rs\u0005 " +
                    "\u0000\u0000st\u0007\u0012\u0000\u0000tu\u0007\b\u0000\u0000uv\u0007\t" +
                    "\u0000\u0000vw\u0005 \u0000\u0000wx\u0007\u0006\u0000\u0000xy\u0007\u0010" +
                    "\u0000\u0000yz\u0007\u000e\u0000\u0000z{\u0007\u0014\u0000\u0000{|\u0007" +
                    "\t\u0000\u0000|}\u0007\u0015\u0000\u0000}~\u0005 \u0000\u0000~\u007f\u0007" +
                    "\u0005\u0000\u0000\u007f\u0080\u0007\u0000\u0000\u0000\u0080\u0010\u0001" +
                    "\u0000\u0000\u0000\u0081\u0082\u0007\u0012\u0000\u0000\u0082\u0083\u0007" +
                    "\b\u0000\u0000\u0083\u0084\u0007\u0002\u0000\u0000\u0084\u0085\u0007\u0007" +
                    "\u0000\u0000\u0085\u0086\u0005 \u0000\u0000\u0086\u0087\u0007\u0003\u0000" +
                    "\u0000\u0087\u0088\u0007\u0005\u0000\u0000\u0088\u0089\u0007\f\u0000\u0000" +
                    "\u0089\u008a\u0007\t\u0000\u0000\u008a\u008b\u0007\u000e\u0000\u0000\u008b" +
                    "\u008c\u0007\u0005\u0000\u0000\u008c\u008d\u0007\u0006\u0000\u0000\u008d" +
                    "\u0012\u0001\u0000\u0000\u0000\u008e\u008f\u0007\u0012\u0000\u0000\u008f" +
                    "\u0090\u0007\b\u0000\u0000\u0090\u0091\u0007\t\u0000\u0000\u0091\u0092" +
                    "\u0005 \u0000\u0000\u0092\u0093\u0007\u000b\u0000\u0000\u0093\u0094\u0007" +
                    "\t\u0000\u0000\u0094\u0095\u0007\u0000\u0000\u0000\u0095\u0096\u0007\t" +
                    "\u0000\u0000\u0096\u0097\u0007\u0006\u0000\u0000\u0097\u0098\u0007\u000b" +
                    "\u0000\u0000\u0098\u0099\u0007\u0002\u0000\u0000\u0099\u009a\u0007\u0006" +
                    "\u0000\u0000\u009a\u009b\u0007\u0013\u0000\u0000\u009b\u009c\u0005 \u0000" +
                    "\u0000\u009c\u009d\u0007\u0003\u0000\u0000\u009d\u009e\u0007\u0005\u0000" +
                    "\u0000\u009e\u009f\u0007\f\u0000\u0000\u009f\u00a0\u0007\r\u0000\u0000" +
                    "\u00a0\u00a1\u0007\u000e\u0000\u0000\u00a1\u00a2\u0007\u0005\u0000\u0000" +
                    "\u00a2\u00a3\u0007\u0006\u0000\u0000\u00a3\u0014\u0001\u0000\u0000\u0000" +
                    "\u00a4\u00a5\u0007\u0002\u0000\u0000\u00a5\u00a6\u0007\u0007\u0000\u0000" +
                    "\u00a6\u00a7\u0005 \u0000\u0000\u00a7\u00a8\u0007\u0006\u0000\u0000\u00a8" +
                    "\u00a9\u0007\u0005\u0000\u0000\u00a9\u00aa\u0007\u0016\u0000\u0000\u00aa" +
                    "\u0016\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007\u0007\u0000\u0000\u00ac" +
                    "\u00ad\u0007\u0001\u0000\u0000\u00ad\u00ae\u0007\t\u0000\u0000\u00ae\u00af" +
                    "\u0007\t\u0000\u0000\u00af\u00b0\u0007\u0003\u0000\u0000\u00b0\u0018\u0001" +
                    "\u0000\u0000\u0000\u00b1\u00b2\u0007\u0004\u0000\u0000\u00b2\u00b3\u0007" +
                    "\u0005\u0000\u0000\u00b3\u00b4\u0007\u0006\u0000\u0000\u00b4\u00b5\u0007" +
                    "\u0000\u0000\u0000\u00b5\u00b6\u0007\u0010\u0000\u0000\u00b6\u00b7\u0007" +
                    "\u0007\u0000\u0000\u00b7\u00b8\u0007\t\u0000\u0000\u00b8\u00b9\u0007\u000b" +
                    "\u0000\u0000\u00b9\u001a\u0001\u0000\u0000\u0000\u00ba\u00bb\u0007\u0003" +
                    "\u0000\u0000\u00bb\u00bc\u0007\n\u0000\u0000\u00bc\u00bd\u0007\u0015\u0000" +
                    "\u0000\u00bd\u00be\u0007\n\u0000\u0000\u00be\u00bf\u0007\u0001\u0000\u0000" +
                    "\u00bf\u00c0\u0007\u000f\u0000\u0000\u00c0\u00c1\u0007\u0007\u0000\u0000" +
                    "\u00c1\u00c2\u0007\t\u0000\u0000\u00c2\u00c3\u0007\u000b\u0000\u0000\u00c3" +
                    "\u001c\u0001\u0000\u0000\u0000\u00c4\u00c6\u0007\u0017\u0000\u0000\u00c5" +
                    "\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7" +
                    "\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8" +
                    "\u001e\u0001\u0000\u0000\u0000\u00c9\u00cb\u0007\u0018\u0000\u0000\u00ca" +
                    "\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc" +
                    "\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd" +
                    "\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0006\u000f\u0000\u0000\u00cf" +
                    " \u0001\u0000\u0000\u0000\u0003\u0000\u00c7\u00cc\u0001\u0006\u0000\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}