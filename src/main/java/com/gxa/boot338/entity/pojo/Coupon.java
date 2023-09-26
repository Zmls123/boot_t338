package com.gxa.boot338.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon implements Serializable {
   private Integer cpId;
   private String cpTitle;
   private String cpDesc;
   @JsonIgnore
   private Integer cpOff;
   private String cpRole;
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
   private LocalDateTime cpCollectExpire;
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
   private LocalDateTime cpUseExpire;
   private String cpImg;

}
