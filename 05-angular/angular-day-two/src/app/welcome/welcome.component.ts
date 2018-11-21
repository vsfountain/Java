import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PokemonService } from '../shared/pokemon.service';

// @Injectable isn't needed for components, because the injector checks
//  all components
@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private _routerServ: Router, private _pokes: PokemonService) { }

  ngOnInit() {
  }

  enterButtonClicked() {
    console.log('enter clicked');
    this._routerServ.navigate(['/superheroes']);
  }

  pokemonButtonClicked() {
    console.log('pokemon button clicked');
    this._pokes.retrievePokemon().subscribe(
      data => {
        console.log(data);
        console.log('something specific: ', data['base_experience']);
      }
    );
  }

  pokemonButtonClickedAgain() {
    console.log('pokemon button clicked');
    this._pokes.retrievePokemonTwo().subscribe(
      data => {
        console.log(data);
        console.log(data.base_experience);
        console.log(data.id);
        console.log(data.name);
      }
    );
  }
}
