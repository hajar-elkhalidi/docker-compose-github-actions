FROM maven:latest

WORKDIR /app

COPY ./app /app

EXPOSE 8080

CMD ["mvn" ,"clean" ,"spring-boot:run"]