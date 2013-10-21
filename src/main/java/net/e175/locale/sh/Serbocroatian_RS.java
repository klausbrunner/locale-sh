package net.e175.locale.sh;

import java.util.Locale;

/**
 * Various locale settings for the Serbocroatian languages, Serbian variant.
 *
 * @author Klaus Brunner
 */
public class Serbocroatian_RS extends Serbocroatian {
    private static final long serialVersionUID = 1L;
    private static final String SERBOCROATIAN_LANGUAGE = "sh";
    private static final String SERBIA = "RS";

    private static final String CURRENCY_SYMBOL = "RSD";

    private static final String[] MONTHS = {"januar", "februar", "mart", "april", "maj", "jun", "jul", "avgust", "septembar",
            "oktobar", "novembar", "decembar"};

    private static final String[] WEEKDAYS = {"", "nedelja", "ponedeljak", "utorak", "sreda", "četvrtak", "petak", "subota"};

    private static final String[] SHORT_WEEKDAYS = {"", "ned", "pon", "uto", "sre", "čet", "pet", "sub"};

    private static final Locale[] SUPPORTED_LOCALES = {new Locale(SERBOCROATIAN_LANGUAGE, SERBIA)};

    @Override
    public Locale[] getSupportedLocales() {
        return SUPPORTED_LOCALES;
    }

    @Override
    public String getCurrencySymbol() {
        return CURRENCY_SYMBOL;
    }

    @Override
    public String[] getMonths() {
        return MONTHS;
    }

    @Override
    public String[] getShortWeekdays() {
        return SHORT_WEEKDAYS;
    }

    @Override
    public String[] getWeekdays() {
        return WEEKDAYS;
    }

}
