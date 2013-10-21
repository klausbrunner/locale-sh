/**
 *
 */
package net.e175.locale;

import java.text.DecimalFormatSymbols;
import java.text.spi.DecimalFormatSymbolsProvider;
import java.util.Locale;

public abstract class LocaleDecimalFormatSymbolsProvider extends DecimalFormatSymbolsProvider {

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
     * java.text.spi.DecimalFormatSymbolsProvider#getInstance(java.util.Locale)
     */
    @Override
    public DecimalFormatSymbols getInstance(Locale locale) {
        getLocaleData().checkLocaleSupported(locale);

        return new LocaleDecimalFormatSymbols(getLocaleData());
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
