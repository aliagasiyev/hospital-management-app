# 🏥 Hospital Management System

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.2-brightgreen)
![Java](https://img.shields.io/badge/Java-17-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15.3-blue)
![Maven](https://img.shields.io/badge/Maven-Build-yellow)
![JWT](https://img.shields.io/badge/Security-JWT-red)
![Lombok](https://img.shields.io/badge/Lombok-Enabled-orange)
![MapStruct](https://img.shields.io/badge/MapStruct-Mapping-lightgrey)
![License](https://img.shields.io/badge/License-MIT-informational)

## 📌 Project Overview

**Hospital Management System** is a fully-featured Spring Boot-based backend application providing RESTful APIs to manage hospital operations such as patient records, staff, rooms, appointments, lab tests, medications, and prescriptions.

**Key Features:**

- Modular architecture with DTO, Service, Controller layers  
- Role-based access control with Spring Security & JWT  
- Pagination, validation, and global exception handling  
- Clean, scalable, and production-ready backend structure

---

## 🛠️ Technologies Used

- Java 17  
- Spring Boot 3.x  
- Spring Security + JWT  
- PostgreSQL  
- Maven  
- Lombok  
- MapStruct  
- Swagger / OpenAPI 3  

---

## 📂 Project Structure (Controllers)

- `AuthenticationController` – Login & Register  
- `PatientController` – CRUD operations for patients  
- `DoctorController` – CRUD & filtering by specialization/department  
- `StaffController` – Manage hospital staff  
- `RoomController` – Room allocation and availability  
- `BedController` – Bed management  
- `AppointmentController` – Handle appointments  
- `MedicationController` – CRUD for medications  
- `PrescriptionController` – Manage prescriptions  
- `LabTestController` – Lab test handling  
- `OperationController` – Manage surgeries/operations  
- `DepartmentController` – Hospital departments  

---

## 🔐 Authentication API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/auth/register` | Public | Register new user |
| POST | `/hospital/auth/authenticate` | Public | Authenticate & return JWT |

---

## 📅 Appointment API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/appointment/add-appointment` | Admin | Create appointment |
| GET | `/hospital/appointment/get-all-appointments?page=0&count=10` | Admin, User | Get all appointments |
| GET | `/hospital/appointment/get-appointment-by-id/{id}` | Admin, User | Get appointment by ID |
| PATCH | `/hospital/appointment/update-appointment-by-id/{id}` | Admin | Update appointment |
| DELETE | `/hospital/appointment/delete-appointment-by-id/{id}` | Admin | Delete appointment |

---

## 🛏️ Bed API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/bed/add-bed` | Admin | Add new bed |
| PATCH | `/hospital/bed/update-bed-by-bed-number/{bedNumber}` | Admin | Update bed |
| GET | `/hospital/bed/get-all-beds` | Public | List all beds |
| GET | `/hospital/bed/get-all-available-beds` | Public | Available beds |
| GET | `/hospital/bed/get-bed-by-bed-number/{bedNumber}` | Public | Get bed |
| GET | `/hospital/bed/get-bed-by-patient-id/{patientId}` | Public | Get bed by patient |
| GET | `/hospital/bed/get-bed-by-patient-firstname-and-lastname` | Public | Get bed by name |
| POST | `/hospital/bed/bed-is-available-or-not/{bedNumber}` | Public | Check availability |
| DELETE | `/hospital/bed/delete-bed-by-bed-number/{bedNumber}` | Admin | Delete bed |

---

## 🏥 Department API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/department/add-department` | Admin | Add department |
| PATCH | `/hospital/department/update-department-by-id/{id}` | Admin | Update department |
| GET | `/hospital/department/get-all-departments?page=0&count=10` | Admin, User | List departments |
| GET | `/hospital/department/get-department-by-id/{id}` | Admin, User | Get department |
| DELETE | `/hospital/department/delete-department-by-id/{id}` | Admin | Delete department |

---

## 🧑‍⚕️ Doctor API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/doctor/add-doctor` | Admin | Add doctor |
| PATCH | `/hospital/doctor/update-doctor-by-id/{id}` | Admin | Update by ID |
| PATCH | `/hospital/doctor/update-doctor-by-firstname-and-lastname` | Admin | Update by name |
| GET | `/hospital/doctor/get-all-doctors?page=0&count=10` | Admin, User | List doctors |
| GET | `/hospital/doctor/get-doctors-by-specialization` | Admin, User | Filter by specialization |
| GET | `/hospital/doctor/get-doctors-by-department` | Admin, User | Filter by department |
| GET | `/hospital/doctor/get-all-doctors-order-by-age` | Admin, User | Sort by age |
| GET | `/hospital/doctor/get-doctor-by-id/{id}` | Admin, User | Get by ID |
| GET | `/hospital/doctor/get-doctor-by-firstname-and-lastname` | Admin, User | Get by name |
| DELETE | `/hospital/doctor/delete-doctor-by-id/{id}` | Admin | Delete by ID |
| DELETE | `/hospital/doctor/delete-doctor-by-firstname-and-lastname` | Admin | Delete by name |

---

## 👨‍⚕️ Patient API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/patient/add-patient` | Admin | Add patient |
| PATCH | `/hospital/patient/update-patient-by-id/{id}` | Admin | Update by ID |
| PATCH | `/hospital/patient/update-patient-by-firstname-and-lastname` | Admin | Update by name |
| GET | `/hospital/patient/get-all-patients?page=0&count=10` | Admin, User | List patients |
| GET | `/hospital/patient/get-patient-by-id/{id}` | Admin, User | Get by ID |
| GET | `/hospital/patient/get-patient-by-firstname-and-lastname` | Admin, User | Get by name |
| DELETE | `/hospital/patient/delete-patient-by-id/{id}` | Admin | Delete by ID |
| DELETE | `/hospital/patient/delete-patient-by-firstname-and-lastname` | Admin | Delete by name |

---

## 💊 Medication API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/medication/add-medication` | Admin | Add medication |
| PATCH | `/hospital/medication/update-medication-by-id/{id}` | Admin | Update |
| GET | `/hospital/medication/get-all-medications?page=0&count=10` | Admin, User | List medications |
| GET | `/hospital/medication/get-medication-by-id/{id}` | Admin, User | Get by ID |
| DELETE | `/hospital/medication/delete-medication-by-id/{id}` | Admin | Delete |

---

## 🧪 Lab Test API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/laboratory/add-test` | Admin | Add test |
| PATCH | `/hospital/laboratory/update-test-by-id/{id}` | Admin | Update test |
| GET | `/hospital/laboratory/get-all-tests?page=0&count=10` | Public | List all tests |
| GET | `/hospital/laboratory/get-test-by-id/{id}` | Public | Get test by ID |
| GET | `/hospital/laboratory/get-test-by-doctor-id/{id}` | Public | By doctor ID |
| GET | `/hospital/laboratory/get-test-by-patient-id/{id}` | Public | By patient ID |
| GET | `/hospital/laboratory/get-test-by-doctor-firstname-and-lastname` | Public | By doctor name |
| GET | `/hospital/laboratory/get-test-by-patient-firstname-and-lastname` | Public | By patient name |
| DELETE | `/hospital/laboratory/delete-test-by-id/{id}` | Admin | Delete test |

---

## 💉 Prescription API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/prescription/add-prescription` | Admin | Add prescription |
| PATCH | `/hospital/prescription/update-prescription-by-prescription-id/{id}` | Admin | Update |
| GET | `/hospital/prescription/get-all-prescriptions?page=0&count=10` | Admin, User | List all |
| GET | `/hospital/prescription/get-prescription-by-doctor-id/{id}` | Admin, User | By doctor |
| GET | `/hospital/prescription/get-prescription-by-patient-id/{id}` | Admin, User | By patient |
| POST | `/hospital/prescription/validate-prescription/{id}` | Admin, User | Validate |
| DELETE | `/hospital/prescription/delete-prescription-by-id/{id}` | Admin | Delete |

---

## 🏠 Room API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/room/add-room` | Admin | Add room |
| PATCH | `/hospital/room/update-room-by-id/{id}` | Admin | Update |
| GET | `/hospital/room/get-all-rooms?page=0&count=10` | Public | List rooms |
| GET | `/hospital/room/get-room-by-id/{id}` | Public | Get by ID |
| GET | `/hospital/room/get-room-by-doctor-id/{id}` | Public | By doctor ID |
| GET | `/hospital/room/get-room-by-doctor-firstname-and-lastname` | Public | By doctor name |
| GET | `/hospital/room/get-room-by-patient-id/{id}` | Public | By patient ID |
| GET | `/hospital/room/get-room-by-patient-firstname-and-lastname` | Public | By patient name |
| DELETE | `/hospital/room/delete-room-by-room-number/{number}` | Admin | Delete room |
| POST | `/hospital/room/is-available` | Public | Check availability |

---

## 🧑‍💼 Staff API

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| POST | `/hospital/staff/add-staff-member` | Admin | Add staff |
| PATCH | `/hospital/staff/update-staff-member-by-id/{id}` | Admin | Update by ID |
| PATCH | `/hospital/staff/update-staff-member-by-firstname-and-lastname` | Admin | Update by name |
| GET | `/hospital/staff/get-all-staff-members?page=0&count=10` | Public | List staff |
| GET | `/hospital/staff/get-staff-members-by-role` | Public | Filter by role |
| GET | `/hospital/staff/get-staff-member-by-id/{id}` | Public | Get by ID |
| GET | `/hospital/staff/get-staff-member-by-firstname-and-lastname` | Public | Get by name |
| DELETE | `/hospital/staff/delete-staff-member-by-id/{id}` | Admin | Delete by ID |
| DELETE | `/hospital/staff/delete-staff-member-by-firstname-and-lastname` | Admin | Delete by name |

---

## ⚙️ Setup & Installation

```bash
# Clone the repository
git clone git@github.com:your-username/hospital-management-app.git
cd hospital-management-app

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
