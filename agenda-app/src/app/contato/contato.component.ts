import { Component, OnInit } from '@angular/core';
import { Contato } from './contato';
import { ContatoService } from '../contato.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrl: './contato.component.css'
})
export class ContatoComponent implements OnInit {

  formulario!: FormGroup;
  contatos: Contato[] = [];
  colunas = ['foto', 'id', 'nome', 'email', 'favorito']
  
  constructor(private service: ContatoService,
              private fb: FormBuilder){}
  
  montarFormulario(){
    this.formulario = this.fb.group({
    nome: ['', Validators.required],
    email: ['', [Validators.email, Validators.required]]
    })
  }

  listarContatos(){
    this.service.list().subscribe(res => {
      console.log(res)
      this.contatos = res;
    })
  }
  
  ngOnInit(): void {
    this.listarContatos();
    this.montarFormulario();
  }

  favoritar(contato : Contato){
    this.service.favorite(contato).subscribe(res => {
      contato.favorito = !contato.favorito;
    })
  }
  
  submit(){
    const formValues = this.formulario.value;
    const contato: Contato = new Contato(formValues.nome, formValues.email)
    this.service.save(contato).subscribe(res => {
      let lista: Contato[] = [...this.contatos, res];
      this.contatos = lista;
    })
  }

  uploadFoto(event: any, contato: Contato){
    const files = event.target.files;
    if(files){
      const foto = files[0];
      const formData: FormData = new FormData();
      formData.append("foto", foto);
      this.service.upload(contato, formData)
      .subscribe(res => this.listarContatos());
    }
  }
}
