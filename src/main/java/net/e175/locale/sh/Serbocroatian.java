package net.e175.locale.sh;

import net.e175.locale.LocaleData;

import java.text.Collator;
import java.util.Locale;

/**
 * Various locale settings for the Serbocroatian languages (mostly Bosnian
 * usage).
 *
 * @author Klaus Brunner
 */
public class Serbocroatian implements LocaleData {

    private static final long serialVersionUID = 1L;

    private static final Locale HR_LOCALE = new Locale("hr");

    private static final String SERBOCROATIAN_LANGUAGE = "sh";

    private static final String BOSNIAN_LANGUAGE = "bs";

    private static final Locale[] SUPPORTED_LOCALES = {new Locale(BOSNIAN_LANGUAGE), new Locale(SERBOCROATIAN_LANGUAGE)};

    private static final String[] ERAS = {"p.n.e.", "n.e."};

    private static final String PATTERN_CHARS = "GanjkHmsSEDFwWxhKzZ";

    private static final String[] MONTHS = {"januar", "februar", "mart", "april", "maj", "juni", "juli", "avgust",
            "septembar", "oktobar", "novembar", "decembar"};

    private static final String[] SHORT_MONTHS = {"jan", "feb", "mar", "apr", "maj", "jun", "jul", "avg", "sep", "okt", "nov",
            "dec"};

    private static final String[] WEEKDAYS = {"", "nedjelja", "ponedjeljak", "utorak", "srijeda", "četvrtak", "petak", "subota"};

    private static final String[] SHORT_WEEKDAYS = {"", "ned", "pon", "uto", "sri", "čet", "pet", "sub"};

    private static final String DATE_SHORT = "dd.MM.yy.";

    private static final String DATE_MEDIUM = "dd.MM.yyyy.";

    private static final String DATE_LONG = "d. MMMM yyyy.";

    private static final String DATE_FULL = "EEEE, d. MMMM yyyy.";

    private static final String TIME_SHORT = "HH:mm";

    private static final String TIME_MEDIUM = "HH:mm:ss";

    private static final String TIME_LONG = "HH:mm:ss z";

    private static final String TIME_FULL = "HH:mm:ss z";

    private static final char DECIMAL_SEPARATOR = ',';

    private static final char GROUPING_SEPARATOR = '.';

    private static final char PATTERN_SEPARATOR = ';';

    private static final char PERCENT = '%';

    private static final char ZERO_DIGIT = '0';

    private static final char DIGIT = '#';

    private static final char MINUS_SIGN = '-';

    private static final String EXPONENT_SEPARATOR = "E";

    private static final char PER_MILLE = '‰';

    private static final String INFINITY = "∞";

    private static final String NAN = "NaN"; // TODO: is there anything better?

    private static final String CURRENCY_SYMBOL = "¤"; // generic currency symbol

    private static final String PERCENT_FORMAT = "#,##0%";

    private static final String NUMBER_FORMAT = "#,##0.###";

    private static final String INTEGER_FORMAT = "#,##0";

    private static final String CURRENCY_FORMAT = "¤ #,##0.00";

    private static final String[][] COUNTRY_TUPLES = {{"BA", "Bosna i Hercegovina"}, {"HR", "Hrvatska"},
            {"RS", "Srbija"}, {"SI", "Slovenija"}, {"ME", "Crna Gora"}, {"MK", "Makedonija"},
            {"CS", "Srbija i Crna Gora"}, {"YU", "Jugoslavija"}};

    private static final String[][] LANGUAGE_TUPLES = {{"en", "engleski"}, {"bs", "bosanski"}, {"hr", "hrvatski"},
            {"sr", "srpski"}, {"sl", "slovenski"}, {"mk", "makedonski"}, {"sh", "srpskohrvatski"},};

    public void checkLocaleSupported(Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("locale must not be null");
        }

        // exact search
        for (Locale supported : getSupportedLocales()) {
            if (locale.equals(supported)) {
                return;
            }
        }

        // relaxed search (seems to be necessary, but might also be a trouble
        // spot?)
        for (Locale supported : getSupportedLocales()) {
            if (locale.getLanguage().equals(supported.getLanguage())) {
                return;
            }
        }

        throw new IllegalArgumentException("unsupported locale " + locale);
    }

    public String[][] getCountryTuples() {
        return COUNTRY_TUPLES;
    }

    public String getCurrencyFormat() {
        return CURRENCY_FORMAT;
    }

    public String getCurrencySymbol() {
        return CURRENCY_SYMBOL;
    }

    public String getDateFull() {
        return DATE_FULL;
    }

    public String getDateLong() {
        return DATE_LONG;
    }

    public String getDateMedium() {
        return DATE_MEDIUM;
    }

    public String getDateShort() {
        return DATE_SHORT;
    }

    public char getDecimalSeparator() {
        return DECIMAL_SEPARATOR;
    }

    public char getDigit() {
        return DIGIT;
    }

    public String[] getEras() {
        return ERAS;
    }

    public String getExponentSeparator() {
        return EXPONENT_SEPARATOR;
    }

    public char getGroupingSeparator() {
        return GROUPING_SEPARATOR;
    }

    public String getInfinity() {
        return INFINITY;
    }

    public String getIntegerFormat() {
        return INTEGER_FORMAT;
    }

    public String[][] getLanguageTuples() {
        return LANGUAGE_TUPLES;
    }

    public char getMinusSign() {
        return MINUS_SIGN;
    }

    public String[] getMonths() {
        return MONTHS;
    }

    public String getNaN() {
        return NAN;
    }

    public String getNumberFormat() {
        return NUMBER_FORMAT;
    }

    public String getPatternChars() {
        return PATTERN_CHARS;
    }

    public char getPatternSeparator() {
        return PATTERN_SEPARATOR;
    }

    public char getPercent() {
        return PERCENT;
    }

    public String getPercentFormat() {
        return PERCENT_FORMAT;
    }

    public char getPerMille() {
        return PER_MILLE;
    }

    public String[] getShortMonths() {
        return SHORT_MONTHS;
    }

    public String[] getShortWeekdays() {
        return SHORT_WEEKDAYS;
    }

    public Locale[] getSupportedLocales() {
        return SUPPORTED_LOCALES;
    }

    public String getTimeFull() {
        return TIME_FULL;
    }

    public String getTimeLong() {
        return TIME_LONG;
    }

    public String getTimeMedium() {
        return TIME_MEDIUM;
    }

    public String getTimeShort() {
        return TIME_SHORT;
    }

    public String[] getWeekdays() {
        return WEEKDAYS;
    }

    public char getZeroDigit() {
        return ZERO_DIGIT;
    }

    public Collator getCollator() {
        return Collator.getInstance(HR_LOCALE); // TODO: shouldn't rely on HR
        // locale
    }

}
