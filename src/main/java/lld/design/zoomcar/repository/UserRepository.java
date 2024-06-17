package lld.design.zoomcar.repository;

import lld.design.zoomcar.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findById(Long userId);
    public Optional<User> findByPhoneNumber(String phoneNumber);
    public User save(User user);
}
