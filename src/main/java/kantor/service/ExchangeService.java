package kantor.service;

import java.io.IOException;

public class ExchangeService {


    public static float sellingCurrent(float exchangedValue, String baseCurrency, String outCurrency){
        return *exchangeCurrent(exchangedValue,baseCurrency,outCurrency);
    }

    private static float exchangeCurrent(float exchangedValue, String baseCurrency, String outCurrency) {

        float result = 0;

        if (exchangedValue > 0) {
            try {
                return result = exchangedValue * CurrencyService.getCustomBaseCurrency(baseCurrency).getSingleRate(outCurrency);
            } catch (IOException e) {
                e.getStackTrace();
                return result;
            }
        }
        return 0;
    }
}
