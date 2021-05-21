import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class Flight {

  constructor(
    public flightIdentifier: string,
    public createdAt: Date,
    public updatedAt: Date,
    public outGmt: Date,
    public inGmt: Date,
    public onGmt: Date,
    public offGmt: Date,
    public destination: string,
    public origin: string,
    public destinationFullName: string,
    public originFullName: string,
    public scheduledOriginGate: string,
    public scheduledDestinationGate: string
  ) { }
}

@Injectable({
  providedIn: 'root'
})
export class FlightDataService {
  BASE_URL = "http://localhost:8080/flight-finder/"
  constructor(
    private http: HttpClient
  ) { }


  callBackendFlightService(station) {
    return this.http.get<Flight[]>(`${this.BASE_URL}/flights/${station}`);
  }

  suggestStations(keyword) {
    return this.http.get<string[]>(`${this.BASE_URL}/stations/${keyword}`);
  }

}
