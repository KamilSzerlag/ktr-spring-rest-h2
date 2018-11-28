package kantor.model;


public class Exchange {
    private String baseCurrency;
    private String outCurrency;
    private float amount;

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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
