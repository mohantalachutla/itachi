import java.util.*;
import java.util.stream.*;
import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.function.*;


import javax.script.*;
import jdk.nashorn.api.scripting.*;

@FunctionalInterface
interface P
{
	void print(Object o);
}
public class TestReflection
{
	public static void main(String args[])
	{
		MainBlock mb =new MainBlock();
		//mb.declared(ScriptEngine.class);
		//mb.inherited(ScriptEngineManager.class);
		//mb.test(Base64.Encoder.class);
		mb.test(Annotated1.class);
		
		
		//ClassReflect clsRef = new ClassReflect(ScriptEngine.class, ScriptEngineManager.class, ScriptContext.class, Bindings.class, Invocable.class, ClassFilter.class);
		//clsRef.getMethodsBulk();
	}
}
		/*
		Class.class, Method.class, Field.class, Constructor.class, 
		Type.class, Annotation.class, Package.class, Optional.class
		
		Collections.class, Arrays.class, List.class, String.class
		*/
class MainBlock
{
	P p = System.out::println;
	void inherited(Class cls)
	{
		ClassReflect clsRef = new ClassReflect(cls);
		clsRef.getMethods();
		p.print("\n\n");
		clsRef.getFields();
		p.print("\n\n");
		clsRef.getConstructors();
	}
	void declared(Class cls)
	{
		ClassReflect clsRef = new ClassReflect(cls);
		clsRef.getDeclaredMethods();
		p.print("\n\n");
		clsRef.getDeclaredFields();
		p.print("\n\n");
		clsRef.getDeclaredConstructors();
	}
	void test(Class cls)	
	{
		//p.print("getEnclosingClass()"+cls.getEnclosingClass()); // upper class
		//p.print("getDeclaringClass()"+cls.getDeclaringClass()); // upper class
		p.print("getClasses");
		for(Class c : cls.getClasses()) p.print(c);
		p.print("getDeclaredClasses");
		for(Class c : cls.getDeclaredClasses()) p.print(c); // inner classes
		//p.print(cls.getClasses());
	}
}

class ClassReflect
{
	P p = System.out::println;
	private Parser parser = null;
	private Class cls = null;
	private Class[] clsArr = null;
	private int ind = 0;
	ClassReflect()
	{
		this.parser = new Parser();
	}
	ClassReflect(Class cls)
	{
		this.parser = new Parser();
		this.cls = cls;
	}
	ClassReflect(Class... args)
	{
		this.parser = new Parser();
		this.clsArr =new Class[100];
		this.ind=0;
		for(Class cls : args)
		{
			this.clsArr[this.ind] = cls;
			ind++;
		}
	}
	void getConstructors()
	{
		p.print("\ngetConstructors():\n");
		for(Constructor c:this.cls.getConstructors())
		{
			p.print(c.toString());
		}
	}
	void getDeclaredConstructors()
	{
		p.print("\ngetDeclaredConstructors():\n");
		for(Constructor c:this.cls.getDeclaredConstructors())
		{
			p.print(c.toString());
		}
	}
	
	void getFields()
	{
		p.print("\ngetFields():\n");
		for(Field f:this.cls.getFields())
		{
			p.print(f.toString());
		}
	}
	void getDeclaredFields()
	{
		p.print("\ngetDeclaredFields():\n");
		for(Field f:this.cls.getDeclaredFields())
		{
			p.print(f.toString());
		}
	}
	void getMethods()
	{
		p.print("\ngetMethods():\n");
		List<String> methods = new ArrayList();
		for(Method m:this.cls.getMethods())
		{
			methods.add(parser.parse(m));
		}
		methods.stream().sorted((s1,s2) -> s1.compareTo(s2)).forEach(s -> p.print(s));
	}
	void getDeclaredMethods()
	{
		p.print("\ngetDeclaredMethods():\n");
		List<String> methods = new ArrayList();
		for(Method m:this.cls.getDeclaredMethods())
		{
			methods.add(parser.parse(m));
		}
		methods.stream().sorted((s1,s2) -> s1.compareTo(s2)).forEach(s -> p.print(s));
	}
	void getMethodsBulk()
	{
		for(this.ind=0; this.ind <this.clsArr.length; ind++)
		{
			p.print(this.clsArr[this.ind].getName());
			this.cls = this.clsArr[this.ind];
			getMethods();
			p.print("\n\n");
		}
	}
}
/* class ConstructorReflect
{
	
}
class FieldReflect
{
	
}
class MethodReflect
{
	
}
class ParameterReflect
{
	
}
class TypeReflect
{
	
}
class AnnotationReflect
{
	
}*/

