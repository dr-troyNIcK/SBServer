package online.javalearn.spacelectrician.SpringBootExample.repository;

import online.javalearn.spacelectrician.SpringBootExample.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
