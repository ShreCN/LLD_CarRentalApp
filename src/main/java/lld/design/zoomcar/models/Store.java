package lld.design.zoomcar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Store extends BaseModel{
    private String name;
    private String address;
    @OneToMany(mappedBy = "store")
    private List<Vehicle> vehicles;

}