class Parser
{
	String parse(Method obj)
	{
		String method = obj.getName();
		String sign	= obj.toString();
		String ret1 = sign.substring(0,sign.indexOf(method)-1);
		String ret = ret1.substring(0,ret1.lastIndexOf(" "));
		String s = sign.substring(sign.indexOf(method),sign.indexOf(')')+1);
		return ret +"    "+ s;
	}
	String parse(Class obj)
	{
		String method = obj.getName();
		String sign	= obj.toString();
		String ret1 = sign.substring(0,sign.indexOf(method)-1);
		String ret = ret1.substring(0,ret1.lastIndexOf(" "));
		String s = sign.substring(sign.indexOf(method),sign.indexOf(')')+1);
		return ret +"    "+ s;
	}
}
/*
values must be initialised with default value.
void, List, map like type not applicable. Only primitives can be used in annotations.
*/

/* @Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Anno
{
	void value();
} */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Anno1
{
	int iValue() default 0;
}
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Anno2
{
	String sValue() default "nothing";
}
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Anno3
{
	String[] sArr() default {"nothing"};
}

/* @Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Anno4
{
	List<String> sList();
}
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Anno5
{
	Map<String,String> sMap();
} */

class Parent
{
	Parent()
	{
		System.out.println("constructor Parent.Parent()");
	}
	void parent()
	{
		System.out.println("method Parent.Parent()");
	}
}
class Child extends Annotated1
{
	Child()
	{
		System.out.println("constructor Parent.Parent()");
	}
	void child()
	{
		System.out.println("method Parent.Parent()");
	}
}
@Anno3(sArr = {"Sharingan","rennegan","byakuyan","jugan"})
class Annotated1 extends Parent
{
	class Inner
	{
		Inner()
		{
			System.out.println("constructor Inner.inner()");
		}
		void inner()
		{
			System.out.println("method Inner.inner()");
		}
	}
	
	@Anno2(sValue = "Itachi")
	String name;
	@Anno2
	String village;
	
	@Anno3(sArr = {"Sharingan","rennegan","byakuyan","jugan"})
	Annotated1()
	{
		
	}	
	//@Anno1 //not applicable @Target is not set
	Annotated1(int i, String s)
	{
		
	}
	
	@Anno3(sArr = {"Sharingan","rennegan","byakuyan","jugan"})
	void annotated(@Anno1(iValue = 23) int param1, @Anno3(sArr = {"Sharingan","rennegan","byakuyan","jugan"}) String[] param2)
	{
		//@Anno1 //not applicable @Target is not set
		int local;
		@Anno2
		String local1;
	}
}


/*
methods of Package.class

public boolean    equals(java.lang.Object)
public boolean    isAnnotationPresent(java.lang.Class)
public boolean    isCompatibleWith(java.lang.String)
public boolean    isSealed()
public boolean    isSealed(java.net.URL)
public final native java.lang.Class    getClass()
public final native void    notify()
public final native void    notifyAll()
public final native void    wait(long)
public final void    wait()
public final void    wait(long,int)
public int    hashCode()
public java.lang.String    getImplementationTitle()
public java.lang.String    getImplementationVendor()
public java.lang.String    getImplementationVersion()
public java.lang.String    getName()
public java.lang.String    getSpecificationTitle()
public java.lang.String    getSpecificationVendor()
public java.lang.String    getSpecificationVersion()
public java.lang.String    toString()
public java.lang.annotation.Annotation    getAnnotation(java.lang.Class)
public java.lang.annotation.Annotation    getDeclaredAnnotation(java.lang.Class)
public java.lang.annotation.Annotation[]    getAnnotations()
public java.lang.annotation.Annotation[]    getAnnotationsByType(java.lang.Class)
public java.lang.annotation.Annotation[]    getDeclaredAnnotations()
public java.lang.annotation.Annotation[]    getDeclaredAnnotationsByType(java.lang.Class)
public static java.lang.Package    getPackage(java.lang.String)
public static java.lang.Package[]    getPackages()

*/

