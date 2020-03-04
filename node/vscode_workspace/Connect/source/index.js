
import {doLogin,loading,a,b} from "./js/test";
//import "./css/test.css"; 
import "./sass/test"
import * as ts from "./ts/test";

//loading();
//doLogin();
//ts.alertTS("ts is up running");
//ts.loadingTS();
//ts.writeTS();

console.log(JSON.stringify(a));
document.write(JSON.stringify(a));
document.write("<br><br>");

document.write(JSON.stringify(b));
document.write("<br><br>");

var count=0;
var c=0;

var ab = __.mergeWith(a,b,function(val1,val2){
    c++;
    document.write(typeof(val1)+",");
    if(__.isArray(val1))
    {
        count++;
        return val1.concat(val2);
    }
});

document.write(JSON.stringify(ab));
document.write("<br><br>");
document.write("count"+count+"\n");
document.write("invoked"+c);