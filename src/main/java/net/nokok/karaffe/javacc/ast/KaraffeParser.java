/* KaraffeParser.java */
/* Generated By:JavaCC: Do not edit this line. KaraffeParser.java */
package net.nokok.karaffe.javacc.ast;

public class KaraffeParser implements KaraffeParserConstants {

    private final Program program = new Program();

    public KaraffeParser(String sourceCode) {
        this(new java.io.StringReader(sourceCode));
    }

    public int getCurrentTokenBeginColumn() {
        return jj_input_stream.getBeginColumn();
    }

    public int getCurrentTokenEndColumn() {
        return jj_input_stream.getEndColumn();
    }

    public int getCurrentLine() {
        return jj_input_stream.getEndLine();
    }

    final public Program parse() throws ParseException {
        Program p = new Program();
        ASTNode node;
        label_1:
        while ( true ) {
            switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                case BoolLiteral:
                case IntLiteral:
                case Hexadecimal:
                case FloatLiteral:
                case StringLiteral:
                case Identifier:
                case LeftBracket: {
                    ;
                    break;
                }
                default:
                    jj_la1[0] = jj_gen;
                    break label_1;
            }
            node = programElement();
            p.addElement(node);
        }
        jj_consume_token(0);
        p.addElement(new EndOfFileStatement());
        {
            if ( "" != null ) {
                return p;
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public ASTNode programElement() throws ParseException {
        ASTNode node;
        switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
            case BoolLiteral:
            case IntLiteral:
            case Hexadecimal:
            case FloatLiteral:
            case StringLiteral:
            case LeftBracket: {
                node = expr();
                {
                    if ( "" != null ) {
                        return node;
                    }
                }
                break;
            }
            case Identifier: {
                node = statement();
                {
                    if ( "" != null ) {
                        return node;
                    }
                }
                break;
            }
            default:
                jj_la1[1] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        throw new Error("Missing return statement in function");
    }

    final public Expression expr() throws ParseException {
        Expression e;
        e = literals();
        {
            if ( "" != null ) {
                return e;
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public Statement statement() throws ParseException {
        Statement s;
        s = variableDeclaration();
        {
            if ( "" != null ) {
                return s;
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public Expression literals() throws ParseException {
        Expression l;
        switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
            case BoolLiteral: {
                l = boolLiteral();
                {
                    if ( "" != null ) {
                        return l;
                    }
                }
                break;
            }
            case IntLiteral:
            case Hexadecimal: {
                l = intLiteral();
                {
                    if ( "" != null ) {
                        return l;
                    }
                }
                break;
            }
            case FloatLiteral: {
                l = floatLiteral();
                {
                    if ( "" != null ) {
                        return l;
                    }
                }
                break;
            }
            case StringLiteral: {
                l = stringLiteral();
                {
                    if ( "" != null ) {
                        return l;
                    }
                }
                break;
            }
            case LeftBracket: {
                l = arrayLiteral();
                {
                    if ( "" != null ) {
                        return l;
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
    }

    final public Expression boolLiteral() throws ParseException {
        Token t;
        t = jj_consume_token(BoolLiteral);
        {
            if ( "" != null ) {
                return new BoolLiteral(Boolean.parseBoolean(t.image));
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public Expression intLiteral() throws ParseException {
        Token t;
        switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
            case IntLiteral: {
                t = jj_consume_token(IntLiteral);
                {
                    if ( "" != null ) {
                        return new IntLiteral(Integer.parseInt(t.image));
                    }
                }
                break;
            }
            case Hexadecimal: {
                t = jj_consume_token(Hexadecimal);
                {
                    if ( "" != null ) {
                        return new IntLiteral(Integer.parseInt(t.image.replaceFirst("0[xX]", ""), 16));
                    }
                }
                break;
            }
            default:
                jj_la1[3] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        throw new Error("Missing return statement in function");
    }

    final public Expression floatLiteral() throws ParseException {
        Token t;
        t = jj_consume_token(FloatLiteral);
        {
            if ( "" != null ) {
                return new FloatLiteral(Double.parseDouble(t.image));
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public Expression stringLiteral() throws ParseException {
        Token t;
        t = jj_consume_token(StringLiteral);
        {
            if ( "" != null ) {
                return new StringLiteral(t.image);
            }
        }
        throw new Error("Missing return statement in function");
    }

    /**
     * ArrayLiteral
     * ArrayLiteral = "[" ArrayElements "]"
     * ArrayElements = ArrayElement*
     * ArrayElement = expr
     */
    final public Expression arrayLiteral() throws ParseException {
        ArrayElements elements = ArrayElements.EMPTY;
        jj_consume_token(LeftBracket);
        switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
            case BoolLiteral:
            case IntLiteral:
            case Hexadecimal:
            case FloatLiteral:
            case StringLiteral:
            case LeftBracket: {
                elements = arrayElements();
                break;
            }
            default:
                jj_la1[4] = jj_gen;
                ;
        }
        jj_consume_token(RightBracket);
        {
            if ( "" != null ) {
                return new FixedSizeArrayLiteral(elements, elements.getHeadElementType());
            }
        }
        throw new Error("Missing return statement in function");
    }

    /**
     * FunctionLiteral
     * FunctionLiteral = "[" VariableList "]" "to" FunctionBody
     * FunctionBody = Expression
     */
    final public Expression functionLiteral() throws ParseException {
        VariableList varList = null;
        VariableIdTypePairs varIdPairs = null;
        Expression expr;
        jj_consume_token(LeftBracket);
        switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
            case Identifier: {
                if ( jj_2_1(2) ) {
                    varList = varList();
                } else {
                    switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                        case Identifier: {
                            varIdPairs = varIdTypePairs();
                            break;
                        }
                        default:
                            jj_la1[5] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                }
                break;
            }
            default:
                jj_la1[6] = jj_gen;
                ;
        }
        jj_consume_token(RightBracket);
        jj_consume_token(To);
        expr = expr();
        if ( varList == null && varIdPairs == null ) {
            {
                if ( "" != null ) {
                    return new FunctionLiteral(expr);
                }
            }
        } else if ( varList == null && varIdPairs != null ) {
            {
                if ( "" != null ) {
                    return new FunctionLiteral(varIdPairs, expr);
                }
            }
        } else if ( varList != null && varIdPairs == null ) {
            {
                if ( "" != null ) {
                    return new FunctionLiteral(varList, expr);
                }
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public VariableList varList() throws ParseException {
        VariableId var;
        VariableList list = new VariableList();
        label_2:
        while ( true ) {
            var = variableId();
            list.addVariableElement(var);
            switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                case Identifier: {
                    ;
                    break;
                }
                default:
                    jj_la1[7] = jj_gen;
                    break label_2;
            }
        }
        {
            if ( "" != null ) {
                return list;
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public VariableIdTypePair varIdTypePair() throws ParseException {
        VariableId varId;
        TypeId typeId;
        varId = variableId();
        jj_consume_token(Colon);
        typeId = typeId();
        {
            if ( "" != null ) {
                return new VariableIdTypePair(varId, typeId);
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public VariableIdTypePairs varIdTypePairs() throws ParseException {
        VariableIdTypePair pair;
        VariableIdTypePairs pairs = new VariableIdTypePairs();
        label_3:
        while ( true ) {
            pair = varIdTypePair();
            pairs.addPair(pair);
            switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                case Identifier: {
                    ;
                    break;
                }
                default:
                    jj_la1[8] = jj_gen;
                    break label_3;
            }
        }
        {
            if ( "" != null ) {
                return pairs;
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public ArrayElements arrayElements() throws ParseException {
        ArrayElements elements = new ArrayElements();
        ArrayElement element;
        label_4:
        while ( true ) {
            element = arrayElement();
            elements.addElement(element);
            switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
                case BoolLiteral:
                case IntLiteral:
                case Hexadecimal:
                case FloatLiteral:
                case StringLiteral:
                case LeftBracket: {
                    ;
                    break;
                }
                default:
                    jj_la1[9] = jj_gen;
                    break label_4;
            }
        }
        {
            if ( "" != null ) {
                return elements;
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public ArrayElement arrayElement() throws ParseException {
        Expression expr;
        expr = expr();
        {
            if ( "" != null ) {
                return new ArrayElement(expr);
            }
        }
        throw new Error("Missing return statement in function");
    }

    /**
     * VariableId
     * VariableId = VariableIdHead IdentifierCharacter*
     */
    final public VariableId variableId() throws ParseException {
        Token t;
        t = jj_consume_token(Identifier);
        {
            if ( "" != null ) {
                return new VariableId(t.image);
            }
        }
        throw new Error("Missing return statement in function");
    }

    /**
     * TypeId
     * TypeId = TypeIdHead IdentifierCharacter*
     */
    final public TypeId typeId() throws ParseException {
        Token t;
        t = jj_consume_token(Identifier);
        {
            if ( "" != null ) {
                return new TypeId(t.image);
            }
        }
        throw new Error("Missing return statement in function");
    }

    final public Statement variableDeclaration() throws ParseException {
        VariableId name;
        TypeId typeId = net.nokok.karaffe.javacc.ast.TypeId.UNKNOWN_TYPE;
        ASTNode node;
        name = variableId();
        switch ( (jj_ntk == -1) ? jj_ntk_f() : jj_ntk ) {
            case Colon: {
                jj_consume_token(Colon);
                typeId = typeId();
                break;
            }
            default:
                jj_la1[10] = jj_gen;
                ;
        }
        jj_consume_token(EqualSign);
        node = expr();
        {
            if ( "" != null ) {
                return new VariableDeclaration(name, typeId, node);
            }
        }
        throw new Error("Missing return statement in function");
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

    private boolean jj_3R_5() {
        Token xsp;
        if ( jj_3R_6() ) {
            return true;
        }
        while ( true ) {
            xsp = jj_scanpos;
            if ( jj_3R_6() ) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3_1() {
        if ( jj_3R_5() ) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_7() {
        if ( jj_scan_token(Identifier) ) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_6() {
        if ( jj_3R_7() ) {
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
    final private int[] jj_la1 = new int[11];
    static private int[] jj_la1_0;
    static private int[] jj_la1_1;

    static {
        jj_la1_init_0();
        jj_la1_init_1();
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{ 0x220b8000, 0x220b8000, 0x20b8000, 0x30000, 0x20b8000, 0x20000000, 0x20000000, 0x20000000, 0x20000000, 0x20b8000, 0x0, };
    }

    private static void jj_la1_init_1() {
        jj_la1_1 = new int[]{ 0x1, 0x1, 0x1, 0x0, 0x1, 0x0, 0x0, 0x0, 0x0, 0x1, 0x4, };
    }
    final private JJCalls[] jj_2_rtns = new JJCalls[1];
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
        for ( int i = 0; i < 11; i++ ) {
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
        for ( int i = 0; i < 11; i++ ) {
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
        for ( int i = 0; i < 11; i++ ) {
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
        for ( int i = 0; i < 11; i++ ) {
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
        for ( int i = 0; i < 11; i++ ) {
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
        for ( int i = 0; i < 11; i++ ) {
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
        boolean[] la1tokens = new boolean[37];
        if ( jj_kind >= 0 ) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for ( int i = 0; i < 11; i++ ) {
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
        for ( int i = 0; i < 37; i++ ) {
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

    /**
     * Enable tracing.
     */
    final public void enable_tracing() {
    }

    /**
     * Disable tracing.
     */
    final public void disable_tracing() {
    }

    private void jj_rescan_token() {
        jj_rescan = true;
        for ( int i = 0; i < 1; i++ ) {
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
