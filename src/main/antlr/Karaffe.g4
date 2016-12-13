grammar Karaffe;

//Parser
compileUnit 
  : statement* EOF
  ;

statement 
  : classDecl
  ;

classDecl 
  : 'class' className classBodyBlock?
  ;

classBodyBlock
  : LBRACE classBody* RBRACE
  ;

classBody
  : statement
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

SP
  : [ \t\r\n]+ -> skip
  ;
