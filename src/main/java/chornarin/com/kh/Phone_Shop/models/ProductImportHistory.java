package chornarin.com.kh.Phone_Shop.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "date_import") 
    private LocalDateTime dateImport;

    
    @Column(name = "import_unit", nullable = false, unique = true)
    private Integer importUnit;

    @Column(name = "price_per_unit", nullable = false, unique = true)
    private BigDecimal priceperUnit;


}
