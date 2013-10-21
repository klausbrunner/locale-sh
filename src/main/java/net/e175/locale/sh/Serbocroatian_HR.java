/**
 *
 */
package net.e175.locale.sh;

import java.util.Locale;

/**
 * Various locale settings for the Serbocroatian languages, Croatian variant.
 *
 * @author Klaus Brunner
 */
public class Serbocroatian_HR extends Serbocroatian {
    private static final long serialVersionUID = 1L;
    private static final String SERBOCROATIAN_LANGUAGE = "sh";
    private static final String CROATIA = "HR";

    private static final String CURRENCY_SYMBOL = "HRK";

    private static final Locale[] SUPPORTED_LOCALES = {new Locale(SERBOCROATIAN_LANGUAGE, CROATIA)};

    private static final String[] MONTHS = {"siječanj", "veljača", "ožujak", "travanj", "svibanj", "lipanj", "srpanj",
            "kolovoz", "rujan", "listopad", "studeni", "prosinac"};

    private static final String[] SHORT_MONTHS = {"sij", "vel", "ožu", "tra", "svi", "lip", "srp", "kol", "ruj", "lis", "stu",
            "pro"};

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
    public String[] getShortMonths() {
        return SHORT_MONTHS;
    }
}
