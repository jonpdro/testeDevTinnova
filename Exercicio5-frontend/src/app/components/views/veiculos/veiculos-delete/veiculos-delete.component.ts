import { VeiculoService } from './../../../../services/veiculo.service';
import { Veiculo } from './../../../../model/Veiculo';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-veiculos-delete',
  templateUrl: './veiculos-delete.component.html',
  styleUrls: ['./veiculos-delete.component.scss']
})
export class VeiculosDeleteComponent implements OnInit {

  veiculo: Veiculo = new Veiculo()
  id: number

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: VeiculoService
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id']

    this.findById()
  }

  findById() {
    this.service.getById(this.id).subscribe((resp: Veiculo) => {
      this.veiculo = resp
    })
  }

  deletar() {
    this.service.delete(this.id).subscribe(() => {
      this.router.navigate(['/atualizar'])
    })
  }

}