/*
methods of Class.class

public boolean    desiredAssertionStatus()
public boolean    equals(java.lang.Object)
public boolean    isAnnotation()
public boolean    isAnnotationPresent(java.lang.Class)
public boolean    isAnonymousClass()
public boolean    isEnum()
public boolean    isLocalClass()
public boolean    isMemberClass()
public boolean    isSynthetic()
public final native java.lang.Class    getClass()
public final native void    notify()
public final native void    notifyAll()
public final native void    wait(long)
public final void    wait()
public final void    wait(long,int)
public java.io.InputStream    getResourceAsStream(java.lang.String)
public java.lang.Class    asSubclass(java.lang.Class)
public java.lang.Class    getDeclaringClass()
public java.lang.Class    getEnclosingClass()
public java.lang.ClassLoader    getClassLoader()
public java.lang.Class[]    getClasses()
public java.lang.Class[]    getDeclaredClasses()
public java.lang.Class[]    getInterfaces()
public java.lang.Object    cast(java.lang.Object)
public java.lang.Object    newInstance()
public java.lang.Object[]    getEnumConstants()
public java.lang.Package    getPackage()
public java.lang.String    getCanonicalName()
public java.lang.String    getName()
public java.lang.String    getSimpleName()
public java.lang.String    getTypeName()
public java.lang.String    toGenericString()
public java.lang.String    toString()
public java.lang.annotation.Annotation    getAnnotation(java.lang.Class)
public java.lang.annotation.Annotation    getDeclaredAnnotation(java.lang.Class)
public java.lang.annotation.Annotation[]    getAnnotations()
public java.lang.annotation.Annotation[]    getAnnotationsByType(java.lang.Class)
public java.lang.annotation.Annotation[]    getDeclaredAnnotations()
public java.lang.annotation.Annotation[]    getDeclaredAnnotationsByType(java.lang.Class)
public java.lang.reflect.AnnotatedType    getAnnotatedSuperclass()
public java.lang.reflect.AnnotatedType[]    getAnnotatedInterfaces()
public java.lang.reflect.Constructor    getConstructor(java.lang.Class[])
public java.lang.reflect.Constructor    getDeclaredConstructor(java.lang.Class[])
public java.lang.reflect.Constructor    getEnclosingConstructor()
public java.lang.reflect.Constructor[]    getConstructors()
public java.lang.reflect.Constructor[]    getDeclaredConstructors()
public java.lang.reflect.Field    getDeclaredField(java.lang.String)
public java.lang.reflect.Field    getField(java.lang.String)
public java.lang.reflect.Field[]    getDeclaredFields()
public java.lang.reflect.Field[]    getFields()
public java.lang.reflect.Method    getDeclaredMethod(java.lang.String,java.lang.Class[])
public java.lang.reflect.Method    getEnclosingMethod()
public java.lang.reflect.Method    getMethod(java.lang.String,java.lang.Class[])
public java.lang.reflect.Method[]    getDeclaredMethods()
public java.lang.reflect.Method[]    getMethods()
public java.lang.reflect.Type    getGenericSuperclass()
public java.lang.reflect.TypeVariable[]    getTypeParameters()
public java.lang.reflect.Type[]    getGenericInterfaces()
public java.net.URL    getResource(java.lang.String)
public java.security.ProtectionDomain    getProtectionDomain()
public native boolean    isArray()
public native boolean    isAssignableFrom(java.lang.Class)
public native boolean    isInstance(java.lang.Object)
public native boolean    isInterface()
public native boolean    isPrimitive()
public native int    getModifiers()
public native int    hashCode()
public native java.lang.Class    getComponentType()
public native java.lang.Class    getSuperclass()
public native java.lang.Object[]    getSigners()
public static java.lang.Class    forName(java.lang.String)
public static java.lang.Class    forName(java.lang.String,boolean,java.lang.ClassLoader)

*/


/*
Method.class

public boolean    equals(java.lang.Object)
public boolean    isAccessible()
public boolean    isAnnotationPresent(java.lang.Class)
public boolean    isBridge()
public boolean    isDefault()
public boolean    isSynthetic()
public boolean    isVarArgs()
public final native java.lang.Class    getClass()
public final native void    notify()
public final native void    notifyAll()
public final native void    wait(long)
public final void    wait()
public final void    wait(long,int)
public int    getModifiers()
public int    getParameterCount()
public int    hashCode()
public java.lang.Class    getDeclaringClass()
public java.lang.Class    getReturnType()
public java.lang.Class[]    getExceptionTypes()
public java.lang.Class[]    getParameterTypes()
public java.lang.Object    getDefaultValue()
public java.lang.Object    invoke(java.lang.Object,java.lang.Object[])
public java.lang.String    getName()
public java.lang.String    toGenericString()
public java.lang.String    toString()
public java.lang.annotation.Annotation    getAnnotation(java.lang.Class)
public java.lang.annotation.Annotation    getDeclaredAnnotation(java.lang.Class)
public java.lang.annotation.Annotation[]    getAnnotations()
public java.lang.annotation.Annotation[]    getAnnotationsByType(java.lang.Class)
public java.lang.annotation.Annotation[]    getDeclaredAnnotations()
public java.lang.annotation.Annotation[]    getDeclaredAnnotationsByType(java.lang.Class)
public java.lang.annotation.Annotation[][]    getParameterAnnotations()
public java.lang.reflect.AnnotatedType    getAnnotatedReceiverType()
public java.lang.reflect.AnnotatedType    getAnnotatedReturnType()
public java.lang.reflect.AnnotatedType[]    getAnnotatedExceptionTypes()
public java.lang.reflect.AnnotatedType[]    getAnnotatedParameterTypes()
public java.lang.reflect.Parameter[]    getParameters()
public java.lang.reflect.Type    getGenericReturnType()
public java.lang.reflect.TypeVariable[]    getTypeParameters()
public java.lang.reflect.Type[]    getGenericExceptionTypes()
public java.lang.reflect.Type[]    getGenericParameterTypes()
public static void    setAccessible(java.lang.reflect.AccessibleObject[],boolean)
public void    setAccessible(boolean)

*/

