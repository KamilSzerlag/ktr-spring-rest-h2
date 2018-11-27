package kantor.controller;

import kantor.service.CurrencyService;
import kantor.service.ExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class ExchangeController {


    @GetMapping("/latest")
    private void getLatestCurrency() {
        try {
            System.out.println(CurrencyService.getLatestCurrency().getSingleRate("PLN"));
            System.out.println(CurrencyService.getCustomBaseCurrency("PLN").getBase());
            System.out.println(ExchangeService.exchangeCurrent(110.20F,"PLN","USD"));
        } catch (Exception e) {
        }
    }
}