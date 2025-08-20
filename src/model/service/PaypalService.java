package model.service;

public class PaypalService implements OnlinePaymentService {

    final double TAX_PAYMENT = 2 / 100.0;
    final double TAX_MONTH = 1 / 100.0;

    public double paymentFee(Double amount) {
        amount += amount * TAX_PAYMENT;
        return amount;
    }

    public double interest(Double amount, Integer month) {
        return amount * TAX_MONTH * month;
    }
}
