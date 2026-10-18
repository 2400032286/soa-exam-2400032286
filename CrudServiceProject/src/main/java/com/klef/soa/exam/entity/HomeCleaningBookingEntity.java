
package com.klef.soa.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "home_cleaning_bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeCleaningBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String bookingDate;

    @Column(nullable = false)
    private Double serviceFee;

    @Column(nullable = false)
    private Boolean completed;
}
