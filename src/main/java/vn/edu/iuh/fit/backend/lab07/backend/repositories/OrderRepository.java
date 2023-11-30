package vn.edu.iuh.fit.backend.lab07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.lab07.backend.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}