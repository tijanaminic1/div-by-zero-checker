import org.checkerframework.checker.dividebyzero.qual.*;

// Test subtyping relationships for the Divide By Zero Checker.
// The file contains "// ::" comments to indicate expected errors and warnings.

class SubtypeTest {
  /// You will want a test like this for every pair of qualifiers in your type hierarchy.
  // void oneSubtypingRelationship(@MyTopQualifier int x, @MyBottomQualifier int y) {
  //   @MyTopQualifier int a = x;
  //   @MyTopQualifier int b = y;
  //   // :: error: assignment
  //   @MyBottomQualifier int c = x; // expected error on this line, as indicated just above
  //   @MyBottomQualifier int d = y;
  // }

  // Every type is a subtype of Unknown
    void allUnknown(@Unknown Integer t, @NonZero Integer nz, @Zero Integer z, @Negative Integer n, @Positive Integer p, @Bottom Integer b) {
      @Unknown Integer a1 = t; // tests work with both int and Integer
      @Unknown int a2 = t;
      @Unknown int b1 = nz;
      @Unknown int c1 = z;
      @Unknown int d1 = n;
      @Unknown int e1 = p;
      @Unknown int f1 = b;

    }

    void allBottoms(@Unknown Integer t, @NonZero Integer nz, @Zero Integer z, @Negative Integer n, @Positive Integer p, @Bottom Integer b) {
      @Bottom int a1 = b;
      // :: error: assignment
      @Bottom int b1 = nz; // NonZero is not the subtype of Bottom
      // :: error: assignment
      @Bottom int c1 = z; // Zero is not the subtype of Bottom
      // :: error: assignment
      @Bottom int d1 = n; // Negative is not the subtype of Bottom
      // :: error: assignment
      @Bottom int e1 = p; // Positive is not the subtype of Bottom
      // :: error: assignment
      @Bottom int f1 = t; // Unknown is not the subtype of Bottom
    }

      void allNonZeros(@Unknown Integer t, @NonZero Integer nz, @Zero Integer z, @Negative Integer n,@Positive Integer p, @Bottom Integer b) {
      @NonZero int a1 = nz;
      @NonZero int b1 = p;
      @NonZero int c1 = n;
      @NonZero int d1 = b; 
      // :: error: assignment
      @NonZero int e1 = z; // Zero is not a subtype of NonZero
      // :: error: assignment
      @NonZero int f1 = t; // Unknown is not the subtype of NonZero
    }

    void allZeros(@Unknown Integer t, @NonZero Integer nz, @Zero Integer z, @Negative Integer n,@Positive Integer p, @Bottom Integer b) {
      @Zero int a1 = z;
      // :: error: assignment
      @Zero int b1 = p; // Positive is not a subtype of Zero
      // :: error: assignment
      @Zero int c1 = n; // Negative is not a subtype of Zero
      @Zero int d1 = b; 
      // :: error: assignment
      @Zero int e1 = nz; // NonZero is not a subtype of Zero
      // :: error: assignment
      @Zero int f1 = t; // Unknown is not the subtype of Zero
    }

    void allPositives(@Unknown Integer t, @NonZero Integer nz, @Zero Integer z, @Negative Integer n,@Positive Integer p, @Bottom Integer b) {
      @Positive int a1 = p;
      // :: error: assignment
      @Positive int b1 = n; // Negative is not a subtype of Positive
      // :: error: assignment
      @Positive int c1 = z; // Zero is not a subtype of Positive
      @Positive int d1 = b; 
      // :: error: assignment
      @Positive int e1 = nz; // NonZero is not a subtype of Positive
      // :: error: assignment
      @Positive int f1 = t; // Unknown is not the subtype of Zero
    }

    void allNegatives(@Unknown Integer t, @NonZero Integer nz, @Zero Integer z, @Negative Integer n,@Positive Integer p, @Bottom Integer b) {
      @Negative int a1 = n;
      // :: error: assignment
      @Negative int b1 = p; // Positive is not a subtype of Negative
      // :: error: assignment
      @Negative int c1 = z; // Zero is not a subtype of Negative
      @Negative int d1 = b; 
      // :: error: assignment
      @Negative int e1 = nz; // NonZero is not a subtype of Negative
      // :: error: assignment
      @Negative int f1 = t; // Unknown is not the subtype of Negative
    }


}
