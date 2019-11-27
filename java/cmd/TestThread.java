import java.util.*;
import java.util.concurrent.*;
import java.lang.annotation.*;

@FunctionalInterface
interface P{
	void print(Object o);
}
public class TestThread
{
	public static void main(String[] args)
	{
		MainBlock mb = new MainBlock();
		mb.main();
	}
}
class MainBlock
{
	Thread t = null, t1 = null, t2 = null, t3 = null, t4 = null, t5 = null;
	ExecutorService es = null;
	Runtime run = null;
	P p = System.out::println;
	P p2 = System.out::print;
	public void main()
	{
		try
		{
			p.print("in main --> currentThread().getName() -->"+Thread.currentThread().getName());
			//threads();
			//pool();
			//group();
			runtime();
		}
		catch(Exception e) {p.print("exception ->"+e);}
	}
	void threads() throws Exception
	{
		// IllegalThreadStateException, can't start same thred twice
		// can call run method directly cause its will loose its thread property.
		// Each thread creates new call stack, invoking run directly will not create call stack, simply replaces calling method in existing call stack
		//in run method, thread operations take place.
		// new state when thread created. runnable state when start method invoked, running state when run method invoked, non-runnable {blocked} stated on wait, sleep,yield. terminated state on destroy, stop
		// jvm's thread shedular calls runnable threads based on priorities.
		t = new Thread1("itachi-1");
		t1 = new Thread1("leeluch-2");
		t2 = new Thread2("pain-3");
		t3 = new Thread(new Runnable1("kensen-4"),"kensen-4");
		t4 = new Thread(new Runnable2("tanjiro-5"),"tanjiro-5");
		t5 = new Thread(new Runnable2("sasuke-6"),"sasuke-6");
		t.setDaemon(true);
		t.start();
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.setPriority(Thread.NORM_PRIORITY); // getPriority()
		t2.start();
		t3.setPriority(Thread.NORM_PRIORITY);
		t3.join(); // makes other threads wait until t3 got executed.
		t3.start();
		t4.setPriority(Thread.MAX_PRIORITY);
		t4.start();
		t5.setPriority(Thread.NORM_PRIORITY);
		t5.start();
	}
	void pool() throws Exception
	{
		es = Executors.newFixedThreadPool(3); // can holds only 3 threads only at max, remaining will be added as once get complete.
		t = new Thread1("itachi-1");
		t1 = new Thread1("leeluch-2");
		t2 = new Thread2("pain-3");
		t3 = new Thread(new Runnable1("kensen-4"),"kensen-4");
		t4 = new Thread(new Runnable2("tanjiro-5"),"tanjiro-5");
		t5 = new Thread(new Runnable2("sasuke-6"),"sasuke-6");
		t.setDaemon(true);
		es.execute(t);
		t1.setPriority(Thread.MIN_PRIORITY);
		es.execute(t1);
		t2.setPriority(Thread.NORM_PRIORITY); // getPriority()
		es.execute(t2);
		t3.setPriority(Thread.NORM_PRIORITY);
		t3.join(); // makes other threads wait until t3 got executed.
		es.execute(t3);
		t4.setPriority(Thread.MAX_PRIORITY);
		es.execute(t4);
		t5.setPriority(Thread.NORM_PRIORITY);
		es.execute(t5);
	}
	void group() throws Exception
	{
		ThreadGroup tg = new ThreadGroup("Naruto");
		ThreadGroup tg1 = new ThreadGroup("Lengends");
		t = new Thread1(tg,"itachi-1");
		t1 = new Thread1(tg1,"leeluch-2");
		t2 = new Thread2(tg,"pain-3");
		t3 = new Thread(tg1,new Runnable1("kensen-4"),"kensen-4");
		t4 = new Thread(tg1,new Runnable2("tanjiro-5"),"tanjiro-5");
		t5 = new Thread(tg,new Runnable2("sasuke-6"),"sasuke-6");
		prioritizeCall();
	}
	void runtime()
	{
		run = Runtime.getRuntime();
		p.print("availableProcessors() -->"+run.availableProcessors());
		p.print("freeMemory() -->"+run.freeMemory());
		p.print("maxMemory() -->"+run.maxMemory());
		p.print("totalMemory() -->"+run.totalMemory());
		run.gc(); // used for manual garbge collection will invoke Object.finalize()
		t = new ShudownThread();
		run.addShutdownHook(t);
		run.exit(0);
		run.removeShutdownHook(t);
	}
	void normalCall() throws Exception
	{
		t.start();
		t1.start();
		t2.start();
		t3.join(); // makes other threads wait until t3 got executed.
		t3.start();
		t4.start();
		t5.start();
	}
	void prioritizeCall() throws Exception
	{
		t.setDaemon(true);
		t.start();
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.setPriority(Thread.NORM_PRIORITY); // getPriority()
		t2.start();
		t3.setPriority(Thread.NORM_PRIORITY);
		t3.join(); // makes other threads wait until t3 got executed.
		t3.start();
		t4.setPriority(Thread.MAX_PRIORITY);
		t4.start();
		t5.setPriority(Thread.NORM_PRIORITY);
		t5.start();
	}
}


