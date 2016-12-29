// Generated from Karaffe.g4 by ANTLR 4.5.3
package org.karaffe.compiler.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KaraffeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, LBRACE=12, RBRACE=13, Identifier=14, SP=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "LBRACE", "RBRACE", "Identifier", "IdentifierHead", "IdentifierBody", 
		"SP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'package'", "'.'", "'class'", "'public'", "'open'", "'private'", 
		"'abstract'", "':'", "','", "'def'", "'='", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"LBRACE", "RBRACE", "Identifier", "SP"
	};
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


	public KaraffeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Karaffe.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21r\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\7\17c\n\17\f\17\16\17f\13\17"+
		"\3\20\3\20\3\21\3\21\3\22\6\22m\n\22\r\22\16\22n\3\22\3\22\2\2\23\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\2"+
		"!\2#\21\3\2\5\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"q\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5-\3\2\2\2\7/\3\2\2"+
		"\2\t\65\3\2\2\2\13<\3\2\2\2\rA\3\2\2\2\17I\3\2\2\2\21R\3\2\2\2\23T\3\2"+
		"\2\2\25V\3\2\2\2\27Z\3\2\2\2\31\\\3\2\2\2\33^\3\2\2\2\35`\3\2\2\2\37g"+
		"\3\2\2\2!i\3\2\2\2#l\3\2\2\2%&\7r\2\2&\'\7c\2\2\'(\7e\2\2()\7m\2\2)*\7"+
		"c\2\2*+\7i\2\2+,\7g\2\2,\4\3\2\2\2-.\7\60\2\2.\6\3\2\2\2/\60\7e\2\2\60"+
		"\61\7n\2\2\61\62\7c\2\2\62\63\7u\2\2\63\64\7u\2\2\64\b\3\2\2\2\65\66\7"+
		"r\2\2\66\67\7w\2\2\678\7d\2\289\7n\2\29:\7k\2\2:;\7e\2\2;\n\3\2\2\2<="+
		"\7q\2\2=>\7r\2\2>?\7g\2\2?@\7p\2\2@\f\3\2\2\2AB\7r\2\2BC\7t\2\2CD\7k\2"+
		"\2DE\7x\2\2EF\7c\2\2FG\7v\2\2GH\7g\2\2H\16\3\2\2\2IJ\7c\2\2JK\7d\2\2K"+
		"L\7u\2\2LM\7v\2\2MN\7t\2\2NO\7c\2\2OP\7e\2\2PQ\7v\2\2Q\20\3\2\2\2RS\7"+
		"<\2\2S\22\3\2\2\2TU\7.\2\2U\24\3\2\2\2VW\7f\2\2WX\7g\2\2XY\7h\2\2Y\26"+
		"\3\2\2\2Z[\7?\2\2[\30\3\2\2\2\\]\7}\2\2]\32\3\2\2\2^_\7\177\2\2_\34\3"+
		"\2\2\2`d\5\37\20\2ac\5!\21\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e"+
		"\36\3\2\2\2fd\3\2\2\2gh\t\2\2\2h \3\2\2\2ij\t\3\2\2j\"\3\2\2\2km\t\4\2"+
		"\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\b\22\2\2q$\3\2"+
		"\2\2\5\2dn\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}