package while_ut2.ast;

import java.util.*;

/** Representación de la operación que evalúa al tiempo en milisegundos desde el comienzo del programa.
*/
public class Time extends Exp {

	public Time() {
	}

	@Override public int precedence() {
		return 10;
	}

	@Override public String unparse() {
		return "time";
	}

	@Override public String toString() {
		return "Time("+")";
	}

	@Override public int hashCode() {
		int result = 1;
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		return true;
	}

	public static final Time instance = new Time();

	public static Time generate(Random random, int min, int max) {
		return Time.instance;
	}
}
