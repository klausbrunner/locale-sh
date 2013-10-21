package net.e175.locale.sh;

import net.e175.locale.LocaleCollatorProvider;
import net.e175.locale.LocaleData;

/**
 * A CollatorProvider for the Serbocroatian languages.
 *
 * @author Klaus Brunner
 */
public class CollatorProvider_sh extends LocaleCollatorProvider {

    private static final LocaleData LOCALE_DATA = new Serbocroatian();

    @Override
    public LocaleData getLocaleData() {
        return LOCALE_DATA;
    }

}
