package net.e175.locale.sh;

import net.e175.locale.LocaleData;
import net.e175.locale.LocaleDateFormatSymbolsProvider;

/**
 * A DateFormatSymbolsProvider class for the Serbocroatian languages (primarily
 * Bosnian usage).
 *
 * @author Klaus Brunner
 */
public class DateFormatSymbolsProvider_sh extends LocaleDateFormatSymbolsProvider {

    private static final LocaleData LOCALE_DATA = new Serbocroatian();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }

}
