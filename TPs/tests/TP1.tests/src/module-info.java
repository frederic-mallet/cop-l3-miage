module tp1.tests {
	requires transitive java.desktop;
	requires transitive junit;
	requires uca.l3.helper.test;
	requires uca.l3.helper.swing;
	requires transitive tp1;
	exports tp1.tests;
}