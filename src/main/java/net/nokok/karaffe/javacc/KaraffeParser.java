/* KaraffeParser.java */
/* Generated By:JavaCC: Do not edit this line. KaraffeParser.java */
package net.nokok.karaffe.javacc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.nokok.karaffe.javacc.expr.*;
import net.nokok.karaffe.javacc.identifier.TypeId;
import net.nokok.karaffe.javacc.identifier.VariableId;
import net.nokok.karaffe.javacc.literal.BoolLiteral;
import net.nokok.karaffe.javacc.literal.FloatLiteral;
import net.nokok.karaffe.javacc.literal.IntLiteral;
import net.nokok.karaffe.javacc.literal.UndefinedLiteral;
import net.nokok.karaffe.javacc.modifier.*;
import net.nokok.karaffe.javacc.stmt.*;

public class KaraffeParser implements KaraffeParserConstants {

    public final Statements statements = new Statements();
    public static final List codeList = new ArrayList(); //List<String>

    public static KaraffeParser createParser(String sourceCode) {
        KaraffeParser parser = new KaraffeParser(new java.io.StringReader(sourceCode));
        codeList.clear();
        codeList.addAll(Arrays.asList(sourceCode.split("\u005cn")));
        return parser;
    }

    final public Statements start() throws ParseException {
        trace_call("start");
        try {
            Statement s;
            label_1:
            while ( true ) {
                switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                    case Type:
                    case SideEffect:
                    case GlobalScope:
                    case VariableId:
                    case NewLine: {
                        ;
                        break;
                    }
                    default:
                        jj_la1[0] = jj_gen;
                        break label_1;
                }
                s = statement();
                statements.addStatement(s);
            }
            jj_consume_token(0);
            {
                if ( "" != null ) {
                    return statements;
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("start");
        }
    }

    final public Statement statement() throws ParseException {
        trace_call("statement");
        try {
            Statement t;
            if ( jj_2_1(2) ) {
                t = typeAlias();
                jj_consume_token(NewLine);
                {
                    if ( "" != null ) {
                        return t;
                    }
                }
            } else if ( jj_2_2(2) ) {
                t = variableDeclaration();
                jj_consume_token(NewLine);
                {
                    if ( "" != null ) {
                        return t;
                    }
                }
            } else {
                switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                    case NewLine: {
                        jj_consume_token(NewLine);
                        {
                            if ( "" != null ) {
                                return new NewLineStatement();
                            }
                        }
                        break;
                    }
                    default:
                        jj_la1[1] = jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("statement");
        }
    }

    final public Expression literals() throws ParseException {
        trace_call("literals");
        try {
            Expression expr;
            switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                case Undefined: {
                    expr = undefined();
                    {
                        if ( "" != null ) {
                            return expr;
                        }
                    }
                    break;
                }
                case Bool: {
                    expr = boolLiteral();
                    {
                        if ( "" != null ) {
                            return expr;
                        }
                    }
                    break;
                }
                case IntLiteral:
                case Hexadecimal:
                case Zero: {
                    expr = intLiteral();
                    {
                        if ( "" != null ) {
                            return expr;
                        }
                    }
                    break;
                }
                case FloatLiteral: {
                    expr = floatLiteral();
                    {
                        if ( "" != null ) {
                            return expr;
                        }
                    }
                    break;
                }
                default:
                    jj_la1[2] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("literals");
        }
    }

    /**
     * TypeAliasの宣言
     */
    final public Statement typeAlias() throws ParseException {
        trace_call("typeAlias");
        try {
            Set modifiers;
            TypeId newType;
            TypeId existingTypeName = net.nokok.karaffe.javacc.identifier.TypeId.Any;
            modifiers = modifiers();
            jj_consume_token(Type);
            newType = typeId();
            switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                case Assign: {
                    jj_consume_token(Assign);
                    existingTypeName = typeId();
                    break;
                }
                default:
                    jj_la1[3] = jj_gen;
                    ;
            }
            {
                if ( "" != null ) {
                    return new TypeAliasStatement(modifiers, existingTypeName, newType);
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("typeAlias");
        }
    }

    final public Expression expr() throws ParseException {
        trace_call("expr");
        try {
            Expression body;
            body = literals();
            {
                if ( "" != null ) {
                    return body;
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("expr");
        }
    }

    final public Set modifiers() throws ParseException {
        trace_call("modifiers");
        try {
            Set modifiers = new HashSet(); //Set<Modifier>
            Modifier modifier;
            label_2:
            while ( true ) {
                switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                    case SideEffect:
                    case GlobalScope: {
                        ;
                        break;
                    }
                    default:
                        jj_la1[4] = jj_gen;
                        break label_2;
                }
                modifier = modifier();
                modifiers.add(modifier);
            }
            {
                if ( "" != null ) {
                    return modifiers;
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("modifiers");
        }
    }

    final public Modifier modifier() throws ParseException {
        trace_call("modifier");
        try {
            switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                case SideEffect: {
                    jj_consume_token(SideEffect);
                    {
                        if ( "" != null ) {
                            return Modifier.SEFFECT;
                        }
                    }
                    break;
                }
                case GlobalScope: {
                    jj_consume_token(GlobalScope);
                    {
                        if ( "" != null ) {
                            return Modifier.GLOBAL;
                        }
                    }
                    break;
                }
                default:
                    jj_la1[5] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("modifier");
        }
    }

    final public TypeId typeId() throws ParseException {
        trace_call("typeId");
        try {
            Token token;
            token = jj_consume_token(TypeId);
            {
                if ( "" != null ) {
                    return new TypeId(token.image);
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("typeId");
        }
    }

    final public VariableId variableId() throws ParseException {
        trace_call("variableId");
        try {
            Token token;
            token = jj_consume_token(VariableId);
            {
                if ( "" != null ) {
                    return new VariableId(token.image);
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("variableId");
        }
    }

    final public Expression undefined() throws ParseException {
        trace_call("undefined");
        try {
            jj_consume_token(Undefined);
            {
                if ( "" != null ) {
                    return new UndefinedLiteral();
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("undefined");
        }
    }

    final public Expression boolLiteral() throws ParseException {
        trace_call("boolLiteral");
        try {
            Expression expr;
            Token token;
            token = jj_consume_token(Bool);
            {
                if ( "" != null ) {
                    return new BoolLiteral(token.image);
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("boolLiteral");
        }
    }

    final public Expression intLiteral() throws ParseException {
        trace_call("intLiteral");
        try {
            Token t;
            switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                case IntLiteral: {
                    t = jj_consume_token(IntLiteral);
                    {
                        if ( "" != null ) {
                            return new IntLiteral(t.image);
                        }
                    }
                    break;
                }
                case Zero: {
                    t = jj_consume_token(Zero);
                    {
                        if ( "" != null ) {
                            return new IntLiteral(0);
                        }
                    }
                    break;
                }
                case Hexadecimal: {
                    t = jj_consume_token(Hexadecimal);
                    String hexNum;
                    if ( t.image.startsWith("-") ) {
                        hexNum = t.image.substring(3, t.image.length());
                    } else {
                        hexNum = t.image.substring(2, t.image.length());
                    }
                    {
                        if ( "" != null ) {
                            return new IntLiteral(hexNum, 16);
                        }
                    }
                    break;
                }
                default:
                    jj_la1[6] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("intLiteral");
        }
    }

    final public Expression floatLiteral() throws ParseException {
        trace_call("floatLiteral");
        try {
            Token t;
            t = jj_consume_token(FloatLiteral);
            {
                if ( "" != null ) {
                    return new FloatLiteral(t.image);
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("floatLiteral");
        }
    }

    final public Statement variableDeclaration() throws ParseException {
        trace_call("variableDeclaration");
        try {
            Set modifiers;
            VariableId name;
            TypeId type = null;
            Expression expr;
            modifiers = modifiers();
            name = variableId();
            switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                case Colon: {
                    jj_consume_token(Colon);
                    type = typeId();
                    break;
                }
                default:
                    jj_la1[7] = jj_gen;
                    ;
            }
            jj_consume_token(Assign);
            expr = expr();
            if ( type == null ) {
                type = net.nokok.karaffe.javacc.identifier.TypeId.Inference;
            }
            {
                if ( "" != null ) {
                    return new VariableDeclaration(modifiers, name, type, expr);
                }
            }
            throw new Error("Missing return statement in function");
        } finally {
            trace_return("variableDeclaration");
        }
    }

    private boolean jj_2_1(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_1();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(0, xla);
        }
    }

    private boolean jj_2_2(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_2();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(1, xla);
        }
    }

    private boolean jj_3R_12() {
        if ( jj_scan_token(GlobalScope) ) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_11() {
        if ( jj_scan_token(SideEffect) ) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_10() {
        if ( !jj_rescan ) {
            trace_call("modifier(LOOKING AHEAD...)");
        }
        Token xsp;
        xsp = jj_scanpos;
        if ( jj_3R_11() ) {
            jj_scanpos = xsp;
            if ( jj_3R_12() ) {
                if ( !jj_rescan ) {
                    trace_return("modifier(LOOKAHEAD FAILED)");
                }
                return true;
            }
        }
        {
            if ( !jj_rescan ) {
                trace_return("modifier(LOOKAHEAD SUCCEEDED)");
            }
            return false;
        }
    }

    private boolean jj_3_2() {
        if ( jj_3R_4() ) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_3() {
        if ( !jj_rescan ) {
            trace_call("typeAlias(LOOKING AHEAD...)");
        }
        if ( jj_3R_5() ) {
            if ( !jj_rescan ) {
                trace_return("typeAlias(LOOKAHEAD FAILED)");
            }
            return true;
        }
        if ( jj_scan_token(Type) ) {
            if ( !jj_rescan ) {
                trace_return("typeAlias(LOOKAHEAD FAILED)");
            }
            return true;
        }
        if ( jj_3R_6() ) {
            if ( !jj_rescan ) {
                trace_return("typeAlias(LOOKAHEAD FAILED)");
            }
            return true;
        }
        {
            if ( !jj_rescan ) {
                trace_return("typeAlias(LOOKAHEAD SUCCEEDED)");
            }
            return false;
        }
    }

    private boolean jj_3R_7() {
        if ( !jj_rescan ) {
            trace_call("variableId(LOOKING AHEAD...)");
        }
        if ( jj_scan_token(VariableId) ) {
            if ( !jj_rescan ) {
                trace_return("variableId(LOOKAHEAD FAILED)");
            }
            return true;
        }
        {
            if ( !jj_rescan ) {
                trace_return("variableId(LOOKAHEAD SUCCEEDED)");
            }
            return false;
        }
    }

    private boolean jj_3_1() {
        if ( jj_3R_3() ) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_9() {
        if ( jj_3R_10() ) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_5() {
        if ( !jj_rescan ) {
            trace_call("modifiers(LOOKING AHEAD...)");
        }
        Token xsp;
        while ( true ) {
            xsp = jj_scanpos;
            if ( jj_3R_9() ) {
                jj_scanpos = xsp;
                break;
            }
        }
        {
            if ( !jj_rescan ) {
                trace_return("modifiers(LOOKAHEAD SUCCEEDED)");
            }
            return false;
        }
    }

    private boolean jj_3R_6() {
        if ( !jj_rescan ) {
            trace_call("typeId(LOOKING AHEAD...)");
        }
        if ( jj_scan_token(TypeId) ) {
            if ( !jj_rescan ) {
                trace_return("typeId(LOOKAHEAD FAILED)");
            }
            return true;
        }
        {
            if ( !jj_rescan ) {
                trace_return("typeId(LOOKAHEAD SUCCEEDED)");
            }
            return false;
        }
    }

    private boolean jj_3R_4() {
        if ( !jj_rescan ) {
            trace_call("variableDeclaration(LOOKING AHEAD...)");
        }
        if ( jj_3R_5() ) {
            if ( !jj_rescan ) {
                trace_return("variableDeclaration(LOOKAHEAD FAILED)");
            }
            return true;
        }
        if ( jj_3R_7() ) {
            if ( !jj_rescan ) {
                trace_return("variableDeclaration(LOOKAHEAD FAILED)");
            }
            return true;
        }
        Token xsp;
        xsp = jj_scanpos;
        if ( jj_3R_8() ) {
            jj_scanpos = xsp;
        }
        if ( jj_scan_token(Assign) ) {
            if ( !jj_rescan ) {
                trace_return("variableDeclaration(LOOKAHEAD FAILED)");
            }
            return true;
        }
        {
            if ( !jj_rescan ) {
                trace_return("variableDeclaration(LOOKAHEAD SUCCEEDED)");
            }
            return false;
        }
    }

    private boolean jj_3R_8() {
        if ( jj_scan_token(Colon) ) {
            return true;
        }
        return false;
    }

    /**
     * Generated Token Manager.
     */
    public KaraffeParserTokenManager token_source;
    SimpleCharStream jj_input_stream;
    /**
     * Current token.
     */
    public Token token;
    /**
     * Next token.
     */
    public Token jj_nt;
    private int jj_ntk;
    private Token jj_scanpos, jj_lastpos;
    private int jj_la;
    private int jj_gen;
    final private int[] jj_la1 = new int[8];
    static private int[] jj_la1_0;
    static private int[] jj_la1_1;

    static {
        jj_la1_init_0();
        jj_la1_init_1();
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{ 0x8a00, 0x0, 0x1d01000, 0x2000000, 0x8800, 0x8800, 0xc00000, 0x80000, };
    }

    private static void jj_la1_init_1() {
        jj_la1_1 = new int[]{ 0x4020, 0x4000, 0x80, 0x0, 0x0, 0x0, 0x80, 0x0, };
    }
    final private JJCalls[] jj_2_rtns = new JJCalls[2];
    private boolean jj_rescan = false;
    private int jj_gc = 0;

    /**
     * Constructor with InputStream.
     */
    public KaraffeParser(java.io.InputStream stream) {
        this(stream, null);
    }

    /**
     * Constructor with InputStream and supplied encoding
     */
    public KaraffeParser(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source = new KaraffeParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for ( int i = 0; i < 8; i++ ) {
            jj_la1[i] = -1;
        }
        for ( int i = 0; i < jj_2_rtns.length; i++ ) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.InputStream stream) {
        ReInit(stream, null);
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream.ReInit(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for ( int i = 0; i < 8; i++ ) {
            jj_la1[i] = -1;
        }
        for ( int i = 0; i < jj_2_rtns.length; i++ ) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /**
     * Constructor.
     */
    public KaraffeParser(java.io.Reader stream) {
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new KaraffeParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for ( int i = 0; i < 8; i++ ) {
            jj_la1[i] = -1;
        }
        for ( int i = 0; i < jj_2_rtns.length; i++ ) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for ( int i = 0; i < 8; i++ ) {
            jj_la1[i] = -1;
        }
        for ( int i = 0; i < jj_2_rtns.length; i++ ) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /**
     * Constructor with generated Token Manager.
     */
    public KaraffeParser(KaraffeParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for ( int i = 0; i < 8; i++ ) {
            jj_la1[i] = -1;
        }
        for ( int i = 0; i < jj_2_rtns.length; i++ ) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /**
     * Reinitialise.
     */
    public void ReInit(KaraffeParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for ( int i = 0; i < 8; i++ ) {
            jj_la1[i] = -1;
        }
        for ( int i = 0; i < jj_2_rtns.length; i++ ) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ( (oldToken = token).next != null ) {
            token = token.next;
        } else {
            token = token.next = token_source.getNextToken();
        }
        jj_ntk = -1;
        if ( token.kind == kind ) {
            jj_gen++;
            if ( ++jj_gc > 100 ) {
                jj_gc = 0;
                for ( int i = 0; i < jj_2_rtns.length; i++ ) {
                    JJCalls c = jj_2_rtns[i];
                    while ( c != null ) {
                        if ( c.gen < jj_gen ) {
                            c.first = null;
                        }
                        c = c.next;
                    }
                }
            }
            trace_token(token, "");
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }

    @SuppressWarnings("serial")
    static private final class LookaheadSuccess extends java.lang.Error {
    }
    final private LookaheadSuccess jj_ls = new LookaheadSuccess();

    private boolean jj_scan_token(int kind) {
        if ( jj_scanpos == jj_lastpos ) {
            jj_la--;
            if ( jj_scanpos.next == null ) {
                jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
            } else {
                jj_lastpos = jj_scanpos = jj_scanpos.next;
            }
        } else {
            jj_scanpos = jj_scanpos.next;
        }
        if ( jj_rescan ) {
            int i = 0;
            Token tok = token;
            while ( tok != null && tok != jj_scanpos ) {
                i++;
                tok = tok.next;
            }
            if ( tok != null ) {
                jj_add_error_token(kind, i);
            }
        } else {
            trace_scan(jj_scanpos, kind);
        }
        if ( jj_scanpos.kind != kind ) {
            return true;
        }
        if ( jj_la == 0 && jj_scanpos == jj_lastpos ) {
            throw jj_ls;
        }
        return false;
    }

    /**
     * Get the next Token.
     */
    final public Token getNextToken() {
        if ( token.next != null ) {
            token = token.next;
        } else {
            token = token.next = token_source.getNextToken();
        }
        jj_ntk = -1;
        jj_gen++;
        trace_token(token, " (in getNextToken)");
        return token;
    }

    /**
     * Get the specific Token.
     */
    final public Token getToken(int index) {
        Token t = token;
        for ( int i = 0; i < index; i++ ) {
            if ( t.next != null ) {
                t = t.next;
            } else {
                t = t.next = token_source.getNextToken();
            }
        }
        return t;
    }

    private int jj_ntk_f() {
        if ( (jj_nt = token.next) == null ) {
            return (jj_ntk = (token.next = token_source.getNextToken()).kind);
        } else {
            return (jj_ntk = jj_nt.kind);
        }
    }

    private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
    private int[] jj_expentry;
    private int jj_kind = -1;
    private int[] jj_lasttokens = new int[100];
    private int jj_endpos;

    private void jj_add_error_token(int kind, int pos) {
        if ( pos >= 100 ) {
            return;
        }
        if ( pos == jj_endpos + 1 ) {
            jj_lasttokens[jj_endpos++] = kind;
        } else if ( jj_endpos != 0 ) {
            jj_expentry = new int[jj_endpos];
            for ( int i = 0; i < jj_endpos; i++ ) {
                jj_expentry[i] = jj_lasttokens[i];
            }
            jj_entries_loop:
            for ( java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext(); ) {
                int[] oldentry = (int[]) (it.next());
                if ( oldentry.length == jj_expentry.length ) {
                    for ( int i = 0; i < jj_expentry.length; i++ ) {
                        if ( oldentry[i] != jj_expentry[i] ) {
                            continue jj_entries_loop;
                        }
                    }
                    jj_expentries.add(jj_expentry);
                    break jj_entries_loop;
                }
            }
            if ( pos != 0 ) {
                jj_lasttokens[(jj_endpos = pos) - 1] = kind;
            }
        }
    }

    /**
     * Generate ParseException.
     */
    public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[47];
        if ( jj_kind >= 0 ) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for ( int i = 0; i < 8; i++ ) {
            if ( jj_la1[i] == jj_gen ) {
                for ( int j = 0; j < 32; j++ ) {
                    if ( (jj_la1_0[i] & (1 << j)) != 0 ) {
                        la1tokens[j] = true;
                    }
                    if ( (jj_la1_1[i] & (1 << j)) != 0 ) {
                        la1tokens[32 + j] = true;
                    }
                }
            }
        }
        for ( int i = 0; i < 47; i++ ) {
            if ( la1tokens[i] ) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.add(jj_expentry);
            }
        }
        jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] exptokseq = new int[jj_expentries.size()][];
        for ( int i = 0; i < jj_expentries.size(); i++ ) {
            exptokseq[i] = jj_expentries.get(i);
        }
        return new ParseException(token, exptokseq, tokenImage);
    }

    private int trace_indent = 0;
    private boolean trace_enabled = true;

    /**
     * Enable tracing.
     */
    final public void enable_tracing() {
        trace_enabled = true;
    }

    /**
     * Disable tracing.
     */
    final public void disable_tracing() {
        trace_enabled = false;
    }

    private void trace_call(String s) {
        if ( trace_enabled ) {
            for ( int i = 0; i < trace_indent; i++ ) {
                System.out.print(" ");
            }
            System.out.println("Call:   " + s);
        }
        trace_indent = trace_indent + 2;
    }

    private void trace_return(String s) {
        trace_indent = trace_indent - 2;
        if ( trace_enabled ) {
            for ( int i = 0; i < trace_indent; i++ ) {
                System.out.print(" ");
            }
            System.out.println("Return: " + s);
        }
    }

    private void trace_token(Token t, String where) {
        if ( trace_enabled ) {
            for ( int i = 0; i < trace_indent; i++ ) {
                System.out.print(" ");
            }
            System.out.print("Consumed token: <" + tokenImage[t.kind]);
            if ( t.kind != 0 && !tokenImage[t.kind].equals("\"" + t.image + "\"") ) {
                System.out.print(": \"" + t.image + "\"");
            }
            System.out.println(" at line " + t.beginLine + " column " + t.beginColumn + ">" + where);
        }
    }

    private void trace_scan(Token t1, int t2) {
        if ( trace_enabled ) {
            for ( int i = 0; i < trace_indent; i++ ) {
                System.out.print(" ");
            }
            System.out.print("Visited token: <" + tokenImage[t1.kind]);
            if ( t1.kind != 0 && !tokenImage[t1.kind].equals("\"" + t1.image + "\"") ) {
                System.out.print(": \"" + t1.image + "\"");
            }
            System.out.println(" at line " + t1.beginLine + " column " + t1.beginColumn + ">; Expected token: <" + tokenImage[t2] + ">");
        }
    }

    private void jj_rescan_token() {
        jj_rescan = true;
        for ( int i = 0; i < 2; i++ ) {
            try {
                JJCalls p = jj_2_rtns[i];
                do {
                    if ( p.gen > jj_gen ) {
                        jj_la = p.arg;
                        jj_lastpos = jj_scanpos = p.first;
                        switch ( i ) {
                            case 0:
                                jj_3_1();
                                break;
                            case 1:
                                jj_3_2();
                                break;
                        }
                    }
                    p = p.next;
                } while ( p != null );
            } catch (LookaheadSuccess ls) {
            }
        }
        jj_rescan = false;
    }

    private void jj_save(int index, int xla) {
        JJCalls p = jj_2_rtns[index];
        while ( p.gen > jj_gen ) {
            if ( p.next == null ) {
                p = p.next = new JJCalls();
                break;
            }
            p = p.next;
        }
        p.gen = jj_gen + xla - jj_la;
        p.first = token;
        p.arg = xla;
    }

    static final class JJCalls {

        int gen;
        Token first;
        int arg;
        JJCalls next;
    }

}
