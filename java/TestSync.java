import java.util.*;
import java.lang.annotation.*;
import java.util.concurrent.*;
/*
synchronization, process of locking a object or resource until the op completes. Others thread can not perform op.
static synchronization where resource will be class but not instance.
block syschronizaion proto: synchronized(Object o) {code...}
static block syschronizaion proto: synchronized(Class c) {code...}
delock, where thread needs resource locked by another thread which is doing the same
*/
@FunctionalInterface
interface P
{
	void print(Object o);
}
public class TestSync
{
	public static void main(String[] args)
	{
		MainBlock mb = new MainBlock();
		mb.sync();
	}
}
class Status
{
	public static boolean isDone(Thread thread)
	{
		while(thread.isAlive()){}
		return true;
	}
}
class MainBlock
{
	P p = System.out::println;
	P p2 = System.out::print;
	Bank 	leaf = null;
	Account sasuke = null;
	Account itachi = null;
	
	Runnable run = null, run1 = null, run2 = null;
	Thread thd = null , thd1 = null, thd2 = null;
	
	public void sync()
	{
		leaf = new Bank("LeafBank",1);
		sasuke = new Account("sasuke",2,100);
		itachi = new Account("itachi",1,500);
		display(leaf,itachi,sasuke);
		// sasuke <- itachi
		transferIt(leaf,itachi,sasuke, 100);
		sasuke.setStatus(false);
		transferIt(leaf,itachi,sasuke, 300);
		addIt(itachi,300); // will be invoke after the completion of above Op
		try{
			leaf.processOutStand();
		}
		catch(Exception e) {p.print(e);}
		display(leaf);
		sasuke.setStatus(true);
		try{
			leaf.processOutStand();
		}
		catch(Exception e) {p.print(e);}
		display(leaf,itachi,sasuke);
	}
	void addIt(Account acc,int amount)
	{
		run = new Runnable() {
			public void run()
			{
				try{
					acc.add(amount);
				}
				catch(Exception e) {p.print(e);}
			}
		};
		(thd = new Thread(run,"addIt")).start();
		if(Status.isDone(thd)) display(acc);
	}
	void transferIt(Bank bank,Account acc1,Account acc2, int amount)
	{
		run = new Runnable() {
			public void run()
			{
				try{
					bank.transfer(acc1,acc2,amount);
				}
				catch(Exception e) {p.print(e);}
			}
		};
		(thd = new Thread(run,"transferIt")).start();
		if(Status.isDone(thd)) display(bank,acc1,acc2);
	}
	void display(Bank bank)
	{
		p.print("Bank ->"+bank);
		p.print("\n");
	}
	void display(Account... accs)
	{
		for(Account acc : accs)
		{
			p.print("Acc ->"+acc);
		}
		p.print("\n");
	}
	void display(Bank bank, Account... accs)
	{
		p.print("Bank ->"+bank);
		for(Account acc : accs)
		{
			p.print("Acc ->"+acc);
		}
		p.print("\n");
	}
}
class Account
{
	private String holderName;
	private int id;
	private int balance;
	private boolean status = true;
	public Account(String name, int id, int amount)
	{
		this.holderName = name;
		this.id = id;
		this.balance = amount;
	}
	void delay(long sec) throws Exception
	{
		Thread.sleep(sec);
	}
	private void validate(int amount) throws Exception
	{
		if(amount < 0 )
		{
			throw new InvalidAmount();
		}
	}
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	public boolean getStatus()
	{
		return this.status;
	}
	public void checkStatus() throws Exception
	{
		delay(2000);
		if(this.status == false) throw new InActiveAccount();
	}
	public synchronized int add(int amount) throws Exception
	{
		delay(3000);
		checkStatus();
		validate(amount);
		this.balance += amount;
		return this.balance;
	}
	public synchronized int deduct(int amount) throws Exception
	{
		delay(3000);
		checkStatus();
		validate(amount);
		if(amount <= this.balance)
		{
			this.balance -= amount;
		}
		else
		{
			throw new InsufficientFunds();
		}
		return this.balance;
	}
	public String getName()
	{
		return this.holderName;
	}
	public int getId()
	{
		return this.id;
	}
	public synchronized int getBalance() throws Exception
	{
		delay(4000);
		return this.balance;
	}
	@Override
	public synchronized String toString()
	{
		return "[holderName:"+this.holderName+", id:"+this.id+", balance:"+this.balance+"]";
	}
}
class Bank
{
	P p = System.out::println;
	P p2 = System.out::print;
	private class OutStanding
	{
		//getters and setters
		int amount;
		Account from;
		Account to;
		OutStanding(Account from, Account to,int amount)
		{
			this.amount = amount;
			this.from = from;
			this.to = to;
		}
		@Override
		public String toString()
		{
			return "[from:"+this.from+", to:"+this.to+", amount:"+this.amount+"]";
		}
	}
	List<OutStanding> outStanding;
	private String name;
	private int id;
	public Bank(String name,int id)
	{
		super();
		this.name = name;
		this.outStanding = new ArrayList();
		this.id = id;
	}
	public synchronized void transfer(Account from, Account to, int amount) throws Exception
	{
		from.deduct(amount);
		try
		{
			to.add(amount);
		}
		catch(Exception e){outStanding.add(new OutStanding(from, to, amount));}
	}
	public void processOutStand() throws Exception
	{
		for(OutStanding o : this.outStanding)
		{
			o.to.add(o.amount);
			o.amount = 0;
		}
	}
/* 	public synchronized int add(int amount)
	{
		this.outStanding += amount;
		return this.outStanding;
	} */
/* 	public synchronized void deduct(int amount)
	{
		this.outStanding -= amount;
	} */
	@Override
	public synchronized String toString()
	{
		return "[name:"+this.name+", id:"+this.id+", outStanding:"+this.outStanding+"]";
	}
}
class InsufficientFunds extends Exception
{
	@Override
	public String toString()
	{
		return "InsufficientFunds...";
	}
}
class InvalidAmount extends Exception
{
	@Override
	public String toString()
	{
		return "InvalidAmount...";
	}
}
class InActiveAccount extends Exception
{
	@Override
	public String toString()
	{
		return "InActiveAccount...";
	}
}