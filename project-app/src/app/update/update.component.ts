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
  project1: String="";

  constructor(private service: ProjectService, private route:Router) {
    this.project=new Project();
   }

  ngOnInit() {}

updateProject(){
this.service.modifyProject(this.project).subscribe(p => this.project1 = p);
this.project=new Project();
alert("Project Modified");
this.route.navigate(['display']);

}
}
