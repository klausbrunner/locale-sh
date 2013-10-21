package net.e175.locale.test;

import net.e175.locale.sh.CollatorProvider_sh;
import org.junit.Test;

import java.net.URL;
import java.text.Collator;
import java.text.spi.CollatorProvider;
import java.util.Locale;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CollatorTest {
    private static final Locale BOSNIAN_LOCALE = new Locale("bs");

    @Test(expected = IllegalArgumentException.class)
    public void providerChecksInvalidLocale() {
        CollatorProvider provider = new CollatorProvider_sh();

        provider.getInstance(new Locale("??", "!!"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void providerChecksNullLocale() {
        CollatorProvider provider = new CollatorProvider_sh();

        provider.getInstance(null);
    }

    @Test
    public void providerValidLocale() {
        CollatorProvider provider = new CollatorProvider_sh();

        Collator collator = provider.getInstance(BOSNIAN_LOCALE);
        assertNotNull(collator);
    }

    @Test
    public void testSimpleComparisons() {
        CollatorProvider provider = new CollatorProvider_sh();

        Collator collator = provider.getInstance(BOSNIAN_LOCALE);

        // simple ASCII - if this fails, things are seriously wrong
        assertTrue(collator.compare("a", "a") == 0);
        assertTrue(collator.compare("a", "b") < 0);
        assertTrue(collator.compare("a", "z") < 0);
        assertTrue(collator.compare("A", "Z") < 0);

        // ASCII - same char, different cases
        assertTrue(collator.compare("a", "A") < 0);
    }

    @Test
    public void testLocaleSpecificComparisons() {
        CollatorProvider provider = new CollatorProvider_sh();

        Collator collator = provider.getInstance(BOSNIAN_LOCALE);

        assertTrue(collator.compare("c", "č") < 0);
        assertTrue(collator.compare("č", "ć") < 0);
        assertTrue(collator.compare("d", "dž") < 0); // decomposed dž
        assertTrue(collator.compare("d", "\u01c6") < 0); // dž digraph
        assertTrue(collator.compare("d", "đ") < 0);
        assertTrue(collator.compare("lz", "lj") < 0); // decomposed lj
        assertTrue(collator.compare("lz", "\u01c9") < 0); // lj digraph
        assertTrue(collator.compare("nz", "nj") < 0); // decomposed nj
        assertTrue(collator.compare("nz", "\u01cc") < 0); // nj digraph

        assertTrue(collator.compare("s", "š") < 0);
        assertTrue(collator.compare("z", "ž") < 0);

        // TODO: more tests with all sorts of digraph/non-digraph situations,
        // different cases etc.
    }

    @Test
    public void checkSpiDeclaration() {
        // check that SPI "declaration file" exists
        URL spifile = Thread.currentThread().getContextClassLoader().getResource(
                "META-INF/services/java.text.spi.CollatorProvider");
        assertNotNull(spifile);
    }

}
