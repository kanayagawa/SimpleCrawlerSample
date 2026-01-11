# SimpleCrawlerSample

Jsoupを使用したシンプルなWebクローラーのサンプルプロジェクトです。指定したブログサイトから記事一覧を取得し、各記事の内容をHTMLファイルとして保存します。

## 機能

このクローラーは以下の処理を行います。

1. 指定したブログページ（はてなブログ）にアクセス
2. 記事一覧から各記事へのリンクを抽出
3. 各記事ページにアクセスして本文を取得
4. 記事タイトルをファイル名として、本文をHTMLファイルに保存

## 必要条件

- Java 8以上
- Gradle

## 依存ライブラリ

- Jsoup 1.10.3 - HTMLパーサー
- crawler4j 4.3 - Webクローラーフレームワーク
- JUnit 4.12 - テストフレームワーク

## ビルド方法

```bash
./gradlew build
```

## 実行方法

```bash
./gradlew run
```

または、ビルド後に生成されたJARファイルを直接実行することもできます。

## プロジェクト構成

```
SimpleCrawlerSample/
├── build.gradle          # Gradleビルド設定
├── settings.gradle       # Gradleプロジェクト設定
├── gradlew              # Gradle Wrapper (Unix)
├── gradlew.bat          # Gradle Wrapper (Windows)
└── src/
    └── main/
        └── java/
            └── SimpleCrawlerSample.java  # メインクラス
```

## 使用例

デフォルトでは `http://takezoe.hatenablog.com/` のブログ記事をクロールします。別のサイトをクロールする場合は、`SimpleCrawlerSample.java` 内のURL変数を変更してください。

## ライセンス

このプロジェクトはサンプルコードとして提供されています。
