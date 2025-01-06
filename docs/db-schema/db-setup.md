# DBセットアップ説明書
## DB概要
本アプリケーションではDocker内でDBを構築し、それとのデータのやり取りによって実装や単体テストを進めておりました。

テーブル定義とカラム定義は[DB項目定義書](./db.md)を参照してください。

## ディレクトリ
任意のディレクトリから下記の構造でファイルを配置していました。

各ファイルの内容は次の章を参照してください。
```
任意のディレクトリ
└── postgres/
    ├── init/
    │   └── init.sql
    └── docker-compose.yml
```

## 各ファイルの記述
docker-compose.yml
```
version: '3.8'

services:
  postgres:
    image: postgres:latest
    container_name: postgres
    restart: always # コンテナが落ちた際に自動で再起動
    environment:
      POSTGRES_USER: user # ユーザー名
      POSTGRES_PASSWORD: password # パスワード
      POSTGRES_DB: postgres # データベース名
    ports:
      - "5432:5432" # ホストの5432番ポートをコンテナの5432番ポートへマッピング
    volumes:
      - pg_data:/var/lib/postgresql/data # 永続化のためのボリュームマウント
      - ./init:/docker-entrypoint-initdb.d

volumes:
  pg_data: # 永続化ボリュームの定義
```

init.sql
```
CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    userId VARCHAR(10) NOT NULL,
    confirmWord VARCHAR(10) NOT NULL
);

INSERT INTO users(userId, confirmWord) VALUES
('lessonList', 'confirming');

CREATE TABLE IF NOT EXISTS history(
    id SERIAL PRIMARY KEY,
    lessonDate DATE NOT NULL,
    studentName VARCHAR(10) NOT NULL,
    lessonMemo VARCHAR(200) NOT NULL
)

INSERT INTO history (lessonDate, studentName, lessonMemo) VALUES
('2025-01-01', 'student01', 'memo01'),
('2025-01-02', 'student02', 'memo02'),
('2025-01-03', 'student03', 'memo03')
;
```

## 起動・接続方法
使用しているOSにてDockerをインストールの上、ターミナルでディレクトリを*postgres*へ移動してください。

その次に下記のコマンドを実行するとコンテナ内にpostgreSQLのデータベースとテーブルを構築し立ち上げることができます。
```
docker-compose build
docker-compose up -d
```
この内"docker-compose build"は新たに作り直す必要がなければ初回以降の実行は不要です。

テーブルの中身をUIで確認する場合は"docker-compose up -d"でデータベースとテーブルを起動しDBeaverなどで接続するようにしてください。

(接続設定についてはDBをPostgreSQLと指定し、"docker-compose.yml"にあるユーザー名、パスワード、データベース名から入力しホスト名はlocalhostとしてください。)

DBの使用を終えた際にはターミナルで下記のコマンドを実行するようにしてください。
```
docker-compose down
```