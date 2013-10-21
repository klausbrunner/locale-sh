package net.e175.locale;

import java.text.DecimalFormatSymbols;

public class LocaleDecimalFormatSymbols extends DecimalFormatSymbols {
    private static final long serialVersionUID = 1L;
    private final LocaleData localeData;

    public LocaleDecimalFormatSymbols(LocaleData localeData) {
        this.localeData = localeData;
        initializeFields();
    }

    private void initializeFields() {
        setDecimalSeparator(localeData.getDecimalSeparator());
        setGroupingSeparator(localeData.getGroupingSeparator());
        setPatternSeparator(localeData.getPatternSeparator());
        setPercent(localeData.getPercent());
        setZeroDigit(localeData.getZeroDigit());
        setDigit(localeData.getDigit());
        setMinusSign(localeData.getMinusSign());
        setExponentSeparator(localeData.getExponentSeparator());
        setPerMill(localeData.getPerMille());
        setInfinity(localeData.getInfinity());
        setNaN(localeData.getNaN());
        setCurrencySymbol(localeData.getCurrencySymbol());
    }

}
