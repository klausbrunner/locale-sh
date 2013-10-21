package net.e175.locale.test;

import net.e175.locale.sh.LocaleNameProvider_sh;
import org.junit.Test;

import java.net.URL;
import java.util.Locale;
import java.util.spi.LocaleNameProvider;

import static org.junit.Assert.*;


public class LocaleNameTest {
    private static final Locale BOSNIAN_LOCALE = new Locale("bs");

    @Test(expected = IllegalArgumentException.class)
    public void providerChecksWrongLocale() {
        LocaleNameProvider provider = new LocaleNameProvider_sh();

        assertNull(provider.getDisplayCountry("BA", new Locale("hr")));
    }

    @Test
    public void providerChecksBogusCountry() {
        LocaleNameProvider provider = new LocaleNameProvider_sh();

        assertNull(provider.getDisplayCountry("??", BOSNIAN_LOCALE));
    }

    @Test
    public void providerChecksBogusLanguage() {
        LocaleNameProvider provider = new LocaleNameProvider_sh();

        assertNull(provider.getDisplayLanguage("??", BOSNIAN_LOCALE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void providerChecksBadLanguageFormat() {
        LocaleNameProvider provider = new LocaleNameProvider_sh();

        provider.getDisplayLanguage("srp", BOSNIAN_LOCALE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void providerChecksBadCountryFormat() {
        LocaleNameProvider provider = new LocaleNameProvider_sh();

        provider.getDisplayLanguage("AUT", BOSNIAN_LOCALE);
    }

    @Test
    public void providerKnowsLanguages() {
        LocaleNameProvider provider = new LocaleNameProvider_sh();

        assertEquals("bosanski", provider.getDisplayLanguage("bs", BOSNIAN_LOCALE));
        assertEquals("engleski", provider.getDisplayLanguage("en", BOSNIAN_LOCALE));
        assertEquals("hrvatski", provider.getDisplayLanguage("hr", BOSNIAN_LOCALE));
        assertEquals("srpski", provider.getDisplayLanguage("sr", BOSNIAN_LOCALE));
    }

    @Test
    public void providerKnowsCountries() {
        LocaleNameProvider provider = new LocaleNameProvider_sh();

        assertEquals("Bosna i Hercegovina", provider.getDisplayCountry("BA", BOSNIAN_LOCALE));
        assertEquals("Hrvatska", provider.getDisplayCountry("HR", BOSNIAN_LOCALE));
        assertEquals("Srbija", provider.getDisplayCountry("RS", BOSNIAN_LOCALE));
        assertEquals("Slovenija", provider.getDisplayCountry("SI", BOSNIAN_LOCALE));
        assertEquals("Crna Gora", provider.getDisplayCountry("ME", BOSNIAN_LOCALE));
    }


    @Test
    public void checkSpiDeclaration() {
        // check that SPI "declaration file" exists
        URL spifile = Thread.currentThread().getContextClassLoader().getResource(
                "META-INF/services/java.util.spi.LocaleNameProvider");
        assertNotNull(spifile);
    }

}
