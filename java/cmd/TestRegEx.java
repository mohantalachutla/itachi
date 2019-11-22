import java.util.regex.*;
import java.lang.annotation.*;
import java.util.*;

@FunctionalInterface
interface P{
	void print(Object o);
}
public class TestRegEx
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
		Pattern pattern;
		Matcher matcher;
		String alpha="abcde,fghi,jklmno,pqrs,tuv,wxyz";
		String beta= "ABCDEFG#@HIJKLM#@NOPQRSTU#@VWXYZ";
		String ran = "adf23dioAd83l934kddffdf";
		String ran1 = "aodfLK32893lldsd22";
		String num = "2329339338448";
		String alph = "sdfasdfSDFAfeesDSDfwe";
		String rep = "abcdexyzmnoxyzabcpqrmnopqrxyzabcabcacbabc";
		
		
		String pat_num = "^[0-9]+$";
		String pat_apha_sm = "^[a-z]+$";
		String pat_apha_lg = "^[A-Z]+$";
		String pat_mail = "^([a-zA-Z]){3,}@([a-zA-Z]){2,}.([a-zA-Z]){2,}$";
		pattern = Pattern.compile("abc");
		matcher = pattern.matcher(rep); 
		
		testPattern(pattern,rep);
		p.print("\n\n\n\n");
		testMatcher(matcher);
		
		p.print("Pattern.matches()  -->"+Pattern.matches(pat_num,num));
	}
	public void testPattern(Pattern pat,String... args)
	{
		p.print("testPattern() -->");
		p.print("split()  -->");
		String[] splited = pat.split(args[0]);
		Arrays.asList(splited).forEach(s -> p.print(s));
		
	}
	public void testMatcher(Matcher mat, String... args)
	{
		p.print("testMatcher() -->");
		p.print("matches()  -->"+mat.matches());
		p.print("find()  -->"+mat.find());
		p.print("find(i)  -->"+mat.find(4));
		p.print("start()  -->"+mat.start()); //starting index of match
		p.print("end()  -->"+mat.end());	// after index of the ending  of match(exclusive)
		while(mat.find()) p.print("group()  -->"+mat.group());	//group of characters  matched
		p.print("groupCount()  -->"+mat.groupCount());
	}
}

