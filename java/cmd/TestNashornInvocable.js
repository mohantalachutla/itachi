
var myFun = function()
{
	var firstName = 'Itachi';
	var lastName = 'Uchiha';
	var name = {"firstName" :firstName,  "lastName" :lastName};
	var ability = "sharingan"
	var village = "Hidden Leaf"
	var data = { "name" :name, "ability" :ability, "village" :village};
	
	print("name ="+name);
	print("name.firstName ="+name.firstName);
	print("name.lastName ="+name.lastName);
	print("ability ="+ability);
	print("village ="+village);
	print("data ="+data);
	print("data.name.firstName ="+data.name.firstName);
	print("data.ability ="+data.ability);
}