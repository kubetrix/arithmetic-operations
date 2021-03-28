package com.tele.dto;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Operation")
public class Operation {
    @Id
    private String id;

    @NonNull
    private BigDecimal val1;

    @NonNull
    private BigDecimal val2;

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    private BigDecimal result;

    public void setId(String id) {
        this.id = id;
    }

    public void setVal1(BigDecimal val1) {
        this.val1 = val1;
    }

    public void setVal2(BigDecimal val2) {
        this.val2 = val2;
    }

}
