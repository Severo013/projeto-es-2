package br.unesp.rc.msfinancialmanagement.dto.assembler;

import br.unesp.rc.msfinancialmanagement.dto.PaymentDTO;
import br.unesp.rc.msfinancialmanagement.entity.Payment;

public class PaymentAssembler {

    private PaymentAssembler() {
        // Private constructor to prevent instantiation
    }

    public static Payment dtoToEntityModel(PaymentDTO dto) {
        if (dto == null) {
            return null;
        }

        Payment payment = new Payment();
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setAmountPaid(dto.getAmountPaid());
        payment.setPaymentMethod(dto.getPaymentMethod());

        return payment;
    }
}
