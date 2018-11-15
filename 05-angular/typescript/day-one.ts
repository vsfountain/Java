import {Quiz} from "./quiz";


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
s2= "hello again";
s2= 37;
let s3: string;
s3="hello?";
//s3= 40;
//console.log(s1);

///numbers
let n1: number;
let n2= 5+9;
//boolean
let b1:boolean;
//any
let a1: any;
a1='string';
a1=17;
a1= false;

//void
let v1: void = null;
let nu1: null= undefined;
let un1: undefined= null;

//arrays
let arry1: string[];
arry1= ['one', 'two', 'three'];
//arry1= ['one', 7, 'nine'];

let arry2: Array<number>;
arry2=[2,17,19,900];

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

enum abilityType{OFFENSE=0, DEFENSE=1, SUPPORT=2, OTHER=3};
let variable;
if(variable == abilityType.OFFENSE){
}

//tuple
//fixed size and datatype array
let tu1: [string, boolean, boolean];
tu1= ["hola", true, false];
//tu1= [true, 77, false];

///////functions!!!!
/* function myFunc(first, second){ //old way
    console.log('stuff');
    return 'JackJack';
} */

function myFunc(first: string, second: any): string{
    return 'JackJack';
}

function myOtherFunc(): void{
    //return 5;
    return;
}

////////
/* function myFunc3(make, model, mileage, d, e, f, g, h, i, j, k, l){
    //what if all our parameters are closely related? What can we do?
} */

interface Criminal{
    name: string;
    //record: boolean;
    //tattoo: boolean;

    //method1(); //this is acceptable
    //method2(){}; //no implementation
}

function myFunc3(obj: Criminal){
    //our logic
    //console.log(obj.name);
}

//let daCriminal: Criminal= {name:'Al Capone', record: true, tattoo: false};
//myFunc3(daCriminal);
/* let myObj: Object={};
myFunc3(myObj); */

/////classes

class SuperVillain implements Criminal{
    //what are the access modifiers in typescript?
    //  private, public, protected, there is not a default access modifier
    //  public is the default modifier
    name: string;
    private ability: string;
    private bounty: number;

    constructor(name: string, ability: string, bounty: number){
        this.name=name;
        this.ability=ability;
        this.bounty=bounty;
    }

    useAbility(): void{
        console.log(this.ability);
    }
}

//let pepper = new SuperVillain();
let pepper: SuperVillain = new SuperVillain('Pepper','drowsy fist', 110_000);
/* pepper.ability='drowsy fist';
pepper.bounty=110_000; */
//pepper.useAbility();


//children
class SpecialClass extends SuperVillain{
    title: string;

    constructor(title: string, name: string, ability: string, bounty: number)
    {
        super(name,ability, bounty);
        this.title=title;
    }

    public useAbility(){
        console.log('in the special class');
        super.useAbility();
    }
}

let sean: SuperVillain = new SpecialClass('chessmaster','Sean',
    'laughing uncontrollably', 2);
//sean.useAbility();

////////////
//other class stuff
interface A{};
interface B{};
//multiple inheritance?
class Pet implements A, B{
    /* name: string;
    age: number;
    breed: string; */

    //question marks make the parameter optional
    //  each parameter to the right of a question  mark must ALSO
    //  be optional.
    //giving an access modifier in the constructor parameters declares
    //  the field FOR YOU and sets the argument equal to the field
    constructor(private _name?: string, private age?: number, private breed?: string){
                //underscore for variable that share names with
                //  their getters and setters
        /* this.name= name;
        this.age= age;
        this.breed= breed; */
    }

    get name(){
        console.log('getter');
        return this._name;
    }

    set name(name: string){
        console.log('setter');
        this._name=name;
    }
}

/* let pupperino= new Pet('Charles', 7, 'dalmation'); */
let pupperino= new Pet('Charles', 7);

/* console.log(pupperino.name);
console.log(pupperino.age);
console.log(pupperino.breed); */

//without keywords
/* pupperino.setName('Milton');
console.log(pupperino.getName()); */

pupperino.name='Milton';
console.log(pupperino.name);

/////////arrow notation
let exampleFunc= (vari) => console.log('vari is working');



//////////////
/* class Quiz{
    qNum: number;
    points: number;
} */

function printQuiz(q1: Quiz){
    console.log(q1.points, q1.qNum);
}

let q1: Quiz= {qNum: 25, points: 100};

printQuiz(q1);

////////if exporting not working then run:
//            tsc -t es2015 filename.ts -w