/*
Pattern.class
METHODS:
java.util.Map    namedGroups()
private boolean    findSupplementary(int,int)
private boolean    has(int)
private boolean    isLineSeparator(int)
private boolean    lambda$asPredicate$0(java.lang.String)
private int    c()
private int    cursor()
private int    escape(boolean,boolean,boolean)
private int    getClass(int)
private int    next()
private int    nextEscaped()
private int    normalizeCharClass(java.lang.StringBuilder,int)
private int    o()
private int    parsePastLine()
private int    parsePastWhitespace(int)
private int    peek()
private int    peekPastLine()
private int    peekPastWhitespace(int)
private int    read()
private int    readEscaped()
private int    skip()
private int    util.regex.Pattern.u()
private int    uxxxx()
private int    x.Pattern.x()
private java.lang.String    composeOneStep(java.lang.String)
private java.lang.String    groupname(int)
private java.lang.String    produceEquivalentAlternation(java.lang.String)
private java.lang.String[]    producePermutations(java.lang.String)
private java.util.regex.Pattern$CharProperty    bitsOrSingle(java.util.regex.Pattern$BitClass,int)
private java.util.regex.Pattern$CharProperty    caseInsensitiveRangeFor(int,int)
private java.util.regex.Pattern$CharProperty    charPropertyNodeFor(java.lang.String)
private java.util.regex.Pattern$CharProperty    clazz(boolean)
private java.util.regex.Pattern$CharProperty    family(boolean,boolean)
private java.util.regex.Pattern$CharProperty    newSingle(int)
private java.util.regex.Pattern$CharProperty    range(java.util.regex.Pattern$BitClass)
private java.util.regex.Pattern$CharProperty    unicodeBlockPropertyFor(java.lang.String)
private java.util.regex.Pattern$CharProperty    unicodeScriptPropertyFor(java.lang.String)
private java.util.regex.Pattern$Node    atom()
private java.util.regex.Pattern$Node    closure(java.util.regex.Pattern$Node)
private java.util.regex.Pattern$Node    createGroup(boolean)
private java.util.regex.Pattern$Node    expr(java.util.regex.Pattern$Node)
private java.util.regex.Pattern$Node    group0()
private java.util.regex.Pattern$Node    newSlice(int[],int,boolean)
private java.util.regex.Pattern$Node    ref(int)
private java.util.regex.Pattern$Node    sequence(java.util.regex.Pattern$Node)
private java.util.regex.PatternSyntaxException    error(java.lang.String)
private static boolean    hasBaseCharacter(java.util.regex.Matcher,int,java.lang.CharSequence)
private static boolean    inRange(int,int,int)
private static final boolean    isSupplementary(int)
private static final int    countChars(java.lang.CharSequence,int,int)
private static final int    countCodePoints(java.lang.CharSequence)
private static java.util.regex.Pattern$CharProperty    intersection(java.util.regex.Pattern$CharProperty,java.util.regex.Pattern$CharProperty)
private static java.util.regex.Pattern$CharProperty    rangeFor(int,int)
private static java.util.regex.Pattern$CharProperty    setDifference(java.util.regex.Pattern$CharProperty,java.util.regex.Pattern$CharProperty)
private static java.util.regex.Pattern$CharProperty    union(java.util.regex.Pattern$CharProperty,java.util.regex.Pattern$CharProperty)
private static void    printObjectTree(java.util.regex.Pattern$Node)
private void    RemoveQEQuoting()
private void    accept(int,java.lang.String)
private void    addFlag()
private void    append(int,int)
private void    compile()
private void    mark(int)
private void    normalize()
private void    readObject(java.io.ObjectInputStream)
private void    setcursor(int)
private void    subFlag()
private void    unread()
public int    flags()
public java.lang.String    pattern()
public java.lang.String    toString()
public java.lang.String[]    split(java.lang.CharSequence)
public java.lang.String[]    split(java.lang.CharSequence,int)
public java.util.function.Predicate    asPredicate()
public java.util.regex.Matcher    matcher(java.lang.CharSequence)
public java.util.stream.Stream    splitAsStream(java.lang.CharSequence)
public static boolean    matches(java.lang.String,java.lang.CharSequence)
public static java.lang.String    quote(java.lang.String)
public static java.util.regex.Pattern    compile(java.lang.String)
public static java.util.regex.Pattern    compile(java.lang.String,int)
static boolean    access$200(int,int,int)
static boolean    access$400(java.util.regex.Matcher,int,java.lang.CharSequence)
static int    access$300(java.lang.CharSequence,int,int)
static java.util.regex.Pattern$CharProperty    access$600(int,int)


FIELDS:
public static final int java.util.regex.Pattern.UNIX_LINES
public static final int java.util.regex.Pattern.CASE_INSENSITIVE
public static final int java.util.regex.Pattern.COMMENTS
public static final int java.util.regex.Pattern.MULTILINE
public static final int java.util.regex.Pattern.LITERAL
public static final int java.util.regex.Pattern.DOTALL
public static final int java.util.regex.Pattern.UNICODE_CASE
public static final int java.util.regex.Pattern.CANON_EQ
public static final int java.util.regex.Pattern.UNICODE_CHARACTER_CLASS
private static final long java.util.regex.Pattern.serialVersionUID
private java.lang.String java.util.regex.Pattern.pattern
private int java.util.regex.Pattern.flags
private transient volatile boolean java.util.regex.Pattern.compiled
private transient java.lang.String java.util.regex.Pattern.normalizedPattern
transient java.util.regex.Pattern$Node java.util.regex.Pattern.root
transient java.util.regex.Pattern$Node java.util.regex.Pattern.matchRoot
transient int[] java.util.regex.Pattern.buffer
transient volatile java.util.Map java.util.regex.Pattern.namedGroups
transient java.util.regex.Pattern$GroupHead[] java.util.regex.Pattern.groupNodes
private transient int[] java.util.regex.Pattern.temp
transient int java.util.regex.Pattern.capturingGroupCount
transient int java.util.regex.Pattern.localCount
private transient int java.util.regex.Pattern.cursor
private transient int java.util.regex.Pattern.patternLength
private transient boolean java.util.regex.Pattern.hasSupplementary
static final int java.util.regex.Pattern.MAX_REPS
static final int java.util.regex.Pattern.GREEDY
static final int java.util.regex.Pattern.LAZY
static final int java.util.regex.Pattern.POSSESSIVE
static final int java.util.regex.Pattern.INDEPENDENT
static java.util.regex.Pattern$Node java.util.regex.Pattern.lookbehindEnd
static java.util.regex.Pattern$Node java.util.regex.Pattern.accept
static java.util.regex.Pattern$Node java.util.regex.Pattern.lastAccept
static final boolean java.util.regex.Pattern.$assertionsDisabled




CONSTRUCTIORS:

private java.util.regex.Pattern(java.lang.String,int)
*/

