package lld.design.zoomcar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation extends BaseModel{
    @ManyToOne
    private User user;
    @ManyToOne
    private Vehicle vehicle;
    private Date startTime;
    private Date endTime;
    @OneToOne
    private Bill bill;
}
