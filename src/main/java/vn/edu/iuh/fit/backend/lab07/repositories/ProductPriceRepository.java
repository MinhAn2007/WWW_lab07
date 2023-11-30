package vn.edu.iuh.fit.backend.lab07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.lab07.entities.ProductPrice;
import vn.edu.iuh.fit.backend.lab07.pks.ProductPricePK;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK> {
}