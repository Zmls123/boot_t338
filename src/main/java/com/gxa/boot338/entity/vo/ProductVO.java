package com.gxa.boot338.entity.vo;

import com.gxa.boot338.entity.pojo.Product;
import lombok.Data;

/*
* pojo的父级
* */
@Data
public class ProductVO extends Product {
    private String producttypeName;
}
