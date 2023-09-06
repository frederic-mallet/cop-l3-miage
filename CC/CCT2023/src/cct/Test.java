package cct;

public class Test {

	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		Carre carre = new Carre();
		Object obj = carre;
		Rectangle rc = carre;

		System.out.print("rect.equals(obj); -> ");
		rect.equals(obj);
		
		System.out.print("rect.equals(rc); -> ");
		rect.equals(rc);
		
		System.out.print("obj.equals(rc); -> ");
		obj.equals(rc);

		System.out.print("rc.equals(carre); -> ");
		rc.equals(carre);
		
		System.out.print("carre.equals(carre); -> ");
		carre.equals(carre);
	}

}
