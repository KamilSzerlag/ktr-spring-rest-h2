package kantor.model;

import java.util.Map;

public class Wallet {

    private Map<String, Float> money;

    public Map<String, Float> getMoney() {
        return money;
    }

    public void CreateCurrncyInWallet(String currencyName) {
        this.money.put(currencyName, 0F);
    }

    public void addMoney(String moneyKey, Float money) {
        if (this.money.containsKey(moneyKey))
            this.money.put(moneyKey, this.money.get(moneyKey) + money);
    }

    public void subtractMoney(String moneyKey, Float money) {
        if (this.money.containsKey(moneyKey))
            this.money.put(moneyKey, this.money.get(moneyKey) - money);
    }

    public Float getSingleMoney(String moneyKey) {
        if (money.containsKey(moneyKey))
            return money.get(moneyKey);
        return 0.0F;
    }
}
