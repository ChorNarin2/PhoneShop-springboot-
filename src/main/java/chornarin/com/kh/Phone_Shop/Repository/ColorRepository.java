package chornarin.com.kh.Phone_Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chornarin.com.kh.Phone_Shop.models.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

}
