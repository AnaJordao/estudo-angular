import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../clientes/cliente';
import { ClientesService } from '../../clientes.service';
import { ServicoPrestado } from '../servicoPrestado';
import { ServicoPrestadoService } from '../../servico-prestado.service';

@Component({
  selector: 'app-servico-prestado-form',
  templateUrl: './servico-prestado-form.component.html',
  styleUrl: './servico-prestado-form.component.css'
})
export class ServicoPrestadoFormComponent implements OnInit {
  
  clientes : Cliente[] = [];
  servico : ServicoPrestado;
  success: boolean = false;
  errors: string[] | undefined;
  
  constructor(
    private clienteService : ClientesService,
    private service : ServicoPrestadoService
  ){
    this.servico = new ServicoPrestado();
  }

  ngOnInit(): void {
    this.clienteService
    .getClientes()
    .subscribe(res => this.clientes = res)
    
  }

  onSubmit() {
    this.service
        .salvar(this.servico)
        .subscribe(res => {
            this.success = true;
            this.errors = [];
            this.servico = new ServicoPrestado();
        }, erroRes => {
            this.success = false;
            this.errors =  erroRes.error.errors;
        });
    }
}
