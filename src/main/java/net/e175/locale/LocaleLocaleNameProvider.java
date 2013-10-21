/**
 *
 */
package net.e175.locale;

import java.util.Locale;
import java.util.spi.LocaleNameProvider;

public abstract class LocaleLocaleNameProvider extends LocaleNameProvider {

    /**
     * Get LocaleData for this instance. Must be provided by concrete
     * implementations.
     *
     * @return LOCALE_DATA
     */
    protected abstract LocaleData getLocaleData();

    /*
     * (non-Javadoc)
     *
     * @see java.util.spi.LocaleNameProvider#getDisplayCountry(java.lang.String,
     * java.util.Locale)
     */
    @Override
    public String getDisplayCountry(String countryCode, Locale locale) {
        getLocaleData().checkLocaleSupported(locale);

        if (badCountryCodeFormat(countryCode)) {
            throw new IllegalArgumentException("country code not in required format");
        }

        for (String[] tuple : getLocaleData().getCountryTuples()) {
            String key = tuple[0];
            String value = tuple[1];

            if (key.equals(countryCode)) {
                return value;
            }
        }

        return null;
    }

    private boolean badCountryCodeFormat(String countryCode) {
        return countryCode.length() != 2 || Character.isLowerCase(countryCode.charAt(0))
                || Character.isLowerCase(countryCode.charAt(1));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.util.spi.LocaleNameProvider#getDisplayLanguage(java.lang.String,
     * java.util.Locale)
     */
    @Override
    public String getDisplayLanguage(String languageCode, Locale locale) {
        getLocaleData().checkLocaleSupported(locale);

        if (badLanguageCodeFormat(languageCode)) {
            throw new IllegalArgumentException("language code not in required format");
        }

        for (String[] tuple : getLocaleData().getLanguageTuples()) {
            String key = tuple[0];
            String value = tuple[1];

            if (key.equals(languageCode)) {
                return value;
            }
        }

        return null;
    }

    private boolean badLanguageCodeFormat(String languageCode) {
        return languageCode.length() != 2 || Character.isUpperCase(languageCode.charAt(0))
                || Character.isUpperCase(languageCode.charAt(1));
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.spi.LocaleNameProvider#getDisplayVariant(java.lang.String,
     * java.util.Locale)
     */
    @Override
    public String getDisplayVariant(String variant, Locale locale) {
        return null;
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
