let name = 'mohan';
let age = 23;
let percent = 84.3;
let sex = 'M';
let arr = [1,344,33,44,48];
let student1 = {name : 'mohan', age :23, percent :84.3, sex : 'M'};

let intBuff;
//let intBuff = new Buffer(4);  // deprecated
intBuff =Buffer.alloc(4);  // size
intBuff.write(name,1,3,'utf-8'); 
console.log(intBuff);
console.log(intBuff.toString("utf-8",1,3));


//let intBuff = new Buffer();
intBuff = Buffer.from(arr);
console.log(intBuff);



let setInt = setInterval(()=>{console.log("every 3 more sec");},3000);
let setTimout = setTimeout(()=>{clearInterval(setInt);},10000);
//  clearTimeout(setTimout);
let setImmd = setImmediate(()=>{console.log("let's see");},3000);  // find out
clearImmediate(setImmd);

