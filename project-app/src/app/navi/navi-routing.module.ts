import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponent } from '../search/search.component';
import { AddComponent } from '../add/add.component';
import { DisplayComponent } from '../display/display.component';
import { DeleteComponent } from '../delete/delete.component';
import { UpdateComponent } from '../update/update.component';

const routes: Routes = [
  {path:"",redirectTo:"/find", pathMatch:"full"},
  {path:"search", component:SearchComponent},
  {path:"add", component:AddComponent},
  {path:"delete", component:DeleteComponent},
  {path:"display", component:DisplayComponent},
  {path:"update", component:UpdateComponent},
  {path:"**" , redirectTo:"/search", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
