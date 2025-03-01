import { Component } from '@angular/core';
import { VehicleDisplayComponent } from './components/vehicle-display/vehicle-display.component';
import {Vehicle} from "./vehicle";
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { VehicleInputComponent } from "./components/vehicle-input/vehicle-input.component";
import { VehicleWrapperComponent } from './components/vehicle-wrapper/vehicle-wrapper.component';
import { VehicleEditComponent } from './components/vehicle-edit/vehicle-edit.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [VehicleWrapperComponent, CommonModule, VehicleInputComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  appendData(newVehicle: any): void {
    this.vehicles.push(newVehicle);
  }

  removeItem(vehicleId: number): void {
    this.http.delete(
      "http://localhost:8080/vehicles/" + vehicleId,
    ).subscribe(data => this.vehicles = this.vehicles.filter((vehicle: Vehicle) => vehicle.id != vehicleId));
  }
  vehicles: Vehicle[] = []; 
  constructor(private http: HttpClient){};

  ngOnInit(): void{
    this.http.get<Vehicle[]>("http://localhost:8080/vehicles").subscribe(data => this.vehicles = data);
  }
}
