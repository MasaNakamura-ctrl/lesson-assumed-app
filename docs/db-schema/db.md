# DB項目定義書

## テーブル定義
| テーブル名   | 概要 |
| --- | ----------- |
| users    | ユーザーIDとパスワードを管理 |
| history    | レッスン記録の登録日、生徒名、記録日を管理 |

## カラム定義
| テーブル名   | カラム名 | 型 | 最大文字数 | 主キー | 必須 | 概要 |
| --- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| users   | id | INTEGER |  | ○ | ○ | ユーザーの管理ID(主キー) |
| users   | userId | VARCHAR | 10 |  | ○ | ユーザーID |
| users   | confirmWord | VARCHAR | 10 |  | ○ | パスワード |
| history   | id | INTEGER |  | ○ | ○ | レッスン記録の管理ID(主キー) |
| history   | lessonDate | DATE |  |  | ○ | レッスン記録の登録日 |
| history   | studentName | VARCHAR | 10 |  | ○ | 生徒名 |
| history   | lessonMemo | VARCHAR | 200 |  | ○ | レッスンでの進捗・記録といった詳細情報 |