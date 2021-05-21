# Flight Finder Rest API

### Dockerfile

```text
FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/flight-finder-rest-api.jar flight-finder-rest-api.jar
ENTRYPOINT ["sh", "-c", "java -jar /flight-finder-rest-api.jar"]
```

### Build and run docker image from the project root folder
under project flight-finder, run following commands

- docker build . -t niteshreddychalla/flight-finder-rest-api
- docker run -p 8080:8080 niteshreddychalla/flight-finder-rest-api 


UI

docker build . -t niteshreddychalla/flight-finder-ui


### Pulling the image directly from dockerhub

```text
You can skip above step and directly pull image from dockerhub.

Below command will pull image from dockerhub and run it on port 8080
```
- docker run -p 8080:8080 niteshreddychalla/flight-finder-rest-api 


UI

- docker run -p 4200:80 niteshreddychalla/flight-finder-ui


### Rest Endpoints


```text
Fetch flight info for displaying on UI
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
Fetch stations list for autosuggest
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


## Rest API UI link: 

- http://localhost:8080/swagger-ui.html


