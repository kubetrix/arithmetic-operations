package com.tele.model;

import com.tele.dto.Operation;
import com.tele.dto.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class ResultBuilder {

    @Autowired
    private OperationRepo operationRepo;

    public ApiResult getResult(OperationEnum operationEnum, BigDecimal val1, BigDecimal val2) {
        return ApiResult.withResult(fetchPeristedOperation(operationEnum, val1, val2));
    }

    public ApiResult getResultFromError(String errorMessage) {
        return ApiResult.withError(errorMessage);
    }

    private BigDecimal fetchPeristedOperation(OperationEnum operationEnum, BigDecimal val1, BigDecimal val2) {
        Operation operation = null;
        String id = operationEnum.toString() + "_" + val1 + "_" + val2;

        if (operationRepo.existsById(id)) {
            operation = operationRepo.getOne(id);
            return operation.getResult();
        }
        operation = new Operation();

        if (OperationEnum.ADDITION.equals(operationEnum))
            operation.setResult(val1.add(val2));
        else if (OperationEnum.SUBTRACT.equals(operationEnum))
            operation.setResult(val1.subtract(val2));
        else if (OperationEnum.MULTIPLICATION.equals(operationEnum))
            operation.setResult(val1.multiply(val2));
        else if (OperationEnum.DIVISION.equals(operationEnum))
            operation.setResult(val1.divide(val2, RoundingMode.HALF_EVEN));

        operation.setId(id);
        operation.setVal1(val1);
        operation.setVal2(val2);
        operationRepo.save(operation);

        return operation.getResult();
    }
}
