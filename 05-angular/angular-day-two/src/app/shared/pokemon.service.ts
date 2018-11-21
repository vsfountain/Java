import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


export interface Pokes {
  'base_experience': number;
  'id': number;
  'name': string;
}

@Injectable()
export class PokemonService {

  private _url = 'https://pokeapi.co/api/v2/pokemon/121/';

  constructor(private httpServ: HttpClient) { }

  retrievePokemon(): Observable<string> {
    // so many pokemans
    /* let _options: RequestOptions = null;
    _options = new RequestOptions({headers: (new Headers()).append}); */

    return this.httpServ.get<string>(this._url);
  }

  retrievePokemonTwo(): Observable<Pokes> {
    // so many pokemans
    /* let _options: RequestOptions = null;
    _options = new RequestOptions({headers: (new Headers()).append}); */

    return this.httpServ.get<Pokes>(this._url);
  }
}
