import { Component, Input, OnChanges, OnInit, Output, EventEmitter } from '@angular/core';

// This is a decorator
@Component({
    selector: 'app-star',
    templateUrl: './star.component.html',
    styleUrls: ['./star.component.css']
})
export class StarComponent implements OnInit, OnChanges {
    starWidth: number;
    @Input() rank: number;
    @Output() rankClick: EventEmitter<string> = new EventEmitter<string>();

    constructor() {
        /* this.starWidth = this.rank * 70 / 5; */
    }

    ngOnInit() {
    }

    ngOnChanges() {
        this.starWidth = this.rank * 70 / 5;
    }

    onClick(): void {
        console.log('clicked');
        this.rankClick.emit(`This rank is ${this.rank}`);
    }
}
