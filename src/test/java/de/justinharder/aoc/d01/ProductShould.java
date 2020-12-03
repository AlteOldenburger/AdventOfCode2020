package de.justinharder.aoc.d01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductShould
{
	@Test
	@DisplayName("multiply two numbers")
	void test01()
	{
		assertThat(Product.of(1721, 299)).isEqualTo(514579);
	}

	@Test
	@DisplayName("multiply three numbers")
	void test02()
	{
		assertThat(Product.of(979, 366, 675)).isEqualTo(241861950);
	}
}
