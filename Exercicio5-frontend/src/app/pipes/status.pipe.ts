import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'status'
})
export class StatusPipe implements PipeTransform {
  
  disponivel: string = "Disponível";
  vendido: string = "Vendido"

  transform(value: unknown, ...args: unknown[]): unknown {

    if (value == false) {
      return this.disponivel;
    }
     else {
      return this.vendido;
    }

    
  }

}
