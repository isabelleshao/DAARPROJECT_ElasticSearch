# Ambitious ElasticSearch Project

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Test](#test)

## General info
* This project allows us to search on the CV's using ElasticSearch.
* Team members :
   - Maedeh Daemi  :   maedeh.daemi@etu.sorbonne-universite.fr
   - Kaoutar Nhaila :  Kaoutar.nhaila@etu.sorbonne-universite.fr
   - Isabelle Shao   : isabelle.shao@etu.sorbonne-universite.fr
   - Yohann Robert   : yohannrobert92@gmail.com
    
## Technologies
* Java version: 8
* IntelliJ IDEA version: 11.0.12
* elasticsearch version: 7.3.2
* kibana version: 7.3.2
* logstash version: 7.3.2 
    
## Setup
To run this project, follow this instruction :

1. open the project in your prefered IDEA
2. run elasticsearch in your PC
3. run kibana in your PC
4. run logstash in your PC
5. run PocLhomApplication.java file which is located in POC_LHOM/src/main/java/com/daar/POC_LHOM


## Test
Testing this project has two parts, first test Elasticsearch by Swagger API, second test logstash with kibana UI.
Follow this instruction :

PART 1:
1. open Swagger API (http://localhost:8080/swagger-ui.html#/cv-controller/createProfileUsingPOST)
there are two interfaces for POST request, one for Delete request and five for GET request.
![1](https://imgur.com/XnxwxJs.png)
2. for each request, first click on "try in out" button, after that fill the required boxes as instructed and click on "Execute" button.

POST /CV -> For this part, fill the boxes as shown in the picture.
![2](https://imgur.com/mVoUYqt.png)

GET /CV/List
![3](https://imgur.com/HyBqKzQ.png)

POST /CV/CreateProfile
![5](https://imgur.com/P7WvU2S.png)

GET /CV/List/Tag
![8](https://imgur.com/NAp3S7L.png)

PART 2:
1. Start the spring boot application
2. Go to the kibana UI (http://localhost:5602)
3. Go to Index Patterns 
4. Create index pattern
5. Add the index with pattern "cevetheque-*"
6. Select the timestamp field and finish
7. Go to Kibana
8. Discover


Now you're able to see the logs

![Kibana](https://imgur.com/fPNjjxX.png)



