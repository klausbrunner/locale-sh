package net.e175.locale.sh;

import net.e175.locale.LocaleData;
import net.e175.locale.LocaleDateFormatSymbolsProvider;

/**
 * A DateFormatSymbolsProvider for the Serbocroatian language, Serbian (latin)
 * variant.
 *
 * @author Klaus Brunner
 */
public class DateFormatSymbolsProvider_sh_RS extends LocaleDateFormatSymbolsProvider {
    private static final LocaleData LOCALE_DATA = new Serbocroatian_RS();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }
}
