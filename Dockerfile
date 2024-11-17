FROM mirror.gcr.io/azul/zulu-openjdk:17.0.4 as Build

RUN mkdir -p /app
ADD . /app/
WORKDIR /app
RUN chmod +x gradlew
RUN ./gradlew build

FROM mirror.gcr.io/azul/zulu-openjdk:17.0.4

COPY --from=Build /app/build/libs/qr-for-fun-0.0.1-SNAPSHOT.jar /app/application.jar
EXPOSE 8080
WORKDIR /app

ENTRYPOINT java -jar application.jar