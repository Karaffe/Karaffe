grammar Karaffe;
// Parser

compileUnit
    : topLevel*
    ;

topLevel
    : expr
    | stmt
    ;

stmt
    : assertStmt
    ;
    

assertStmt
    : Assert expr
    ;

expr
    : literal
    ;


literal
    : IntLiteral
    | BoolLiteral
    ;

// Lexer

// Literals

IntLiteral
    : NonZeroDigit
    | '0'
    | NonZeroDigit Digit*
    ;

BoolLiteral
    : 'true'
    | 'false'
    ;

// keywords

Abstract : 'abstract';
Alias : 'alias';
Assert : 'assert';
Break : 'break';
Class : 'class';
Def : 'def';
Defer : 'defer';
Do : 'do';
Docs : 'docs';
Else : 'else';
Ensure : 'ensure';
False : 'false';
Final : 'final';
For : 'for';
Func : 'func';
If : 'if';
Import : 'import';
Init : 'init';
Interface : 'interface';
Invariant : 'invariant';
Main : 'main';
Match : 'match';
Mixin : 'mixin';
Nameof : 'nameof';
Nil : 'nil';
Null : 'null';
Package : 'package';
Private : 'private';
Protected : 'protected';
Public : 'public';
Require : 'require';
Return : 'return';
Self : 'self';
Static : 'static';
Super : 'super';
Then : 'then';
This : 'this';
Throw : 'throw';
Trait : 'trait';
True : 'true';
Type : 'type';
When : 'when';
While : 'while';

// others

WhiteSpace
    : [ \t\r\n] -> skip
    ;

Semi
    : ';'
    ;

TypeNameId
    : Upper Letter*
    ;

VarNameId
    : Lower Letter*
    ;

ConstantNameId
    : Upper UpperOrUnderScore+
    ;


//fragments

fragment Digit
    : '0'
    | NonZeroDigit
    ;

fragment NonZeroDigit
    : '1' .. '9'
    ;

fragment UpperOrUnderScore
    : Upper
    | '_'
    ;

fragment Letter
    : Lower
    | Upper
    ;

fragment Lower
    : 'a' .. 'z'
    ;

fragment Upper
    : 'A' .. 'Z'
    ;

