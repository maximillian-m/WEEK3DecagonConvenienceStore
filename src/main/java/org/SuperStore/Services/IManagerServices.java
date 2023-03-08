package org.SuperStore.Services;

import org.SuperStore.Exceptions.CreteriaException;
import org.SuperStore.Models.Applicants;
import org.SuperStore.Models.Cashier;

public interface IManagerServices {
    void hireCashier(Applicants applicants) throws CreteriaException;
    void fireCashier(Cashier cashier) throws CreteriaException;
    void getListOfStockAndPrices();
    public double getStoreCash();
    public void strikeCashier(Cashier cashier);
}
