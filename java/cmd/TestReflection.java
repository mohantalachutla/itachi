import java.util.*;
import java.util.stream.*;
import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.function.*;

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
		mb.main();
	}
}
class MainBlock
{
	P p = System.out::println;
	void main()
	{
		/*
		Class.class, Method.class, Field.class, Constructor.class, 
		Type.class, Annotation.class, Package.class,
		
		List.class, String.class
		*/
		getMethods(Annotation.class);
		//getConstructors(Method.class);
		//getFields(Method.class);
		//getDeclaredMethods(String.class);
		//getDeclaredFields(String.class);
		//getDeclaredConstructors(String.class);
	}
	
	void getMethods(Class cls)
	{
		p.print("\n getMethods()\n\n\n");
		List<String> methods = new ArrayList();
		for(Method m:cls.getMethods())
		{
			methods.add(parse(m));
		}
		methods.stream().sorted((s1,s2) -> s1.compareTo(s2)).forEach(s -> p.print(s));
	}
	void getDeclaredMethods(Class cls)
	{
		p.print("\n getDeclaredMethods()\n\n\n");
		List<String> methods = new ArrayList();
		for(Method m:cls.getDeclaredMethods())
		{
			methods.add(parse(m));
		}
		methods.stream().sorted((s1,s2) -> s1.compareTo(s2)).forEach(s -> p.print(s));
	}
	
	void getDeclaredFields(Class cls)
	{
		p.print("\n getDeclaredFields()\n\n\n");
		List<String> fields = new ArrayList();
		for(Field f:cls.getDeclaredFields())
		{
			fields.add(f.toString());
		}
	}
	
	
	String parse(Method m)
	{
		String method = m.getName();
		String sign	= m.toString();
		String ret1 = sign.substring(0,sign.indexOf(method)-1);
		String ret = ret1.substring(0,ret1.lastIndexOf(" "));
		String s = sign.substring(sign.indexOf(method),sign.indexOf(')')+1);
		return ret +"    "+ s;
	}
}


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