/*
 * MIT License
 *
 * Copyright (c) 2019 xlui
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package app.xlui.lantana;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * DateUtils -- convert {@link java.util.Date} to {@link java.time.LocalDate}
 * and vice versa.
 *
 * <p>Java 8 provide a series of new datetime APIs, but there is not a clear
 * way to convert from old <code>Date</code> class to new <code>LocalDate</code>,
 * <code>LocalTime</code> and <code>LocalDateTime</code> class or vice versa.</p>
 *
 * <p>So I have created an utility class to simplify such things.</p>
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
	 * @param date source date {@code Date}
	 * @return target date {@code LocalDate}
	 */
	public static LocalDate toLocalDate(Date date) {
		return toZoneDateTime(date, zone).toLocalDate();
	}

	/**
	 * Convert {@link java.util.Date} to {@link java.time.LocalDate}
	 *
	 * @param date source date {@code Date}
	 * @param zone you can specify the timezone, or just use
	 *             {@link DateUtils#zone}, the value is {@link ZoneId#systemDefault()}.
	 * @return target date {@code LocalDate}
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
	 * @param date source date {@code Date}
	 * @return target datetime {@code LocalDateTime}
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		return toZoneDateTime(date, zone).toLocalDateTime();
	}

	/**
	 * Convert {@link java.util.Date} to {@link java.time.LocalDateTime}
	 *
	 * @param date source date {@code Date}
	 * @param zone zone id
	 * @return target datetime {@code LocalDateTime}
	 */
	public static LocalDateTime toLocalDateTime(Date date, ZoneId zone) {
		return toZoneDateTime(date, zone).toLocalDateTime();
	}

	/**
	 * Convert {@link java.time.LocalDate} to {@link java.util.Date}
	 *
	 * @param date source date {@code LocalDate}
	 * @return target date {@code Date}
	 */
	public static Date toDate(LocalDate date) {
		return Date.from(date.atStartOfDay().atZone(zone).toInstant());
	}

	/**
	 * Convert {@link java.time.LocalDate} to {@link java.util.Date}
	 *
	 * @param date source date {@code LocalDate}
	 * @param zone zone id
	 * @return target date {@code Date}
	 */
	public static Date toDate(LocalDate date, ZoneId zone) {
		return Date.from(date.atStartOfDay().atZone(zone).toInstant());
	}

	/**
	 * Convert {@link java.time.LocalDateTime} to {@link java.util.Date}
	 *
	 * <p>Note that {@code LocalDateTime} and related new time APIs use a
	 * precision of nanoseconds, while {@code Date} uses a precision of
	 * milliseconds. The conversion will truncate any excess precision
	 * information as though the amount in nanoseconds was subject to
	 * integer division by one million.</p>
	 *
	 * @param datetime source datetime {@code LocalDateTime}
	 * @return target date {@code Date}
	 */
	public static Date toDate(LocalDateTime datetime) {
		return Date.from(datetime.atZone(zone).toInstant());
	}

	/**
	 * Convert {@link java.time.LocalDateTime} to {@link java.util.Date}
	 *
	 * <p>Note that {@code LocalDateTime} and related new time APIs use a
	 * precision of nanoseconds, while {@code Date} uses a precision of
	 * milliseconds. The conversion will truncate any excess precision
	 * information as though the amount in nanoseconds was subject to
	 * integer division by one million.</p>
	 *
	 * @param datetime source date {@code LocalDateTime}
	 * @param zone     zone id
	 * @return target date {@code Date}
	 */
	public static Date toDate(LocalDateTime datetime, ZoneId zone) {
		return Date.from(datetime.atZone(zone).toInstant());
	}

	/**
	 * Convert {@code Date} to {@code ZoneDateTime}, to provide convenience
	 * for later convert.
	 *
	 * @param date source date {@code Date}
	 * @param zone zone id
	 * @return A date-time with a time-zone in the ISO-8601 calendar system
	 */
	private static ZonedDateTime toZoneDateTime(Date date, ZoneId zone) {
		return date.toInstant().atZone(zone);
	}
}
