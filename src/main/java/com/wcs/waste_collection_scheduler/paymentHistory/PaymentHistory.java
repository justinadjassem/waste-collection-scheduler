package com.wcs.waste_collection_scheduler.paymentHistory;

import com.wcs.waste_collection_scheduler.billingTracker.BillingTracker;
import com.wcs.waste_collection_scheduler.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PaymentHistory extends BaseEntity<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double paymentAmount;
    private Instant paymentDate;

    @ManyToOne
    @JoinColumn(name = "billing_tracker_id")
    private BillingTracker billingTracker;
}
