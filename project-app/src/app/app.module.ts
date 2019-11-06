import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddComponent } from './add/add.component';
import { DeleteComponent } from './delete/delete.component';
import { UpdateComponent } from './update/update.component';
import { DisplayComponent } from './display/display.component';
import { SearchComponent } from './search/search.component';


import {FormsModule} from '@angular/forms';
import { NaviRoutingModule } from './navi/navi-routing.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    DeleteComponent,
    UpdateComponent,
    DisplayComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NaviRoutingModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
