import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/templates/header/header.component';
import { FooterComponent } from './components/templates/footer/footer.component';
import { ContentComponent } from './components/views/content/content.component';
import { VeiculosCreateComponent } from './components/views/veiculos/veiculos-create/veiculos-create.component';
import { VeiculosUpdateComponent } from './components/views/veiculos/veiculos-update/veiculos-update.component';
import { VeiculosDeleteComponent } from './components/views/veiculos/veiculos-delete/veiculos-delete.component';
import { VeiculosReadComponent } from './components/views/veiculos/veiculos-read/veiculos-read.component';

import { StatusPipe } from './pipes/status.pipe';
import { VeiculosUpdate2Component } from './components/views/veiculos/veiculos-update2/veiculos-update2.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ContentComponent,
    VeiculosCreateComponent,
    VeiculosUpdateComponent,
    VeiculosDeleteComponent,
    VeiculosReadComponent,
    StatusPipe,
    VeiculosUpdate2Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatSnackBarModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
