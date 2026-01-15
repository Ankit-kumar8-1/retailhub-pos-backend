package in.ankitsaahariya.retailhub_pos.io;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDetails {

    private String razorpayOderId;
    private String razorpayPaymentId;
    private String razorpaySignature;
    private  enum PaymentStatus{
        PENDING, COMPLETED, FAILED
    }
}
