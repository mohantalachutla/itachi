import javax.script.*;
import java.lang.annotation.*;
import java.io.*;

@FunctionalInterface
interface P
{
	void print(Object o);
}
public class TestNashorn
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
	ScriptEngine se = null;
	void main()
	{
		try
		{
			se = new ScriptEngineManager().getEngineByName("Nashorn");
			p.print("ScriptEngine -> "+se);
			//exeScript();
			//exeScriptWithArgs("mohan");
			exeFun();
		}
		catch(ScriptException |FileNotFoundException |NoSuchMethodException e)
		{
			p.print("Exception ="+e.getMessage());
		}
	}
	void exeScript() throws ScriptException
	{
		se.eval("var firstName='Itachi'; var lastName='Uchiha'; var name ={'firstName':firstName,'lastName':lastName}; print('name ='+name); print('name.firstName ='+name.firstName);");
	}
	<T>void exeScriptWithArgs(T... args) throws ScriptException,FileNotFoundException
	{
		Bindings binder = se.getBindings(ScriptContext.ENGINE_SCOPE);
		binder.put("unknown",args[0]);
		binder.put("nonInitialized",args[0]);
		binder.put("initialized",args[0]);
		se.eval(new FileReader("TestNashornCallable.js"));
	}
	void exeFun() throws ScriptException, NoSuchMethodException, FileNotFoundException
	{
		se.eval(new FileReader("TestNashornInvocable.js"));
		Invocable js = (Invocable)se;
		js.invokeFunction("myFun");
		p.print("\n\n");
		
		js.invokeFunction("myFun2","Itachi","Uchiha","sharingan","HiddenLeaf"); // function got overwritten
		p.print("\n\n");
		
		js.invokeFunction("myFun3","Itachi","Uchiha"); // parameters to non-parameterized function
		//p.print("\n\n");
		
		js.invokeFunction("myFun2","Itachi"); 
		js.invokeFunction("myFun2","Itachi","Uchiha","sharingan","HiddenLeaf"); // // function got overwritten
		js.invokeFunction("myFun2","Itachi","uchiha");  // parameters missmatch
		js.invokeFunction("myFun2");  // not enough parameters
	}
}

/*
ScriptEngine.class

public abstract java.lang.Object    eval(java.io.Reader)
public abstract java.lang.Object    eval(java.io.Reader,javax.script.Bindings)
public abstract java.lang.Object    eval(java.io.Reader,javax.script.ScriptContext)
public abstract java.lang.Object    eval(java.lang.String)
public abstract java.lang.Object    eval(java.lang.String,javax.script.Bindings)
public abstract java.lang.Object    eval(java.lang.String,javax.script.ScriptContext)
public abstract java.lang.Object    get(java.lang.String)
public abstract javax.script.Bindings    createBindings()
public abstract javax.script.Bindings    getBindings(int)
public abstract javax.script.ScriptContext    getContext()
public abstract javax.script.ScriptEngineFactory    getFactory()
public abstract void    put(java.lang.String,java.lang.Object)
public abstract void    setBindings(javax.script.Bindings,int)
public abstract void    setContext(javax.script.ScriptContext)

*/


/*
ScriptEngineManager.class

public boolean    equals(java.lang.Object)
public final native java.lang.Class    getClass()
public final native void    notify()
public final native void    notifyAll()
public final native void    wait(long)
public final void    wait()
public final void    wait(long,int)
public java.lang.Object    get(java.lang.String)
public java.lang.String    toString()
public java.util.List    getEngineFactories()
public javax.script.Bindings    getBindings()
public javax.script.ScriptEngine    getEngineByExtension(java.lang.String)
public javax.script.ScriptEngine    getEngineByMimeType(java.lang.String)
public javax.script.ScriptEngine    getEngineByName(java.lang.String)
public native int    hashCode()
public void    put(java.lang.String,java.lang.Object)
public void    registerEngineExtension(java.lang.String,javax.script.ScriptEngineFactory)
public void    registerEngineMimeType(java.lang.String,javax.script.ScriptEngineFactory)
public void    registerEngineName(java.lang.String,javax.script.ScriptEngineFactory)
public void    setBindings(javax.script.Bindings)

*/

/*
ScriptContext.class

public abstract int    getAttributesScope(java.lang.String)
public abstract java.io.Reader    getReader()
public abstract java.io.Writer    getErrorWriter()
public abstract java.io.Writer    getWriter()
public abstract java.lang.Object    getAttribute(java.lang.String)
public abstract java.lang.Object    getAttribute(java.lang.String,int)
public abstract java.lang.Object    removeAttribute(java.lang.String,int)
public abstract java.util.List    getScopes()
public abstract javax.script.Bindings    getBindings(int)
public abstract void    setAttribute(java.lang.String,java.lang.Object,int)
public abstract void    setBindings(javax.script.Bindings,int)
public abstract void    setErrorWriter(java.io.Writer)
public abstract void    setReader(java.io.Reader)
public abstract void    setWriter(java.io.Writer)
*/

/*
Bindings.class

public abstract boolean    containsKey(java.lang.Object)
public abstract boolean    containsValue(java.lang.Object)
public abstract boolean    equals(java.lang.Object)
public abstract boolean    isEmpty()
public abstract int    hashCode()
public abstract int    size()
public abstract java.lang.Object    get(java.lang.Object)
public abstract java.lang.Object    put(java.lang.String,java.lang.Object)
public abstract java.lang.Object    remove(java.lang.Object)
public abstract java.util.Collection    values()
public abstract java.util.Set    entrySet()
public abstract java.util.Set    keySet()
public abstract void    clear()
public abstract void    putAll(java.util.Map)
public default boolean    remove(java.lang.Object,java.lang.Object)
public default boolean    replace(java.lang.Object,java.lang.Object,java.lang.Object)
public default java.lang.Object    compute(java.lang.Object,java.util.function.BiFunction)
public default java.lang.Object    computeIfAbsent(java.lang.Object,java.util.function.Function)
public default java.lang.Object    computeIfPresent(java.lang.Object,java.util.function.BiFunction)
public default java.lang.Object    getOrDefault(java.lang.Object,java.lang.Object)
public default java.lang.Object    merge(java.lang.Object,java.lang.Object,java.util.function.BiFunction)
public default java.lang.Object    put(java.lang.Object,java.lang.Object)
public default java.lang.Object    putIfAbsent(java.lang.Object,java.lang.Object)
public default java.lang.Object    replace(java.lang.Object,java.lang.Object)
public default void    forEach(java.util.function.BiConsumer)
public default void    replaceAll(java.util.function.BiFunction)

*/

/*
Invocable.java

public abstract java.lang.Object    getInterface(java.lang.Class)
public abstract java.lang.Object    getInterface(java.lang.Object,java.lang.Class)
public abstract java.lang.Object    invokeFunction(java.lang.String,java.lang.Object[])
public abstract java.lang.Object    invokeMethod(java.lang.Object,java.lang.String,java.lang.Object[])
*/