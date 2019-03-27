package datarestandjpa.demo.repository;

import datarestandjpa.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByName(String name);
}
