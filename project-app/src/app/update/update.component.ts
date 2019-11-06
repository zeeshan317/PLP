import { Component, OnInit } from '@angular/core';
import { Project } from '../project';
import { ProjectService } from '../project.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  project: Project;
  constructor(private service: ProjectService, private route:Router) {
    this.project=new Project();
   }

  ngOnInit() {
    this.project=new Project;
  }
updateProject(){
this.service.updateProject(this.project);
this.project=new Project();
this.route.navigate(['search'])

}
}
