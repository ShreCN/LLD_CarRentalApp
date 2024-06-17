package lld.design.zoomcar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String password;
    private String address;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
    @OneToMany(mappedBy = "user")
    private List<Bill> bills;
}
