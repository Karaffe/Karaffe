# Nodeの構造

```
RootNode
  FileUnit
    CompileUnit(s)
      PackageDef
        ImportDef(s)
        TypeDef(s)
          MethodDef(s)
            Instruction(s)
          FieldDef(s)
            Instruction(s)
```

```
Instruction
  Apply
  Atom
  Block
  PathSelector
  Literal
  Return
```

## 実装ルール

- 各要素はNodeクラスを継承する
- 各ノードはユニークなIDを持っている
- ルートノードを除き、各要素は自分の所有主(owner)を取得できる
- 各要素はソースコード上の位置情報を保持している。
- 位置情報が利用できない(コンパイラが生成した、ソースコードに現れない)ノードに関しては、それがわかるように実装する。Javaは特別なフラグが立つ(修飾子のひとつであるACC_SYNTHETIC)などする。Scalaはフラグはつかないが、AST上のメタデータから位置情報が取得できないことが明示的に指定される。(tree.posがNoPositionになる)

## アイデア

リテラル
```
Literal(1)
Literal(1.0)
Literal('H')
Literal("Hoge")
Literal("""Raw""")
Literal([])
```

メソッドの呼び出し
```
ルール：Apply(TargetInstruction, Selector)
1.toString()
1              Literal(1)
1.toString     Select(Literal(1), PathSelector(Ident("toString")))
1.toString()   Apply(Literal(1), PathSelector(Ident("toString")))

Apply(Literal(1), PathSelector(Ident("toString")))
```


## Scala
- 関数の仮引数はデフォルト(_)で初期化された変数宣言として扱う。インスタンスの実体がどこから来るのかは謎
- コンストラクタはそのコンストラクタのクラスが返り値の型になる(AクラスのコンストラクタならA)
