#### 守护线程参考文档

守护线程当jvm中没有了任何Worker Thread,守护线程将会与jvm一起结束.

[Java中守护线程的总结](http://blog.csdn.net/shimiso/article/details/8964414)

#### CAS

传说中的乐观锁,主要是Atomic等类中实现,核心是使用了UnSafe类中的compareAndSwap()的native方法.不会阻塞线程.
可能出现的问题:
出现aba问题,在一个线程B执行时,线程A已经将变量由a变为b又变为a了,线程B执行发现变量还是a,可是该变量已经被操作过了,解决办法是在每次操作完是都加一个版本号,
标识哪次执行的.

[CAS原理讲解](http://zl198751.iteye.com/blog/1848575)

[Java中CAS详解](http://blog.csdn.net/ls5718/article/details/52563959)

[乐观的并发策略——基于CAS的自旋](https://www.kancloud.cn/seaboat/java-concurrent/117870)

#### volatile

volatile使用的一方面是在单例模式中,类变量使用volatile保证在内存中可见.在加双重检查锁定模式(Double Checked Locking)
判断在多线程中可以保证只有一个实例.

```java
public class Foo{
    private volatile Foo foo=null;
    //一个私有构造方法
    private Foo(){}
    public static Foo getInstance(){
        if(foo == null){
            synchronized (Foo.class){
                if(foo==null){
                    return new Foo();
                }
            }
        }
        return foo;
    }
}
```

[Double Checked Locking](https://zh.wikipedia.org/wiki/%E5%8F%8C%E9%87%8D%E6%A3%80%E6%9F%A5%E9%94%81%E5%AE%9A%E6%A8%A1%E5%BC%8F)

[【深入解析Java中volatile关键字的作用】](https://my.oschina.net/shiinnny/blog/387263)

#### ThreadLocal

[理解Java中的ThreadLocal](https://droidyue.com/blog/2016/03/13/learning-threadlocal-in-java/)

[Class ThreadLocal](https://docs.oracle.com/javase/7/docs/api/java/lang/ThreadLocal.html)

[并发编程 | ThreadLocal源码深入分析](http://www.sczyh30.com/posts/Java/java-concurrent-threadlocal/)

#### synchronized

这是同步锁,对内存和cpu消耗比较大,属于悲观锁.会阻塞其他线程,每次都需要切换线程.

#### 线程池

Executors类是个生成线程池的工具类.
newCachePool()是个这缓存的线程池,能够通过aliveTime设置创建完线程后存在的时间,如果超过这个时间并没有task就会结束该线程.
在执行线程时如果发现线程池中有处在idel的线程,则使用该线程,否则创建新线程.适合短任务多任务的使用场景,比如okhttp的http连接的
线程池就使用的是这种.
newFixedPool()是指定核心线程数的线程池,线程池中有固定的线程,如果要执行的任务数大于核心线程数,则会将多余的任务,加入到阻塞队列
(BlockQueue)中,等待后序执行.


#### 线程锁

Lock Condition Semaphore Notify Wait

Lock和synchronized都是阻塞线程,但是Lock的设计的原意就是让锁的机制更加灵活,此外Lock的实现类ReentrantLock有Condition
这个对象,可以用作线程间通信.

[深入浅出java Semaphore](https://www.jianshu.com/p/0090341c6b80)

#### 经典同步问题

生产者消费者问题

银行家算法问题(避免死锁)

哲学家就餐问题

读者写者问题

[银行家算法](https://zh.wikipedia.org/wiki/%E9%93%B6%E8%A1%8C%E5%AE%B6%E7%AE%97%E6%B3%95)

####  死锁

死锁的概念

死锁的形成原因

死锁的处理方法

[死锁](https://zh.wikipedia.org/wiki/%E6%AD%BB%E9%94%81)

#### linux进程同步问题

待续

#### java并发编程参考文档

http://wiki.jikexueyuan.com/project/java-concurrency/



