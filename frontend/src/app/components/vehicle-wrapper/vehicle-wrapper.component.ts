import { Component, Input, Output, EventEmitter } from '@angular/core';
import { VehicleDisplayComponent } from "../vehicle-display/vehicle-display.component";
import { Vehicle } from '../../vehicle';
import { VehicleEditComponent } from '../vehicle-edit/vehicle-edit.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-vehicle-wrapper',
  standalone: true,
  imports: [VehicleDisplayComponent, VehicleEditComponent, CommonModule],
  templateUrl: './vehicle-wrapper.component.html',
  styleUrl: './vehicle-wrapper.component.css'
})
export class VehicleWrapperComponent {
  @Input() vehicle: Vehicle = new Vehicle(0, "", "", "", 0, "");
  @Output() removeItemEvent = new EventEmitter();

  editable : boolean = false;

  handleEditClick() : void {
    this.editable = true;
  }

  handleSaveEdition(vehicle : Vehicle) : void {
    this.editable = false;
    this.vehicle = vehicle;
  }
}
