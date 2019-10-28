// destruct array
let intArr: number[];
let arr:number[];
intArr = [23,21,45,67];
let [a,b, ...v] = intArr;
console.log(a,b,v);
let c :number,d : number, e:number;
[a,b,c,d, ...arr] = intArr; //arr is empty here ... used to represent array while contructing and destructing
console.log(a,b,v);
[a,b,c,d,e, ...v] = intArr;
console.log(a,b,c,d,e,v); // e will be undefined
let [m,n,o,p,q] =intArr;
console.log(m,n,o,p,q); //q is undefined
[m,n] = intArr;
console.log(m,n);

// destruct tuple
type tptup = [number,string,boolean];
type tptup2 = [number,string,boolean?]; //here boolean is optional
let tup1 : [number, string, boolean] =[23,"mohan",true];
let age:number, name1:string, single:boolean;
[age,name1,single] = tup1;
console.log(age,name1,single);
let tup2: tptup2 = [32,"itachi"];
let tup3: tptup2 = [21, "sakura",true];
[age,name1,single =false] = tup2;
console.log(age,name1,single);
[age,name1] = tup2;
console.log(age,name1,single);
[age,name1,single] = tup3;
console.log(age,name1,single);


//destruct objects
type tpobj = {name1:string,age?:number};
let obj1 : tpobj = {name1:"mohan",age:23};
let obj2 : tpobj;
obj1 = {name1:"mohan"};
({name1,age} = obj1); // when it comes to obects property name must match for both type matching and destructing
({name1} = obj2);


//construct array
let conarr = [a,b,c, intArr];
conarr = [intArr,a,b,c];

//construct tuple
tup3 = [age,name1,single];

//construct object
obj1 = {name1,age};

