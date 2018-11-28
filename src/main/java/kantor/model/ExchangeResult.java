package kantor.model;

public class ExchangeResult {
    private String baseCurrency;
    private String outCurrency;
    private float result;

    public ExchangeResult(String baseCurrency, String outCurrency, float result) {
        this.baseCurrency = baseCurrency;
        this.outCurrency = outCurrency;
        this.result = result;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getOutCurrency() {
        return outCurrency;
    }

    public void setOutCurrency(String outCurrency) {
        this.outCurrency = outCurrency;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}
