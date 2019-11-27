
import java.nio.*;
import java.lang.annotation.*;
// what is locale
@FunctionalInterface
interface P{
	void print(Object o);
}
public class TestNIO
{
	public static void main(String[] args)
	{
		MainBlock mb = new MainBlock();
		mb.main();
	}
}
class MainBlock
{
	P p = System.out::println;
	P p2 = System.out::print;
	public void main()
	{
		p.print("main() -->");
	}
}