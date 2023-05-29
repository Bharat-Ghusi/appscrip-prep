package appscripprep.javaprep.inheritance;
interface Car{
	void setEngine();
}
interface Toyota extends Car{
	void setGearBox();
}
interface Mahindra extends Car{
	void setGearBox();
}
class Suzuki implements Toyota,Mahindra{

	@Override
	public void setEngine() {
		System.out.println("Set 3L Turbo Engine.");
	}

	@Override
	public void setGearBox() {
		System.out.println("Set automatic gearbox");
		
	}

	
	
}
public class Hybrid {

	public static void main(String[] args) {
		Suzuki suzuki = new Suzuki();
		suzuki.setEngine();
		suzuki.setGearBox();
	}

}
