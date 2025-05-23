# OpenJDK 21 (軽量な Alpine ベース)
FROM eclipse-temurin:21-jdk-alpine
# 作業ディレクトリの作成
WORKDIR /app
# プロジェクトのソースコードをコピー
COPY . .
# Maven Wrapper に実行権限を付与
RUN chmod +x mvnw
# 依存関係をキャッシュして事前にダウンロード
RUN ./mvnw dependency:go-offline -B
# アプリをビルド（テストをスキップ）
RUN ./mvnw package -DskipTests
# アプリを起動
CMD [“./mvnw”, “spring-boot:run”]