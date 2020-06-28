package com.xcx.designPattern.singleton.lazyLoadSingleton;


public class LazyLoadSingletonTest {

	public static void main(String[] args) {
		System.out.println("懒汉式2 ， 线程安全~");
		LazyLoadSingleton instance = LazyLoadSingleton.getInstance();
		LazyLoadSingleton instance2 = LazyLoadSingleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
	}

}

// 懒汉式(线程安全，同步方法)
class LazyLoadSingleton {
	private static LazyLoadSingleton instance;
	
	private LazyLoadSingleton() {}
	
	//提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
	//即懒汉式
	public static synchronized LazyLoadSingleton getInstance() {
		if(instance == null) {
			instance = new LazyLoadSingleton();
		}
		return instance;
	}
}