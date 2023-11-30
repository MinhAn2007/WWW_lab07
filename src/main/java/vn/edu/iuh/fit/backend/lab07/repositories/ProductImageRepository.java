package vn.edu.iuh.fit.backend.lab07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.lab07.entities.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}