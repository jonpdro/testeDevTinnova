import { MatSnackBar } from '@angular/material/snack-bar';
import { Veiculo } from '../model/Veiculo';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  url = 'http://localhost:8080/veiculos';

  constructor(
    private http: HttpClient,
    private snackBar: MatSnackBar
  ) { }

  showAlert(text: string, isError: boolean = false) {
    this.snackBar.open(text, '✖', {
      duration: 2000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: isError ? ['msg-error'] : ['msg-sucess']
    });
  }

  errorHandler(_e: any): Observable<any> {
    this.showAlert('Ops! Ocorreu um erro!', true)
    return EMPTY;
  }

  getAll(): Observable<Veiculo[]> {
    return this.http.get<Veiculo[]>(this.url);
  }

  getStatus(): Observable<Veiculo[]> {
    const url = 'http://localhost:8080/veiculos/status';
    return this.http.get<Veiculo[]>(url);
  }

  getById(id: number): Observable<Veiculo> {
    const url = `${this.url}/${id}`;

    return this.http.get<Veiculo>(url).pipe(
      map(obj => obj),
      catchError(e => this.errorHandler(e))
    );
  }

  post(veiculo: Veiculo): Observable<Veiculo> {
    return this.http.post<Veiculo>(this.url, veiculo);
  }

  patch(veiculo: Veiculo, id: number): Observable<Veiculo> {
    const url = `${this.url}/${id}`;
    return this.http.patch<Veiculo>(url, veiculo);
  }

  delete(id: number) {
    const url = `${this.url}/${id}`;

    return this.http.delete(url);
  }
}

