package kantor.controller;

import kantor.service.CurrencyService;
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
        } catch (Exception e) {
        }
    }
}