grammar Karaffe;

//Parser
compileUnit 
  : statement* EOF
  ;

statement 
  : packageDecl
  | importDecl
  | funcDecl
  | classDecl 
  | interfaceDecl
  | expr
  ;

packageDecl
  : 'package' packagePath
  ;

packagePath
  : Identifier ('.' Identifier)*
  ;

importDecl
  : 'import' importPath
  ;

importPath
  : Identifier ('.' Identifier)* ('.' '*')?
  ;

interfaceDecl
  : interfaceModifiers? 'interface' className interfaceBody?
  ;

interfaceModifiers
  : interfaceModifier+
  ;

interfaceModifier
  : modifier
  ;

interfaceBody
  : classBodyBlock
  ;

classDecl 
  : classModifiers? 'class' className superOrInterfaceList? classBodyBlock?
  ;

classModifiers
  : classModifier+
  ;

classModifier
  : modifier
  ;

superOrInterfaceList
  : ':' className (',' className)*
  ;

classBodyBlock
  : LBRACE classBody* RBRACE
  ;

classBody
  : statement
  | fieldDecl
  | ctorDecl
  ;

className 
  : Identifier
  ;

fieldDecl
  : fieldModifiers? 'def' fieldName fieldType? fieldInitializer?
  ;

fieldModifiers
  : modifier+
  ;

ctorDecl
  : 'init' methodVar? ctorBody?
  ;

ctorBody
  : methodBody
  ;

funcDecl
  : funcModifiers? 'func' methodName methodVar? returnType? methodBody?
  ;

funcModifiers
  : modifier+
  ;

fieldName
  : Identifier
  ;

methodName
  : Identifier
  ;

methodVar
  : '(' parameterList? ')'
  ;

methodVarRet
  : LPAREN parameterList? RPAREN returnType?
  ;

parameterList
  : parameterSet (COMMA parameterSet)*
  ;

parameterSet
  : parameterName parameterType
  ;

parameterName
  : Identifier
  ;

parameterType
  : type
  | type '...'
  ;

returnType
  : type
  ;

methodBody
  : '{' statement* '}'
  ;  

fieldType
  : ':' type
  ;

fieldInitializer
  : '=' expr
  ;

type
  : Identifier
  ;

expr
  : intLiteral
  | expr op expr
  ;

prefixExpr
  : prefixOp? postfixExpr
  ;

binaryExpr
  : infixOp prefixExpr
  | assignExpr
  | condExpr
  | castExpr
  ;

assignExpr
  : assignHead AssignOp prefixExpr
  ; 

assignHead
  : target
  ;

target
  : Identifier
  | 'this' '.' Identifier
  | 'super' '.' Identifier
  ;

condExpr
  : CondOp prefixExpr
  ;

castExpr
  : CastOp prefixExpr
  ;

AssignOp
  : '='
  | '*='
  | '/='
  | '%='
  | '+='
  | '-='
  | '<<='
  | '>>='
  | '&='
  | '|='
  | '^='
  | '&&='
  | '||='
  ;

CondOp
  : '<'
  | '<='
  | '>'
  | '>='
  | '=='
  | '!='
  | '==='
  | '!=='
  | '~='
  ;

CastOp
  : 'as'
  | 'as?'
  | 'as!'
  ;

postfixExpr
  : primaryExpr
  | postfixExpr postfixOp
  | postfixExpr '(' exprList? ')'
  ;

primaryExpr
  : identifierExpr
  | literalExpr
  | superExpr
  | thisExpr
  | lambdaExpr
  | '(' expr ')'
  | implicitNewExpr
  | wildCardExpr
  ;

identifierExpr
  : Identifier
  ;

literalExpr
  : intLiteral
  | floatingPointLiteral
  | booleanLiteral
  | stringLiteral
  | rawStringLiteral
  | tupleLiteral
  | mapLiteral
  | listLiteral
  | nilLiteral
  ;

superExpr
  : superCtorExpr
  | superMethodExpr
  ; 

superCtorExpr
  : 'super' '.' 'init'
  ;

superMethodExpr
  : 'super' '.' methodName
  ;

thisExpr
  : 'this'
  | 'this' '.' Identifier
  | 'this' '.' 'init'
  ;

lambdaExpr
  : lambdaHead '=>' lambdaBodyBlock?
  ;

lambdaHead
  : Identifier
  | '(' lambdaParameters ')'
  ;

lambdaParameters
  : lambdaParameter (', ' lambdaParameter)*
  ;

lambdaParameter
  : varName type
  ;

varName
  : Identifier
  ;

lambdaBodyBlock
  : '{' lambdaBody* '}'
  | lambdaBody
  ; 

implicitNewExpr
  : '$' '.' expr
  ;

wildCardExpr
  : '_'
  ;

lambdaBody
  : statement
  ;

intLiteral
  : Decimal
  ;

floatingPointLiteral
  : Decimal '.' ZeroToNine+
  ;

booleanLiteral
  : 'true'
  | 'false'
  ;

stringLiteral
  : StaticStringLiteral
  ;

rawStringLiteral
  : RawString
  ;

tupleLiteral
  : '(' exprList ')'
  ;

mapLiteral
  : '[' mapLiteralBodyList?']'
  ;

mapLiteralBodyList
  : mapLiteralBody (',' mapLiteralBody)*
  ;

mapLiteralBody
  : mapKey '=>' mapValue
  ;

mapKey
  : Identifier
  ;

mapValue
  : expr
  ;

listLiteral
  : '[' exprList ']'
  ;

nilLiteral
  : 'Nil'
  ;

exprList
  : expr (',' expr)*
  ;

op
  : prefixOp 
  | infixOp
  | postfixOp
  ; 

prefixOp
  : '+'
  | '-'
  | '!'
  | '~'
  | '++'
  | '--'
  ;

infixOp
  : '<<'
  | '>>'
  | '*'
  | '/'
  | '%'
  | '&'
  | '&'
  | '+'
  | '-'
  | '&+'
  | '&-'
  | '|'
  | '^'
  | '..<'
  | '...'
  | '??'
  | '&&'
  | '||'
  | '?:'
  | 'is'
  | CastOp
  | CondOp
  | AssignOp
  ;

postfixOp
  : '++'
  | '--'
  ;

modifier
  : 'public'
  | 'protected'
  | 'private'
  | 'abstract'
  | 'open'
  | 'static'
  | 'final'
  | 'internal'
  | 'pkg'
  ;

//Lexer

LBRACE : '{';
RBRACE : '}';
LPAREN : '(';
RPAREN : ')';
COMMA  : ',';

Decimal
  : Zero
  | NonZero ZeroToNine*
  ;

fragment Zero
  : '0'
  ;

fragment NonZero
  : [1-9]
  ;

ZeroToNine
  : [0-9]
  ;

RawString
  : '"""' RawChars? '"""'
  ;

fragment RawChars
  : .+
  ;

StaticStringLiteral
  : '"' QuotedText? '"'
  ;

fragment QuotedText
  : QuotedTextItem+
  ;

fragment QuotedTextItem
  : EscapedChar
  | ~["\n\r\\]
  ;

fragment EscapedChar
  : '\\' [0\\tnr"']
  ;

Identifier 
  : IdentifierHead IdentifierBody*
  ;

fragment
IdentifierHead 
  : [a-zA-Z_]
  ;

fragment
IdentifierBody 
  : [a-zA-Z_0-9]
  ;

SP
  : [ \t\r\n]+ -> skip
  ;
