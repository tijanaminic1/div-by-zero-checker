// Tests for arithmeticTransfer: verify the checker computes result qualifiers
// for arithmetic expressions so divide-by-zero diagnostics are correct.

public class ArithmeticTransfer {

	public static void plusLiterals() {
		int a = 0 + 0;
		// :: error: divide.by.zero
		int x = 1 / a;

		int b = 0 + 1;
		int y = 1 / b;

		int c = 2 + 3;
		int z = 1 / c;
	}

	public static void minusLiterals() {
		int a = 0 - 0;
		// :: error: divide.by.zero
		int x = 1 / a;

		int b = 1 - 0;
		int y = 1 / b;

		int c = 0 - 1; // negative, non-zero
		int z = 1 / c;
	}

	public static void timesLiterals() {
		int a = 0 * 5;
		// :: error: divide.by.zero
		int x = 1 / a;

		int b = 1 * 5;
		int y = 1 / b;
	}

	public static void divideLiterals() {
		int a = 0 / 5; // zero
		// :: error: divide.by.zero
		int x = 1 / a;

		int b = 4 / 2; // positive
		int y = 1 / b;
	}

	public static void modLiterals() {
		int a = 0 % 5; // zero
		// :: error: divide.by.zero
		int x = 1 / a;

		int b = 5 % 2; // 1
		// :: error: divide.by.zero
		int y = 1 / b;

		int c = -5 % 2; // -1
		// :: error: divide.by.zero
		int z = 1 / c;
	}

}

