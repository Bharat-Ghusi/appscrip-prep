package appscripprep.javaprep.general;

class Isro {
	private static Isro is_instance;

	private Isro() {
	}

	public static Isro getIsro() {
		if (is_instance == null) {
			is_instance = new Isro();

		}
		return is_instance;
	}
}

//While this is a common approach, it's important to note that it can be 
//problematic in multithreading scenarios, 
//which is the main reason for using Singletons
enum EnumSingleton {
	INSTANCE("Initial class info");

	private String info;

	private EnumSingleton(String info) {
		this.info = info;
	}

	public EnumSingleton getInstance() {
		return INSTANCE;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}

public class Singleton {

	public static void main(String[] args) {
		System.out.println(Isro.getIsro().hashCode());
		System.out.println(Isro.getIsro().hashCode());
		System.out.println(Isro.getIsro().hashCode());
		System.out.println("______________EnumSingleton_________________");

		EnumSingleton instance1 = EnumSingleton.INSTANCE.getInstance();
		System.out.println(instance1.getInfo());

		EnumSingleton instance2 = EnumSingleton.INSTANCE.getInstance();
		System.out.println(instance1.getInfo());
		instance2.setInfo("Modify info");

		System.out.println(instance1.getInfo()+"  HashCode "+instance1.hashCode());
		System.out.println(instance2.getInfo()+"  HashCode "+instance2.hashCode());

	}

}
