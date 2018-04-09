package com.workflow.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class Product {
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
    @ApiModelProperty(notes = "The auto-generated version of the product")
    private Integer version;
    @ApiModelProperty(notes = "The application-specific product ID")
    private String productId;
    @ApiModelProperty(notes = "Feature description")
    private String description;
    @ApiModelProperty(notes = "The image URL of the product")
    private String imageUrl;

}
