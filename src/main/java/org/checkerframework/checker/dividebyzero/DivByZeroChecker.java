package org.checkerframework.checker.dividebyzero;

import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.framework.qual.RelevantJavaTypes;

/** This is the entry point for pluggable type-checking. */
@RelevantJavaTypes({Integer.class, Long.class, int.class, long.class}) // added int.class and long.class so it's easier for me to write tests 
public class DivByZeroChecker extends BaseTypeChecker {}
