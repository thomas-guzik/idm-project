FROM gradle:jdk11

COPY . .

RUN gradle shadowJar

CMD ["./run-generator.sh"]

