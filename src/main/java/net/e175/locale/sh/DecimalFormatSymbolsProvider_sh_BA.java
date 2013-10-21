/**
 *
 */
package net.e175.locale.sh;

import net.e175.locale.LocaleData;
import net.e175.locale.LocaleDecimalFormatSymbolsProvider;

/**
 * A DecimalFormatSymbolsProvider for the Serbocroatian language, as used in
 * Bosnia.
 *
 * @author Klaus Brunner
 */
public class DecimalFormatSymbolsProvider_sh_BA extends LocaleDecimalFormatSymbolsProvider {

    private static final LocaleData LOCALE_DATA = new Serbocroatian_BA();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }
}
