# ShopApi

##Description:
RESTful API is developed to add shop so, it can be useful for customer to get near by shops. This api uses google's Geocoding API to get coordinates based on shop address.

##Run:
To test first checkout and do following
mvn compile

mvn package && java -jar target/assignment-0.0.1-SNAPSHOT.jar

then start any REST client(e.g. Postman)
##1. To Add Shop
use Input method POST and url: http://localhost:8080/shop
with Payload
{"id":"1","name":"Dominos","address":{"number":null,"city":"delhi","postCode":"110002"}}

you should get Output as below
{"id":"1","name":"Dominos","address":{"number":null,"city":"delhi","postCode":"110002","location":{"lat":28.6139391,"lng":77.2090212}}}


##2. To find near shops for cusomter it should be used as below:
use Input method POST and url: http://localhost:8080/shop/nearby
with Payload
{"address":{"location":{"lat":28.6139391,"lng":77.2090212}}}

you should get Output as below
{"id":"1","name":"Dominos","address":{"number":null,"city":"delhi","postCode":"110002","location":{"lat":28.6139391,"lng":77.2090212}}}