# レッスン記録アプリ

## 本アプリでの対応範囲
- 要件定義
- **`設計書作成`**
- **`モック作成`**
- **`DB構築`**
- **`バックエンド実装`**
- **`フロントエンド実装`**
- **`コンテナ構築`**
- **`単体テスト`**
- 結合テスト
- クラウドサービスにデプロイ
- ユーザーテスト
- 本番環境へデプロイ

## 概要
学生時代に音楽サークルに在籍し若い学年の方への指導もしていた経験を思い出し、いつ誰にどういった指導をしたかをCRUD形式で記録することを想定したアプリケーションとなります。

## 技術スタック
### 使用技術
#### フロントエンド
- HTML
- CSS

#### バックエンド
- Java 21
- Spring Boot 3.4.1

    選定理由：実務経験のあるフレームワークでCRUDを実装することでバックエンドの実装能力を拡張するため

#### DB
- PostgreSQL 14.15

    選定理由：中長期的により規模の大きなデータを扱うのを見据えこの段階から基本的な構文に慣れるため

#### OS
- macOS

#### インフラ管理
- Docker 20.10.12

    導入理由(アプリ側)：デプロイを想定し、DBと独立させるため

    導入理由(DB側)：PostgreSQLをこの中で構築し、他のDB環境との競合を避けるため

#### コードエディター
- Visual Studio Code

    選定理由：今後Java以外の言語を用いて開発することを見据えEclipse以外の環境を通して実装できるようにするため

## 主な機能
- アプリケーション立ち上げ時のログイン機能

- DBにあるレッスン記録の表示をはじめとするCRUD機能

下記の動画は実際にアプリケーションを動かしている様子です。

画面録画の都合でレコード削除での確認ダイアログが非表示となっていますが、[単体テスト](./docs/unit-test/unit-tests/no15.md)にてきちんと表示されることは確認済みです。

[![WATCHME](https://img.youtube.com/vi/oaYXNaPVrBQ/0.jpg)](https://www.youtube.com/watch?v=oaYXNaPVrBQ)

各機能の詳細は"lesson-assumed-app/docs/各画面設計書(login.md,home.md,create.md,read.md,update.md)"を参照してください。

## 起動方法
1. 使用しているOSにてDockerをインストールの上、[DBセットアップ説明書](./docs/db-schema/db-setup.md)に沿ってDBを立ち上げてください。

2. その後本リポジトリをcloneし、DBと同じく以下のコマンドを実行してください。
```
docker-compose build # 作り直す必要がなければ初回以降の実行は不要
docker-compose up -d
```

その後下記のリンクをChromeより開くことでアプリを起動できます。

http://localhost:8080

3. 停止する際はDBのコンテナとアプリのコンテナそれぞれで下記のコマンドを実行してください。
```
docker-compose down
```

## 工夫した点
1. 現場で必要とされる機能を実装できるようにするため、CRUDの機能だけでなくログイン機能の実装も行いました。
2. 下記のディレクトリで画面設計書、DB項目定義書、単体テスト仕様書などを一から作成し、**実務の中で経験した詳細設計から単体テストまでの工程を一人称で進める**ことでより現場を想定した実装ができるようにしました。(GitHub上で直接見られるようマークダウン形式で作成しています)

```
lesson-assumed-app/
    ├── docs/
    │   ├── db-schema/
    │   │   ├── DBセットアップ説明書(db-setup.md)
    │   │   └── DB項目定義書(db.md)
    │   ├── screen-design/
    │   │   ├── images/
    │   │   └── 各画面設計書(login.md,home.md,create.md,read.md,update.md)
    │   └── unit-test/
    │       ├── images/
    │       ├── unit-tests/
    │       │   └── 各単体テスト仕様書(noX.md)
    │       └── 単体テスト一覧表(UNITLIST.md)
    └── src/
        └── 本アプリケーションのソースコード
```
3. アプリの性質上UIがシンプルになってしまうので、データの操作に直接関係するボタンに色を付けることでユーザーが行いたい処理をするにはどれを押下すればよいか直感的にわかるようにしました。

4. 今後のデプロイを見据え、アプリ側とDB側のそれぞれでコンテナ化をさせました。

## 今後の課題
### フロントエンドの実装能力を拡張
- JavaScriptやそれを用いたフレームワークを習得し、次回以降で動的な機能も持ったアプリを実装できるよう学習を進める予定です。

### PaaS等でのデプロイ
- フロントエンド等と並行してAWSの学習を行い、準備が整い次第本アプリをデプロイしオンライン上で起動できるようにすることを想定しています。