import { NgModule } from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {AppComponent1} from "./app1.component";

@NgModule({
  imports: [
    BrowserModule
  ],
  declarations: [
    AppComponent,
    AppComponent1
  ],
  bootstrap: [ AppComponent, AppComponent1 ]
})
export class AppModule { }
