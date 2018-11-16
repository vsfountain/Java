import { Component, OnInit } from '@angular/core';
import { ISuperhero } from '../shared/superhero';

@Component({
  selector: 'app-superhero-list',
  templateUrl: './superhero-list.component.html',
  styleUrls: ['./superhero-list.component.css']
})
export class SuperheroListComponent implements OnInit {

  pageTitle = 'Superhero List';
  imageWidth = 50;
  imageMargin = 2;
  showImage = false;
  _listFilter = '';
  get listFilter(): string {
    return this._listFilter;
  }
  set listFilter(temp: string) {
    this._listFilter = temp;
    this.filteredSuperheroes = this._listFilter ? this.performFilter(this._listFilter) : this.superheroes;
  }

  superheroes: ISuperhero[] = [];
  filteredSuperheroes: ISuperhero[] = [];

  constructor() {
    this.superheroes = [
      {
          'name': 'Frozone',
          'ability': 'cold generation',
          'organization': 'incredibles',
          'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/06/Skin1Pc-200x100.jpg'
      },
      {
          'name': 'Eraser',
          'ability': 'power nullification',
          'organization': 'pro hero',
          'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/12/minecraft_wallpaper-200x100.jpg'
      },
      {
          'name': 'Static Shock',
          'ability': 'electric manipulation',
          'organization': 'duo',
          'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/12/minecraft_wallpaper-200x100.jpg'
      },
      {
          'name': 'Jack Jack',
          'ability': 'what doesnt he have?',
          'organization': 'incredibles',
          'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/06/Skin1Pc-200x100.jpg'
      }
  ];
  this.filteredSuperheroes = this.superheroes;
   }

  ngOnInit() {
  }

  toggleImage() {
    this.showImage = !this.showImage;
  }

  performFilter(filterBy: string): ISuperhero[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.superheroes.filter((metahuman: ISuperhero) =>
        metahuman.name.toLocaleLowerCase().indexOf(filterBy) !== -1);
  }

  onRankClicked(temp: string): void {
    this.pageTitle = temp;
  }

}
