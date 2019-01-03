package com.pluralsight.whtasnewonjava8.annotations;

import java.lang.annotation.Repeatable;

// para fazer com que uma anotacao possa ser repetida varias vezes em um atributo ou metodo basta colocar a anotacao @Repeatable

@Repeatable(TestCases.class)
public @interface TestCase {

	int param();
	boolean expected();
	
}
