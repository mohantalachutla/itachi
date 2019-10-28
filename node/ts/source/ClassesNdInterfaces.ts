
interface Student
{
    name : string;
    age? : number;
    dept? : string;
    rank? : number;
}

interface Student1
{
    name : string;
    age? : number; // optional property
    [prop :string] : any;  // you can defind any number of string indexed properties
}
interface Student2
{
    name : string;
    age? : number; // optional property
    [prop :number] : any;  // you can defind any number of string indexed properties
}

interface Str_array // readonly arry, indexed string
{
    readonly [ind:string]:string;
}

interface readonly_str_array // readonly arry, indexed number
{
    readonly [ind:number]:string;
}

let student : Student = {name:"Itachi", dept : "IT"};
//student = {name:"Itachi", dept : "IT", id : 23}; // error undefind property
console.log(student);
let student1 : Student1 = {name:"Itachi", dept : "IT", id : 23};
console.log(student1);
//let student2 : Student2 = {name:"Itachi",  dept:"IT", 2 :23};  // error dept cant be a index


let arr_str : Str_array = {"name":"itachi",'age':"43","rank":"48.33"};
console.log(arr_str);
//arr_str.name  = "sasuke"; // readonly, error
console.log(arr_str);
let arr_ro : readonly_str_array = ["mohan","itachi","susuke","nagato"];
console.log(arr_ro);
//arr_ro[0] = "xyz"; // error


//function declaration in interface
interface Alien
{
    (race :string, id :number, name?:string,native?:string):void; // fuc delcaration
}
//extending
interface  Human extends Alien
{
    (race :string, id :number,apetite?:string, name?:string,native?:string):void; 
}
//usage

var alien : Alien;
alien = (rac,id,native="name") => {  // here native mathes to name's type
    // Unlike objects, in Interfaces, names doesn't need to match and it will asign types in declaration order
    console.log("race ="+rac+"id ="+id+"native ="+native);
    // but if you want to assign value to any name you should use names in the declaration.
}
alien("Dragon",1,"salmandar","earth");//
//alien("Elfe",2,natie:"unknow"); // error unknow parameter.
alien("Elfe",2,"unknow"); // 3rd parm should be of name's type.

//extends

var human : Human;

human = (rac,id,nativ,name) =>{ // notice names are not equivalent
    console.log("race ="+rac+", id ="+id+", name ="+name+", native ="+nativ);
    //console.log("apetite"+apeti);
}
human("human",23,"Itachi");
human("human",23,"Itachi","earth");
human("huma n",222,"NV","sasuke","earth"); 

//double indexing
interface Shinobi
{
    [name:string]:string;
    speciality:string; // return type should be subtype of indexed return type.
}
var shinobi : Shinobi;
shinobi.itachi = "Fire Style";
shinobi.speciality = "mangakyo_sharingan";
shinobi.susuke = "Lightning Style";
shinobi.speciality = "eternal_mangakyo_sharinan";
shinobi.naruto = "Wind Style";
shinobi.speciality = "nine tails";
console.log(shinobi);



class Brand
{
    name :string;
    model :Model;
}
class Model
{
    price :number;
}