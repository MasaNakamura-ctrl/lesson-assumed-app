# 単体テスト仕様書

## 実施項目
| No   | 画面 | テスト処理 | 前提条件 | 操作手順 | 期待結果 | 実施結果 |
| --- | ----------- | ------- | ------- | ------- | ------- | ------- |
| 2 | ログイン画面 | 認証処理・画面遷移 | usersテーブルにレコードが存在すること | usersテーブルに存在するユーザーIDとパスワードを入力しログインボタンを押下する | レッスン記録一覧画面へ遷移すること | OK |

## 画面設計書のモック画像
ログイン画面
![ログイン画面](../../screen-design/images/login.png)

レッスン記録一覧画面
![レッスン記録一覧画面](../../screen-design/images/home.png)

## テスト実施

### DB
usersテーブル
| id | userId | confirmWord |
| --- | ----------- | ------- |
| 1 | lessonList | confirming |

historyテーブル
| id | lessonDate | studentName | lessonMemo |
| --- | ----------- | ------- | ------- |

### usersテーブルに存在するユーザーIDとパスワードを入力
![ログイン画面](../images/test-login.png)

![正しい組み合わせの入力](../images/right-combination.png)

### 実施結果
レッスン記録一覧画面へ遷移
![レッスン記録一覧画面](../images/home-no-record.png)