/*
Field.class

public boolean    equals(java.lang.Object)
public boolean    getBoolean(java.lang.Object)
public boolean    isAccessible()
public boolean    isAnnotationPresent(java.lang.Class)
public boolean    isEnumConstant()
public boolean    isSynthetic()
public byte    getByte(java.lang.Object)
public char    getChar(java.lang.Object)
public double    getDouble(java.lang.Object)
public final native java.lang.Class    getClass()
public final native void    notify()
public final native void    notifyAll()
public final native void    wait(long)
public final void    wait()
public final void    wait(long,int)
public float    getFloat(java.lang.Object)
public int    getInt(java.lang.Object)
public int    getModifiers()
public int    hashCode()
public java.lang.Class    getDeclaringClass()
public java.lang.Class    getType()
public java.lang.Object    get(java.lang.Object)
public java.lang.String    getName()
public java.lang.String    toGenericString()
public java.lang.String    toString()
public java.lang.annotation.Annotation    getAnnotation(java.lang.Class)
public java.lang.annotation.Annotation    getDeclaredAnnotation(java.lang.Class)
public java.lang.annotation.Annotation[]    getAnnotations()
public java.lang.annotation.Annotation[]    getAnnotationsByType(java.lang.Class)
public java.lang.annotation.Annotation[]    getDeclaredAnnotations()
public java.lang.annotation.Annotation[]    getDeclaredAnnotationsByType(java.lang.Class)
public java.lang.reflect.AnnotatedType    getAnnotatedType()
public java.lang.reflect.Type    getGenericType()
public long    getLong(java.lang.Object)
public short    getShort(java.lang.Object)
public static void    setAccessible(java.lang.reflect.AccessibleObject[],boolean)
public void    set(java.lang.Object,java.lang.Object)
public void    setAccessible(boolean)
public void    setBoolean(java.lang.Object,boolean)
public void    setByte(java.lang.Object,byte)
public void    setChar(java.lang.Object,char)
public void    setDouble(java.lang.Object,double)
public void    setFloat(java.lang.Object,float)
public void    setInt(java.lang.Object,int)
public void    setLong(java.lang.Object,long)
public void    setShort(java.lang.Object,short)
*/

/*
Constructor.class

public boolean    equals(java.lang.Object)
public boolean    isAccessible()
public boolean    isAnnotationPresent(java.lang.Class)
public boolean    isSynthetic()
public boolean    isVarArgs()
public final native java.lang.Class    getClass()
public final native void    notify()
public final native void    notifyAll()
public final native void    wait(long)
public final void    wait()
public final void    wait(long,int)
public int    getModifiers()
public int    getParameterCount()
public int    hashCode()
public java.lang.Class    getDeclaringClass()
public java.lang.Class[]    getExceptionTypes()
public java.lang.Class[]    getParameterTypes()
public java.lang.Object    newInstance(java.lang.Object[])
public java.lang.String    getName()
public java.lang.String    toGenericString()
public java.lang.String    toString()
public java.lang.annotation.Annotation    getAnnotation(java.lang.Class)
public java.lang.annotation.Annotation    getDeclaredAnnotation(java.lang.Class)
public java.lang.annotation.Annotation[]    getAnnotations()
public java.lang.annotation.Annotation[]    getAnnotationsByType(java.lang.Class)
public java.lang.annotation.Annotation[]    getDeclaredAnnotations()
public java.lang.annotation.Annotation[]    getDeclaredAnnotationsByType(java.lang.Class)
public java.lang.annotation.Annotation[][]    getParameterAnnotations()
public java.lang.reflect.AnnotatedType    getAnnotatedReceiverType()
public java.lang.reflect.AnnotatedType    getAnnotatedReturnType()
public java.lang.reflect.AnnotatedType[]    getAnnotatedExceptionTypes()
public java.lang.reflect.AnnotatedType[]    getAnnotatedParameterTypes()
public java.lang.reflect.Parameter[]    getParameters()
public java.lang.reflect.TypeVariable[]    getTypeParameters()
public java.lang.reflect.Type[]    getGenericExceptionTypes()
public java.lang.reflect.Type[]    getGenericParameterTypes()
public static void    setAccessible(java.lang.reflect.AccessibleObject[],boolean)
public void    setAccessible(boolean)
*/

/*
Annotation.class

public abstract boolean    equals(java.lang.Object)
public abstract int    hashCode()
public abstract java.lang.Class    annotationType()
public abstract java.lang.String    toString()
*/