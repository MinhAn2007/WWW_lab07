package vn.edu.iuh.fit.backend.lab07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.lab07.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}