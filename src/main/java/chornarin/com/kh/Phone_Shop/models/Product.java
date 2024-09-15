package chornarin.com.kh.Phone_Shop.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
@Data
@Entity
@Table(name = "products",
uniqueConstraints = {@UniqueConstraint(columnNames = {"color_id", "phonemodel_id"})})
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private Long id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "availableUint")
    private Integer availableUint;


    @ManyToOne
    @JoinColumn(name = "phoneModelId",nullable = false)
    private PhoneModel phoneModel;

    @ManyToOne
    @JoinColumn(name = "colorId", nullable = false)
    private Color color;

    @Column(name = "imagepath")
    private String imagePath;

    @Column(name = "salePrice")
    @DecimalMin(value = "0.0000001" , message = "importprice must be greater than 0")
    private BigDecimal salePrice;


}
