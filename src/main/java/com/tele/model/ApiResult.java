package com.tele.model;

import java.math.BigDecimal;

public class ApiResult {

   private BigDecimal result;
   private String error="Result Ok";

   private ApiResult() {
   }

   public static ApiResult withResult(BigDecimal resultMessage) {
      ApiResult apiResult = new ApiResult();
      apiResult.result = resultMessage;
      return apiResult;
   }

   public static ApiResult withError(String errorMessage) {
      ApiResult apiResult = new ApiResult();
      apiResult.error = errorMessage;
      return apiResult;
   }

   public BigDecimal getResult() {
      return result;
   }

   public String getError() {
      return error;
   }
}
