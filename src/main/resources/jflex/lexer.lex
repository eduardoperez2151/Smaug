package while_ut2.parser;

import java_cup.runtime.Symbol;
import java.util.*;

%%

%public
%unicode
%line
%column
%class Lexer
%cupsym Tokens
%cup
%implements Tokens

%{
	/* Embedded lexer class code */
%}

%%

[ \r\n\t]					{ /* Ignore whitespaces */ }
function					{ return new Symbol(Tokens.FUNCTION, yyline, yycolumn); }
return						{ return new Symbol(Tokens.RETURN, yyline, yycolumn);}
while						{ return new Symbol(Tokens.WHILE, yyline, yycolumn); }
do							{ return new Symbol(Tokens.DO, yyline, yycolumn); }
if							{ return new Symbol(Tokens.IF, yyline, yycolumn); }
then 						{ return new Symbol(Tokens.THEN, yyline, yycolumn); }
else						{ return new Symbol(Tokens.ELSE, yyline, yycolumn); }
true						{ return new Symbol(Tokens.TRUE, yyline, yycolumn, new Boolean(yytext())); }
false						{ return new Symbol(Tokens.FALSE, yyline, yycolumn, new Boolean(yytext())); }
time						{ return new Symbol(Tokens.TIME, yyline, yycolumn); }
[a-zA-Z_][a-zA-Z_0-9]* 		{ return new Symbol(Tokens.NAME, yyline, yycolumn ,yytext()); }
(<)							{ return new Symbol(Tokens.COMPARE_LESS, yyline, yycolumn); }
(>)							{ return new Symbol(Tokens.COMPARE_GREATER, yyline, yycolumn); }
(<=)						{ return new Symbol(Tokens.COMPARE_LESS_OR_EQUAL, yyline, yycolumn); }
(>=)						{ return new Symbol(Tokens.COMPARE_GREATER_OR_EQUAL, yyline, yycolumn); }
\+							{ return new Symbol(Tokens.ADDITION, yyline, yycolumn); }
\*							{ return new Symbol(Tokens.MULTIPLICATION, yyline, yycolumn); }
\/							{ return new Symbol(Tokens.DIVISION, yyline, yycolumn); }
"=="						{ return new Symbol(Tokens.COMPARE_EQUAL, yyline, yycolumn); }
"!="						{ return new Symbol(Tokens.COMPARE_NOT_EQUAL, yyline, yycolumn); } 
[0-9]+(\.[0-9]+)?			{ return new Symbol(Tokens.NUMERAL, yyline, yycolumn, Double.parseDouble(yytext())); }
\}							{ return new Symbol(Tokens.LLAVEDER, yyline, yycolumn); }
\{							{ return new Symbol(Tokens.LLAVEIZQ, yyline, yycolumn); }
\)  						{ return new Symbol(Tokens.PARENTESISDER, yyline, yycolumn); }
\( 							{ return new Symbol(Tokens.PARENTESISIZQ, yyline, yycolumn); }
\&\&						{ return new Symbol(Tokens.CONJUNCTION, yyline, yycolumn); }
\|\|						{ return new Symbol(Tokens.DISJUNCTION, yyline, yycolumn); } 
-							{ return new Symbol(Tokens.SUBSTRACTION, yyline, yycolumn); }
\=							{ return new Symbol(Tokens.ASSIGNMENT, yyline, yycolumn); }
"!"							{ return new Symbol(Tokens.NEGATION, yyline, yycolumn); }
;							{ return new Symbol(Tokens.SEMICOLON, yyline, yycolumn); }
,							{ return new Symbol(Tokens.COMMA, yyline, yycolumn); }
\/\/[^\n]*(\n|\$)			{ /* Ignore comments */ }
\/\*(.*?)\*\/				{ /* Ignore comments */ }

.                           { System.out.println("Error in Lexer! at line " + yyline + " column " + yycolumn); }
