//Unlike javascript, typescript is type safe and it is able to throw error. Browser can not support .ts file.
//tcs filename.ts  This will compile .ts and generate  .js file. 
// it supports classes and interfaces. Es6 version.
//var, let, const Es6
//proto    let variable : datatype =val;
// ; is optional
let iVal:number =6;
let fVal:number =6.2333;
// fVal = "mohan"; //error
///let numButString:number = "mohan"; // error
let sVal:string = "mohan";
//sVal = 23; //error
let aVal:any = 54; //can store any
aVal = "mohan";
let aVal1:any = "mohan"; 
let und:undefined = undefined;
und = null;
und : null; // no error
//und = 23; //error
//und = "mohan"; //error
let und1 : null = null;
und1 = undefined;
let und2 : void = undefined;
und2 : null;
//und2 = void;
// null, undefined, void are same can be assigned only undefind, null value. void is not a value.

let id : number | string; // multiple types
id = 233;
id = "adc";
//id = true; // error


//arrays
//proto let name:datatype[] = [values];
let arr : number[] = [2,344,433,223,3]
let arr1 : Array<number> = [2,344,433,223,3]
arr.forEach((val,ind,arr) => {console.log(ind+" = "+val)})
console.log("arr1[]"+arr1[3]);


//tuple can hold combinations of values of different types where array can hold  values of a type. 
//proto let name:[datatype,] = [values,];
let tup : [number] = [323]
let tup1 : [number,string,boolean] = [23,"mohan",true]
tup1.forEach(element => {
    console.log(element);
});



// Object i.e other than primitive types i.e number, string, boolean, symbol, null, or undefined.
//proto let name:Object = {key:val,};
let obj : Object = { age : 32, name : "mohan"}
obj["age"] =true;
console.log("obj[age]"+obj["age"]);


// type creations
// array
// proto type name = datatype[];
// proto name = Array<datatype>;
type tparr = string[];
let usernames : tparr;
usernames = ["itachi","sasuke","thobi"];
console.log(":tptup3   "+usernames[0]+","+usernames[1]);

// tuple
//proto type name = [datatype,];
//type tptup = [number?,string,boolean?] required element can not follow optional element
type tptup3 = [string,number?,boolean?];
let tup32 :tptup3;
tup32= ["itachi",93];
console.log(":tptup3   "+tup32[0]+","+tup32[1]);

//object
// proto type name = { key : datatype,};
type tpobj3 = {a :string, b?:number,c?:boolean};
let agepair : tpobj3 = {a:"itachi", b:23};
let sexpair : tpobj3 = {a:"itachi", c:true};
console.log(":tpobj3   "+agepair.a+","+agepair.b+", "+agepair.c);
console.log(":tpobj3   "+sexpair.a+","+sexpair.b+", "+sexpair.c);


// type conversions
// any to others primitive types.
let int1:any = "23";
let int2:number = ( int1 as number);



//enum
enum Djustu {BYAKUYAN, SHARINGAN, RENNEGAN};
let shinobi:Object = {name : "itachi", djustu:Djustu.BYAKUYAN} ;
console.log("name :"+shinobi["name"]+",  djustu ="+shinobi["djustu"])
console.log("name :"+shinobi["name"]+",  djustu ="+Djustu[shinobi["djustu"]]) // one can access enum both ways