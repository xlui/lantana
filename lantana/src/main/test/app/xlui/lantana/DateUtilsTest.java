package app.xlui.lantana;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtilsTest {
	@Test
	public void testDate() {
		Date now1 = new Date();
		LocalDateTime datetime = DateUtils.toLocalDateTime(now1);
		Date now2 = DateUtils.toDate(datetime);

		Assert.assertEquals(now1, now2);
	}

	@Test
	public void testLocalDate() {
		LocalDate now1 = LocalDate.now();
		Date date = DateUtils.toDate(now1);
		LocalDate now2 = DateUtils.toLocalDate(date);

		Assert.assertEquals(now1, now2);
	}

	/**
	 * precision loss when convert {@code LocalDateTime} to {@code Date}.
	 */
	@Test
	public void testLocalDateTime() {
		LocalDateTime now1 = LocalDateTime.now();
		Date date = DateUtils.toDate(now1);
		LocalDateTime now2 = DateUtils.toLocalDateTime(date);

		Assert.assertNotEquals(now1, now2);
	}
}
