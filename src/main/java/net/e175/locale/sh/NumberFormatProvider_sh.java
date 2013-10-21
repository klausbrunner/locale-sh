package net.e175.locale.sh;

import net.e175.locale.LocaleData;
import net.e175.locale.LocaleNumberFormatProvider;

/**
 * A NumberFormatProvider for the Serbocroatian languages.
 *
 * @author Klaus Brunner
 */
public class NumberFormatProvider_sh extends LocaleNumberFormatProvider {

    private static final LocaleData LOCALE_DATA = new Serbocroatian();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }

}
