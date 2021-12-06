import { VeiculosDeleteComponent } from './components/views/veiculos/veiculos-delete/veiculos-delete.component';
import { VeiculosUpdate2Component } from './components/views/veiculos/veiculos-update2/veiculos-update2.component';
import { VeiculosUpdateComponent } from './components/views/veiculos/veiculos-update/veiculos-update.component';
import { VeiculosReadComponent } from './components/views/veiculos/veiculos-read/veiculos-read.component';
import { VeiculosCreateComponent } from './components/views/veiculos/veiculos-create/veiculos-create.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'inicio',
    pathMatch: 'full'
  },
  {
    path: 'inicio',
    component: VeiculosReadComponent,
  },
  {
    path: 'cadastrar',
    component: VeiculosCreateComponent
  },
  {
    path: 'atualizar',
    component: VeiculosUpdateComponent
  },
  {
    path: 'atualizar/:id',
    component: VeiculosUpdate2Component
  },
  {
    path: 'deletar/:id',
    component: VeiculosDeleteComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
