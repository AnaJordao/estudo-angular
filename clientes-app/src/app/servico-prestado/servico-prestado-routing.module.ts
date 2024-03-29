import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ServicoPrestadoFormComponent } from './servico-prestado-form/servico-prestado-form.component';
import { ServicoPrestadoListaComponent } from './servico-prestado-lista/servico-prestado-lista.component';
import { LayoutComponent } from '../layout/layout.component';

const routes: Routes = [
  {path: 'servicos-prestados', component: LayoutComponent, children: [
    {path: 'form', component: ServicoPrestadoFormComponent},
    {path: 'list', component: ServicoPrestadoListaComponent},
    {path: '', redirectTo: '/servicos-prestados/list', pathMatch: 'full'}
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServicoPrestadoRoutingModule { }
