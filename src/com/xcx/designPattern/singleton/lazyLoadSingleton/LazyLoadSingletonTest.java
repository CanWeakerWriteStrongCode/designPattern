package com.xcx.designPattern.singleton.lazyLoadSingleton;


public class LazyLoadSingletonTest {

	public static void main(String[] args) {
		System.out.println("����ʽ2 �� �̰߳�ȫ~");
		LazyLoadSingleton instance = LazyLoadSingleton.getInstance();
		LazyLoadSingleton instance2 = LazyLoadSingleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
	}

}

// ����ʽ(�̰߳�ȫ��ͬ������)
class LazyLoadSingleton {
	private static LazyLoadSingleton instance;
	
	private LazyLoadSingleton() {}
	
	//�ṩһ����̬�Ĺ��з���������ͬ������Ĵ��룬����̰߳�ȫ����
	//������ʽ
	public static synchronized LazyLoadSingleton getInstance() {
		if(instance == null) {
			instance = new LazyLoadSingleton();
		}
		return instance;
	}
}