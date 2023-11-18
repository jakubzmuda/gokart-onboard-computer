cd ..
mvn clean package
scp target/kart.jar kart@192.168.0.10:~/kart.jar
