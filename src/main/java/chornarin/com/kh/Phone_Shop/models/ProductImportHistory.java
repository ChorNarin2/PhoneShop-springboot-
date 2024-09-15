package chornarin.com.kh.Phone_Shop.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ProductImportHistories")
public class ProductImportHistory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)  // Specify 
    private Product product;

    @Column(name = "date_import")
    private LocalDateTime dateImport;

    @Column(name = "import_unit", nullable = false)
    private Integer importUnit;

    @Column(name = "price_per_unit", nullable = false)
    private BigDecimal priceperUnit;

    //set dateimport to be the current time;
    public ProductImportHistory(){
        this.dateImport = LocalDateTime.now();  
    }

}
