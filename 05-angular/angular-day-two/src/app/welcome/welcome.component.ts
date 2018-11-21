import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

// @Injectable isn't needed for components, because the injector checks
//  all components
@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private _routerServ: Router) { }

  ngOnInit() {
  }

  enterButtonClicked() {
    console.log('enter clicked');
    this._routerServ.navigate(['/superheroes']);
  }

}
