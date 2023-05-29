package appscripprep.javaprep.inheritance;
interface A{
	void displayA();
}
interface B{
	void displayB();
}
interface C extends B,A{
	void displayC();
}
class Child implements C{

	@Override
	public void displayB() {
		System.out.println("Interface B");
	}

	@Override
	public void displayA() {
		System.out.println("Interface A");
		
	}

	@Override
	public void displayC() {
		System.out.println("Interface C");
		
	}
	
}
public class MultipleInheritance {

	public static void main(String[] args) {
		Child child = new Child();
		child.displayA();
		child.displayB();
		child.displayC();
	}

}
