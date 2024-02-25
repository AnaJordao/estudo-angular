import { Component, OnInit } from '@angular/core';
import { Contato } from './contato';
import { ContatoService } from '../contato.service';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrl: './contato.component.css'
})
export class ContatoComponent implements OnInit {
  
  constructor(private service: ContatoService){

  }
  
  ngOnInit(): void {
      const c: Contato = new Contato();
      c.nome =  'Joao';
      c.email =  'joao@gmail.com';
      c.favorito = false;

      this.service.save(c).subscribe(res => {
        console.log(res);
      })
  }
}
