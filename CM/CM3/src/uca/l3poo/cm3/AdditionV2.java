package uca.l3poo.cm3;

public class AdditionV2 {
	int calcule(int [] valeurs) {
		int somme = 0;
		for (int v : valeurs) {
			somme += v;
		}
		return somme;
	}
	
	public static void main(String[] args) {
		System.out.println(new AdditionV2().calcule(new int[] {5, 12}));
		System.out.println(new AdditionV2().calcule(new int[] {5, 12, 40, -5, -16}));
	}
}
