import { Component } from '@angular/core';
import { ISuperhero } from '../Superhero/superhero';

@Component({
    selector: 'app-superhero-list',
    templateUrl: './superhero-list.component.html',
    styleUrls: ['./superhero-list.component.css']
})
export class SuperheroListComponent {
    pageTitle = 'Superhero List';

    superheroes: ISuperhero[] = [];
    filteredSuperheroes: ISuperhero[] = [];

    imageWidth = 100;
    imageMargin = 2;
    showImage = false;
    _listFilter = 'j';

    get listFilter(): string {
        return this._listFilter;
    }

    set listFilter(temp: string) {
        this._listFilter = temp;
        this.filteredSuperheroes = this._listFilter ? this.performFilter(this._listFilter) : this.superheroes;
    }


    constructor() {
        this.superheroes = [
            {
                'superhero': 'Frozone',
                'rank': 4,
                'ability': 'cold generation',
                'organization': 'incredibles',
                'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/06/Skin1Pc-200x100.jpg'
            },
            {
                'superhero': 'Eraser',
                'rank': 5,
                'ability': 'power nullification',
                'organization': 'pro hero',
                'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/12/minecraft_wallpaper-200x100.jpg'
            },
            {
                'superhero': 'Static Shock',
                'rank': 3,
                'ability': 'electric manipulation',
                'organization': 'duo',
                'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/12/minecraft_wallpaper-200x100.jpg'
            },
            {
                'superhero': 'Jack Jack',
                'rank': 2,
                'ability': 'what doesnt he have?',
                'organization': 'incredibles',
                'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/06/Skin1Pc-200x100.jpg'
            }
        ];
        this.filteredSuperheroes = this.superheroes;
    }

    toggleImage() {
        this.showImage = !this.showImage;
    }

    onRankClick(temp: string): void {
        this.pageTitle = temp;
    }

    performFilter(filterBy: string): ISuperhero[] {
        filterBy = filterBy.toLocaleLowerCase();
        return this.superheroes.filter((superhero: ISuperhero) =>
            superhero.superhero.toLocaleLowerCase().indexOf(filterBy) !== -1);
    }
}
