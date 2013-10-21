package net.e175.locale.sh;

import net.e175.locale.LocaleData;
import net.e175.locale.LocaleLocaleNameProvider;

/**
 * A LocaleNameProvider for the Serbocroatian languages (primarily Bosnian
 * usage).
 *
 * @author Klaus Brunner
 */
public class LocaleNameProvider_sh extends LocaleLocaleNameProvider {

    private static final LocaleData LOCALE_DATA = new Serbocroatian();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }

}
