import { Injectable } from '@angular/core';
import { Project } from './project';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  
  project: Project[]=[]
  constructor(public http:HttpClient) { }

  saveProject(pr : Project):Observable<Project> {
    return this.http.post<Project>("http://localhost:8880/project/add",pr);
  }

  searchProject(projectCode: string):Observable<Project> {
    return this.http.get<Project>("http://localhost:8880/project/projectCode/" + projectCode);
  }

  getProject(){
    return this.http.get<Project[]>("http://localhost:8880/project");
    //return this.http.get("http://localhost:9091/player");
  }

  modifyProject(project: Project) {
    return this.http.put<String>("http://localhost:8880/project/update",project);
  }

  deleteProject(projectCode: number){
    return this.http.delete<boolean>("http://localhost:8880/project/delete/"+ projectCode);
  }
}