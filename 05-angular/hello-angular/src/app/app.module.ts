import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SuperheroListComponent } from './superhero-list/superhero-list.component';
import { StarComponent } from './shared/star.component';

@NgModule({
  declarations: [
    AppComponent, SuperheroListComponent, StarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
