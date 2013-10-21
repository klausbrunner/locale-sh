/**
 *
 */
package net.e175.locale.sh;

import net.e175.locale.LocaleData;
import net.e175.locale.LocaleDateFormatProvider;

/**
 * A DateFormatProvider for the Serbocroatian language, Croatian variant.
 *
 * @author Klaus Brunner
 */
public class DateFormatProvider_sh_HR extends LocaleDateFormatProvider {

    private static final LocaleData LOCALE_DATA = new Serbocroatian_HR();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }
}
