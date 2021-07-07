
// In javascript, after ES2015, all declarations will go to the top of the current scope

// like var, let and const will be HOISTED but will throw REFERENCE ERROR: can not be accessed 

//console.log(a) // Reference error: not defined


console.log(b) // undefined, cause of hoisting
var b; // hoisted, will goto the top of the scope
b=1;
console.log(b) // 1
b; // just using it, will not throw an error, no use
var b=0; // can use multiple times;
console.log(b) //0

c = 2; // no need to declare it when initializing
console.log(c); //2

//console.log(d) // Reference error: can not used before its declaration. meaning hoisted, but can not be accessed
let d; //hoisted
//let d =0; // error, can only be declared once in the current scope

//e =3; // can not access, reference error
const e=4; // hoisted
//always needs to initialized // syntax error


class Animal{
    static _a()
    {
        console.log("_a() called")
    }
    a()
    {
        console.log("a() called")
    }
}


class Cat extends Animal{
    static _c(){
        console.log("_c() called")
    }
    c(){
        console.log("c() called")
    }
}

var animal = new Animal()
var cat = new Cat()

console.log(Animal._a())
console.log(animal.a())



console.log(animal.__proto__ === Animal.prototype)
console.log(Cat.__proto__ === Animal)
console.log(Cat.prototype.__proto__ === Animal.prototype)
console.log(cat.__proto__ === Cat.prototype)
console.debug(cat)


Done(); // done called cause of hoisting
function Done(){
    console.log("done called")
}
var done =new Done();  // done called
console.debug(Done()) // undefined, return type is void
console.debug(done)