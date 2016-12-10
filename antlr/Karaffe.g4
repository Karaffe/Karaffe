grammar Karaffe;

//Parser

compileUnit 
  : statement* EOF
  ;

statement 
  : classDecl
  ;

classDecl 
  : 'class' className classBody
  ;

classBody
  : LBRACE RBRACE
  ;

className 
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
