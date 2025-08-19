package model.service;

public interface OnlinePaymentService {

    final double TAX_PAYMENT = 2 / 100.0;
    final double TAX_MONTH = 1 / 100.0;

    public default Double paymentFee(Double amount) {
        amount += amount * TAX_PAYMENT;
        return amount;
    }

    public default Double interest(Double amount, Integer month) {
        return amount * TAX_MONTH * month;
    }
}
