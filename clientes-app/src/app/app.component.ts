import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HelloComponent } from './hello/hello.component';
import { ClientesModule } from './clientes/clientes.module';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HelloComponent, ClientesModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'clientes-app';
}
