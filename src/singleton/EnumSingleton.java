package singleton;

public enum EnumSingleton {
    INSTANCE;
    public void doSomething(){
        System.out.println("我是通过枚举实现的单例!");
    }
}
