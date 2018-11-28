package kantor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kantor.model.Currency;

import java.io.IOException;
import java.util.Map;


public class CurrencyService {
    private static final String URL_EXCHANGE_API = "https://api.exchangeratesapi.io/latest";

    private static float SELLING = 0.03F;
    private static float BUYING = 0.05F;

    public static Currency getBuyingCurrencyPrice(String base) throws IOException {
        Currency buyingCurrency = getCustomBaseCurrency(base);
        for (Map.Entry<String, Float> entry :
                buyingCurrency.getRates().entrySet()) {
            entry.setValue(entry.getValue()-entry.getValue()*BUYING);
        }
        return buyingCurrency;
    }

    public static Currency getSellingCurrencyPrice(String base) throws IOException {
        Currency sellingCurrency = getCustomBaseCurrency(base);
        for (Map.Entry<String, Float> entry :
                sellingCurrency.getRates().entrySet()) {
            entry.setValue(entry.getValue()+entry.getValue()* SELLING);
        }
        return sellingCurrency;

    }


    private static Currency getDefaultLatestCurrency() throws IOException {
        String JsonStr = JsonToPojo.getJsonStr(URL_EXCHANGE_API);
        ObjectMapper mapper = new ObjectMapper();
        Currency currency = mapper.readValue(JsonStr, Currency.class);
        return currency;
    }

    private static Currency getCustomBaseCurrency(String baseCurrency) throws com.fasterxml.jackson.core.JsonParseException, com.fasterxml.jackson.databind.JsonMappingException, IOException {
        String JsonStr = JsonToPojo.getJsonStr(URL_EXCHANGE_API+"?base=" + baseCurrency);
        ObjectMapper mapper = new ObjectMapper();
        Currency currency = mapper.readValue(JsonStr, Currency.class);
        return currency;
    }

}
