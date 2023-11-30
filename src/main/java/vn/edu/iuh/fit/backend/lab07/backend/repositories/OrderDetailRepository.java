package vn.edu.iuh.fit.backend.lab07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.lab07.backend.entities.OrderDetail;
import vn.edu.iuh.fit.backend.lab07.backend.pks.OrderDetailPK;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}