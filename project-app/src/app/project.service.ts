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

  saveProject(pr : Project) {
    return this.http.post<number>("http://localhost:8880/project/add",pr);
  }
  searchProject(code: number):Observable<Project> {
    return this.http.get<Project>("http://localhost:8880/project/projectCode/{code}" + code);
  }
  getProject():Observable<any>{
    return this.http.get("http://localhost:8880/project");
    //return this.http.get("http://localhost:9091/player");
  }
  updateProject(project: Project) {
    return this.http.post<number>("http://localhost:8880/project/update",project);
  }
  deleteProject(code: number){
    return this.http.delete<boolean>("localhost://8880/project/delete/"+ code);
  }
}