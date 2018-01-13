Ingestion Coding Exercise
=========================

For the given catalog XML files 
(see [`ingestion_sample_a.xml`](src/test/resources/catalog/ingestion_sample_a.xml) and 
[`ingestion_sample_b.xml`](src/test/resources/catalog/ingestion_sample_b.xml)), 
create an API that provides a searchable interface to search the catalog. 
An operator must be able to search the catalog by artist, track title, and genre. 
All search results must be in JSON.

Your project must:
1. Ingest/consumes the xml files
2. Store the track content (title, artist, and genre will suffice)
3. Provide a REST endpoint that allows you to query the records by title, artist.
Results should be in JSON
4. (bonus) Your solutions should be executable within a Docker container.

Build
-----

To build project you have to have JDK 8, Maven and Docker installed:

    mvn clean package
    
If build was successful, you'll find the following deliverables in project's `target` directory:

* `ingestion-coding-exercise-1.0-SNAPSHOT.jar` - executable JAR file with microservice.
* `docker/com.dominichenko.test/ingestion-coding-exercise/1.0-SNAPSHOT/tmp/docker-build.tar` - docker image archive.
    
If you want to build project without Docker, just run the following command:

    mvn -Ddocker.skip=true clean package

Run
---

    mvn spring-boot:run
    
or you may just run executable JAR file:

    java -jar target/ingestion-coding-exercise-1.0-SNAPSHOT.jar 

### Load data:

    curl -d @./src/test/resources/catalog/ingestion_sample_a.xml -H 'Content-Type: application/xml' http://localhost:8080/api
    curl -d @./src/test/resources/catalog/ingestion_sample_b.xml -H 'Content-Type: application/xml' http://localhost:8080/api
    
### Get all records:

    curl http://localhost:8080/api
    
### Search records:

Search is performing against artist (parameter `a`), title (parameter `t`) or genre (parameter `g`).
You may use combination of these parameters. 
Comparison is case-insensitive and searches for string inclusion of given parameter value into target string.

    curl 'http://localhost:8080/api?a=kenny&t=and&g=country'

More examples:

    curl 'http://localhost:8080/api?a=o&t=o&g=o'
    curl 'http://localhost:8080/api?g=rock'
