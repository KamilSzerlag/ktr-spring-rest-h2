package kantor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kantor.model.Currency;

import java.io.IOException;


public class CurrencyService {

    private static final String URL_EXCHANGE_API = "https://api.exchangeratesapi.io/latest";

    public static Currency getLatestCurrency() throws com.fasterxml.jackson.core.JsonParseException, com.fasterxml.jackson.databind.JsonMappingException, IOException {
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
