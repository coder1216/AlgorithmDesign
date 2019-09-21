/**
 * 
 * lombok 插件 for java 后端开发
 * 每个fields 自动生成 get set
 * 
 *  process 会被分配独立的memory，所以process和process之间不能share，所以process和process之间交流通过 IPC
 * 
 * JAVA thread -> Object
 * 
 * Thread t = new Thread(); // creat thread object
 * public void run(){} // define what to do for this thread
 * t.start() // start
 * 
 * 
 * 
 */

 class Thread{
     public Thread(){

     }
     public void run(){
         // do sth
     }
     public void start(){ // the thread is ready to schedule into CPU, CPU空闲的时候才会从这里继续往下执行
        // pre procrssing
        run();
        // post processing
     }
 }

 // 在一个 thread中创建另一个thread 并且 run
 public static void main(){
     // for loop
     Thread t = new Thread(){ // 调用thread class new 一个新的thread
         @Override
         public void run(){
             System.out.println(“1”);
         }
     };
     t.start();
     System.out.println(“2”);
 }

 // output 12 or 21 因为在cpu中 contest switch 不可控 

 // 自己写一个新 thread
 // sol1 extend Thread class
 class MyThread extends Thread{
    // ...
    @Override   // 改写thread 里的 run函数，打印出xixi
    public void run(){
        System.out.println(“xixi”);
    }
    public static void main(String[] args){
        Thread myThread = new MyThread();
        myThread.start(); // 等CPU有空闲的时候才会执行这句 打印出xixi
    }

 }

 // sol2 implement runable interface
  interface Runable{
      public void run();
  }
  class MyRunnable implements Runnable{
      @Override
      public void run(){ // 改写 interface里的run 函数 打印出 xixi
        System.out.println(“xixi”);
      }
      public static void main(){
          Thread thread = new Thread(New MyRunnable());
          thread.start();
      }
  }

 /**
  * 
   // how to interrupt thread and do context switch
  // interrupt thread --> you wanna signal the running threads some evernt, thus, thread can change behaviour accordingly
  // 让 cpu里的thread 根据 不在cpu外面的thread 发出的信号 做一些 改变
  exp A 在 cpu b 不在
  B发出 signal 提示 告诉 A，A根据这个signal 来决定 A 要做什么
  */

  // Sol1

class Thread{ // getter setter basic design pattern
    private boolean interrupted;

    public void interrupt(){
        interrupt = true;
    }
    public boolean isInterrupted(){
        return interrupted;
    }

}

  interface Runable{
    public void run();
}
class MyRunnable implements Runnable{
    @Override
    public void run(){ // 改写 interface里的run 函数 打印出 xixi
      System.out.println(“xixi”);
      while(true){
          // do sth
          if(this.isInterrupted()){
              return;
          }
      }
    }
    public static void main(){
        Thread thread = new Thread(New MyRunnable());
        thread.start();
        thread.interrupt();
    }
}

// sol2
public void run(){
    try{
        System,out.println("xixi");
        // do sth take long time
        while(treu){
            if(this.isInterrupted()){
                // return;
                throw new InterruptedException("chucuole");
            }
        }
    }catch (InterruptedException e) {
        //TODO: handle exception
        return;
    }
}

