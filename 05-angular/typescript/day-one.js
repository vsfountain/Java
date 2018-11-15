console.log('Welcome to typescript!');
/*
What are the datatypes in typescript?

    boolean, number, string, object, null, undefined,
    symbol, function, array, void, any, tuple, enum
*/
//strings
let s1 = "hello";
//s1= 5;
let s2;
s2 = "hello again";
s2 = 37;
let s3;
s3 = "hello?";
//s3= 40;
//console.log(s1);
///numbers
let n1;
let n2 = 5 + 9;
//boolean
let b1;
//any
let a1;
a1 = 'string';
a1 = 17;
a1 = false;
//void
let v1 = null;
let nu1 = undefined;
let un1 = null;
//arrays
let arry1;
arry1 = ['one', 'two', 'three'];
//arry1= ['one', 7, 'nine'];
let arry2;
arry2 = [2, 17, 19, 900];
///////WHAT IS AN ENUM?????????????
/*
    enumeration. A collection of constants. Representative values.
*/
/* const offense= 0;
const DEFENSE= 1;
const SUPPORT= 2;
const other= 3;

let variable;
if(variable == SUPPORT){
} */
var abilityType;
(function (abilityType) {
    abilityType[abilityType["OFFENSE"] = 0] = "OFFENSE";
    abilityType[abilityType["DEFENSE"] = 1] = "DEFENSE";
    abilityType[abilityType["SUPPORT"] = 2] = "SUPPORT";
    abilityType[abilityType["OTHER"] = 3] = "OTHER";
})(abilityType || (abilityType = {}));
;
let variable;
if (variable == abilityType.OFFENSE) {
}
//tuple
//fixed size and datatype array
let tu1;
tu1 = ["hola", true, false];
//tu1= [true, 77, false];
///////functions!!!!
/* function myFunc(first, second){ //old way
    console.log('stuff');
    return 'JackJack';
} */
function myFunc(first, second) {
    return 'JackJack';
}
function myOtherFunc() {
    //return 5;
    return;
}
function myFunc3(obj) {
    //our logic
    //console.log(obj.name);
}
//let daCriminal: Criminal= {name:'Al Capone', record: true, tattoo: false};
//myFunc3(daCriminal);
/* let myObj: Object={};
myFunc3(myObj); */
/////classes
class SuperVillain {
    constructor(name, ability, bounty) {
        this.name = name;
        this.ability = ability;
        this.bounty = bounty;
    }
    useAbility() {
        console.log(this.ability);
    }
}
//let pepper = new SuperVillain();
let pepper = new SuperVillain('Pepper', 'drowsy fist', 110000);
/* pepper.ability='drowsy fist';
pepper.bounty=110_000; */
//pepper.useAbility();
//children
class SpecialClass extends SuperVillain {
    constructor(title, name, ability, bounty) {
        super(name, ability, bounty);
        this.title = title;
    }
    useAbility() {
        console.log('in the special class');
        super.useAbility();
    }
}
let sean = new SpecialClass('chessmaster', 'Sean', 'laughing uncontrollably', 2);
;
;
//multiple inheritance?
class Pet {
    /* name: string;
    age: number;
    breed: string; */
    //question marks make the parameter optional
    //  each parameter to the right of a question  mark must ALSO
    //  be optional.
    //giving an access modifier in the constructor parameters declares
    //  the field FOR YOU and sets the argument equal to the field
    constructor(_name, age, breed) {
        this._name = _name;
        this.age = age;
        this.breed = breed;
        //underscore for variable that share names with
        //  their getters and setters
        /* this.name= name;
        this.age= age;
        this.breed= breed; */
    }
    get name() {
        console.log('getter');
        return this._name;
    }
    set name(name) {
        console.log('setter');
        this._name = name;
    }
}
/* let pupperino= new Pet('Charles', 7, 'dalmation'); */
let pupperino = new Pet('Charles', 7);
/* console.log(pupperino.name);
console.log(pupperino.age);
console.log(pupperino.breed); */
//without keywords
/* pupperino.setName('Milton');
console.log(pupperino.getName()); */
pupperino.name = 'Milton';
console.log(pupperino.name);
/////////arrow notation
let exampleFunc = (vari) => console.log('vari is working');
//////////////
/* class Quiz{
    qNum: number;
    points: number;
} */
function printQuiz(q1) {
    console.log(q1.points, q1.qNum);
}
let q1 = { qNum: 25, points: 100 };
printQuiz(q1);
////////if exporting not working then run:
//            tsc -t es2015 filename.ts -w
