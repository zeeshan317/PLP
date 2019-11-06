import { Component, OnInit } from '@angular/core';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  project: Project
  code: number;
  found : boolean;
  constructor(private service:ProjectService) { }

  ngOnInit() {
  }
  searchProject(){
    this.service.searchProject(this.code).subscribe(data => this.project = data, error => alert("Search could not be done!"));
    if(this.project != null){
      this.found = true;
    } else{
      alert("Project not found.")
      this.found = false;
    }
  }

}
