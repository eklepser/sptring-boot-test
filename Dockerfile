# Этап 1: Сборка JAR с помощью Maven
FROM maven:3.8.6-openjdk-17 AS builder

# Копируем файлы проекта
COPY . /app
WORKDIR /app

# Собираем JAR
RUN ./mvnw clean package -DskipTests

# Этап 2: Запуск JAR в легковесном образе
FROM openjdk:17-jre-slim

# Создаём папку для приложения
WORKDIR /app

# Копируем JAR из первого этапа
COPY --from=builder /app/target/*.jar app.jar

# Открываем порт 8080
EXPOSE 8080

# Команда запуска
ENTRYPOINT ["java", "-jar", "app.jar"]