import { ISuperhero } from './superhero';
import { Injectable } from '@angular/core';

@Injectable()
export class CharacterService {

    getCharacters(): ISuperhero[] {
        return [
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
    }
}
