FROM gradle:jdk11

COPY . .

RUN gradle shadowJar

ENTRYPOINT ["./run-generator.sh"]

