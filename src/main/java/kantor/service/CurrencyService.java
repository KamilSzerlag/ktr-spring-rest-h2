package kantor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kantor.model.Currency;

import java.io.IOException;
import java.util.Map;


public class CurrencyService {
    private static final String URL_EXCHANGE_API = "https://api.exchangeratesapi.io/latest";

    private static float SELLING = 0.025F;
    private static float BUYING = 0.02F;

    public static void setSELLING(float SELLING) {
        if(SELLING<0 || SELLING>1F)
            throw new IllegalArgumentException("SELLING value should be between 0 and 1");
        CurrencyService.SELLING = SELLING;
    }

    public static void setBUYING(float BUYING) {
        if(BUYING<0 || BUYING>1F)
            throw new IllegalArgumentException("BUYING value should be between 0 and 1");
        CurrencyService.BUYING = BUYING;
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

    public static Currency getSellingCurrencyPrice(String base) throws IOException {
        Currency sellingCurrency = getCustomBaseCurrency(base);
        for (Map.Entry<String, Float> entry :
                sellingCurrency.getRates().entrySet()) {
            if(!entry.getKey().equals(base))
            entry.setValue(entry.getValue()-entry.getValue()* SELLING);
        }
        return sellingCurrency;

    }

    public static Currency getDefaultLatestCurrency() throws IOException {
        String JsonStr = JsonToPojo.getJsonStr(URL_EXCHANGE_API);
        ObjectMapper mapper = new ObjectMapper();
        Currency currency = mapper.readValue(JsonStr, Currency.class);
        return currency;
    }

    public static Currency getCustomBaseCurrency(String baseCurrency) throws com.fasterxml.jackson.core.JsonParseException, com.fasterxml.jackson.databind.JsonMappingException, IOException {
        String JsonStr = JsonToPojo.getJsonStr(URL_EXCHANGE_API+"?base=" + baseCurrency);
        ObjectMapper mapper = new ObjectMapper();
        Currency currency = mapper.readValue(JsonStr, Currency.class);
        return currency;
    }

}
