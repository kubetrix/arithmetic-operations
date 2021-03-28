package com.tele.controller;

import com.tele.model.ApiResult;
import com.tele.model.OperationEnum;
import com.tele.model.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    ResultBuilder resultBuilder;

    /**
     * This API will perform addition for two value and give a addition output
     * @param val1(BigInteger) - First value for addition
     * @param val2(BigInteger)- Second value for addition
     * @return result(BigInteger)
     */
    @GetMapping("/add")
    public ApiResult add(@RequestParam(value = "val1") BigDecimal val1, @RequestParam(value = "val2") BigDecimal val2) {
        return resultBuilder.getResult(OperationEnum.ADDITION, val1, val2);
    }

    /**
     * This API will perform subtraction for two value and give a subtraction output
     * @param val1(BigInteger) - First value for addition
     * @param val2(BigInteger)- Second value for addition
     * @return result(BigInteger)
     */
    @GetMapping("/subtract")
    public ApiResult subtract(@RequestParam(value = "val1") BigDecimal val1, @RequestParam(value = "val2") BigDecimal val2) {
        return resultBuilder.getResult(OperationEnum.SUBTRACT, val1, val2);
    }

    /**
     * This API will perform multiplication for two value and give a multiplication output
     * @param val1(BigInteger) - First value for addition
     * @param val2(BigInteger)- Second value for addition
     * @return result(BigInteger)
     */
    @GetMapping("/multiply")
    public ApiResult multiply(@RequestParam(value = "val1") BigDecimal val1, @RequestParam(value = "val2") BigDecimal val2) {
        return resultBuilder.getResult(OperationEnum.MULTIPLICATION, val1, val2);
    }

    /**
     * This API will perform division for two value and give a division output
     * @param val1(BigInteger) - First value for addition
     * @param val2(BigInteger)- Second value for addition
     * @return result(BigInteger)
     */
    @GetMapping("/divide")
    public ApiResult divide(@RequestParam BigDecimal val1, @RequestParam BigDecimal val2) {
        if (val2.equals(BigDecimal.ZERO)) {
            return resultBuilder.getResultFromError("Divistion by 0 is not allowed");
        }
        return resultBuilder.getResult(OperationEnum.DIVISION, val1, val2);
    }
}