/**
 * 
 * 
// cpu的每一个核心同一时间只能handle 一个 thread，如果有多个threads，怎么handle？
every cpu core at one time unit can excute only one thread, so how to handle muiltiple threads at same time
 
scheduler + queues
scheduler 空制哪个thread 当前时刻去cpu  
queue 等待的thread

sleep()  -> 把thread suspend 一段时间 让出cpu 可以设置wake的时候 也可以自己起来 比热的thread call 了
wait() -> 只能被交起来 别的trhead call 了才执行 等待
yeld() -> 自己主动让出cpu

more for thread's life cycle


two threads conflict with each other race condition if
1, they operate on the same resource / memory
2, one will do write -> stateful vs stateless
3, they may operate concurently

现代编程 使用 stateless 
要改变一个object的一个变量 是以new一个新的出来的方式去改变 而不是在原有的基础上去改变
例如 数据的读写

exp2
int a = 1;
Thread 1:
b = a + 2;
Thread 2:
c = a + 3;
不会 race condition

exp3
int a = 1;
Thread 1:
a = 2;
Thread 2:
c = a + 3;
会发生race condition


To solve the race, we can use locks(Mutex) to make mutual exclusion

会发生race condition 的代码 叫做 critical section

critical section
exp
int a = 1;
Lock lock1 = new Lock();
Tread1:
lock1.lock();
...
a++;
..
lock1.unlock()

Thread2:
lock1.lock()
...
c = a + 3;
...
lock1.unlock();

尽管不知道 a++ 和 c = a + 3 谁先谁后，但是只有有一个开始执行了，就会被锁住，知道执行完毕，才会执行下一个thread



Dead Lock
threads are inter-dependently locked to each other

T1: hold lock1, ask for lock2
T2: hold lock2, ask for lock1
or even more circular hold and ask


exp for dead lock (时间上的问题，t1请求lock2之后t2马上也请求lock2)
t1                                             t2
lock1.lock()                               lock2.lock()

****critical section*****     
lock2.lock() -> 请求lock2失败因为t2已经锁了    lock1.lock() 请求lock失败因为t1已经在执行
...                                         ....
lock2.unlock()                             lock1.unlock()

lock1.unlock()                             lock2.unlock()


dead lock 发生的四个条件 (不互斥，独占，hold一个等另一个)
1, mutual exclusion
2, hold and wait
3, no preemption(只能被hold 的那个要求release，不能被外界或者别的不想管的锁 release， can only by holding thread)
4, circular wait (成环导致dead lock) exp: A -> B -> C -> D 
, A hold 1的锁请求B，B hold2的锁请求C，C hold3的锁请求D，D hould 4的锁请求1


怎样实现lock
1,synchronized(this)
2,synchronized(SynchronizedCounter.class)
3, lock.lock(), lock.unlock()
 

problem with locks
keep waiting -> periodic check -> tracking and notify
instead of busy waiting or periodic checking, we need a mechanism to:
1, allow threads to wait on condition
2, allow a thread satisfies the condition to notify all waiting threads


Conditional variable
wait()
notify()
notifyAll() 

IMMUTABLE
all the wrapper class objects are immutable
a wrapper class is just a wrapper of the corresponding primitive type, the object repressentation of primitive type values
int: Integer
long: Long
char: Character
double: Double
boolean: Boolean
...


interface  comparable  -> int compareTo(MyClass another)  // 本class的大小比较
interface  comparable  -> int compare(MyClass obj1, MyClass obj2) // heap这个结构中

class Integer impletments Comparable<Integer>{ immutable class
    private final int value;

    public Integer(int value){
        this.value = value;
    }
    public it intValue(){
        return value;
    }
    public Integer plus(Integer another){
        return Integer.valueOf(value + another.intValue());
    }
    @Override
    public int compareTo(Integer another){
        if(value == another.intValue()){
            return 0;
        }
        return value < another ? -1 : 1;
    }
}


+, -, *, /, >, <, >=, <=, ... only applied to primitive type. 
Integer a = 5; // autoboxing
int b = 5; // primitive
System.out.println(a > b); false // => a.intValue() > b, false
System.out.println(a + 2); 7
System.out.println(a * 3); 15
System.out.println(a == b); // true

Integer c = 5;

System.out.println(a > c); false // unboxing => a.intValue() > c.intValue()

// == both operand can be Object type and it is comparing if the two references are pointed to the same Object.

Integer a = 5; // lnteger.value0f(5); 
Integer c = 5; // lnteger.value0f(5);
System.out.println(a > c); false // => a.intValue() > c.intValue() 
System.out.println(a >= c); true // => a.intValue() >= c.intValue() 
System.out.println(a == c): // true

a= 129; // lnteger.value0f(129); 
c = 129; // lnteger.value0f(129); 
System.out.println(a > c); 
System.out.println(a >= c); 
System.out.println(a == c): // false


When you implement your own Comparator or override equals(), keep in mind:
be very careful if you see "==" on Object type. 
class MyComparator implements Comparator<lnteger> {
		@Override
		public int compare(lnteger i1, Integer i2) {
			if (i1 == i2) { // we do not want to check the references. 如果是-128~127，works. 否则应该是li.val 和 i2.val比较
return 0; 
}
return i1 < i2 ? 1 : -1;
}
}
	class MyComparator implements Comparator<lnteger> {
		@Override
		public int compare(lnteger 11, Integer 12) {
			return i1 - i2; 
		}
	}
	class MyComparator implements Comparator<lnteger> {
		@Override
		public int compare(lnteger i1,  Integer i2} {
			if (i1 < i2) {
				return -1;
			} else if (i1  > i2) {
				return 1;
			}
			return 0;
		}
	}


    Integer class cache the Integer object with value from -128 to 127, so every time an Integer object within this range is needed, it will always return the corresponding object.
The unboxing is done only when it is necessary, for example, a > b.  Be very careful about using "==" 

int[] vs. lnteger[]
Integer[] objArray = new lnteger[5];
int[] array = objArray; // compile error.

But,
Integer[] objArray = new lnteger[5];
objArray[0] = 1; // will work. 
int[] array= new int[5];
Integer a = 5;
array[0] = a;// will work.
*****



String
class String {
	private final char[] value;
	// different String objects can reuse the same char array, 

	...
}
	
String literal:
	String s1 = "abc";
String s2 = "abc";
System.out.println(s1  == s2); // true
String Pool: TO HW
There is no need for maintaining several copies of String objects with the same literal, since String objects are immutable.
String s1  = "abc";
	String s2 = new String("abc"); // String(String another) 
// how many Strings are created? 
System.out.println(s1  == s2); // false
System.out.println(s1.equals(s2)); // true



Singleton
guarantee a class only have one instance, provide global access to the instance, 
Multiple threading

t1
Singleton s1 = Singleton.getInstance();
t2
Singleton s2 = Singleton.getInstance();

// 要通过class 名直接访问 就要在前面加 static, static 代表只有一份copy，share给class本身和class创建出来的多个object
S1: bad
public class Singleton {
    private static Singleton instance;
   // private static final Singleton instance;  // 加final 一旦赋值不可以改变 防止 multi threads, 但是final 和 static 一起写 就要new 在这里使用也不行 只能加lock在getinstance里
	
	private Singleton() {
		// do sth
	}

	public static synchronized Singleton getInstance() { // 加sychronized 防止 multi threading
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}

// bad 时间复杂度差

how to handle the critical section
option1: add synchronized keyword
option2: design



S2: bad 空间复杂度太高
public class Singleton {
	private static final Singleton INSTANCE = new Singleton();

	private Singleton() {
		// do sth;
	}

	public static Singleton getInstance() {
		return INSTANCE;
	}
}


S3:
public class Singleton {
	private final static Singleton instance;

	private Singleton() {
		// dosth
	}

	public static Singleton getInstance() {
		// do sth ...a
		if (instance == null)
		synchronized(this) { // volatile
		if (instance == null) {
			instance = new Singleton();
		}
	}
}
do sth ...b
		return instance;
	}
}


static,
one copy class自己和object

singleton,
one copy 不同的thread


*/

