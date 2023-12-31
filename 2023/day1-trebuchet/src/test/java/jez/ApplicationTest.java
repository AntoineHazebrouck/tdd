package jez;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class ApplicationTest
{
	@Test
	void high_order_test()
	{
		CalibrationLine calibrationLine = CalibrationLine.of("1abc2");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(12);

		calibrationLine = CalibrationLine.of("pqr3stu8vwx");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(38);

		calibrationLine = CalibrationLine.of("a1b2c3d4e5f");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(15);

		calibrationLine = CalibrationLine.of("treb7uchet");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(77);

		calibrationLine = CalibrationLine.of("two1nine");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(29);

		calibrationLine = CalibrationLine.of("eightwothree");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(83);

		calibrationLine = CalibrationLine.of("abcone2threexyz");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(13);

		calibrationLine = CalibrationLine.of("xtwone3four");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(24);

		calibrationLine = CalibrationLine.of("4nineeightseven2");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(42);

		calibrationLine = CalibrationLine.of("zoneight234");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(14);

		calibrationLine = CalibrationLine.of("7pqrstsixteen");
		assertThat(calibrationLine.getCalibrationValue()).isEqualTo(76);
	}


	@Test
	void parsing_textdigit()
	{
		String textDigit = "4nineeightseven2";

		assertThat(Parser.parse(textDigit)).isEqualTo("49872");

		assertThat(CalibrationLine.of(textDigit)
				.getCalibrationValue()).isEqualTo(42);

		textDigit = "eightwothree";
		assertThat(Parser.parse(textDigit)).isEqualTo("823");
		assertThat(CalibrationLine.of(textDigit)
				.getCalibrationValue()).isEqualTo(83);
	}
}
