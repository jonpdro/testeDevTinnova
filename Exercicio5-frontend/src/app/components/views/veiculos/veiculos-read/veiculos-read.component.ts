import { VeiculoService } from './../../../../services/veiculo.service';
import { Veiculo } from './../../../../model/Veiculo';
import { Component, OnInit } from '@angular/core';
import { reduce } from 'rxjs/operators';

@Component({
  selector: 'app-veiculos-read',
  templateUrl: './veiculos-read.component.html',
  styleUrls: ['./veiculos-read.component.scss']
})
export class VeiculosReadComponent implements OnInit {

  listarVeiculos: Veiculo[]

  constructor(
    private service: VeiculoService
  ) { }

  ngOnInit() {
    this.getAllStatus()
  }

  getAllStatus() {
    this.service.getStatus().subscribe(veiculos =>{
      this.listarVeiculos = veiculos
    })
  }
}
