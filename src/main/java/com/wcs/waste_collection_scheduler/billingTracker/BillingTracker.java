package com.wcs.waste_collection_scheduler.billingTracker;

import com.wcs.waste_collection_scheduler.home.Home;
import com.wcs.waste_collection_scheduler.paymentHistory.PaymentHistory;
import com.wcs.waste_collection_scheduler.utils.BaseEntity;
import com.wcs.waste_collection_scheduler.wasteCollectionProgram.WasteCollectionProgram;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BillingTracker extends BaseEntity<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalCost; // Coût total calculé pour le service de collecte
    private double amountPaid; // Montant total payé jusqu'à présent
    private double arrears; // Arriérés dus, si des paiements sont en retard
    private int totalCollections; // Nombre total de collectes effectuées

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;

    @ManyToOne
    @JoinColumn(name = "waste_collection_program_id")
    private WasteCollectionProgram wasteCollectionProgram;

    // Historique des paiements pour suivre les paiements au fil du temps
    @OneToMany(mappedBy = "billingTracker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentHistory> paymentHistory = new ArrayList<>();
}
