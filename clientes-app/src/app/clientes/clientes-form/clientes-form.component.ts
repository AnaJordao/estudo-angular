import { Component } from '@angular/core';
import { Cliente } from '../cliente';
import { ClientesService } from '../../clientes.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrl: './clientes-form.component.css'
})
export class ClientesFormComponent {
    cliente!: Cliente;
    success: boolean = false;
    errors: string[] | undefined;

    constructor(private service : ClientesService){
        this.cliente = new Cliente();
    }

    onSubmit(){
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
