package jez;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import jez.entities.Operation;

class ApplicationTest
{

	@Test
	void high_order_test()
	{
		// noop
		// addx 3
		// addx -5

		Operation first = Operation.noOperation()
				.withCurrentCycle(1)
				.withCurrentX(1)
				.build();

		assertThat(first.getCurrentCycle()).isEqualTo(1);
		assertThat(first.getCurrentX()).isEqualTo(1);

		Operation second = first.next(
										Operation.addX()
												.withV(3)
		// ici on garde le builder et on y ajoute le current X et current cycle
		);

		assertThat(second.getCurrentCycle()).isEqualTo(3);
		assertThat(second.getCurrentX()).isEqualTo(4);

		Operation third = second.next(
										Operation.addX()
												.withV(-5));

		assertThat(third.getCurrentCycle()).isEqualTo(5);
		assertThat(third.getCurrentX()).isEqualTo(-1);


	}

}
