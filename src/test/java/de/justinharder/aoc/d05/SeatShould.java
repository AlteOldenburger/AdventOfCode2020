package de.justinharder.aoc.d05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SeatShould
{
	@Test
	@DisplayName("calcute the SeatID correctly")
	void test01()
	{
		assertAll(
			() -> assertThat(new Seat(44, 5).getSeatId()).isEqualTo(357),
			() -> assertThat(new Seat(70, 7).getSeatId()).isEqualTo(567),
			() -> assertThat(new Seat(14, 7).getSeatId()).isEqualTo(119),
			() -> assertThat(new Seat(102, 4).getSeatId()).isEqualTo(820));
	}
}
