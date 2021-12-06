import { Veiculo } from './../../../../model/Veiculo';
import { VeiculoService } from './../../../../services/veiculo.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-veiculos-create',
  templateUrl: './veiculos-create.component.html',
  styleUrls: ['./veiculos-create.component.scss']
})
export class VeiculosCreateComponent implements OnInit {

  veiculos: Veiculo = new Veiculo()

  constructor(
    private router: Router,
    private service: VeiculoService
  ) { }

  ngOnInit(): void {
  }

  create() {
    return this.service.post(this.veiculos).subscribe(() => {
      this.service.showAlert('Veículo cadastrado com sucesso!')
      this.router.navigate(['/inicio'])
    })
  }

  cancel() {
    return this.router.navigate(['/inicio'])
  }

}
