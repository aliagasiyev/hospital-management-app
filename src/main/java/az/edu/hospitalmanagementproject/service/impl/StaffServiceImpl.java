//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.service.impl;

import az.edu.turing.hospitalmanagementapp.dto.page.StaffPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.StaffRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.StaffResponse;
import az.edu.turing.hospitalmanagementapp.enums.RoleEnum;
import az.edu.turing.hospitalmanagementapp.exception.StaffMemberNotFoundException;
import az.edu.turing.hospitalmanagementapp.mapper.StaffMapper;
import az.edu.turing.hospitalmanagementapp.model.Staff;
import az.edu.turing.hospitalmanagementapp.repository.StaffRepository;
import az.edu.turing.hospitalmanagementapp.service.StaffService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    public StaffServiceImpl(StaffRepository staffRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }

    public void addStaffMember(StaffRequest staffRequest) {
        this.staffRepository.save(this.staffMapper.toStaffEntity(staffRequest));
    }

    public void updateStaffMemberByID(StaffRequest staffRequest, Integer id) {
        Optional<Staff> existingStaffMember = this.staffRepository.findById(id);
        if (existingStaffMember.isEmpty()) {
            throw new StaffMemberNotFoundException("Staff member not found");
        } else {
            ((Staff)existingStaffMember.get()).setFirstName(staffRequest.getFirstName());
            ((Staff)existingStaffMember.get()).setLastName(staffRequest.getLastName());
            ((Staff)existingStaffMember.get()).setAge(staffRequest.getAge());
            ((Staff)existingStaffMember.get()).setEmail(staffRequest.getEmail());
            ((Staff)existingStaffMember.get()).setPhoneNumber(staffRequest.getPhoneNumber());
            ((Staff)existingStaffMember.get()).setRoleEnum(staffRequest.getRoleEnum());
            ((Staff)existingStaffMember.get()).setDepartment(staffRequest.getDepartment());
            this.staffRepository.save((Staff)existingStaffMember.get());
        }
    }

    public void updateStaffMemberByFirstNameAndLastName(StaffRequest staffRequest, String firstName, String lastName) {
        Optional<Staff> existingStaffMember = this.staffRepository.findByFirstNameAndLastName(firstName, lastName);
        if (existingStaffMember.isEmpty()) {
            throw new StaffMemberNotFoundException("Staff member not found");
        } else {
            ((Staff)existingStaffMember.get()).setFirstName(staffRequest.getFirstName());
            ((Staff)existingStaffMember.get()).setLastName(staffRequest.getLastName());
            ((Staff)existingStaffMember.get()).setAge(staffRequest.getAge());
            ((Staff)existingStaffMember.get()).setEmail(staffRequest.getEmail());
            ((Staff)existingStaffMember.get()).setPhoneNumber(staffRequest.getPhoneNumber());
            ((Staff)existingStaffMember.get()).setRoleEnum(staffRequest.getRoleEnum());
            ((Staff)existingStaffMember.get()).setDepartment(staffRequest.getDepartment());
            this.staffRepository.save((Staff)existingStaffMember.get());
        }
    }

    public StaffPageResponse getAllStaffMembers(Integer page, Integer count) {
        Page<Staff> staffPage = this.staffRepository.findAll(PageRequest.of(page, count));
        if (staffPage.isEmpty()) {
            throw new StaffMemberNotFoundException("Staff member not found");
        } else {
            Stream var10002 = staffPage.getContent().stream();
            StaffMapper var10003 = this.staffMapper;
            var10003.getClass();
            return new StaffPageResponse((List)var10002.map(var10003::toStaffResponse).collect(Collectors.toList()), (long)staffPage.getTotalPages(), staffPage.getTotalElements(), staffPage.hasNext());
        }
    }

    public StaffPageResponse getStaffMembersByRole(RoleEnum roleEnum, Integer page, Integer count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Staff> staffPage = this.staffRepository.findByRoleEnum(roleEnum, pageable);
        if (staffPage.isEmpty()) {
            throw new StaffMemberNotFoundException("Staff member not found");
        } else {
            Stream var10002 = staffPage.getContent().stream();
            StaffMapper var10003 = this.staffMapper;
            var10003.getClass();
            return new StaffPageResponse((List)var10002.map(var10003::toStaffResponse).collect(Collectors.toList()), (long)staffPage.getTotalPages(), staffPage.getTotalElements(), staffPage.hasNext());
        }
    }

    public StaffResponse getStaffMemberByID(Integer id) {
        Stream var10000 = this.staffRepository.findById(id).stream();
        StaffMapper var10001 = this.staffMapper;
        var10001.getClass();
        return (StaffResponse)var10000.map(var10001::toStaffResponse).findFirst().orElseThrow(() -> new StaffMemberNotFoundException("Staff member not found"));
    }

    public StaffResponse getStaffMemberByFirstNamAndLastName(String firstName, String lastName) {
        Stream var10000 = this.staffRepository.findByFirstNameAndLastName(firstName, lastName).stream();
        StaffMapper var10001 = this.staffMapper;
        var10001.getClass();
        return (StaffResponse)var10000.map(var10001::toStaffResponse).findFirst().orElseThrow(() -> new StaffMemberNotFoundException("Staff member not found"));
    }

    public void deleteStaffMemberByID(Integer id) {
        if (this.staffRepository.findById(id).isEmpty()) {
            throw new StaffMemberNotFoundException("Staff member not found");
        } else {
            this.staffRepository.deleteById(id);
        }
    }

    public void deleteStaffMemberByFirstNameAndLastName(String firstName, String lastName) {
        if (this.staffRepository.findByFirstNameAndLastName(firstName, lastName).isEmpty()) {
            throw new StaffMemberNotFoundException("Staff member not found");
        } else {
            this.staffRepository.deleteByFirstNameAndLastName(firstName, lastName);
        }
    }
}
