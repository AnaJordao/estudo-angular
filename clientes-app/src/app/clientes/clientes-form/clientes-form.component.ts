import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClientesService } from '../../clientes.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrl: './clientes-form.component.css'
})
export class ClientesFormComponent implements OnInit {
    cliente!: Cliente;
    success: boolean = false;
    errors: string[] | undefined;
    id! : number;

    constructor(private service : ClientesService, 
                private router : Router,
                private activatedRoute : ActivatedRoute){
        this.cliente = new Cliente();
    }

    ngOnInit(): void {
        let params = this.activatedRoute.params;
        params.subscribe(urlParams => {
            this.id = urlParams['id'];
            if(this.id){
                this.service
                    .getClienteById(this.id)
                    .subscribe(res => this.cliente = res, 
                                errorRes => this.cliente = new Cliente())
            }
        })
    }

    voltarParaListagem(){
        this.router.navigate(['/clientes-lista'])
    }

    onSubmit(){
        if(this.id){
            this.service
                .atualizar(this.cliente)
                .subscribe(res => {this.success = true;
                                    this.errors = [];
                }, erroRes => {
                    this.errors = ['Erro ao atualizar o cliente.']
                });
        }else{
            this.service
                .salvar(this.cliente)
                .subscribe(response => {
                    this.success = true;
                    this.errors = [];
                    this.cliente = response;
                }, errorRes => {
                    this.success = false;
                    this.errors = errorRes.error.errors;
                })
        }
    }
}
