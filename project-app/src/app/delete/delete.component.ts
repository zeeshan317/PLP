import { Component, OnInit } from '@angular/core';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
 
 project:Project;
  code:number;
  submitted:boolean=true;
  constructor(private service: ProjectService) { }

  ngOnInit() {
    this.project= new Project();
  }
  searchProject(){
    this.service.searchProject(this.code).subscribe(data => this.project = data, error => alert("Search could not be done!"));
    if(this.project != null){
      this.submitted = true;
    } else{
      alert("Project not found.")
      this.submitted = false;
    }
  }
    deleteProject() {
      var ans = confirm("Are You Sure You want To delete?");
      if (ans)
        this.service.deleteProject(this.code);
    }
  }

