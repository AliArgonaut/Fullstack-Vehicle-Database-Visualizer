import { HttpClient } from '@angular/common/http';
import { Component, Output, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import { Vehicle } from '../../vehicle';
import { FormsModule } from '@angular/forms';

import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';



@Component({
  selector: 'app-vehicle-input',
  standalone: true,
  imports: [FormsModule, MatInputModule, MatFormFieldModule, MatIconModule, MatDividerModule, MatButtonModule],
  templateUrl: './vehicle-input.component.html',
  styleUrl: './vehicle-input.component.css'
})

export class VehicleInputComponent {
  vehicles : Vehicle[]  = [];

  @ViewChild("vehicleForm")
  vehicleForm!: NgForm;

  @Output() newDataEvent : any = new EventEmitter();

  constructor (private http: HttpClient){};

  onSubmit(): void {
    this.http.post<Vehicle>(
      "http://localhost:8080/vehicles",
      this.vehicleForm.value
    ).subscribe(data => {
      this.newDataEvent.emit(data);
      });
  }

   appendData(newVehicle : any): void {
    this.vehicles.push(newVehicle);
   } 
}
