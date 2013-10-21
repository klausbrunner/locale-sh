/**
 *
 */
package net.e175.locale;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;

public abstract class LocaleNumberFormatProvider extends NumberFormatProvider {

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
     * java.text.spi.NumberFormatProvider#getCurrencyInstance(java.util.Locale)
     */
    @Override
    public NumberFormat getCurrencyInstance(Locale locale) {
        getLocaleData().checkLocaleSupported(locale);

        DecimalFormat currencyInstance = new DecimalFormat(getLocaleData().getCurrencyFormat(),
                new LocaleDecimalFormatSymbols(getLocaleData()));
        currencyInstance.setRoundingMode(RoundingMode.HALF_UP);

        return currencyInstance;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.text.spi.NumberFormatProvider#getIntegerInstance(java.util.Locale)
     */
    @Override
    public NumberFormat getIntegerInstance(Locale locale) {
        getLocaleData().checkLocaleSupported(locale);

        DecimalFormat integerInstance = new DecimalFormat(getLocaleData().getIntegerFormat(),
                new LocaleDecimalFormatSymbols(getLocaleData()));

        // following settings are required by contract for this method
        integerInstance.setParseIntegerOnly(true);
        integerInstance.setRoundingMode(RoundingMode.HALF_EVEN);

        return integerInstance;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.text.spi.NumberFormatProvider#getNumberInstance(java.util.Locale)
     */
    @Override
    public NumberFormat getNumberInstance(Locale locale) {
        getLocaleData().checkLocaleSupported(locale);

        DecimalFormat instance = new DecimalFormat(getLocaleData().getNumberFormat(), new LocaleDecimalFormatSymbols(
                getLocaleData()));
        instance.setRoundingMode(RoundingMode.HALF_UP);

        return instance;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.text.spi.NumberFormatProvider#getPercentInstance(java.util.Locale)
     */
    @Override
    public NumberFormat getPercentInstance(Locale locale) {
        getLocaleData().checkLocaleSupported(locale);

        DecimalFormat percentInstance = new DecimalFormat(getLocaleData().getPercentFormat(),
                new LocaleDecimalFormatSymbols(getLocaleData()));
        percentInstance.setRoundingMode(RoundingMode.HALF_UP);

        return percentInstance;
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
