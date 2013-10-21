/**
 *
 */
package net.e175.locale;

import java.text.Collator;
import java.text.spi.CollatorProvider;
import java.util.Locale;

public abstract class LocaleCollatorProvider extends CollatorProvider {

    /**
     * Get LocaleData for this instance. Must be provided by concrete
     * implementations.
     *
     * @return LOCALE_DATA
     */
    public abstract LocaleData getLocaleData();

    /*
     * (non-Javadoc)
     *
     * @see java.text.spi.CollatorProvider#getInstance(java.util.Locale)
     */
    @Override
    public Collator getInstance(Locale locale) {
        getLocaleData().checkLocaleSupported(locale);

        return getLocaleData().getCollator();

    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.spi.LocaleServiceProvider#getAvailableLocales()
     */
    @Override
    public Locale[] getAvailableLocales() {
        return getLocaleData().getSupportedLocales();
    }

}
