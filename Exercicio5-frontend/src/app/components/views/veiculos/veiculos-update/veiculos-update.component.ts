import { VeiculoService } from './../../../../services/veiculo.service';
import { Veiculo } from './../../../../model/Veiculo';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-veiculos-update',
  templateUrl: './veiculos-update.component.html',
  styleUrls: ['./veiculos-update.component.scss']
})
export class VeiculosUpdateComponent implements OnInit {

  listarVeiculos: Veiculo[]

  constructor(
    private service: VeiculoService
  ) { }

  ngOnInit() {
    this.getAll()
  }

  getAll() {
    this.service.getAll().subscribe((resp: Veiculo[]) =>{
      this.listarVeiculos = resp
    })
  }

}
