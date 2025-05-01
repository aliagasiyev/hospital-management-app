package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.StaffPageResponse;
import az.edu.hospitalmanagementproject.dto.request.StaffRequest;
import az.edu.hospitalmanagementproject.dto.response.StaffResponse;
import az.edu.hospitalmanagementproject.enums.RoleEnum;

public interface StaffService {

    void addStaffMember(StaffRequest var1);

    void updateStaffMemberByID(StaffRequest var1, Integer var2);

    void updateStaffMemberByFirstNameAndLastName(StaffRequest var1, String var2, String var3);

    StaffPageResponse getAllStaffMembers(Integer var1, Integer var2);

    StaffPageResponse getStaffMembersByRole(RoleEnum var1, Integer var2, Integer var3);

    StaffResponse getStaffMemberByID(Integer var1);

    StaffResponse getStaffMemberByFirstNamAndLastName(String var1, String var2);

    void deleteStaffMemberByID(Integer var1);

    void deleteStaffMemberByFirstNameAndLastName(String var1, String var2);

}
