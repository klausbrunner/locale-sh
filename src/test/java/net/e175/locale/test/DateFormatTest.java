package net.e175.locale.test;

import net.e175.locale.sh.DateFormatProvider_sh;
import net.e175.locale.sh.DateFormatProvider_sh_HR;
import net.e175.locale.sh.DateFormatProvider_sh_RS;
import org.junit.Test;

import java.net.URL;
import java.text.DateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

@SuppressWarnings("deprecation")
public class DateFormatTest {

    private static final int DAYS_RANGE = 400;
    private static final Locale BOSNIAN_LOCALE = new Locale("bs");
    private static final Locale SH_RS_LOCALE = new Locale("sh", "RS");
    private static final Locale SH_HR_LOCALE = new Locale("sh", "HR");
    private static final int SECOND = 19;
    private static final int MINUTE = 25;
    private static final int HOUR = 22;
    private static final int DAY = 10;
    private static final int MONTH = 7;
    private static final int YEAR = 2008;

    private static final Date TEST_DATE = new Date(YEAR - 1900, MONTH - 1, DAY, HOUR, MINUTE, SECOND);

    @Test
    public void getLegalDateInstance() {
        DateFormatProvider provider = new DateFormatProvider_sh();

        assertNotNull(provider.getDateInstance(DateFormat.SHORT, BOSNIAN_LOCALE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIllegalDateInstance() {
        DateFormatProvider provider = new DateFormatProvider_sh();

        provider.getDateInstance(DateFormat.SHORT * 2, BOSNIAN_LOCALE);
    }

    @Test
    public void dateFormats() {
        DateFormatProvider provider = new DateFormatProvider_sh();

        {
            DateFormat shortDate = provider.getDateInstance(DateFormat.SHORT, BOSNIAN_LOCALE);
            String shortDateString = shortDate.format(TEST_DATE);

            String expected = String.format("%02d.%02d.%02d.", DAY, MONTH, YEAR - 2000);

            assertEquals(expected, shortDateString);
        }

        {
            DateFormat mediumDate = provider.getDateInstance(DateFormat.MEDIUM, BOSNIAN_LOCALE);
            String mediumDateString = mediumDate.format(TEST_DATE);

            String expected = String.format("%02d.%02d.%04d.", DAY, MONTH, YEAR);

            assertEquals(expected, mediumDateString);
        }

        {
            DateFormat longDate = provider.getDateInstance(DateFormat.LONG, BOSNIAN_LOCALE);
            String longDateString = longDate.format(TEST_DATE);

            String expected = String.format("%d. juli %04d.", DAY, YEAR);

            assertEquals(expected, longDateString);
        }

        {
            DateFormat fullDate = provider.getDateInstance(DateFormat.FULL, BOSNIAN_LOCALE);
            String fullDateString = fullDate.format(TEST_DATE);

            String expected = String.format("četvrtak, %d. juli %04d.", DAY, YEAR);

            assertEquals(expected, fullDateString);
        }

    }

    @Test
    public void dateFormatsSerbia() {
        DateFormatProvider provider = new DateFormatProvider_sh_RS();
        {
            DateFormat fullDate = provider.getDateInstance(DateFormat.FULL, SH_RS_LOCALE);
            String fullDateString = fullDate.format(TEST_DATE);

            String expected = String.format("četvrtak, %d. jul %04d.", DAY, YEAR);

            assertEquals(expected, fullDateString);
        }

    }

    @Test
    public void dayRangesWithoutCrashing() {
        // see if it doesn't crash on a range of days

        {
            DateFormatProvider provider = new DateFormatProvider_sh();
            DateFormat fullDate = provider.getDateInstance(DateFormat.FULL, BOSNIAN_LOCALE);
            formatDayRange(fullDate);
        }

        {
            DateFormatProvider provider = new DateFormatProvider_sh_RS();
            DateFormat fullDate = provider.getDateInstance(DateFormat.FULL, SH_RS_LOCALE);
            formatDayRange(fullDate);
        }

        {
            DateFormatProvider provider = new DateFormatProvider_sh_HR();
            DateFormat fullDate = provider.getDateInstance(DateFormat.FULL, SH_HR_LOCALE);
            formatDayRange(fullDate);
        }


    }

    private void formatDayRange(DateFormat fullDate) {
        Date currentDate = TEST_DATE;
        for (int i = 0; i < DAYS_RANGE; i++) {
            assertNotNull(fullDate.format(currentDate));
            currentDate = new Date(currentDate.getTime() + 24 * 60 * 60 * 1000);
        }
    }

    @Test
    public void dateFormatsCroatia() {
        DateFormatProvider provider = new DateFormatProvider_sh_HR();
        {
            DateFormat fullDate = provider.getDateInstance(DateFormat.FULL, SH_HR_LOCALE);
            String fullDateString = fullDate.format(TEST_DATE);

            String expected = String.format("četvrtak, %d. srpanj %04d.", DAY, YEAR);

            assertEquals(expected, fullDateString);
        }

    }

    @Test
    public void timeFormats() {
        DateFormatProvider provider = new DateFormatProvider_sh();

        {
            DateFormat shortTime = provider.getTimeInstance(DateFormat.SHORT, BOSNIAN_LOCALE);
            String shortTimeString = shortTime.format(TEST_DATE);

            String expected = String.format("%02d:%02d", HOUR, MINUTE);

            assertEquals(expected, shortTimeString);
        }

        {
            DateFormat mediumTime = provider.getTimeInstance(DateFormat.MEDIUM, BOSNIAN_LOCALE);
            String mediumDateString = mediumTime.format(TEST_DATE);

            String expected = String.format("%02d:%02d:%02d", HOUR, MINUTE, SECOND);

            assertEquals(expected, mediumDateString);
        }

        {
            DateFormat longTime = provider.getTimeInstance(DateFormat.LONG, BOSNIAN_LOCALE);
            String longDateString = longTime.format(TEST_DATE);

            String expected = String.format("%02d:%02d:%02d", HOUR, MINUTE, SECOND);

            assertTrue(longDateString.startsWith(expected)); // TODO: complete
            // check
        }

        {
            DateFormat fullTime = provider.getTimeInstance(DateFormat.LONG, BOSNIAN_LOCALE);
            String fullDateString = fullTime.format(TEST_DATE);

            String expected = String.format("%02d:%02d:%02d", HOUR, MINUTE, SECOND);

            assertTrue(fullDateString.startsWith(expected)); // TODO: complete
            // check
        }

    }

    @Test
    public void checkSpiDeclaration() {
        // check that SPI "declaration file" exists
        URL spifile = Thread.currentThread().getContextClassLoader().getResource(
                "META-INF/services/java.text.spi.DateFormatProvider");
        assertNotNull(spifile);
    }

}
