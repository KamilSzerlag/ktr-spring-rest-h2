package kantor.service;

import kantor.model.Currency;

import java.io.IOException;
import java.util.Map;

public class CurrencySellingService extends CurrencyService {

    private static float SELLING = 0.025F;

    public static void setSELLING(float SELLING) {
        if (SELLING < 0 || SELLING > 1F)
            throw new IllegalArgumentException("SELLING value should be between 0 and 1");
        CurrencySellingService.SELLING = SELLING;
    }

    public static Currency getSellingCurrencyPrice(String base) throws IOException {
        Currency sellingCurrency = getCustomBaseCurrency(base);
        for (Map.Entry<String, Float> entry :
                sellingCurrency.getRates().entrySet()) {
            if (!entry.getKey().equals(base))
                entry.setValue(entry.getValue() - entry.getValue() * SELLING);
        }
        return sellingCurrency;

    }
}
