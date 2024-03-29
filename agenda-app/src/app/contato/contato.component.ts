import { Component, OnInit } from '@angular/core';
import { Contato } from './contato';
import { ContatoService } from '../contato.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ContatoDetalheComponent } from '../contato-detalhe/contato-detalhe.component';
import { PageEvent } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrl: './contato.component.css'
})
export class ContatoComponent implements OnInit {

  formulario!: FormGroup;
  contatos: Contato[] = [];
  colunas = ['foto', 'id', 'nome', 'email', 'favorito']
  totalElementos = 0;
  pagina = 0;
  tamanho = 10;
  pageSizeOptions: number[] = [10];
  
  constructor(private service: ContatoService,
              private fb: FormBuilder,
              private dialog: MatDialog,
              private snackBar: MatSnackBar){}
  
  montarFormulario(){
    this.formulario = this.fb.group({
    nome: ['', Validators.required],
    email: ['', [Validators.email, Validators.required]]
    })
  }

  listarContatos(pagina = 0, tamanho = 10){
    this.service.list(pagina, tamanho).subscribe(res => {
      this.contatos = res.content;
      this.totalElementos = res.totalElements;
      console.log(this.totalElementos)
      this.pagina = res.number;
    })
  }
  
  ngOnInit(): void {
    this.montarFormulario();
    this.listarContatos(this.pagina, this.tamanho);
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
      this.listarContatos();
      this.snackBar.open('Contato adicionado!', 'Sucesso!', {
        duration: 2000
      })
      this.formulario.reset();
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

  visualizarContato(contato: Contato){
    this.dialog.open(ContatoDetalheComponent, {
      width: '400px',
      height: '400px',
      data: contato
    })
  }

  paginar(event: PageEvent){
    this.pagina = event.pageIndex;
    this.listarContatos(this.pagina, this.tamanho);
  }
}
