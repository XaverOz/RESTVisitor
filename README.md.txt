для запуска проекта необходимо:

1) скачать и установить JDK8 
https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
(требуется регистрация)
2) установить maven
https://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip
3) скачать дистрибутив сервиса
https://github.com/XaverOz/RESTVisitor.git
4) разархивировать дистрибутив 
5) в терминале выполнить команду mvn spring-boot:run
6) для проверки работоспособности открыть ссылку и увидеть JSON ответ с нулями
http://localhost:8080/site-statistic?from=2010-05-06%2018:25&to=2030-05-06%2018:25

