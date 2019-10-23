// node wraps every module with in a function and excutes that function... put error in first line
// global is object of scope to an application and it's equivalent to Window object
// module is object of scope to a file. Every variable scope to the file it self.

let name = 'mohan';
///var global.name = 'shamili';  //variables does not belong to global objects. syntax error too.
///var module.name = 'shamili';  //variables does not belong to global objects. syntax error too.
global.console.log(global.name);  //undefined varible. But you can access functions;
global.console.log(name);
global.console.log('hello'); 

console.log(module);
name = 'naidu'; // will  re-write exiting Objects. scope to global
//let name = 'naidu'; // will through an  error. scope to block.
//const name = 'naidu'; // will through an error. scope to bloc. immutable.
console.log(name);
console.log(module.name);






// ES6 notation function creation
    let myFun = (name)=>{
    console.log(name);
    console.warn(`dldf ${name})`);
    console.error(new Error(`It's an error${name}`));
    }
    myFun('mohan');
    //global.myFun("naidu"); // scope to module. But We can't access them with objects.
    //module.myFun("naidu");
    exports.myFun = myFun;
    // normal function creation
    let myFun2 = function(name)
    {
        console.log(name);
    }
    myFun2('shamili');
    ///global.myFun2('shamili');
    //module.myFun2('shamili');
    
    function myFun3(name)
    {
        console.log(name);
    }
    myFun3('pavani');
    //global.myFun3('pavani');
    //module.myFun3('pavani');
    exports.method3= myFun3; // allowing to access from others modules using require