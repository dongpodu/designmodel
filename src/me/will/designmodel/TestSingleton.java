package me.will.designmodel;

/**
 * Created by duyisong on 09/06/2018.
 */
public class TestSingleton {
    private static volatile TestSingleton instance;
    private TestSingleton(){

    }

    /**
     * 方式1
     *
     * 此方法在jdk1.5或之后能正确运行
     * 原因：从语义角度来看，并没有什么问题。但是其实还是有坑。说这个坑之前我们要先来看看volatile这个关键字。
     * 其实这个关键字有两层语义。第一层语义相信大家都比较熟悉，就是可见性。
     * 可见性指的是在一个线程中对该变量的修改会马上由工作内存（Work Memory）写回主内存（Main Memory），
     * 所以会马上反应在其它线程的读取操作中。顺便一提，工作内存和主内存可以近似理解为实际电脑中的高速缓存和主存，
     * 工作内存是线程独享的，主存是线程共享的。volatile的第二层语义是禁止指令重排序优化。大家知道我们写的代码（尤其是多线程代码），
     * 由于编译器优化，在实际执行的时候可能与我们编写的顺序不同。编译器只保证程序执行结果与源代码相同，
     * 却不保证实际指令的顺序与源代码相同。这在单线程看起来没什么问题，然而一旦引入多线程，这种乱序就可能导致严重问题。
     * volatile关键字就可以从语义上解决这个问题。
     * 注意，前面反复提到“从语义上讲是没有问题的”，但是很不幸，禁止指令重排优化这条语义直到jdk1.5以后才能正确工作。
     * 此前的JDK中即使将变量声明为volatile也无法完全避免重排序所导致的问题。所以，在jdk1.5版本前，
     * 双重检查锁形式的单例模式是无法保证线程安全的
     * @return
     */
    public static TestSingleton getInstance(){
        if(instance==null){
            synchronized (TestSingleton.class){
                if(instance==null){
                    instance = new TestSingleton();
                }
            }
        }
        return instance;
    }


    /**
     * 方式2：改进方式
     * 原因：静态内部类和非静态内部类一样，都是在被调用时才会被加载。这样既可实现懒汉加载模式，也可保证线程安全
     *
     */
    private static class Holder {
        private static TestSingleton singleton = new TestSingleton();
    }

    public static TestSingleton getSingleton(){
        return Holder.singleton;
    }

}
