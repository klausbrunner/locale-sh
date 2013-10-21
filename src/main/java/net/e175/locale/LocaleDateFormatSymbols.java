package net.e175.locale;

import java.text.DateFormatSymbols;

public class LocaleDateFormatSymbols extends DateFormatSymbols {
    private static final long serialVersionUID = 1L;
    private final LocaleData localeData;

    public LocaleDateFormatSymbols(LocaleData localeData) {
        this.localeData = localeData;
        initializeFields();
    }

    private void initializeFields() {
        setEras(localeData.getEras());
        setLocalPatternChars(localeData.getPatternChars());
        setMonths(localeData.getMonths());
        setShortMonths(localeData.getShortMonths());
        setWeekdays(localeData.getWeekdays());
        setShortWeekdays(localeData.getShortWeekdays());
    }

}
