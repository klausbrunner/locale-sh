/**
 *
 */
package net.e175.locale.sh;

import net.e175.locale.LocaleData;
import net.e175.locale.LocaleNumberFormatProvider;

/**
 * A NumberFormatProvider for the Serbocroatian language, Croatian variant.
 *
 * @author Klaus Brunner
 */
public class NumberFormatProvider_sh_HR extends LocaleNumberFormatProvider {

    private static final LocaleData LOCALE_DATA = new Serbocroatian_HR();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }

}
