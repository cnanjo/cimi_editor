import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { enableProdMode, NgModule } from '@angular/core';

import { AngularComponent } from './app/cimi-editor';
import { BrowserModule } from '@angular/platform-browser';

if (process.env.ENV === 'production') {
  enableProdMode();
}

// Main module, bootstrapping AngularComponent as root component

@NgModule({
  imports: [BrowserModule],
  declarations: [AngularComponent],
  bootstrap: [AngularComponent],
})
class AppModule { }

// Application bootstrap (specific for browser environments)

const platform = platformBrowserDynamic();
platform.bootstrapModule(AppModule);
