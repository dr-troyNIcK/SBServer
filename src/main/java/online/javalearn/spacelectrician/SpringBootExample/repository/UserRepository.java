package online.javalearn.spacelectrician.SpringBootExample.repository;

import online.javalearn.spacelectrician.SpringBootExample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
