import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ProjectService } from '../project.service';
import { Project } from '../project';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  project:Project= new Project;
  
  pr:Project= new Project;
  
  submitted = false;

  constructor(private service: ProjectService, private route:Router) {
  }

  ngOnInit() {
  }

  newProject(): void {
    this.submitted = false;
    this.project = new Project();
  }

  AddProject() {
    this.service.saveProject(this.project)
      .subscribe(data => this.pr, error => console.log(error));
           
        if(this.pr!=null){
            alert("Project successfully Added!");
            this.route.navigate(['display']);
        }else{
          alert("Project could not be Added!");
          this.route.navigate(['add']);
        }
  }

  onSubmit() {
    this.submitted = true;
    this.AddProject();
  }
 

}
