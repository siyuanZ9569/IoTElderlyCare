package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/31/2018.
 */
public interface FlowMeterRepository extends JpaRepository<FlowMeter, Integer> {
    ArrayList<FlowMeter> findFlowMeterByResidentId(int residentId);


}
