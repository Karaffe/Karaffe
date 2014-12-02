/* KaraffeParser.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. KaraffeParser.java */
package net.nokok.karaffe.parser;

import net.nokok.karaffe.parser.util.*;
import java.util.*;

public class KaraffeParser/*@bgen(jjtree)*/implements KaraffeParserTreeConstants, KaraffeParserConstants {/*@bgen(jjtree)*/
  protected JJTKaraffeParserState jjtree = new JJTKaraffeParserState();
    public KaraffeParser(String sourceCode){
        this(new java.io.StringReader(sourceCode));
    }

    public int getCurrentTokenBeginColumn(){
        return jj_input_stream.getBeginColumn();
    }

    public int getCurrentTokenEndColumn(){
        return jj_input_stream.getEndColumn();
    }

    public int getCurrentLine(){
        return jj_input_stream.getEndLine();
    }

//文法定義
  final public ASTCompileUnit CompileUnit() throws ParseException {/*@bgen(jjtree) CompileUnit */
  ASTCompileUnit jjtn000 = new ASTCompileUnit(JJTCOMPILEUNIT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case EndModule:
        case Module:
        case Identifier:
        case Minus:
        case Bang:
        case NewLine:{
          ;
          break;
          }
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case EndModule:
        case Module:
        case Identifier:
        case Minus:
        case Bang:{
          Statement();
          break;
          }
        case NewLine:{
          NewLineToken();
          break;
          }
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      jj_consume_token(0);
jjtree.closeNodeScope(jjtn000, true);
                                            jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case Identifier:
    case Minus:
    case Bang:{
      Declaration();
      break;
      }
    case Module:{
      ModuleStatement();
      break;
      }
    case EndModule:{
      EndOfModule();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Declaration() throws ParseException {
    VariableDeclaration();
  }

/**
    VariableDeclaration

    修飾子 識別子        = 式
    修飾子 識別子 : 型名 = 式
 */
  final public void VariableDeclaration() throws ParseException {/*@bgen(jjtree) VariableDeclaration */
    ASTVariableDeclaration jjtn000 = new ASTVariableDeclaration(JJTVARIABLEDECLARATION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token id;
    Token type = null;
    try {
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case Minus:
        case Bang:{
          ;
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          break label_2;
        }
        Modifier();
      }
      id = jj_consume_token(Identifier);
      jj_consume_token(Colon);
      type = jj_consume_token(Identifier);
      jj_consume_token(EqualSign);
      Expression();
jjtree.closeNodeScope(jjtn000, true);
                                                                                             jjtc000 = false;
jjtn000.jjtSetValue(new VariableDeclarationData(id,type));
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void ModuleStatement() throws ParseException {/*@bgen(jjtree) ModuleStatement */
    ASTModuleStatement jjtn000 = new ASTModuleStatement(JJTMODULESTATEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(Module);
      t = jj_consume_token(Identifier);
jjtree.closeNodeScope(jjtn000, true);
                                jjtc000 = false;
jjtn000.jjtSetValue(t);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void EndOfModule() throws ParseException {/*@bgen(jjtree) EndOfModule */
  ASTEndOfModule jjtn000 = new ASTEndOfModule(JJTENDOFMODULE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(EndModule);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void Literal() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case BoolLiteral:{
      BoolLiteral();
      break;
      }
    case IntLiteral:{
      IntLiteral();
      break;
      }
    case FloatLiteral:{
      FloatLiteral();
      break;
      }
    case StringLiteral:{
      StringLiteral();
      break;
      }
    case Undefined:{
      jj_consume_token(Undefined);
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void BoolLiteral() throws ParseException {/*@bgen(jjtree) BoolLiteral */
    ASTBoolLiteral jjtn000 = new ASTBoolLiteral(JJTBOOLLITERAL);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(BoolLiteral);
jjtree.closeNodeScope(jjtn000, true);
                        jjtc000 = false;
jjtn000.jjtSetValue(t.image);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void IntLiteral() throws ParseException {/*@bgen(jjtree) IntLiteral */
    ASTIntLiteral jjtn000 = new ASTIntLiteral(JJTINTLITERAL);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(IntLiteral);
jjtree.closeNodeScope(jjtn000, true);
                       jjtc000 = false;
jjtn000.jjtSetValue(t.image);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void FloatLiteral() throws ParseException {/*@bgen(jjtree) FloatLiteral */
    ASTFloatLiteral jjtn000 = new ASTFloatLiteral(JJTFLOATLITERAL);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(FloatLiteral);
jjtree.closeNodeScope(jjtn000, true);
                         jjtc000 = false;
jjtn000.jjtSetValue(t.image);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void StringLiteral() throws ParseException {/*@bgen(jjtree) StringLiteral */
    ASTStringLiteral jjtn000 = new ASTStringLiteral(JJTSTRINGLITERAL);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(StringLiteral);
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.jjtSetValue(t.image);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void UndefinedLiteral() throws ParseException {/*@bgen(jjtree) UndefinedLiteral */
  ASTUndefinedLiteral jjtn000 = new ASTUndefinedLiteral(JJTUNDEFINEDLITERAL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(Undefined);
jjtree.closeNodeScope(jjtn000, true);
                  jjtc000 = false;
jjtn000.jjtSetValue(new UndefinedLiteral());
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void NewLineToken() throws ParseException {/*@bgen(jjtree) NewLineToken */
  ASTNewLineToken jjtn000 = new ASTNewLineToken(JJTNEWLINETOKEN);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(NewLine);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

/**
    Expressionの評価優先度
    低い順から
    AssignExpr =
    ↓
    OrOperatorExpr |
    ↓
    AndOperatorExpr &
    ↓
    EqualityOperatorExpr == !=
    ↓
    ComparisonOperatorExpr <= >= < >
    ↓
    AdditiveOperatorExpr + -
    ↓
    MultiplyOperatorExpr * / /? % %? 
    ↓
    UnaryOperatorExpr - ~ !
    ↓
    FunctionApply
 */
  final public void Expression() throws ParseException {
    AssignExpr();
  }

/**
    =
 */
  final public void AssignExpr() throws ParseException {
ASTAssignExpr jjtn001 = new ASTAssignExpr(JJTASSIGNEXPR);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      OrOperatorExpr();
      label_3:
      while (true) {
        if (jj_2_1(2)) {
          ;
        } else {
          break label_3;
        }
        jj_consume_token(EqualSign);
        OrOperatorExpr();
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

/**
    |
 */
  final public void OrOperatorExpr() throws ParseException {
ASTOrOpExpr jjtn001 = new ASTOrOpExpr(JJTOROPEXPR);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      AndOperatorExpr();
      label_4:
      while (true) {
        if (jj_2_2(2)) {
          ;
        } else {
          break label_4;
        }
        jj_consume_token(Or);
        AndOperatorExpr();
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

/**
    &   
 */
  final public void AndOperatorExpr() throws ParseException {
ASTAndOpExpr jjtn001 = new ASTAndOpExpr(JJTANDOPEXPR);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      ComparisonOperatorExpr();
      label_5:
      while (true) {
        if (jj_2_3(2)) {
          ;
        } else {
          break label_5;
        }
        jj_consume_token(And);
        ComparisonOperatorExpr();
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

/**
    ==, !=, >=, <= !<>= <>=
 */
  final public void ComparisonOperatorExpr() throws ParseException {
ASTComparisonOpExpr jjtn001 = new ASTComparisonOpExpr(JJTCOMPARISONOPEXPR);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      AdditiveOperatorExpr();
      label_6:
      while (true) {
        if (jj_2_4(2)) {
          ;
        } else {
          break label_6;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case EqualTo:{
          jj_consume_token(EqualTo);
          break;
          }
        case NotEqualTo:{
          jj_consume_token(NotEqualTo);
          break;
          }
        case GtE:{
          jj_consume_token(GtE);
          break;
          }
        case LtE:{
          jj_consume_token(LtE);
          break;
          }
        case NonComparable:{
          jj_consume_token(NonComparable);
          break;
          }
        case Comparable:{
          jj_consume_token(Comparable);
          break;
          }
        default:
          jj_la1[5] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        AdditiveOperatorExpr();
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

/**
    +, -
 */
  final public void AdditiveOperatorExpr() throws ParseException {
ASTAdditiveOpExpr jjtn001 = new ASTAdditiveOpExpr(JJTADDITIVEOPEXPR);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      MultiplyOperatorExpr();
      label_7:
      while (true) {
        if (jj_2_5(2)) {
          ;
        } else {
          break label_7;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case Plus:{
          jj_consume_token(Plus);
          break;
          }
        case Minus:{
          jj_consume_token(Minus);
          break;
          }
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        MultiplyOperatorExpr();
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

/**
    *, /, %, /?, %?   
 */
  final public void MultiplyOperatorExpr() throws ParseException {
ASTMultiplyOpExpr jjtn001 = new ASTMultiplyOpExpr(JJTMULTIPLYOPEXPR);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      UnaryOperatorExpr();
      label_8:
      while (true) {
        if (jj_2_6(2)) {
          ;
        } else {
          break label_8;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case Star:{
          jj_consume_token(Star);
          break;
          }
        case Slash:{
          jj_consume_token(Slash);
          break;
          }
        case Percent:{
          jj_consume_token(Percent);
          break;
          }
        case SafeDiv:{
          jj_consume_token(SafeDiv);
          break;
          }
        case SafeRem:{
          jj_consume_token(SafeRem);
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        UnaryOperatorExpr();
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

/**
    -, ~, ! 
 */
  final public void UnaryOperatorExpr() throws ParseException {
ASTUnaryOpExpr jjtn001 = new ASTUnaryOpExpr(JJTUNARYOPEXPR);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case Bang:{
        jj_consume_token(Bang);
        UnaryOperatorExpr();
        break;
        }
      case Minus:{
        jj_consume_token(Minus);
        UnaryOperatorExpr();
        break;
        }
      case LeftParen:{
        jj_consume_token(LeftParen);
        AssignExpr();
        jj_consume_token(RightParen);
        break;
        }
      case Undefined:
      case BoolLiteral:
      case IntLiteral:
      case FloatLiteral:
      case StringLiteral:
      case Identifier:{
        PrimaryExpression();
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

  final public void PrimaryExpression() throws ParseException {
ASTPrimaryExpr jjtn001 = new ASTPrimaryExpr(JJTPRIMARYEXPR);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case Identifier:{
        ExplicitModuleElementAccess();
        label_9:
        while (true) {
          if (jj_2_7(2)) {
            ;
          } else {
            break label_9;
          }
          Expression();
        }
        break;
        }
      case Undefined:
      case BoolLiteral:
      case IntLiteral:
      case FloatLiteral:
      case StringLiteral:{
        Literal();
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte001) {
if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

/**
    ModuleName::ElementName
 */
  final public void ExplicitModuleElementAccess() throws ParseException {/*@bgen(jjtree) ExplicitModuleElementAccess */
    ASTExplicitModuleElementAccess jjtn000 = new ASTExplicitModuleElementAccess(JJTEXPLICITMODULEELEMENTACCESS);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token moduleName;
    Token elementName;
    Token[] ids = new Token[2];
    try {
      moduleName = jj_consume_token(Identifier);
ids[0] = moduleName;
      jj_consume_token(72);
      elementName = jj_consume_token(Identifier);
jjtree.closeNodeScope(jjtn000, true);
                                                                                       jjtc000 = false;
ids[1] = elementName;jjtn000.jjtSetValue(ids);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

/**
    Modifier 

    - : プライベート
    ! : 変数
    指定なし : 公開定数
 */
  final public void Modifier() throws ParseException {/*@bgen(jjtree) Modifier */
  ASTModifier jjtn000 = new ASTModifier(JJTMODIFIER);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case Minus:{
        jj_consume_token(Minus);
jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
jjtn000.jjtSetValue(Modifier.PRIVATE);
        break;
        }
      case Bang:{
        jj_consume_token(Bang);
jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
jjtn000.jjtSetValue(Modifier.VARIABLE);
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_3_2()
 {
    if (jj_scan_token(Or)) return true;
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_30()
 {
    if (jj_3R_34()) return true;
    return false;
  }

  private boolean jj_3R_29()
 {
    if (jj_3R_33()) return true;
    return false;
  }

  private boolean jj_3R_14()
 {
    if (jj_3R_15()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_6()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_28()
 {
    if (jj_3R_32()) return true;
    return false;
  }

  private boolean jj_3R_10()
 {
    if (jj_3R_11()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_2()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_27()
 {
    if (jj_3R_31()) return true;
    return false;
  }

  private boolean jj_3R_26()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_27()) {
    jj_scanpos = xsp;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) {
    jj_scanpos = xsp;
    if (jj_3R_30()) {
    jj_scanpos = xsp;
    if (jj_scan_token(17)) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_5()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(48)) return true;
    }
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3_1()
 {
    if (jj_scan_token(EqualSign)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3R_34()
 {
    if (jj_scan_token(StringLiteral)) return true;
    return false;
  }

  private boolean jj_3R_25()
 {
    if (jj_scan_token(Identifier)) return true;
    if (jj_scan_token(72)) return true;
    return false;
  }

  private boolean jj_3R_13()
 {
    if (jj_3R_14()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_5()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_21()
 {
    if (jj_3R_10()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_1()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_24()
 {
    if (jj_3R_26()) return true;
    return false;
  }

  private boolean jj_3R_33()
 {
    if (jj_scan_token(FloatLiteral)) return true;
    return false;
  }

  private boolean jj_3_4()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(65)) {
    jj_scanpos = xsp;
    if (jj_scan_token(66)) {
    jj_scanpos = xsp;
    if (jj_scan_token(46)) {
    jj_scanpos = xsp;
    if (jj_scan_token(44)) {
    jj_scanpos = xsp;
    if (jj_scan_token(67)) {
    jj_scanpos = xsp;
    if (jj_scan_token(68)) return true;
    }
    }
    }
    }
    }
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_23()
 {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_16()
 {
    if (jj_3R_21()) return true;
    return false;
  }

  private boolean jj_3R_22()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_23()) {
    jj_scanpos = xsp;
    if (jj_3R_24()) return true;
    }
    return false;
  }

  private boolean jj_3R_20()
 {
    if (jj_3R_22()) return true;
    return false;
  }

  private boolean jj_3R_12()
 {
    if (jj_3R_13()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_4()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_19()
 {
    if (jj_scan_token(LeftParen)) return true;
    if (jj_3R_21()) return true;
    return false;
  }

  private boolean jj_3R_32()
 {
    if (jj_scan_token(IntLiteral)) return true;
    return false;
  }

  private boolean jj_3R_18()
 {
    if (jj_scan_token(Minus)) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3_3()
 {
    if (jj_scan_token(And)) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_17()
 {
    if (jj_scan_token(Bang)) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3R_15()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) {
    jj_scanpos = xsp;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3_7()
 {
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3R_11()
 {
    if (jj_3R_12()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_3()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_31()
 {
    if (jj_scan_token(BoolLiteral)) return true;
    return false;
  }

  private boolean jj_3_6()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(49)) {
    jj_scanpos = xsp;
    if (jj_scan_token(50)) {
    jj_scanpos = xsp;
    if (jj_scan_token(52)) {
    jj_scanpos = xsp;
    if (jj_scan_token(51)) {
    jj_scanpos = xsp;
    if (jj_scan_token(53)) return true;
    }
    }
    }
    }
    if (jj_3R_15()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public KaraffeParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[11];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40002400,0x40002400,0x40002400,0x0,0x44e0000,0x0,0x0,0x0,0x444e0000,0x444e0000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x810000,0x810000,0x810000,0x810000,0x0,0x5000,0x18000,0x3e0000,0x810040,0x0,0x810000,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x40,0x40,0x0,0x0,0x0,0x1e,0x0,0x0,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[7];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public KaraffeParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public KaraffeParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new KaraffeParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public KaraffeParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new KaraffeParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public KaraffeParser(KaraffeParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(KaraffeParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
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
  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[73];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 11; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 73; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 7; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
