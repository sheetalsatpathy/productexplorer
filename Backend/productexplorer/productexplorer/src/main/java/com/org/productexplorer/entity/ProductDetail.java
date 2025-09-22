package com.org.productexplorer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class ProductDetail {

	 @Id
	    private Long id; 

	    @OneToOne
	    @MapsId
	    @JoinColumn(name = "product_id")
	    @JsonIgnore
	    private Product product;

	    @Column(columnDefinition = "TEXT")
	    private String description;

	    @Column(columnDefinition = "TEXT")
	    private String specsJson; 

	    private Double ratingsAvg;
	    private Integer reviewsCount;
}
