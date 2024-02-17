import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClientesService } from '../../clientes.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-clientes-lista',
    templateUrl: './clientes-lista.component.html',
    styleUrl: './clientes-lista.component.css'
})
export class ClientesListaComponent implements OnInit{
    clientes: Cliente[] = [];
    clienteSelecionado! : Cliente;
    mensagemSucesso: string = '';
    mensagemErro: string = '';

    constructor(private service: ClientesService, private router : Router){ // para se conectar a api
        
    }

    ngOnInit(): void { // ao inicializar este componente
        this.service
            .getClientes()
            .subscribe(res => this.clientes = res);
    }

    novoCadastro(){
        this.router.navigate(['/clientes/form'])
    }

    preparaDelecao(cliente : Cliente){
        this.clienteSelecionado = cliente;
    }

    deletarCliente(){
        this.service
            .deletar(this.clienteSelecionado)
            .subscribe(
                res => {
                    this.mensagemSucesso = 'Cliente deletado com sucesso.'
                    this.ngOnInit();
                },
                erro => this.mensagemErro = 'Ocorreu um erro ao deletar o cliente.'
            )
    }
}
