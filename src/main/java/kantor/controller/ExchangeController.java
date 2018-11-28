package kantor.controller;

import kantor.model.Currency;
import kantor.service.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/kantor")
public class ExchangeController {

    @GetMapping("/welcome")
    private String welcomePage() {
        return "welcome-page";
    }

    @GetMapping("/currency")
    private String getLatestCurrency(@RequestParam(name = "base") String base, Model model) {

        Currency currency = new Currency();
        try {
            currency = CurrencyService.getCustomBaseCurrency(base);

        } catch (IOException e) {
            e.getStackTrace();
        }
        List<String> currencyKeysList = new LinkedList<>(currency.getRates().keySet());
        List<Float> currencyValuesList = new LinkedList<>(currency.getRates().values());
        model.addAttribute("currencyKeysList", currencyKeysList);
        model.addAttribute("currencyValuesList", currencyValuesList);

        return "kantor";
    }


}
