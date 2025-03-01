import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Vehicle } from '../../vehicle';


import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';




@Component({
  selector: 'app-vehicle-edit',
  standalone: true,
  imports: [MatInputModule, 
    MatFormFieldModule, 
    MatIconModule, 
    MatDividerModule, 
    MatButtonModule,
    FormsModule],
  templateUrl: './vehicle-edit.component.html',
  styleUrl: './vehicle-edit.component.css'
})
export class VehicleEditComponent {
    vehicles : Vehicle[]  = [];
  
    @Input() vehicle: Vehicle = new Vehicle(0, "", "", "", 0, "");
  
    @Output() editDataEvent : any = new EventEmitter();
  
    constructor (private http: HttpClient){};
  
    onSubmit(): void {
      this.http.post<Vehicle>(
        "http://localhost:8080/vehicles",
        this.vehicle
      ).subscribe(data => {
        this.editDataEvent.emit(data);
        });
    }

}
