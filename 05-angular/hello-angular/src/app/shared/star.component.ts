import { Component } from '@angular/core';

// This is a decorator
@Component({
    selector: 'app-star',
    templateUrl: './star.component.html',
    styleUrls: ['./star.component.css']
})
export class StarComponent {
    starWidth: number;

    constructor() {
    }
}
