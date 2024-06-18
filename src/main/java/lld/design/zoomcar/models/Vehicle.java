package lld.design.zoomcar.models;

import jakarta.persistence.*;
import lld.design.zoomcar.strategies.PricingStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Vehicle extends BaseModel{
    @Enumerated
    private VehicleType vehicleType;
    private String companyName;
    @Enumerated
    private VehicleStatus vehicleStatus;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @OneToMany(mappedBy = "vehicle")
    private List<Reservation> reservations;
}
