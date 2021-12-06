import { Veiculo } from './../../../../model/Veiculo';
import { VeiculoService } from './../../../../services/veiculo.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-veiculos-update2',
  templateUrl: './veiculos-update2.component.html',
  styleUrls: ['./veiculos-update2.component.scss']
})
export class VeiculosUpdate2Component implements OnInit {

  veiculos: Veiculo
  id: number

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: VeiculoService
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id']

    this.service.getById(this.id).subscribe((resp: Veiculo) => {
      this.veiculos = resp
    })
  }

  cancel() {
    return this.router.navigate(['/atualizar'])
  }

  atualizar() {
    this.service.patch(this.veiculos, this.id).subscribe((resp: Veiculo) => {
      this.veiculos = resp
      this.router.navigate(['/atualizar'])
    })
  }

}
