package uca.l3poo.lec1;

class CM1 {
	static 
	long factorielle(int n) {
		if ( n <= 1 ) return 1;
		return n * factorielle( n - 1);
	}
	
	public static 
	void main(String[] args) {
		long res = factorielle(10);
		System.out.println(res);
	}
}
