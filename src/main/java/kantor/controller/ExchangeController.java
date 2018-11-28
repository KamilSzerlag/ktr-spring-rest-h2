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

        Currency currencyBuying = new Currency();
        Currency currencySelling = new Currency();
        try {
            currencyBuying = CurrencyService.getBuyingCurrencyPrice(base);
            currencySelling = CurrencyService.getSellingCurrencyPrice(base);
        } catch (IOException e) {
            e.getStackTrace();
        }
        List<String> currencyKeysList = new LinkedList<>(currencyBuying.getRates().keySet());
        List<Float> currencyBuyingValuesList = new LinkedList<>(currencyBuying.getRates().values());
        List<Float> currencySellingValuesList = new LinkedList<>(currencySelling.getRates().values());
        model.addAttribute("baseCurrency", base);
        model.addAttribute("currencyKeysList", currencyKeysList);
        model.addAttribute("currencyBuyingValuesList", currencyBuyingValuesList);
        model.addAttribute("currencySellingValuesList", currencySellingValuesList);

        return "list";
    }

    @GetMapping("/exchange/buy")
    private String buyExchange(@RequestParam(name = "base") String base, @RequestParam("out") String out, @RequestParam("amount") float amount, Model model) {
        float result = ExchangeService.buyingCurrent(amount, base, out);
        String message = "You will pay";
        model.addAttribute("base", base);
        model.addAttribute("out", out);
        model.addAttribute("amount", amount);
        model.addAttribute("result", result);
        model.addAttribute("message", message);
        return "result-page";
    }

    @GetMapping("/exchange/sell")
    private String sellExchange(@RequestParam(name = "base") String base, @RequestParam("out") String out, @RequestParam("amount") float amount, Model model) {
        float result = ExchangeService.sellingCurrent(amount, base, out);
        String message = "You will get";
        model.addAttribute("base", base);
        model.addAttribute("out", out);
        model.addAttribute("amount", amount);
        model.addAttribute("result", result);
        model.addAttribute("message", message);
        return "result-page";
    }

}
