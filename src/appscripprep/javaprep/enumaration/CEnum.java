package appscripprep.javaprep.enumaration;

public class CEnum {
	
	//Enums
	public enum Color{
		RED("R"),
		GREEN("G"),
		BLLUE("B");
		
		private final String label;
		private Color(String label) {
			this.label=label;
		}
	}

	public static void main(String[] args) {
		for (Color col : Color.values()) {
			System.out.println(col.label);
		}
	}

}
