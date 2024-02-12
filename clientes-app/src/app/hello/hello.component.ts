import { Component } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
    selector: 'hello',
    standalone: true,
    imports: [],
    templateUrl: './hello.component.html',
    styleUrl: './hello.component.css'
})
export class HelloComponent {
    nome: string;
    clientes: Cliente[];

    constructor(){
        this.nome = 'Fulano';
        let fulano = new Cliente('Fulano', 38);
        let ciclano = new Cliente('Ciclano', 25);
        let outro = new Cliente('Outro', 12);

        this.clientes = [fulano, ciclano, outro];
    }
}

class Cliente {
    constructor(
        public nome: string,
        public idade: number
    ){}
}
