package lld.design.zoomcar.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bill extends BaseModel{
    @ManyToOne
    private User user;
    private double amount;
    @OneToOne
    private Payment payment;
}
