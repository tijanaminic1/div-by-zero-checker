// Focused tests for refineLhsOfComparison. These rely on refinement of
// primitive `int` values when compared to literals like 0.

public class RefineLHS {

	public static void testEquality(int y) {
		if (y == 0) {
			// In this branch y is refined to 0.
			// :: error: divide.by.zero
			int a = 1 / y;
		} else {
			int b = 1 / y;
		}

		if (y != 0) {
			int c = 1 / y;
		} else {
			// :: error: divide.by.zero
			int d = 1 / y;
		}
	}

	public static void testInequalities(int y) {
		if (y < 0) {
			int a = 1 / y; // negative, non-zero allowed
		}

		if (y <= 0) {
			// y <= 0 may be zero
			// :: error: divide.by.zero
			int b = 1 / y;
		}

		if (y > 0) {
			int c = 1 / y;
		}

		if (y >= 0) {
			// y >= 0 may be zero
			// :: error: divide.by.zero
			int d = 1 / y;
		}
	}

	public static void testNegation(int y) {
		if (!(y == 0)) {
			int a = 1 / y;
		} else {
			// :: error: divide.by.zero
			int b = 1 / y;
		}

		if (!(y != 0)) {
			// :: error: divide.by.zero
			int c = 1 / y;
		} else {
			int d = 1 / y;
		}
	}

}

