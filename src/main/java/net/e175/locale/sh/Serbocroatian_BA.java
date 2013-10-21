package net.e175.locale.sh;

import java.util.Locale;

/**
 * Various locale settings for the Serbocroatian languages, Bosnia variant.
 *
 * @author Klaus Brunner
 */
public class Serbocroatian_BA extends Serbocroatian {
    private static final long serialVersionUID = 1L;
    private static final String SERBOCROATIAN_LANGUAGE = "sh";
    private static final String BOSNIAN_LANGUAGE = "bs";
    private static final String BOSNIA_AND_HERZEGOVINA = "BA";

    private static final String CURRENCY_SYMBOL = "BAM";

    private static final Locale[] SUPPORTED_LOCALES = {new Locale(BOSNIAN_LANGUAGE, BOSNIA_AND_HERZEGOVINA),
            new Locale(SERBOCROATIAN_LANGUAGE, BOSNIA_AND_HERZEGOVINA)};

    @Override
    public Locale[] getSupportedLocales() {
        return SUPPORTED_LOCALES;
    }

    @Override
    public String getCurrencySymbol() {
        return CURRENCY_SYMBOL;
    }

}
