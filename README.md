🏥 Hospital Management System










📌 Project Overview

Hospital Management System is a fully-featured Spring Boot-based backend application that provides RESTful APIs for managing hospital operations like patient records, staff, rooms, appointments, lab tests, medications, and prescriptions.

It supports:

Modular architecture with DTO, service, controller layers

Role-based access control using Spring Security & JWT

Pagination, validation, global exception handling

Clean and scalable design suitable for production systems

🛠️ Technologies Used

Java 17

Spring Boot 3.x

Spring Security + JWT

PostgreSQL

Maven

Lombok

MapStruct

Swagger / OpenAPI 3

📂 Project Structure (Controllers)

AuthenticationController – Login & Register

PatientController – CRUD for patients

DoctorController – CRUD for doctors + search by specialization

StaffController – Manage hospital staff

RoomController – Rooms & availability

BedController – Bed allocation and lookup

AppointmentController – Patient appointments

MedicationController – Medication CRUD

PrescriptionController – Prescription logic

LabTestController – Lab test handling

OperationController – Surgery/operation management

DepartmentController – Manage departments

🔐 Authentication API

Method

Endpoint

Access

Description

POST

/hospital/auth/register

Public

Register a new user

POST

/hospital/auth/authenticate

Public

Authenticate & return JWT

📅 Appointment API

Method

Endpoint

Access

Description

POST

/hospital/appointment/add-appointment

Admin

Create new appointment

GET

/hospital/appointment/get-all-appointments?page=0&count=10

Admin, User

Get all appointments (paginated)

GET

/hospital/appointment/get-appointment-by-id/{id}

Admin, User

Get appointment by ID

PATCH

/hospital/appointment/update-appointment-by-id/{id}

Admin

Update appointment

DELETE

/hospital/appointment/delete-appointment-by-id/{id}

Admin

Delete appointment

🛏️ Bed API

Method

Endpoint

Access

Description

POST

/hospital/bed/add-bed

Admin

Add new bed

PATCH

/hospital/bed/update-bed-by-bed-number/{bedNumber}

Admin

Update bed by number

GET

/hospital/bed/get-all-beds

Public

List all beds

GET

/hospital/bed/get-all-available-beds

Public

List available beds

GET

/hospital/bed/get-bed-by-bed-number/{bedNumber}

Public

Get bed by number

GET

/hospital/bed/get-bed-by-patient-id/{patientId}

Public

Get bed by patient ID

GET

/hospital/bed/get-bed-by-patient-firstname-and-lastname

Public

Get bed by patient name

POST

/hospital/bed/bed-is-available-or-not/{bedNumber}

Public

Check bed availability

DELETE

/hospital/bed/delete-bed-by-bed-number/{bedNumber}

Admin

Delete bed

🏥 Department API

Method

Endpoint

Access

Description

POST

/hospital/department/add-department

Admin

Add department

PATCH

/hospital/department/update-department-by-id/{id}

Admin

Update department

GET

/hospital/department/get-all-departments?page=0&count=10

Admin, User

List all departments

GET

/hospital/department/get-department-by-id/{id}

Admin, User

Get department by ID

DELETE

/hospital/department/delete-department-by-id/{id}

Admin

Delete department

🧑‍⚕️ Doctor API

Method

Endpoint

Access

Description

POST

/hospital/doctor/add-doctor

Admin

Add doctor

PATCH

/hospital/doctor/update-doctor-by-id/{id}

Admin

Update doctor by ID

PATCH

/hospital/doctor/update-doctor-by-firstname-and-lastname

Admin

Update doctor by name

GET

/hospital/doctor/get-all-doctors?page=0&count=10

Admin, User

List all doctors

GET

/hospital/doctor/get-doctors-by-specialization

Admin, User

Filter by specialization

GET

/hospital/doctor/get-doctors-by-department

Admin, User

Filter by department

GET

/hospital/doctor/get-all-doctors-order-by-age

Admin, User

Order doctors by age

GET

/hospital/doctor/get-doctor-by-id/{id}

Admin, User

Get doctor by ID

GET

/hospital/doctor/get-doctor-by-firstname-and-lastname

Admin, User

Get doctor by name

DELETE

/hospital/doctor/delete-doctor-by-id/{id}

Admin

Delete doctor by ID

DELETE

/hospital/doctor/delete-doctor-by-firstname-and-lastname

Admin

Delete doctor by name

👨‍⚕️ Patient API

Method

Endpoint

Access

Description

POST

/hospital/patient/add-patient

Admin

Add new patient

PATCH

/hospital/patient/update-patient-by-id/{id}

Admin

Update patient by ID

PATCH

/hospital/patient/update-patient-by-firstname-and-lastname

Admin

Update patient by name

GET

