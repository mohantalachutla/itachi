
//functions
//proto1    function <name>(arg1 : datatype) : returntype {}
//proto2    var <name> = function(arg1 : datatype) : returntype {}
//proto3    var <name> = (arg1 : datatype) :return type => {}   //Es6

// function whose return type neither void nor any must return value
// default type for variable any
// default type for function void

// type creations
type TypeObj = { age : number, name : string};
let typeObj : TypeObj = {age:32,name : "mohan"}
var obj23 = ({age, name}:TypeObj) : string =>
{
    
    return "age ="+age+", name ="+name;
}
console.log(obj23(typeObj));
console.log(obj23({name:"itachi",age:23}));

var sum = function(a:number, b:number):number{
    return a+b;
}
console.log("sum()"+sum(3,5));
var cancat = (str1 : string, str2 :string) : string => {
    return str1 + str2;
}
console.log("cancat()"+cancat("Itachi","Uchiha"));

function equals(val1 : any, val2 : any) : boolean
{
    return val1 == val2;
}
console.log("equals"+equals("mohan","mohan"));
console.log("equals"+equals(4,2));
/* 
function print(...args : any[]) // means : void as return type
{
    console.log(args[0]);
}
//print(2,3,"itachi","uchiha"); // Overload must all be ambieant or non-ambient
print("itachi","uchiha");
// supports ... varArgs */

var sumDefault = (val1 : number, val2 : number, val3 : number = 10) : string => // val3 default value 10 
{
    let sum : number = 0;
    let result:string = "";
    if(val3 !=NaN)
    {
        sum = val1 + val2 + val3;
    }
    else
    {
        sum = val1 + val2;
    }
    result = sum +", val3 = "+val3;
    return result;
}
console.log("sumDefault()"+sumDefault(23,32));
console.log("sumDefault()"+sumDefault(23,32,100));
//never
var noReturn = ():never => {
    while(true)
    {
        console.log("infinite");   
    }
}

//? means optional
var sumOptional = (val1 : number, val2 : number, val3? : number) : string => // val3 is optional and can't be given default
{
    let sum : number = 0;
    let result : string = "";
    if(val3 !=undefined) // orElse return NaN
    {
        sum = val1 + val2 + val3;
    }
    else
    {
        sum = val1 + val2;
    }
    result = sum +", val3 = "+val3;
    return result;
}
console.log("sumOptional()"+sumOptional(23,32));
console.log("sumOptional()"+sumOptional(23,32,100));