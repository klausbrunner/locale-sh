package net.e175.locale.sh;

import net.e175.locale.LocaleData;
import net.e175.locale.LocaleDecimalFormatSymbolsProvider;

/**
 * A DecimalFormatSymbolsProvider class for the Serbocroatian languages.
 *
 * @author Klaus Brunner
 */
public class DecimalFormatSymbolsProvider_sh extends LocaleDecimalFormatSymbolsProvider {

    private static final LocaleData LOCALE_DATA = new Serbocroatian();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }

}
