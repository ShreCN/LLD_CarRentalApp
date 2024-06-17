package lld.design.zoomcar.repository;

import lld.design.zoomcar.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    public Optional<Vehicle> findById(Long vehicleId);
}
