package br.unesp.rc.msfinancialmanagement.utils;

import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.entity.ChargeType;
import java.util.Date;
import java.util.ArrayList;

public class InstanceGenerator {

    private InstanceGenerator() {
        // Private constructor to prevent instantiation
    }

    public static Charge getCharge() {
        return Charge.builder()
                .id(1L)
                .value(500.0)
                .emissionDate(new Date())
                .dueDate(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000)) // 30 days from now
                .status("PENDING")
                .chargeType(ChargeType.MONTHLY_QUOTA)
                .unit(null) // Mock can have null references
                .resident(null)
                .payments(new ArrayList<>())
                .build();
    }
}
