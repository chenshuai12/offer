package singleton;

import java.util.Objects;

public class DoubleSynSingleton {
    private volatile static DoubleSynSingleton synSingleton;

    private DoubleSynSingleton(){

    }

    public static DoubleSynSingleton getInstance(){
        if (Objects.isNull(synSingleton)){
            synchronized (DoubleSynSingleton.class){
                if (Objects.isNull(synSingleton)){
                    synSingleton = new DoubleSynSingleton();
                }
            }
        }
        return synSingleton;
    }
    public void doSomething(){
        System.out.println("我是通过双检锁实现的单例模式");
    }
}
