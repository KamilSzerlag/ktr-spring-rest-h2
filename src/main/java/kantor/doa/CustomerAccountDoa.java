package kantor.doa;

import kantor.model.CustomerAcount;

public interface CustomerAccountDoa {

    void saveAccount(CustomerAcount account);

    void updateAccount(int theId);

    CustomerAcount getCustomerAccount(int theId);

    void deleteAccount(int theId);

}