class Thread1 extends Thread 
{
	P p = System.out::println;
	P p2 = System.out::print;
	private String shinobi = "";
	public Thread1()
	{
		
	}
	public Thread1(String name)
	{
		super(name);
		this.shinobi = name;
	}
	public Thread1(ThreadGroup gname, String name)
	{
		super(gname,name);
		this.shinobi = name;
	}
	public void run()// thread operations take place.
	{
		try{
			Thread.sleep(2000);
			Thread ths = Thread.currentThread();
			ThreadGroup tg = ths.getThreadGroup();
			String name = ths.getName();
			p.print("shinobi ="+this.shinobi+",name ="+name+", isDaemon() ="+ths.isDaemon()+", getPriority() ="+ths.getPriority());
			p.print("group-name ="+tg.getName()+", isDaemon() ="+tg.isDaemon()+", getMaxPriority() ="+tg.getMaxPriority());
		}
		catch(Exception e) {p.print("exceptions =>"+e);}
	}
}
class Thread2 extends Thread
{
	P p = System.out::println;
	P p2 = System.out::print;
	private String shinobi = "";
	public Thread2()
	{
		
	}
	public Thread2(String name)
	{
		super(name);
		this.shinobi = name;
	}
	public Thread2(ThreadGroup gname, String name)
	{
		super(gname,name);
		this.shinobi = name;
	}
	public void run() // thread operations take place.
	{
		try
		{
			Thread.sleep(1000);
			Thread ths = Thread.currentThread();
			ThreadGroup tg = ths.getThreadGroup();
			String name = ths.getName();
			p.print("shinobi ="+this.shinobi+",name ="+name+", isDaemon() ="+ths.isDaemon()+", getPriority() ="+ths.getPriority());
			p.print("group-name ="+tg.getName()+", isDaemon() ="+tg.isDaemon()+", getMaxPriority() ="+tg.getMaxPriority());
			for(int i = 0; i < 5; i++) 
			{
				p.print("shinobi ="+this.shinobi+",name ="+name+",group-name ="+tg.getName()+", i="+i);
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {p.print("exceptions =>"+e);}
	}
}
class Runnable1 implements Runnable
{
	P p = System.out::println;
	P p2 = System.out::print;
	private String shinobi = "";
	public Runnable1()
	{
		
	}
	public Runnable1(String name)
	{
		this.shinobi = name;
	}
	public void run()// thread operations take place.
	{
		try
		{
			Thread.sleep(4000);
			Thread ths = Thread.currentThread();
			ThreadGroup tg = ths.getThreadGroup();
			String name = ths.getName();
			p.print("shinobi ="+this.shinobi+",name="+name+", isDaemon() ="+ths.isDaemon()+", getPriority() ="+ths.getPriority());
			p.print("group-name ="+tg.getName()+", isDaemon() ="+tg.isDaemon()+", getMaxPriority() ="+tg.getMaxPriority());
		}
		catch(Exception e) {p.print("exceptions =>"+e);}
	}
}
class Runnable2 implements Runnable
{
	P p = System.out::println;
	P p2 = System.out::print;
	private String shinobi = "";
	public Runnable2()
	{
		
	}
	public Runnable2(String name)
	{
		this.shinobi = name;
	}
	public void run()// thread operations take place.
	{
		try
		{
			Thread.sleep(2000);
			Thread ths = Thread.currentThread();
			ThreadGroup tg = ths.getThreadGroup();
			String name = ths.getName();
			p.print("shinobi ="+this.shinobi+",name ="+name+", isDaemon() ="+ths.isDaemon()+", getPriority() ="+ths.getPriority());
			p.print("group-name ="+tg.getName()+", isDaemon() ="+tg.isDaemon()+", getMaxPriority() ="+tg.getMaxPriority());
			for(int i = 0; i < 5; i++) 
			{
				p.print("shinobi ="+this.shinobi+",name ="+name+",group-name ="+tg.getName()+", i="+i);
				Thread.sleep(2000);
				if(i == 2) ths.yield();
			}
		}
		catch(Exception e) {p.print("exceptions =>"+e);}
	}
}
class ShudownThread extends Thread
{
	P p = System.out::println;
	P p2 = System.out::print;
	public void run()
	{
		try
		{
			p.print("JVM Shutting down...");
			Thread.sleep(3000);
			p.print("JVM Shutdown.");
		}
		catch(Exception e) {p.print("Exception -->"+e);}
	}
}
// yeild, wait, notify, notifyAll, interrupt, join
// thread group, group a threads using name
// thread pool, creating a thread pool of fixed size
// shutdown hook, functinality of JVM, will invoke Runtime.addShutdownHook() on shutdown


/*
Thread.class
getDeclaredMethods():
private native boolean    isInterrupted(boolean)
private native void    interrupt0()
private native void    resume0()
private native void    setNativeName(java.lang.String)
private native void    setPriority0(int)
private native void    start0()
private native void    stop0(java.lang.Object)
private native void    suspend0()
private static boolean    auditSubclass(java.lang.Class)
private static boolean    isCCLOverridden(java.lang.Class)
private static native java.lang.StackTraceElement[][]    dumpThreads(java.lang.Thread[])
private static native java.lang.Thread[]    getThreads()
private static native void    registerNatives()
private static synchronized int    nextThreadNum()
private static synchronized long    nextThreadID()
private void    dispatchUncaughtException(java.lang.Throwable)
private void    exit()
private void    init(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String,long)
private void    init(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String,long,java.security.AccessControlContext,
protected java.lang.Object    clone()
public boolean    isInterrupted()
public final boolean    isDaemon()
public final int    getPriority()
public final java.lang.String    getName()
public final java.lang.ThreadGroup    getThreadGroup()
public final native boolean    isAlive()
public final synchronized void    join(long)
public final synchronized void    join(long,int)
public final synchronized void    setName(java.lang.String)
public final synchronized void    stop(java.lang.Throwable)
public final void    checkAccess()
public final void    join()
public final void    resume()
public final void    setDaemon(boolean)
public final void    setPriority(int)
public final void    stop()
public final void    suspend()
public java.lang.ClassLoader    getContextClassLoader()
public java.lang.StackTraceElement[]    getStackTrace()
public java.lang.String    toString()
public java.lang.Thread$State    getState()
public java.lang.Thread$UncaughtExceptionHandler    getUncaughtExceptionHandler()
public long    getId()
public native int    countStackFrames()
public static boolean    interrupted()
public static int    activeCount()
public static int    enumerate(java.lang.Thread[])
public static java.lang.Thread$UncaughtExceptionHandler    getDefaultUncaughtExceptionHandler()
public static java.util.Map    getAllStackTraces()
public static native boolean    holdsLock(java.lang.Object)
public static native java.lang.Thread    currentThread()
public static native void    sleep(long)
public static native void    yield()
public static void    dumpStack()
public static void    setDefaultUncaughtExceptionHandler(java.lang.Thread$UncaughtExceptionHandler)
public static void    sleep(long,int)
public synchronized void    start()
public void    destroy()
public void    interrupt()
public void    run()
public void    setContextClassLoader(java.lang.ClassLoader)
public void    setUncaughtExceptionHandler(java.lang.Thread$UncaughtExceptionHandler)
static void    processQueue(java.lang.ref.ReferenceQueue,java.util.concurrent.ConcurrentMap)
void    blockedOn(sun.nio.ch.Interruptible)

getDeclaredFields():
private volatile java.lang.String java.lang.Thread.name
private int java.lang.Thread.priority
private java.lang.Thread java.lang.Thread.threadQ
private long java.lang.Thread.eetop
private boolean java.lang.Thread.single_step
private boolean java.lang.Thread.daemon
private boolean java.lang.Thread.stillborn
private java.lang.Runnable java.lang.Thread.target
private java.lang.ThreadGroup java.lang.Thread.group
private java.lang.ClassLoader java.lang.Thread.contextClassLoader
private java.security.AccessControlContext java.lang.Thread.inheritedAccessControlContext
private static int java.lang.Thread.threadInitNumber
java.lang.ThreadLocal$ThreadLocalMap java.lang.Thread.threadLocals
java.lang.ThreadLocal$ThreadLocalMap java.lang.Thread.inheritableThreadLocals
private long java.lang.Thread.stackSize
private long java.lang.Thread.nativeParkEventPointer
private long java.lang.Thread.tid
private static long java.lang.Thread.threadSeqNumber
private volatile int java.lang.Thread.threadStatus
volatile java.lang.Object java.lang.Thread.parkBlocker
private volatile sun.nio.ch.Interruptible java.lang.Thread.blocker
private final java.lang.Object java.lang.Thread.blockerLock
public static final int java.lang.Thread.MIN_PRIORITY
public static final int java.lang.Thread.NORM_PRIORITY
public static final int java.lang.Thread.MAX_PRIORITY
private static final java.lang.StackTraceElement[] java.lang.Thread.EMPTY_STACK_TRACE
private static final java.lang.RuntimePermission java.lang.Thread.SUBCLASS_IMPLEMENTATION_PERMISSION
private volatile java.lang.Thread$UncaughtExceptionHandler java.lang.Thread.uncaughtExceptionHandler
private static volatile java.lang.Thread$UncaughtExceptionHandler java.lang.Thread.defaultUncaughtExceptionHandler
long java.lang.Thread.threadLocalRandomSeed
int java.lang.Thread.threadLocalRandomProbe
int java.lang.Thread.threadLocalRandomSecondarySeed

getDeclaredConstructors():
java.lang.Thread(java.lang.Runnable,java.security.AccessControlContext)
public java.lang.Thread(java.lang.Runnable)
public java.lang.Thread()
public java.lang.Thread(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String)
public java.lang.Thread(java.lang.Runnable,java.lang.String)
public java.lang.Thread(java.lang.ThreadGroup,java.lang.String)
public java.lang.Thread(java.lang.String)
public java.lang.Thread(java.lang.ThreadGroup,java.lang.Runnable)
public java.lang.Thread(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String,long)
*/

/*
Runnable.class
methods:
public abstract void    run()
*/

/*
Executors.class
public static java.util.concurrent.Callable    callable(java.lang.Runnable)
public static java.util.concurrent.Callable    callable(java.lang.Runnable,java.lang.Object)
public static java.util.concurrent.Callable    callable(java.security.PrivilegedAction)
public static java.util.concurrent.Callable    callable(java.security.PrivilegedExceptionAction)
public static java.util.concurrent.Callable    privilegedCallable(java.util.concurrent.Callable)
public static java.util.concurrent.Callable    privilegedCallableUsingCurrentClassLoader(java.util.concurrent.Callable)
public static java.util.concurrent.ExecutorService    newCachedThreadPool()
public static java.util.concurrent.ExecutorService    newCachedThreadPool(java.util.concurrent.ThreadFactory)
public static java.util.concurrent.ExecutorService    newFixedThreadPool(int)
public static java.util.concurrent.ExecutorService    newFixedThreadPool(int,java.util.concurrent.ThreadFactory)
public static java.util.concurrent.ExecutorService    newSingleThreadExecutor()
public static java.util.concurrent.ExecutorService    newSingleThreadExecutor(java.util.concurrent.ThreadFactory)
public static java.util.concurrent.ExecutorService    newWorkStealingPool()
public static java.util.concurrent.ExecutorService    newWorkStealingPool(int)
public static java.util.concurrent.ExecutorService    unconfigurableExecutorService(java.util.concurrent.ExecutorService)
public static java.util.concurrent.ScheduledExecutorService    newScheduledThreadPool(int)
public static java.util.concurrent.ScheduledExecutorService    newScheduledThreadPool(int,java.util.concurrent.ThreadFactory)
public static java.util.concurrent.ScheduledExecutorService    newSingleThreadScheduledExecutor()
public static java.util.concurrent.ScheduledExecutorService    newSingleThreadScheduledExecutor(java.util.concurrent.ThreadFactory)
public static java.util.concurrent.ScheduledExecutorService    unconfigurableScheduledExecutorService(java.util.concurrent.ScheduledExecutorService)
public static java.util.concurrent.ThreadFactory    defaultThreadFactory()
*/
/*
ExecuteService.class
public abstract boolean    awaitTermination(long,java.util.concurrent.TimeUnit)
public abstract boolean    isShutdown()
public abstract boolean    isTerminated()
public abstract java.lang.Object    invokeAny(java.util.Collection)
public abstract java.lang.Object    invokeAny(java.util.Collection,long,java.util.concurrent.TimeUnit)
public abstract java.util.List    invokeAll(java.util.Collection)
public abstract java.util.List    invokeAll(java.util.Collection,long,java.util.concurrent.TimeUnit)
public abstract java.util.List    shutdownNow()
public abstract java.util.concurrent.Future    submit(java.lang.Runnable)
public abstract java.util.concurrent.Future    submit(java.lang.Runnable,java.lang.Object)
public abstract java.util.concurrent.Future    submit(java.util.concurrent.Callable)
public abstract void    shutdown()
*/

/*
Runtime.class
private static native void    runFinalization0()
public boolean    removeShutdownHook(java.lang.Thread)
public java.io.InputStream    getLocalizedInputStream(java.io.InputStream)
public java.io.OutputStream    getLocalizedOutputStream(java.io.OutputStream)
public java.lang.Process    exec(java.lang.String)
public java.lang.Process    exec(java.lang.String,java.lang.String[])
public java.lang.Process    exec(java.lang.String,java.lang.String[],java.io.File)
public java.lang.Process    exec(java.lang.String[])
public java.lang.Process    exec(java.lang.String[],java.lang.String[])
public java.lang.Process    exec(java.lang.String[],java.lang.String[],java.io.File)
public native int    availableProcessors()
public native long    freeMemory()
public native long    maxMemory()
public native long    totalMemory()
public native void    gc()
public native void    traceInstructions(boolean)
public native void    traceMethodCalls(boolean)
public static java.lang.Runtime    getRuntime()
public static void    runFinalizersOnExit(boolean)
public void    addShutdownHook(java.lang.Thread)
public void    exit(int)
public void    halt(int)
public void    load(java.lang.String)
public void    loadLibrary(java.lang.String)
public void    runFinalization()
synchronized void    load0(java.lang.Class,java.lang.String)
synchronized void    loadLibrary0(java.lang.Class,java.lang.String)

getDeclaredFields():
private static java.lang.Runtime java.lang.Runtime.currentRuntime

getDeclaredConstructors():
private java.lang.Runtime()*/