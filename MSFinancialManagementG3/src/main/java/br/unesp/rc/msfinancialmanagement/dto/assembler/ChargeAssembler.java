package br.unesp.rc.msfinancialmanagement.dto.assembler;

import br.unesp.rc.msfinancialmanagement.dto.ChargeDTO;
import br.unesp.rc.msfinancialmanagement.dto.PaymentDTO;
import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.entity.ChargeType;
import br.unesp.rc.msfinancialmanagement.entity.Payment;

import java.util.ArrayList;
import java.util.List;

public class ChargeAssembler {

    private ChargeAssembler() {
        // Private constructor to prevent instantiation
    }

    public static Charge dtoToEntityModel(ChargeDTO dto) {
        if (dto == null) {
            return null;
        }

        Charge charge = new Charge();
        charge.setId(dto.getId());
        charge.setValue(dto.getValue());
        charge.setDueDate(dto.getDueDate());
        charge.setEmissionDate(dto.getEmissionDate());
        charge.setStatus(dto.getStatus());
        charge.setChargeType(dto.getChargeType() != null ? ChargeType.valueOf(dto.getChargeType()) : null);

        if (dto.getPayments() != null) {
            List<Payment> payments = new ArrayList<>();
            for (var paymentDTO : dto.getPayments()) {
                payments.add(new Payment(
                        paymentDTO.getPaymentDate(),
                        paymentDTO.getAmountPaid(),
                        paymentDTO.getPaymentMethod()
                ));
            }
            charge.setPayments(payments);
        }

        return charge;
    }
}