package net.e175.locale.test;

import net.e175.locale.sh.NumberFormatProvider_sh;
import net.e175.locale.sh.NumberFormatProvider_sh_RS;
import org.junit.Test;

import java.net.URL;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NumberFormatTest {
    private static final Locale BOSNIAN_LOCALE = new Locale("bs");
    private static final Locale SH_RS_LOCALE = new Locale("sh", "RS");

    private static final double TEST_DOUBLE = 1234.565d;

    @Test(expected = IllegalArgumentException.class)
    public void providerChecksInvalidLocale() {
        NumberFormatProvider provider = new NumberFormatProvider_sh();

        provider.getNumberInstance(new Locale("??", "!!"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void providerChecksNullLocale() {
        NumberFormatProvider provider = new NumberFormatProvider_sh();

        provider.getNumberInstance(null);
    }

    @Test
    public void testGetCurrencyInstanceLocale() {
        NumberFormatProvider provider = new NumberFormatProvider_sh();

        NumberFormat format = provider.getCurrencyInstance(BOSNIAN_LOCALE);

        String formatted = format.format(TEST_DOUBLE);

        assertEquals("¤ 1.234,57", formatted);
    }

    @Test
    public void testGetCurrencyInstanceLocaleSerbian() {
        NumberFormatProvider provider = new NumberFormatProvider_sh_RS();

        NumberFormat format = provider.getCurrencyInstance(SH_RS_LOCALE);

        String formatted = format.format(TEST_DOUBLE);

        assertEquals("RSD 1.234,57", formatted);
    }

    @Test
    public void testGetIntegerInstanceLocale() {
        NumberFormatProvider provider = new NumberFormatProvider_sh();

        NumberFormat format = provider.getIntegerInstance(BOSNIAN_LOCALE);

        String formatted = format.format(TEST_DOUBLE);

        assertEquals("1.235", formatted);
    }

    @Test
    public void testGetNumberInstanceLocale() {
        NumberFormatProvider provider = new NumberFormatProvider_sh();

        NumberFormat format = provider.getNumberInstance(BOSNIAN_LOCALE);

        String formatted = format.format(TEST_DOUBLE);

        assertEquals("1.234,565", formatted);


        format = provider.getNumberInstance(SH_RS_LOCALE);

        formatted = format.format(TEST_DOUBLE);

        assertEquals("1.234,565", formatted);
    }

    @Test
    public void testGetPercentInstanceLocale() {
        NumberFormatProvider provider = new NumberFormatProvider_sh();

        NumberFormat format = provider.getPercentInstance(BOSNIAN_LOCALE);

        String formatted = format.format(TEST_DOUBLE);

        assertEquals("123.457%", formatted);
    }

    @Test
    public void checkSpiDeclaration() {
        // check that SPI "declaration file" exists
        URL spifile = Thread.currentThread().getContextClassLoader().getResource(
                "META-INF/services/java.text.spi.NumberFormatProvider");
        assertNotNull(spifile);
    }

}