/*
Matcher.class
Methods:
boolean    match(int,int)
boolean    search(int)
char    charAt(int)
int    getMatchedGroupIndex(java.lang.String)
int    getTextLength()
java.lang.CharSequence    getSubSequence(int,int)
public boolean    find()
public boolean    find(int)
public boolean    hasAnchoringBounds()
public boolean    hasTransparentBounds()
public boolean    hitEnd()
public boolean    lookingAt()
public boolean    matches()
public boolean    requireEnd()
public int    end()
public int    end(int)
public int    end(java.lang.String)
public int    groupCount()
public int    regionEnd()
public int    regionStart()
public int    start()
public int    start(int)
public int    start(java.lang.String)
public java.lang.String    group()
public java.lang.String    group(int)
public java.lang.String    group(java.lang.String)
public java.lang.String    replaceAll(java.lang.String)
public java.lang.String    replaceFirst(java.lang.String)
public java.lang.String    toString()
public java.lang.StringBuffer    appendTail(java.lang.StringBuffer)
public java.util.regex.MatchResult    toMatchResult()
public java.util.regex.Matcher    appendReplacement(java.lang.StringBuffer,java.lang.String)
public java.util.regex.Matcher    region(int,int)
public java.util.regex.Matcher    reset()
public java.util.regex.Matcher    reset(java.lang.CharSequence)
public java.util.regex.Matcher    useAnchoringBounds(boolean)
public java.util.regex.Matcher    usePattern(java.util.regex.Pattern)
public java.util.regex.Matcher    useTransparentBounds(boolean)
public java.util.regex.Pattern    pattern()
public static java.lang.String    quoteReplacement(java.lang.String)
Fields:

java.util.regex.Pattern java.util.regex.Matcher.parentPattern
int[] java.util.regex.Matcher.groups
int java.util.regex.Matcher.from
int java.util.regex.Matcher.to
int java.util.regex.Matcher.lookbehindTo
java.lang.CharSequence java.util.regex.Matcher.text
static final int java.util.regex.Matcher.ENDANCHOR
static final int java.util.regex.Matcher.NOANCHOR
int java.util.regex.Matcher.acceptMode
int java.util.regex.Matcher.first
int java.util.regex.Matcher.last
int java.util.regex.Matcher.oldLast
int java.util.regex.Matcher.lastAppendPosition
int[] java.util.regex.Matcher.locals
boolean java.util.regex.Matcher.hitEnd
boolean java.util.regex.Matcher.requireEnd
boolean java.util.regex.Matcher.transparentBounds
boolean java.util.regex.Matcher.anchoringBounds


Constructors:
java.util.regex.Matcher()
java.util.regex.Matcher(java.util.regex.Pattern,java.lang.CharSequence)


*/
