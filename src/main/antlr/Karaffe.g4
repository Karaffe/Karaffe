grammar Karaffe;

//Parser
compileUnit 
  : statement* EOF
  ;

statement 
  : packageDecl
  | classDecl 
  ;

packageDecl
  : 'package' packagePath
  ;

packagePath
  : Identifier ('.' Identifier)*
  ;

classDecl 
  : classModifiers? 'class' className superOrInterfaceList? classBodyBlock?
  ;

classModifiers
  : classModifier+
  ;

classModifier
  : 'public'
  | 'open'
  | 'private'
  | 'abstract'
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
  ;

className 
  : Identifier
  ;

fieldDecl
  : 'def' fieldName ':' fieldType fieldInitializer
  ;

fieldName
  : Identifier
  ;

fieldType
  : type
  ;

fieldInitializer
  : '=' expr
  ;

type
  : Identifier
  ;

expr
  : Identifier
  ;

//Lexer

LBRACE : '{';
RBRACE : '}';

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
