#Karaffe Programming Language(ja)

#この言語の開発目標
- メモ帳でも書けるとにかくシンプルで現代的な機能を持つ言語
- Javaから見た時に違和感の無いバイトコード生成

##ビルド方法
ビルドする前に、MavenとJDK 8が必要です。

以下を実行して、ビルドします。  
```
mvn package
```

`target`ディレクトリが生成され、その中に`Karaffe-lang-x.y.z.jar`及び  
`Karaffe-Lang-x.y.z-jar-with-dependencies.jar`が生成されます。  
x,y,zはバージョンを表しています。  

例:
targetディレクトリへ移動します。
```
class User(age Int, name String) {

}

```
を`User.krf`として保存し、
```
java -jar Karaffe-Lang-x.y.z-jar-with-dependencies.jar User.krf
```
を実行した時に、`User.class`が作成されていればOKです。
あとはjavapとかしながら遊んであげてください。

##コントリビューティング

IDEはNetbeans 8.0以上を推奨しますが、一般的なMavenプロジェクト構成なのでEclipseやIntelliJ IDEAでも動作します。どのIDEも、Mavenのプロジェクトとして開くことができます。事前に必要なプラグインをインストールした後に開いてください。  

PullRequest大歓迎です。  
その際は[CONTRIBUTING.md](CONTRIBUTING.md)を参照してください。  
