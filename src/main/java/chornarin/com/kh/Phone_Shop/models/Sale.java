package chornarin.com.kh.Phone_Shop.models;

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
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sale_id", nullable = false, unique = true)
    private Long id; 

    @Column(name = "sold_date", nullable = false, unique = true)
    private LocalDateTime solddate;

    private Boolean active;


    public Sale() {
        this.solddate = LocalDateTime.now();
    }

}
