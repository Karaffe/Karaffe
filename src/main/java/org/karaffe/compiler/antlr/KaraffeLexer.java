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
		IntLiteral=1, BoolLiteral=2, Abstract=3, Alias=4, Assert=5, Break=6, Class=7, 
		Def=8, Defer=9, Do=10, Docs=11, Else=12, Ensure=13, False=14, Final=15, 
		For=16, Func=17, If=18, Import=19, Init=20, Interface=21, Invariant=22, 
		Main=23, Match=24, Mixin=25, Nameof=26, Nil=27, Null=28, Package=29, Private=30, 
		Protected=31, Public=32, Require=33, Return=34, Self=35, Static=36, Super=37, 
		Then=38, This=39, Throw=40, Trait=41, True=42, Type=43, When=44, While=45, 
		WhiteSpace=46, Semi=47, TypeNameId=48, VarNameId=49, ConstantNameId=50;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IntLiteral", "BoolLiteral", "Abstract", "Alias", "Assert", "Break", "Class", 
		"Def", "Defer", "Do", "Docs", "Else", "Ensure", "False", "Final", "For", 
		"Func", "If", "Import", "Init", "Interface", "Invariant", "Main", "Match", 
		"Mixin", "Nameof", "Nil", "Null", "Package", "Private", "Protected", "Public", 
		"Require", "Return", "Self", "Static", "Super", "Then", "This", "Throw", 
		"Trait", "True", "Type", "When", "While", "WhiteSpace", "Semi", "TypeNameId", 
		"VarNameId", "ConstantNameId", "Digit", "NonZeroDigit", "UpperOrUnderScore", 
		"Letter", "Lower", "Upper"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'abstract'", "'alias'", "'assert'", "'break'", "'class'", 
		"'def'", "'defer'", "'do'", "'docs'", "'else'", "'ensure'", "'false'", 
		"'final'", "'for'", "'func'", "'if'", "'import'", "'init'", "'interface'", 
		"'invariant'", "'main'", "'match'", "'mixin'", "'nameof'", "'nil'", "'null'", 
		"'package'", "'private'", "'protected'", "'public'", "'require'", "'return'", 
		"'self'", "'static'", "'super'", "'then'", "'this'", "'throw'", "'trait'", 
		"'true'", "'type'", "'when'", "'while'", null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IntLiteral", "BoolLiteral", "Abstract", "Alias", "Assert", "Break", 
		"Class", "Def", "Defer", "Do", "Docs", "Else", "Ensure", "False", "Final", 
		"For", "Func", "If", "Import", "Init", "Interface", "Invariant", "Main", 
		"Match", "Mixin", "Nameof", "Nil", "Null", "Package", "Private", "Protected", 
		"Public", "Require", "Return", "Self", "Static", "Super", "Then", "This", 
		"Throw", "Trait", "True", "Type", "When", "While", "WhiteSpace", "Semi", 
		"TypeNameId", "VarNameId", "ConstantNameId"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\64\u01bb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\2\7\2x\n"+
		"\2\f\2\16\2{\13\2\5\2}\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0088"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$"+
		"\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3"+
		",\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\61\3"+
		"\61\7\61\u0198\n\61\f\61\16\61\u019b\13\61\3\62\3\62\7\62\u019f\n\62\f"+
		"\62\16\62\u01a2\13\62\3\63\3\63\6\63\u01a6\n\63\r\63\16\63\u01a7\3\64"+
		"\3\64\5\64\u01ac\n\64\3\65\3\65\3\66\3\66\5\66\u01b2\n\66\3\67\3\67\5"+
		"\67\u01b6\n\67\38\38\39\39\2\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\2i\2k\2m\2o\2q\2\3\2\3\5\2\13\f\17\17\"\"\u01be\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\3|\3\2\2\2\5\u0087\3\2\2\2\7\u0089\3\2\2\2\t"+
		"\u0092\3\2\2\2\13\u0098\3\2\2\2\r\u009f\3\2\2\2\17\u00a5\3\2\2\2\21\u00ab"+
		"\3\2\2\2\23\u00af\3\2\2\2\25\u00b5\3\2\2\2\27\u00b8\3\2\2\2\31\u00bd\3"+
		"\2\2\2\33\u00c2\3\2\2\2\35\u00c9\3\2\2\2\37\u00cf\3\2\2\2!\u00d5\3\2\2"+
		"\2#\u00d9\3\2\2\2%\u00de\3\2\2\2\'\u00e1\3\2\2\2)\u00e8\3\2\2\2+\u00ed"+
		"\3\2\2\2-\u00f7\3\2\2\2/\u0101\3\2\2\2\61\u0106\3\2\2\2\63\u010c\3\2\2"+
		"\2\65\u0112\3\2\2\2\67\u0119\3\2\2\29\u011d\3\2\2\2;\u0122\3\2\2\2=\u012a"+
		"\3\2\2\2?\u0132\3\2\2\2A\u013c\3\2\2\2C\u0143\3\2\2\2E\u014b\3\2\2\2G"+
		"\u0152\3\2\2\2I\u0157\3\2\2\2K\u015e\3\2\2\2M\u0164\3\2\2\2O\u0169\3\2"+
		"\2\2Q\u016e\3\2\2\2S\u0174\3\2\2\2U\u017a\3\2\2\2W\u017f\3\2\2\2Y\u0184"+
		"\3\2\2\2[\u0189\3\2\2\2]\u018f\3\2\2\2_\u0193\3\2\2\2a\u0195\3\2\2\2c"+
		"\u019c\3\2\2\2e\u01a3\3\2\2\2g\u01ab\3\2\2\2i\u01ad\3\2\2\2k\u01b1\3\2"+
		"\2\2m\u01b5\3\2\2\2o\u01b7\3\2\2\2q\u01b9\3\2\2\2s}\5i\65\2t}\7\62\2\2"+
		"uy\5i\65\2vx\5g\64\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z}\3\2\2\2"+
		"{y\3\2\2\2|s\3\2\2\2|t\3\2\2\2|u\3\2\2\2}\4\3\2\2\2~\177\7v\2\2\177\u0080"+
		"\7t\2\2\u0080\u0081\7w\2\2\u0081\u0088\7g\2\2\u0082\u0083\7h\2\2\u0083"+
		"\u0084\7c\2\2\u0084\u0085\7n\2\2\u0085\u0086\7u\2\2\u0086\u0088\7g\2\2"+
		"\u0087~\3\2\2\2\u0087\u0082\3\2\2\2\u0088\6\3\2\2\2\u0089\u008a\7c\2\2"+
		"\u008a\u008b\7d\2\2\u008b\u008c\7u\2\2\u008c\u008d\7v\2\2\u008d\u008e"+
		"\7t\2\2\u008e\u008f\7c\2\2\u008f\u0090\7e\2\2\u0090\u0091\7v\2\2\u0091"+
		"\b\3\2\2\2\u0092\u0093\7c\2\2\u0093\u0094\7n\2\2\u0094\u0095\7k\2\2\u0095"+
		"\u0096\7c\2\2\u0096\u0097\7u\2\2\u0097\n\3\2\2\2\u0098\u0099\7c\2\2\u0099"+
		"\u009a\7u\2\2\u009a\u009b\7u\2\2\u009b\u009c\7g\2\2\u009c\u009d\7t\2\2"+
		"\u009d\u009e\7v\2\2\u009e\f\3\2\2\2\u009f\u00a0\7d\2\2\u00a0\u00a1\7t"+
		"\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a4\7m\2\2\u00a4\16"+
		"\3\2\2\2\u00a5\u00a6\7e\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7c\2\2\u00a8"+
		"\u00a9\7u\2\2\u00a9\u00aa\7u\2\2\u00aa\20\3\2\2\2\u00ab\u00ac\7f\2\2\u00ac"+
		"\u00ad\7g\2\2\u00ad\u00ae\7h\2\2\u00ae\22\3\2\2\2\u00af\u00b0\7f\2\2\u00b0"+
		"\u00b1\7g\2\2\u00b1\u00b2\7h\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7t\2\2"+
		"\u00b4\24\3\2\2\2\u00b5\u00b6\7f\2\2\u00b6\u00b7\7q\2\2\u00b7\26\3\2\2"+
		"\2\u00b8\u00b9\7f\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7e\2\2\u00bb\u00bc"+
		"\7u\2\2\u00bc\30\3\2\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0"+
		"\7u\2\2\u00c0\u00c1\7g\2\2\u00c1\32\3\2\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4"+
		"\7p\2\2\u00c4\u00c5\7u\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7t\2\2\u00c7"+
		"\u00c8\7g\2\2\u00c8\34\3\2\2\2\u00c9\u00ca\7h\2\2\u00ca\u00cb\7c\2\2\u00cb"+
		"\u00cc\7n\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7g\2\2\u00ce\36\3\2\2\2\u00cf"+
		"\u00d0\7h\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7c\2\2"+
		"\u00d3\u00d4\7n\2\2\u00d4 \3\2\2\2\u00d5\u00d6\7h\2\2\u00d6\u00d7\7q\2"+
		"\2\u00d7\u00d8\7t\2\2\u00d8\"\3\2\2\2\u00d9\u00da\7h\2\2\u00da\u00db\7"+
		"w\2\2\u00db\u00dc\7p\2\2\u00dc\u00dd\7e\2\2\u00dd$\3\2\2\2\u00de\u00df"+
		"\7k\2\2\u00df\u00e0\7h\2\2\u00e0&\3\2\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3"+
		"\7o\2\2\u00e3\u00e4\7r\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7t\2\2\u00e6"+
		"\u00e7\7v\2\2\u00e7(\3\2\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea\7p\2\2\u00ea"+
		"\u00eb\7k\2\2\u00eb\u00ec\7v\2\2\u00ec*\3\2\2\2\u00ed\u00ee\7k\2\2\u00ee"+
		"\u00ef\7p\2\2\u00ef\u00f0\7v\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2\7t\2\2"+
		"\u00f2\u00f3\7h\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7e\2\2\u00f5\u00f6"+
		"\7g\2\2\u00f6,\3\2\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa"+
		"\7x\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7t\2\2\u00fc\u00fd\7k\2\2\u00fd"+
		"\u00fe\7c\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7v\2\2\u0100.\3\2\2\2\u0101"+
		"\u0102\7o\2\2\u0102\u0103\7c\2\2\u0103\u0104\7k\2\2\u0104\u0105\7p\2\2"+
		"\u0105\60\3\2\2\2\u0106\u0107\7o\2\2\u0107\u0108\7c\2\2\u0108\u0109\7"+
		"v\2\2\u0109\u010a\7e\2\2\u010a\u010b\7j\2\2\u010b\62\3\2\2\2\u010c\u010d"+
		"\7o\2\2\u010d\u010e\7k\2\2\u010e\u010f\7z\2\2\u010f\u0110\7k\2\2\u0110"+
		"\u0111\7p\2\2\u0111\64\3\2\2\2\u0112\u0113\7p\2\2\u0113\u0114\7c\2\2\u0114"+
		"\u0115\7o\2\2\u0115\u0116\7g\2\2\u0116\u0117\7q\2\2\u0117\u0118\7h\2\2"+
		"\u0118\66\3\2\2\2\u0119\u011a\7p\2\2\u011a\u011b\7k\2\2\u011b\u011c\7"+
		"n\2\2\u011c8\3\2\2\2\u011d\u011e\7p\2\2\u011e\u011f\7w\2\2\u011f\u0120"+
		"\7n\2\2\u0120\u0121\7n\2\2\u0121:\3\2\2\2\u0122\u0123\7r\2\2\u0123\u0124"+
		"\7c\2\2\u0124\u0125\7e\2\2\u0125\u0126\7m\2\2\u0126\u0127\7c\2\2\u0127"+
		"\u0128\7i\2\2\u0128\u0129\7g\2\2\u0129<\3\2\2\2\u012a\u012b\7r\2\2\u012b"+
		"\u012c\7t\2\2\u012c\u012d\7k\2\2\u012d\u012e\7x\2\2\u012e\u012f\7c\2\2"+
		"\u012f\u0130\7v\2\2\u0130\u0131\7g\2\2\u0131>\3\2\2\2\u0132\u0133\7r\2"+
		"\2\u0133\u0134\7t\2\2\u0134\u0135\7q\2\2\u0135\u0136\7v\2\2\u0136\u0137"+
		"\7g\2\2\u0137\u0138\7e\2\2\u0138\u0139\7v\2\2\u0139\u013a\7g\2\2\u013a"+
		"\u013b\7f\2\2\u013b@\3\2\2\2\u013c\u013d\7r\2\2\u013d\u013e\7w\2\2\u013e"+
		"\u013f\7d\2\2\u013f\u0140\7n\2\2\u0140\u0141\7k\2\2\u0141\u0142\7e\2\2"+
		"\u0142B\3\2\2\2\u0143\u0144\7t\2\2\u0144\u0145\7g\2\2\u0145\u0146\7s\2"+
		"\2\u0146\u0147\7w\2\2\u0147\u0148\7k\2\2\u0148\u0149\7t\2\2\u0149\u014a"+
		"\7g\2\2\u014aD\3\2\2\2\u014b\u014c\7t\2\2\u014c\u014d\7g\2\2\u014d\u014e"+
		"\7v\2\2\u014e\u014f\7w\2\2\u014f\u0150\7t\2\2\u0150\u0151\7p\2\2\u0151"+
		"F\3\2\2\2\u0152\u0153\7u\2\2\u0153\u0154\7g\2\2\u0154\u0155\7n\2\2\u0155"+
		"\u0156\7h\2\2\u0156H\3\2\2\2\u0157\u0158\7u\2\2\u0158\u0159\7v\2\2\u0159"+
		"\u015a\7c\2\2\u015a\u015b\7v\2\2\u015b\u015c\7k\2\2\u015c\u015d\7e\2\2"+
		"\u015dJ\3\2\2\2\u015e\u015f\7u\2\2\u015f\u0160\7w\2\2\u0160\u0161\7r\2"+
		"\2\u0161\u0162\7g\2\2\u0162\u0163\7t\2\2\u0163L\3\2\2\2\u0164\u0165\7"+
		"v\2\2\u0165\u0166\7j\2\2\u0166\u0167\7g\2\2\u0167\u0168\7p\2\2\u0168N"+
		"\3\2\2\2\u0169\u016a\7v\2\2\u016a\u016b\7j\2\2\u016b\u016c\7k\2\2\u016c"+
		"\u016d\7u\2\2\u016dP\3\2\2\2\u016e\u016f\7v\2\2\u016f\u0170\7j\2\2\u0170"+
		"\u0171\7t\2\2\u0171\u0172\7q\2\2\u0172\u0173\7y\2\2\u0173R\3\2\2\2\u0174"+
		"\u0175\7v\2\2\u0175\u0176\7t\2\2\u0176\u0177\7c\2\2\u0177\u0178\7k\2\2"+
		"\u0178\u0179\7v\2\2\u0179T\3\2\2\2\u017a\u017b\7v\2\2\u017b\u017c\7t\2"+
		"\2\u017c\u017d\7w\2\2\u017d\u017e\7g\2\2\u017eV\3\2\2\2\u017f\u0180\7"+
		"v\2\2\u0180\u0181\7{\2\2\u0181\u0182\7r\2\2\u0182\u0183\7g\2\2\u0183X"+
		"\3\2\2\2\u0184\u0185\7y\2\2\u0185\u0186\7j\2\2\u0186\u0187\7g\2\2\u0187"+
		"\u0188\7p\2\2\u0188Z\3\2\2\2\u0189\u018a\7y\2\2\u018a\u018b\7j\2\2\u018b"+
		"\u018c\7k\2\2\u018c\u018d\7n\2\2\u018d\u018e\7g\2\2\u018e\\\3\2\2\2\u018f"+
		"\u0190\t\2\2\2\u0190\u0191\3\2\2\2\u0191\u0192\b/\2\2\u0192^\3\2\2\2\u0193"+
		"\u0194\7=\2\2\u0194`\3\2\2\2\u0195\u0199\5q9\2\u0196\u0198\5m\67\2\u0197"+
		"\u0196\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2"+
		"\2\2\u019ab\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u01a0\5o8\2\u019d\u019f"+
		"\5m\67\2\u019e\u019d\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1d\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a5\5q9\2\u01a4"+
		"\u01a6\5k\66\2\u01a5\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a5\3\2"+
		"\2\2\u01a7\u01a8\3\2\2\2\u01a8f\3\2\2\2\u01a9\u01ac\7\62\2\2\u01aa\u01ac"+
		"\5i\65\2\u01ab\u01a9\3\2\2\2\u01ab\u01aa\3\2\2\2\u01ach\3\2\2\2\u01ad"+
		"\u01ae\4\63;\2\u01aej\3\2\2\2\u01af\u01b2\5q9\2\u01b0\u01b2\7a\2\2\u01b1"+
		"\u01af\3\2\2\2\u01b1\u01b0\3\2\2\2\u01b2l\3\2\2\2\u01b3\u01b6\5o8\2\u01b4"+
		"\u01b6\5q9\2\u01b5\u01b3\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6n\3\2\2\2\u01b7"+
		"\u01b8\4c|\2\u01b8p\3\2\2\2\u01b9\u01ba\4C\\\2\u01bar\3\2\2\2\f\2y|\u0087"+
		"\u0199\u01a0\u01a7\u01ab\u01b1\u01b5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}