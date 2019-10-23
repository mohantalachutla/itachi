// jjs -scripting TestNashornJava.js
// command to execute .js from cmd

//alert("not okay");  // not defined
//window.confirm("is okay"); // not defined
//document.alert("is okay"); // not defined

print("Executing via Nashorn");

var myfun = function()
{
	// It's should neither be declared nor initialized to see the bindings effect.
	var nonInitialized;
	var initialized = "init";
	var a = 3;
	var b = 3;
	var sum = a+b;
	var firstName = 'Itachi';
	var lastName = 'Uchiha';
	var name = {"firstName" :firstName,  "lastName" :lastName};
	var ability = "sharingan"
	var village = "Hidden Leaf"
	var data = { "name" :name, "ability" :ability, "village" :village};
	print("a ="+a);
	print("b ="+b);
	print("sum ="+sum);
	print("name ="+name);
	print("name.firstName ="+name.firstName);
	print("name.lastName ="+name.lastName);
	print("ability ="+ability);
	print("village ="+village);
	print("data ="+data);
	print("data.name.firstName ="+data.name.firstName);
	print("data.ability ="+data.ability);
	print("unknown="+unknown);
	print("nonInitialized="+nonInitialized);
	print("initialized="+initialized);
}
myfun();