
/**
 * In Javascript, function, class and instance will have a structure of an OBJECT {}
 * In Javascript, class is nothing but function which return a function
 * In Javascript, @decorator is nothing but function which takes a function prototype and returns modified function
 * 
 * In class:
 * static members added directly to the class Type, instance members added to Type.prototype
 * 
 * function or class:
 * will simply look for it's members with in itself or in __proto__ property of it but not prototype property
 * 
 * new keyword assigns:
 * Type.prototype to Ref.__proto__, meaning Ref.__proto__ === Type.prototype, applies for both function and class
 * 
 * In ineheratance:
 * static members added to __proto__ of the child, meaning ParentType === ChildType.__proto__, ChildType === GrandChildType.__proto, ParentType === GrandChildType.__proto__.__proto__
 * 
 * instance members of ParentType.prototype are  added to Child.prototype.__proto__, meaning ParentType.prototype === ChildType.prototype.__proto__ and so on
 * 
 * 
 * 
 * summery: while being instantiated or inhereted, always transited from it's own or prototype  of  SOURCE to __proto__ of it's own or prototype of DESTINATION
 * 
 */




 function Done(){
     console.log("done called")
 }
 var done =new Done();  // done called
 console.debug(Done()) // undefined, return type is void
 console.debug(done) // Done {}  // {} of type Done
 console.debug(done.__proto__ === Done.prototype) // true



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



console.log(animal.__proto__ === Animal.prototype) // true // instantiated
console.log(Cat.__proto__ === Animal) // true // static inheritance
console.log(Cat.prototype.__proto__ === Animal.prototype) // true // instance inheritance
console.log(cat.__proto__ === Cat.prototype) // true
console.log(cat.__proto__.__proto__ === Animal.prototype) // true
console.log(cat.__proto__ === Cat.__proto__) // false // static __proto__  !== instance __proto__,  new keywork will not add static __proto__