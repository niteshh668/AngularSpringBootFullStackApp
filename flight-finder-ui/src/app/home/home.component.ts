import { FlightDataService, Flight } from './../service/flight-data.service';
import { Component, OnInit } from '@angular/core';

// Component responible for data binding and calling service layer to fetch the data

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  originstation: string;
  keyword: string;
  filteredStations: string[];
  fligts: Flight[];

  constructor(private service: FlightDataService) { }

  ngOnInit() {

  }
  handleFindFlights() {
    this.service.callBackendFlightService(this.originstation).subscribe(
      response => this.handleSuccessResponse(response),
      error => console.log(error.error)
    );

  }

  // 
  search(event) {
    this.service.suggestStations(event.query).subscribe(
      response => {
        this.filteredStations = response;
      },
      error => console.log(error.error)
    );

  }

  handleSuccessResponse(response) {
    this.fligts = response;
  }

}
