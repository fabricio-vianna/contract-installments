package model.service;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer month) {

        for (int i = 1; i <= month; i++) {
            double baseAmount = contract.getTotalValue() / month;
            double valorComJuros = baseAmount + paymentService.interest(baseAmount, i);
            double finalAmount = paymentService.paymentFee(valorComJuros);
            LocalDate dueDate = contract.getDate().plusMonths(i);

            Installment inst = new Installment(finalAmount, dueDate);

            contract.addInstallment(inst);
        }
    }
}
