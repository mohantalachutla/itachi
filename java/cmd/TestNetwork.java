import java.util.*;
import java.lang.annotation.*;

@FunctionalInterface
interface P{
	void print(Object o);
}
public class TestNetwork
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