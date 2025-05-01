package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.BedPageResponse;
import az.edu.hospitalmanagementproject.dto.request.BedRequest;
import az.edu.hospitalmanagementproject.dto.response.BedResponse;

public interface BedService {

    void addBed(BedRequest var1);

    void updateBedByBedNumber(BedRequest var1, Integer var2);

    BedPageResponse getAllBeds(Integer var1, Integer var2);

    BedPageResponse getAllAvailableBeds(Integer var1, Integer var2);

    BedResponse getBedByBedNumber(Integer var1);

    BedResponse getBedByPatientId(Integer var1);

    BedResponse getBedByPatientFirstnameAndLastname(String var1, String var2);

    boolean isAvailableOrNot(Integer var1);

    void deleteBedByBedNumber(Integer var1);
}
