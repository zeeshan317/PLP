import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {
  project: ProjectService
  constructor(private service: ProjectService) { }

  ngOnInit() {
    this.service.getProject().subscribe(data => this.project = data);
  }
}