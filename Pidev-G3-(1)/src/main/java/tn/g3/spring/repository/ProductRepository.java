package tn.g3.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.g3.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
