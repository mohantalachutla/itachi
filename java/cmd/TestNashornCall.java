
print("calling java from js");

var _util_ = new JavaImporter(java.util);

var arrList = new _util_.ArrayList();
arrList.add("Itachi");
arrList.add("mohan");
arrList.add("sasuke");
print("arrList =>"+arrList);


with(_util_)
{
	var arrList1  = new ArrayList();
	arrList1.add(1);
	arrList1.add(2);
	arrList1.add(3);
	print("arrList1 =>"+arrList1);
}