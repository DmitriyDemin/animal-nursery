FROM ringcentral/jdk:21
COPY ./src ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d ./out ./src/programm/Programm.java
CMD java -classpath ./out  programm.Programm