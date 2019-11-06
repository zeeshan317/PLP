import { Component, OnInit } from '@angular/core';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  project: Project;
  b:boolean;
  projectCode: number;
  submitted: boolean = true;

  constructor(private service: ProjectService) { }

  ngOnInit() {
    this.project = new Project();
  }

  findProject() {
    this.service.searchProject(this.project.projectCode).subscribe(data => this.project = data);
  }
  removeProject() {
    var ans = confirm("Are You Sure You want To delete?");
    if (ans)
      this.service.deleteProject(this.project.projectCode).subscribe(data => this.project = data);;
  }
}

