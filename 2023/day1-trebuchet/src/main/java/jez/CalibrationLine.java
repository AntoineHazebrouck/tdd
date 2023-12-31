package jez;

public class CalibrationLine
{
	private final String calibrationLine;

	private CalibrationLine(String calibrationLine)
	{
		this.calibrationLine = calibrationLine;
	}

	public static CalibrationLine of(String calibrationLine)
	{
		return new CalibrationLine(calibrationLine);
	}

	public int getCalibrationValue()
	{

		var formattedDigits = Parser.parse(calibrationLine);

		// var onlyNumbers = formattedDigits.chars()
		// .filter(letter -> letter >= '0' && letter <= '9')
		// .mapToObj(letterAsInt -> (char) letterAsInt)
		// .toList();

		return Integer.parseInt("" + formattedDigits.charAt(0) +
				formattedDigits.charAt(formattedDigits.length() - 1));
	}
}
