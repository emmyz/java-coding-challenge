# Challenge answers

## A - The entities
![UML class](https://user-images.githubusercontent.com/35503757/115096176-e65e5b00-9ed8-11eb-9e78-f110f6f96d2a.png)

Brand entity contains the name of the brand and the models of the brand. Models entity contains the common attributes of basic model and their submodels. It also has aggregation "has a" relationship with Engine and Wheel because each car model in ford-exmaple data has Engine and Wheel. Basic models and submodels has a "is a " relationship and inherits from Model class with their special type or line.

## B - Ingest the data
<img width="883" alt="Screen Shot 2021-04-16 at 5 27 33 PM" src="https://user-images.githubusercontent.com/35503757/115096227-0aba3780-9ed9-11eb-9336-957b8ee60b67.png">
<img width="186" alt="Screen Shot 2021-04-16 at 5 28 00 PM" src="https://user-images.githubusercontent.com/35503757/115096235-1ad21700-9ed9-11eb-85f9-e86cf6ee1105.png">

Parse xml data with Java library DOM. Each object is annotated as JPA entities and mapped to table. Persist entities using JPA repository and the save method.

## C - Expose data with a RESTful API

## D - Adding images

## E - Improvements
