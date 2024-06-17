package lld.design.zoomcar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    private Double amount;
    private String referenceNumber;
}
