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
    imageWidth = 100;
    imageMargin = 2;
    showImage = false;

    constructor() {
        this.superheroes = [
            {
                'superhero': 'Frozone',
                'rank': 5,
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
                'rank': 4,
                'ability': 'electric manipulation',
                'organization': 'duo',
                'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/12/minecraft_wallpaper-200x100.jpg'
            },
            {
                'superhero': 'Jack Jack',
                'rank': 6,
                'ability': 'what doesnt he have?',
                'organization': 'incredibles',
                'image': 'http://www.minecraftjunkie.com/wp-content/uploads/2011/06/Skin1Pc-200x100.jpg'
            }
        ];
    }

    toggleImage() {
        this.showImage = !this.showImage;
    }
}
