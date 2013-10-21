package net.e175.locale.sh;

import net.e175.locale.LocaleData;
import net.e175.locale.LocaleDateFormatProvider;

/**
 * A DateFormatProvider class for the Serbocroatian languages.
 *
 * @author Klaus Brunner
 */
public class DateFormatProvider_sh extends LocaleDateFormatProvider {

    private static final LocaleData LOCALE_DATA = new Serbocroatian();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }

}
