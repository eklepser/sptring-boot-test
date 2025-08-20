# Этап 1: Сборка JAR с помощью Maven
FROM maven:3.8.6-openjdk-17 AS builder

# Копируем файлы проекта
COPY . /app
WORKDIR /app

# Убедимся, что mvnw исполняемый
RUN chmod +x ./mvnw

# Собираем JAR (пропускаем тесты, чтобы ускорить сборку)
RUN ./mvnw clean package -DskipTests

# Этап 2: Запуск JAR в легковесном образе
# Используем официальный образ Eclipse Temurin с OpenJDK 17 JRE
FROM eclipse-temurin:17-jre-alpine

# Рабочая директория
WORKDIR /app

# Копируем JAR из первого этапа
COPY --from=builder /app/target/*.jar app.jar

# Открываем порт 8080
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]