package model.service;

public class PaypalService implements OnlinePaymentService {

    final double TAX_PAYMENT = 2 / 100.0;
    final double TAX_MONTH = 1 / 100.0;

    public Double paymentFee(Double amount) {
        amount += amount * TAX_PAYMENT;
        return amount;
    }

    public Double interest(Double amount, Integer month) {
        for (int i = 1; i <= month; i++) {
            amount += TAX_MONTH * (i);
        }
        return amount;
    }
}
