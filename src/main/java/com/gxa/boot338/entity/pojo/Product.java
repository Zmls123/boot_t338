package com.gxa.boot338.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

   private String productNO;
   private String otherInfo;
   private double price;
   private String producingArea;
   private String productName;
   private String productOwner;
   private String quantity;
   private Integer unit;
   private String producttypeNO;

}
