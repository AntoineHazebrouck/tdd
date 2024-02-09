package jez;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    @Test
    void person_enters() {
        Person abbey = new Person("abbey", Location.OUT);

		assertThat(abbey.isOut()).isTrue();

		Person abbeyInside = abbey.enter().get();

		assertThat(abbeyInside.isIn()).isTrue();
		assertThat(abbeyInside.isOut()).isFalse();
    }

	@Test
	void checking_anomalies() throws Exception {
		Person abbey = new Person("abbey", Location.OUT);

		assertThatThrownBy(() -> {
			Person abbeyOutside = abbey.exit().orElseThrow(() -> new Exception("ANOMALY"));
		}).isInstanceOf(Exception.class);
	}
}
