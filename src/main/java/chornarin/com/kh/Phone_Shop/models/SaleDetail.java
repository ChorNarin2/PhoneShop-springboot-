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
import jakarta.persistence.criteria.Join;
import lombok.Data;


@Data
@Entity
@Table(name = "SaleDetail")
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="saledetail_id", nullable = false, unique = true)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productid;

    public Product getProductid() {
        return productid;
    }

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "unit")
    private Integer unit;



}
