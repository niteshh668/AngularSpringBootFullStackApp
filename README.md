# Flight Finder Rest API

This is a simple web app to list flights originating from a station. It is made up of two 
docker containers
- Java backend (Spring Boot) with in memory H2 DB 
- Angular frontend

The entry point for a user is a website which is available under the
address: **http://localhost:4200/**

---

### Prerequisites

In order to run this application you need docker running on your local machine

---
### How to run it?

An entire application can be ran with a single command in a terminal under /AngularSpringBootFullStackApp

```
$ docker -compose up -d
```

If you want to stop it use following command:

```
$ docker -compose down
```
---

### Rest API

Expose endpoints for UI to return list of stations with matching keyword and list of 
flights originating from a source station. 

Data for the service is loaded into in memory h2 db using script located under flight-finder/src/main/resources/data.sql 
```
http://localhost:8080/flight-finder/flights/{sourceStation}
```
- E.g http://localhost:8080/flight-finder/flights/LAX

```json
[
{
"id": 291511,
"createdAt": "2019-09-19T20:36:00",
"updatedAt": "2019-09-19T20:36:00",
"flightIdentifier": "442b8a42-a442-4ce0-8343-4e224e9d3fbd",
"fltNum": 2637,
"scheduledOriginGate": "24A",
"scheduledDestinationGate": "A12",
"outGmt": "2019-02-09T19:59:00",
"inGmt": "2019-02-10T00:14:00",
"offGmt": "2019-02-09T20:14:00",
"onGmt": "2019-02-10T00:06:00",
"destination": "ATL",
"origin": "LAX",
"destinationFullName": "Hartsfield - Jackson Atlanta I",
"originFullName": "Los Angeles Intl"
},
{
"id": 291540,
"createdAt": "2019-09-19T20:36:00",
"updatedAt": "2019-09-19T20:36:00",
"flightIdentifier": "4d4f2c7d-8232-4938-8fa0-70a08076e022",
"fltNum": 156,
"scheduledOriginGate": "27",
"scheduledDestinationGate": "TBA",
"outGmt": "2019-02-09T20:11:00",
"inGmt": "2019-02-10T06:55:00",
"offGmt": "2019-02-09T20:29:00",
"onGmt": "2019-02-10T06:49:00",
"destination": "CDG",
"origin": "LAX",
"destinationFullName": "Charles-de-gaulle",
"originFullName": "Los Angeles Intl"
}]

```
```text
Fetch list of stations for autosuggest
http://localhost:8080/flight-finder/stations/{stationKeyword}
```
 
- E.g http://localhost:8080/flight-finder/stations/LA

```json
[
"BLA",
"DLA",
"GLA",
"LAD",
"LAS",
"LAW",
"LAX",
"SLA"
]
```
---
#### Rest API Swagger link which html view of endpoints: 

- http://localhost:8080/swagger-ui.html
---
#### Flight finder ui (Frontend)
---
Angular frontend for displaying flight details

Dockerfile can be found here:  flight-finder-ui/Dockerfile
App can be entered using link: **http://localhost:4200/**

---
####  Way to run the docker containers separately if docker compose does not work (Optional)

```text
Below command will pull images from dockerhub and run it locally
```
---
##### Backend
- docker run -p 8080:8080 niteshreddychalla/flight-finder-rest-api 

##### UI

- docker run -p 4200:80 niteshreddychalla/flight-finder-ui

#### Build the images for backend and frontend (Optional)

under project flight-finder, run following commands
###### Backend:

- docker build . -t niteshreddychalla/flight-finder-rest-api
- docker run -p 8080:8080 niteshreddychalla/flight-finder-rest-api 

###### UI:
under project flight-finder-ui, run following commands


- docker build . -t niteshreddychalla/flight-finder-ui
- docker run -p 4200:80 niteshreddychalla/flight-finder-ui 

