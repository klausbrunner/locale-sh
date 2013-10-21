package net.e175.locale.test;

import net.e175.locale.sh.DateFormatSymbolsProvider_sh;
import net.e175.locale.sh.DateFormatSymbolsProvider_sh_RS;
import org.junit.Test;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.spi.DateFormatSymbolsProvider;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DateFormatSymbolsTest {
    private static final String BOSNIAN_LANGUAGE = "bs";
    private static final String SERBIA = "RS";
    private static final String SERBOCROATIAN_LANGUAGE = "sh";

    @Test(expected = IllegalArgumentException.class)
    public void providerChecksInvalidLocale() {
        DateFormatSymbolsProvider provider = new DateFormatSymbolsProvider_sh();

        provider.getInstance(new Locale("??", "!!"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void providerChecksNullLocale() {
        DateFormatSymbolsProvider provider = new DateFormatSymbolsProvider_sh();

        provider.getInstance(null);
    }

    @Test
    public void providerReturnsInstance() {
        DateFormatSymbolsProvider provider = new DateFormatSymbolsProvider_sh();

        assertNotNull(provider.getInstance(new Locale(BOSNIAN_LANGUAGE)));
    }

    @Test
    public void monthNames() {
        DateFormatSymbolsProvider provider = new DateFormatSymbolsProvider_sh();
        DateFormatSymbols symbols = provider.getInstance(new Locale(BOSNIAN_LANGUAGE));

        assertEquals(12, symbols.getMonths().length);
        assertEquals("januar", symbols.getMonths()[0]);
        assertEquals("decembar", symbols.getMonths()[11]);
    }

    @Test
    public void weekdays() {
        DateFormatSymbolsProvider provider = new DateFormatSymbolsProvider_sh();
        DateFormatSymbols symbols = provider.getInstance(new Locale(BOSNIAN_LANGUAGE));

        assertEquals(8, symbols.getWeekdays().length);
        assertEquals(8, symbols.getShortWeekdays().length);
        assertEquals("", symbols.getWeekdays()[0]);
        assertEquals("", symbols.getShortWeekdays()[0]);

        assertEquals("četvrtak", symbols.getWeekdays()[5]);
        assertEquals("čet", symbols.getShortWeekdays()[5]);
    }


    @Test
    public void serbianWeekdays() {
        DateFormatSymbolsProvider provider = new DateFormatSymbolsProvider_sh_RS();
        DateFormatSymbols symbols = provider.getInstance(new Locale(SERBOCROATIAN_LANGUAGE, SERBIA));

        assertEquals(8, symbols.getWeekdays().length);
        assertEquals(8, symbols.getShortWeekdays().length);
        assertEquals("", symbols.getWeekdays()[0]);
        assertEquals("", symbols.getShortWeekdays()[0]);

        assertEquals("sreda", symbols.getWeekdays()[4]);
        assertEquals("sre", symbols.getShortWeekdays()[4]);

        assertEquals("nedelja", symbols.getWeekdays()[1]);
        assertEquals("ned", symbols.getShortWeekdays()[1]);

    }

    @Test
    public void checkSpiDeclaration() {
        // check that SPI "declaration file" exists
        URL spifile = Thread.currentThread().getContextClassLoader().getResource(
                "META-INF/services/java.text.spi.DateFormatSymbolsProvider");
        assertNotNull(spifile);
    }

    @Test
    public void checkEnglishWeekdays() {
        DateFormatSymbols symbols = DateFormatSymbols.getInstance(new Locale("en"));
        assertEquals(8, symbols.getWeekdays().length);
        assertEquals(8, symbols.getShortWeekdays().length);

        assertEquals("", symbols.getWeekdays()[0]);
        assertEquals("Sunday", symbols.getWeekdays()[1]);
        assertEquals("Saturday", symbols.getWeekdays()[7]);
    }

}
