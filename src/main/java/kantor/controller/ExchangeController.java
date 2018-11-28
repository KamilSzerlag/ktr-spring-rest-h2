package kantor.controller;

import kantor.model.Currency;
import kantor.service.CurrencyService;
import kantor.service.ExchangeService;
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

    @GetMapping("/")
    private String welcomePage(Model model) {
        try {
            List<String> keysList = new ArrayList<>(CurrencyService.getDefaultLatestCurrency().getRates().keySet());
            model.addAttribute("keysList", keysList);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return "welcome-page";
    }

    @GetMapping("/list")
    private String getLatestCurrency(@RequestParam(name = "base") String base, Model model) {

        Currency currency = new Currency();
        try {
            currency = CurrencyService.getCustomBaseCurrency(base);

        } catch (IOException e) {
            e.getStackTrace();
        }
        List<String> currencyKeysList = new LinkedList<>(currency.getRates().keySet());
        List<Float> currencyValuesList = new LinkedList<>(currency.getRates().values());
        model.addAttribute("baseCurrency", base);
        model.addAttribute("currencyKeysList", currencyKeysList);
        model.addAttribute("currencyValuesList", currencyValuesList);

        return "kantor";
    }

    @GetMapping("/result")
    private String makeExchange(@RequestParam(name = "base") String base, @RequestParam("out") String out, @RequestParam("amount") float amount, Model model) {
        float result = ExchangeService.exchangeCurrent(amount, base, out);
        model.addAttribute("base",base);
        model.addAttribute("out",out);
        model.addAttribute("amount",amount);
        model.addAttribute("result",result);
        return "result-page";
    }


}
