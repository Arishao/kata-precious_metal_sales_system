package com.coding.sales.utils;

import com.coding.sales.input.PaymentCommand;
import com.coding.sales.output.PaymentRepresentation;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtils {

    public static List<PaymentRepresentation> getPayments(List<PaymentCommand> paymentCommands) {

        List<PaymentRepresentation> paymentRepresentations = new ArrayList<PaymentRepresentation>();
        for (PaymentCommand paymentCommand : paymentCommands) {
            PaymentRepresentation paymentRepresentation = new PaymentRepresentation(paymentCommand.getType(), paymentCommand.getAmount());
            paymentRepresentations.add(paymentRepresentation);
        }
        return paymentRepresentations;
    }
}
