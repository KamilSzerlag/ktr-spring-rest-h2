package kantor.controller;

import kantor.model.Currency;
import kantor.model.ExchangeResult;
import kantor.service.CurrencyService;
import kantor.service.ExchangeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class RestExchangeController {


    @GetMapping("/latest")
    private Currency getLatestCurrency(@RequestParam(name = "base") String base) {
        try {
            return CurrencyService.getCustomBaseCurrency(base);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @GetMapping("/exchange")
    private ExchangeResult makeExchange(@RequestParam(name = "base") String base, @RequestParam(name = "out") String out, @RequestParam(name = "amount") float amount) {
        float result = ExchangeService.exchangeCurrent(amount, base, out);
        return new ExchangeResult(base, out, result);
    }


    @GetMapping("/help")
    private ResponseEntity website() throws IOException {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "/WEB-INF/resources/pages/help.html").build();
    }


}