/hospital/patient/get-all-patients?page=0&count=10

Admin, User

Get all patients

GET

/hospital/patient/get-patient-by-id/{id}

Admin, User

Get patient by ID

GET

/hospital/patient/get-patient-by-firstname-and-lastname

Admin, User

Get patient by name

DELETE

/hospital/patient/delete-patient-by-id/{id}

Admin

Delete by ID

DELETE

/hospital/patient/delete-patient-by-id

Admin

Delete by name

💊 Medication API

Method

Endpoint

Access

Description

POST

/hospital/medication/add-medication

Admin

Add medication

PATCH

/hospital/medication/update-medication-by-id/{id}

Admin

Update medication

GET

/hospital/medication/get-all-medications?page=0&count=10

Admin, User

List medications

GET

/hospital/medication/get-medication-by-id/{id}

Admin, User

Get medication by ID

DELETE

/hospital/medication/delete-medication-by-id/{id}

Admin

Delete medication

🧪 Lab Test API

Method

Endpoint

Access

Description

POST

/hospital/laboratory/add-test

Admin

Add test

PATCH

/hospital/laboratory/update-test-by-id/{id}

Admin

Update test

GET

/hospital/laboratory/get-all-tests?page=0&count=10

Public

List tests

GET

/hospital/laboratory/get-tes-by-id/{id}

Public

Get test by ID

GET

/hospital/laboratory/get-test-by-doctor-id/{id}

Public

Tests by doctor ID

GET

/hospital/laboratory/get-test-by-patient-id/{id}

Public

Tests by patient ID

GET

/hospital/laboratory/get-test-by-doctor-firstname-and-lastname

Public

By doctor name

GET

/hospital/laboratory/get-test-by-patient-firstname-and-lastname

Public

By patient name

DELETE

/hospital/laboratory/delete-test-by-id/{id}

Admin

Delete test

💉 Prescription API

Method

Endpoint

Access

Description

POST

/hospital/prescription/add-prescription

Admin

Add prescription

PATCH

/hospital/prescription/update-prescription-by-prescription-id/{id}

Admin

Update prescription

GET

/hospital/prescription/get-all-prescriptions?page=0&count=10

Admin, User

List prescriptions

GET

/hospital/prescription/get-prescription-by-doctor-id/{id}

Admin, User

Filter by doctor

GET

/hospital/prescription/get-prescription-by-patient-id/{id}

Admin, User

Filter by patient

POST

/hospital/prescription/validate-prescription/{id}

Admin, User

Validate prescription

DELETE

/hospital/prescription/delete-prescription-by-id/{id}

Admin

Delete prescription

🏠 Room API

Method

Endpoint

Access

Description

POST

/hospital/room/add-room

Admin

Add room

PATCH

/hospital/room/update-room-by-id/{id}

Admin

Update room

GET

/hospital/room/get-all-rooms?page=0&count=10

Public

List rooms

GET

/hospital/room/get-room-by-id/{id}

Public

Get room by number

GET

/hospital/room/get-room-by-doctor-id/{id}

Public

Rooms by doctor ID

GET

/hospital/room/get-room-by-doctor-firstname-and-lastname

Public

By doctor name

GET

/hospital/room/get-room-by-patient-id/{id}

Public

Room by patient ID

GET

/hospital/room/get-room-by-patient-firstname-and-lastname

Public

By patient name

DELETE

/hospital/room/delete-room-by-room-number/{number}

Admin

Delete room

POST

/hospital/room/is-available

Public

Check availability

🧑‍💼 Staff API

Method

Endpoint

Access

Description

POST

/hospital/staff/add-staff-member

Admin

Add staff member

PATCH

/hospital/staff/update-staff-member-by-id/{id}

Admin

Update by ID

PATCH

/hospital/staff/update-staff-member-by-firstname-and-lastname

Admin

Update by name

GET

/hospital/staff/get-all-staff-members?page=0&count=10

Public

List staff

GET

/hospital/staff/get-staff-members-by-role

Public

Filter by role

GET

/hospital/staff/get-staff-member-by-id/{id}

Public

Get by ID

GET

/hospital/staff/get-staff-member-by-firstname-and-lastname

Public

Get by name

DELETE

/hospital/staff/delete-staff-member-by-id/{id}

Admin

Delete by ID

DELETE

/hospital/staff/delete-staff-member-by-firstname-and-lastname

Admin

Delete by name

⚙️ Setup & Installation

# Clone the repository
git clone git@github.com:your-username/hospital-management-app.git
cd hospital-management-app

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run

📑 Swagger API Docs

http://localhost:8080/swagger-ui/index.html

🤝 Contributing

Feel free to fork the repository and create pull requests. Use the dev branch for new features.

📄 License

Licensed under the MIT License.

