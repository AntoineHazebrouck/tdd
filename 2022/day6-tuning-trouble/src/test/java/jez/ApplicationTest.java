package jez;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class ApplicationTest
{
	private final String DATASTREAM = "bvwbjplbgvbhsrlpgdmjqwftvncz";

	@Test
	void moving_through_the_datastream_4_by_4()
	{
		DatastreamIterator datastreamIterator = new DatastreamIterator(DATASTREAM, 4);

		assertThat(datastreamIterator.hasNext()).isEqualTo(true);
		assertThat(datastreamIterator.next()).isEqualTo("bvwb");
		assertThat(datastreamIterator.next()).isEqualTo("vwbj");
	}

	@Test
	void check_validity()
	{
		PaquetChecker paquetChecker = new PaquetChecker();
		DatastreamIterator datastreamIterator = new DatastreamIterator(DATASTREAM, 4);

		String firstPaquet = datastreamIterator.next();
		String secondPaquet = datastreamIterator.next();
		String thirdPaquet = datastreamIterator.next();

		assertThat(paquetChecker.check(firstPaquet)).isFalse();
		assertThat(paquetChecker.check(secondPaquet)).isTrue();
	}
}
