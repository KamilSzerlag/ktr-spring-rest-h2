package kantor.service;

import kantor.model.Currency;

import java.io.IOException;
import java.util.Map;

public class CurrencyBuyingService extends CurrencyService {

    private static float BUYING = 0.02F;

    public static void setBUYING(float BUYING) {
        if(BUYING<0 || BUYING>1F)
            throw new IllegalArgumentException("BUYING value should be between 0 and 1");
        CurrencyBuyingService.BUYING=  BUYING;
    }

    public static Currency getBuyingCurrencyPrice(String base) throws IOException {
        Currency buyingCurrency = getCustomBaseCurrency(base);
        for (Map.Entry<String, Float> entry :
                buyingCurrency.getRates().entrySet()) {
            if(!entry.getKey().equals(base))
                entry.setValue(entry.getValue()+entry.getValue()*BUYING);
        }
        return buyingCurrency;
    }
}
