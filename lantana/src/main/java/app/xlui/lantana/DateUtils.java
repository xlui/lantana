package app.xlui.lantana;

import java.time.*;
import java.util.Date;

/**
 * DateUtils -- convert {@link java.util.Date} to {@link java.time.LocalDate}
 * and vice versa.
 *
 * Java 8 provide a series of new datetime APIs, but there is not a clear
 * way to convert from old <code>Date</code> class to new <code>LocalDate</code>,
 * <code>LocalTime</code> and <code>LocalDateTime</code> class or vice versa.
 *
 * So I have created an utility class to simplify such things.
 */
public class DateUtils {
	public static final ZoneId zone = ZoneId.systemDefault();

	/**
	 * Prevent unexpected instantiate.
	 */
	private DateUtils() {
	}

	/**
	 * Convert {@link java.util.Date} to {@link java.time.LocalDate}
	 *
	 * @param date source date
	 * @return target instance of {@link java.time.LocalDate}
	 */
	public static LocalDate toLocalDate(Date date) {
		return toZoneDateTime(date, zone).toLocalDate();
	}

	/**
	 * Convert {@link java.util.Date} to {@link java.time.LocalDate}
	 *
	 * @param date source date
	 * @param zone you can specify the timezone, or just use
	 *             {@link DateUtils#zone}, the value is {@link ZoneId#systemDefault()}.
	 * @return target instance of {@link java.time.LocalDate}
	 */
	public static LocalDate toLocalDate(Date date, ZoneId zone) {
		return toZoneDateTime(date, zone).toLocalDate();
	}

	/**
	 * Convert {@link java.util.Date} to {@link java.time.LocalTime}
	 *
	 * @param date source date
	 * @return instance of {@link java.time.LocalTime}
	 */
	public static LocalTime toLocalTime(Date date) {
		return toZoneDateTime(date, zone).toLocalTime();
	}

	/**
	 * Convert {@link java.util.Date} to {@link java.time.LocalTime}
	 *
	 * @param date source date
	 * @param zone zone id
	 * @return instance of {@link java.time.LocalTime}
	 */
	public static LocalTime toLocalTime(Date date, ZoneId zone) {
		return toZoneDateTime(date, zone).toLocalTime();
	}

	/**
	 * Convert {@link java.util.Date} to {@link java.time.LocalDateTime}
	 *
	 * @param date source date
	 * @return instance of {@link java.time.LocalDateTime}
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		return toZoneDateTime(date, zone).toLocalDateTime();
	}

	/**
	 * Convert {@link java.util.Date} to {@link java.time.LocalDateTime}
	 *
	 * @param date source date
	 * @param zone zone id
	 * @return instance of {@link java.time.LocalDateTime}
	 */
	public static LocalDateTime toLocalDateTime(Date date, ZoneId zone) {
		return toZoneDateTime(date, zone).toLocalDateTime();
	}

	/**
	 * Convert {@link java.time.LocalDate} to {@link java.util.Date}
	 *
	 * @param date source LocalDate instance
	 * @return instance of {@link java.util.Date}
	 */
	public static Date toDate(LocalDate date) {
		return java.sql.Date.valueOf(date);
	}

	/**
	 * Convert {@link java.time.LocalDate} to {@link java.util.Date}
	 *
	 * @param date source LocalDate instance
	 * @param zone zone id
	 * @return instance of {@link java.util.Date}
	 */
	public static Date toDate(LocalDate date, ZoneId zone) {
		return Date.from(date.atStartOfDay().atZone(zone).toInstant());
	}

	/**
	 * Convert {@link java.time.LocalDateTime} to {@link java.util.Date}
	 * Note that the actually return type of this convert is
	 * {@link java.sql.Timestamp}. So when you want to compare it with
	 * another object, the object must be the instance of
	 * {@link java.sql.Timestamp}. Otherwise the compare will always
	 * <code>False</code>.
	 *
	 * @param datetime source LocalDateTime instance
	 * @return instance of {@link java.util.Date}
	 */
	public static Date toDate(LocalDateTime datetime) {
		return java.sql.Timestamp.valueOf(datetime);
	}

	/**
	 * Convert {@link java.time.LocalDateTime} to {@link java.util.Date}
	 * Note that {@code LocalDateTime} and related new time APIs use a
	 * precision of nanoseconds, while {@code Date} uses a precision of
	 * milliseconds. The conversion will truncate any excess precision
	 * information as though the amount in nanoseconds was subject to
	 * integer division by one million.
	 *
	 * @param datetime source {@code LocalDateTime} instance
	 * @param zone     zone id
	 * @return instance of {@code Date}
	 */
	public static Date toDate(LocalDateTime datetime, ZoneId zone) {
		return Date.from(datetime.atZone(zone).toInstant());
	}

	private static ZonedDateTime toZoneDateTime(Date date, ZoneId zone) {
		return date.toInstant().atZone(zone);
	}
}
