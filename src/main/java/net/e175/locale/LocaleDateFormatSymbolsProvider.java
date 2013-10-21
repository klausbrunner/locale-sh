/**
 *
 */
package net.e175.locale;

import java.text.DateFormatSymbols;
import java.text.spi.DateFormatSymbolsProvider;
import java.util.Locale;

public abstract class LocaleDateFormatSymbolsProvider extends DateFormatSymbolsProvider {

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
     * @see
     * java.text.spi.DateFormatSymbolsProvider#getInstance(java.util.Locale)
     */
    @Override
    public DateFormatSymbols getInstance(Locale locale) {
        getLocaleData().checkLocaleSupported(locale);

        return new LocaleDateFormatSymbols(getLocaleData());
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
