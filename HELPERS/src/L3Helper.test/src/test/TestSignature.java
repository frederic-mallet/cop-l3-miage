package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestSignature {
	private Class<?> internalClass;

	public TestSignature(Class<?> c) {
		this.internalClass = c;
	}
	public void privateField(String name) {
		try {
			Field f = internalClass.getDeclaredField(name);
			assertTrue("Field Should be private", Modifier.isPrivate(f.getModifiers()));
		} catch (NoSuchFieldException e) {
			System.out.println("Warning: no field " + name);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	public void publicConstructors(int expected) {
		assertEquals("expected public constructors", expected, internalClass.getConstructors().length);
	}
	public void packageConstructors(int expected) {
		assertEquals("expected package constructors", expected, internalClass.getDeclaredConstructors().length);
	}
	public void packageConstructor(Class<?> ...classes) {
		Constructor<?>[] cons = internalClass.getDeclaredConstructors();
		
		constructor(cons, classes);
	}
	public void publicConstructor(Class<?> ...classes) {
		Constructor<?>[] cons = internalClass.getConstructors();
		
		constructor(cons, classes);
	}
	private void constructor(Constructor<?>[] cons, Class<?>...classes) {
		for (Constructor<?> c : cons) {
			if (c.getParameterCount() != classes.length) continue; // not the right number of parameters
			Class<?>[] pTypes = c.getParameterTypes();

			boolean found = true;
			
			for (int i = 0; i < classes.length; i++) {
				if (pTypes[i] != classes[i]) {
					found = false;
					break; // not the right parameter type
				}
			}
			if (found) return; // Ok found a constructor with the right signature
		}
		fail("Did not find a package constructor with the expected signature");
	}
}
