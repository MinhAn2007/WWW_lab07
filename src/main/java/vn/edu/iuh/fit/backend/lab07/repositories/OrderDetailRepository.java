package vn.edu.iuh.fit.backend.lab07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.lab07.entities.OrderDetail;
import vn.edu.iuh.fit.backend.lab07.pks.OrderDetailPK;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}