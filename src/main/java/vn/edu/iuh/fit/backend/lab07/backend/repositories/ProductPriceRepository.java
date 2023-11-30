package vn.edu.iuh.fit.backend.lab07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.lab07.backend.entities.ProductPrice;
import vn.edu.iuh.fit.backend.lab07.backend.pks.ProductPricePK;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK> {
}