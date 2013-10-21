package net.e175.locale.test;

import net.e175.locale.sh.DecimalFormatSymbolsProvider_sh;
import org.junit.Test;

import java.net.URL;
import java.text.DecimalFormatSymbols;
import java.text.spi.DecimalFormatSymbolsProvider;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class DecimalFormatSymbolsTest {
    private static final Locale BOSNIAN_LOCALE = new Locale("bs");

    @Test
    public void getLegalSymbolsProviderInstance() {
        DecimalFormatSymbolsProvider provider = new DecimalFormatSymbolsProvider_sh();

        assertNotNull(provider.getInstance(BOSNIAN_LOCALE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIllegalDateInstance() {
        DecimalFormatSymbolsProvider provider = new DecimalFormatSymbolsProvider_sh();

        provider.getInstance(new Locale("??"));
    }

    @Test
    public void testSymbols() {
        DecimalFormatSymbolsProvider provider = new DecimalFormatSymbolsProvider_sh();

        DecimalFormatSymbols symbols = provider.getInstance(BOSNIAN_LOCALE);

        assertEquals(',', symbols.getDecimalSeparator());
        assertEquals('.', symbols.getGroupingSeparator());
    }

    @Test
    public void checkSpiDeclaration() {
        // check that SPI "declaration file" exists
        URL spifile = Thread.currentThread().getContextClassLoader().getResource(
                "META-INF/services/java.text.spi.DecimalFormatSymbolsProvider");
        assertNotNull(spifile);
    }

}
