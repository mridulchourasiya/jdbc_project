
import Model.Payment;
import Model.*;
import Service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BDOService bdoService = new BDOService();
        GramPanchayatMemberService memberService = new GramPanchayatMemberService();
        ProjectService projectService = new ProjectService();
        EmployeeService employeeService = new EmployeeService();

        PaymentService paymentsService = new PaymentService();
        Scanner scanner = new Scanner(System.in);

        EmployeeProjectAssignmentService assignmentService = new EmployeeProjectAssignmentService();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MGNREGA Management System ---");
            System.out.println("1. Manage BDO");
            System.out.println("2. Manage Gram Panchayat Members");
            System.out.println("3. Manage Projects");
            System.out.println("4. Manage Employee-Project Assignments");
            System.out.println("5. Manage Employee");
            System.out.println("6. Manage Employee Payment");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageBDO(scanner, bdoService);
                    break;

                case 2:
                    manageGramPanchayatMember(scanner, memberService);
                    break;

                case 3:
                    manageProject(scanner, projectService);
                    break;

                case 4:
                    manageEmployeeProjectAssignment(scanner, assignmentService); // Add this
                    break;

                case 5:
                    manageEmployee(scanner, employeeService);
                    break;

                case 6:
                    managePayment(scanner, paymentsService);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    private static void managePayment(Scanner scanner, PaymentService paymentService) {
        while (true) {
            System.out.println("\n--- Payments Management ---");
            System.out.println("1. Add Payment");
            System.out.println("2. View Payment by ID");
            System.out.println("3. View All Payments");
            System.out.println("4. Update Payment");
            System.out.println("5. Delete Payment");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();

                    System.out.print("Enter Payment Date (YYYY-MM-DD): ");
                    LocalDate paymentDate = LocalDate.parse(scanner.next());

                    System.out.print("Enter Amount: ");
                    BigDecimal amount = scanner.nextBigDecimal();

                    System.out.print("Enter Payment Status (Pending, Completed): ");
                    String status = scanner.next();

                    System.out.print("Enter Payment Mode (Cash, Bank Transfer): ");
                    String paymentMode = scanner.next();

                    Payment payment = new Payment(0, employeeId, paymentDate, amount, status, paymentMode);
                    if (paymentService.addPayment(payment)) {
                        System.out.println("Payment added successfully.");
                    } else {
                        System.out.println("Failed to add payment.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Payment ID: ");
                    int id = scanner.nextInt();
                    Payment paymentById = paymentService.getPaymentById(id);
                    if (paymentById != null) {
                        System.out.println("Payment Details: " + paymentById);
                    } else {
                        System.out.println("Payment not found.");
                    }
                    break;

                case 3:
                    List<Payment> payments = paymentService.getAllPayments();
                    if (payments.isEmpty()) {
                        System.out.println("No payments found.");
                    } else {
                        System.out.println("All Payments:");
                        for (Payment p : payments) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Payment ID to update: ");
                    int updateId = scanner.nextInt();
                    Payment updatePayment = paymentService.getPaymentById(updateId);
                    if (updatePayment != null) {
                        scanner.nextLine();  // Consume newline

                        System.out.print("Employee ID (" + updatePayment.getEmployeeId() + "): ");
                        String updateEmployeeId = scanner.nextLine();
                        if (!updateEmployeeId.isEmpty())
                            updatePayment.setEmployeeId(Integer.parseInt(updateEmployeeId));

                        System.out.print("Payment Date (" + updatePayment.getPaymentDate() + "): ");
                        String updatePaymentDate = scanner.nextLine();
                        if (!updatePaymentDate.isEmpty())
                            updatePayment.setPaymentDate(LocalDate.parse(updatePaymentDate));

                        System.out.print("Amount (" + updatePayment.getAmount() + "): ");
                        String updateAmount = scanner.nextLine();
                        if (!updateAmount.isEmpty()) updatePayment.setAmount(new BigDecimal(updateAmount));

                        System.out.print("Status (" + updatePayment.getStatus() + "): ");
                        String updateStatus = scanner.nextLine();
                        if (!updateStatus.isEmpty()) updatePayment.setStatus(updateStatus);

                        System.out.print("Payment Mode (" + updatePayment.getPaymentMode() + "): ");
                        String updatePaymentMode = scanner.nextLine();
                        if (!updatePaymentMode.isEmpty()) updatePayment.setPaymentMode(updatePaymentMode);

                        if (paymentService.updatePayment(updatePayment)) {
                            System.out.println("Payment updated successfully.");
                        } else {
                            System.out.println("Failed to update payment.");
                        }
                    } else {
                        System.out.println("Payment not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Payment ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (paymentService.deletePayment(deleteId)) {
                        System.out.println("Payment deleted successfully.");
                    } else {
                        System.out.println("Failed to delete payment.");
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

//

    private static void manageBDO(Scanner scanner, BDOService bdoService) {
        while (true) {
            System.out.println("\n--- BDO Management ---");
            System.out.println("1. Add BDO");
            System.out.println("2. View BDO by ID");
            System.out.println("3. View All BDOs");
            System.out.println("4. Update BDO");
            System.out.println("5. Delete BDO");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter BDO details: ");
                    scanner.nextLine();  // Consume newline

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    BDO newBDO = new BDO();
                    newBDO.setName(name);
                    newBDO.setEmail(email);
                    newBDO.setPassword(password);
                    newBDO.setCreatedAt(LocalDateTime.now());
                    newBDO.setUpdatedAt(LocalDateTime.now());

                    if (bdoService.addBDO(newBDO)) {
                        System.out.println("BDO added successfully.");
                    } else {
                        System.out.println("Failed to add BDO.");
                    }
                    break;

                case 2:
                    System.out.print("Enter BDO ID: ");
                    int id = scanner.nextInt();
                    BDO bdoById = bdoService.getBDOById(id);
                    if (bdoById != null) {
                        System.out.println("BDO Details: " + bdoById);
                    } else {
                        System.out.println("BDO not found.");
                    }
                    break;

                case 3:
                    List<BDO> bdoList = bdoService.getAllBDOs();
                    if (bdoList.isEmpty()) {
                        System.out.println("No BDOs found.");
                    } else {
                        System.out.println("All BDOs:");
                        for (BDO bdo : bdoList) {
                            System.out.println(bdo);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter BDO ID to update: ");
                    int updateId = scanner.nextInt();
                    BDO updateBDO = bdoService.getBDOById(updateId);
                    if (updateBDO != null) {
                        scanner.nextLine();  // Consume newline

                        System.out.print("Name (" + updateBDO.getName() + "): ");
                        String updateName = scanner.nextLine();
                        if (!updateName.isEmpty()) updateBDO.setName(updateName);

                        System.out.print("Email (" + updateBDO.getEmail() + "): ");
                        String updateEmail = scanner.nextLine();
                        if (!updateEmail.isEmpty()) updateBDO.setEmail(updateEmail);

                        System.out.print("Password: ");
                        String updatePassword = scanner.nextLine();
                        if (!updatePassword.isEmpty()) updateBDO.setPassword(updatePassword);

                        updateBDO.setUpdatedAt(LocalDateTime.now());

                        if (bdoService.updateBDO(updateBDO)) {
                            System.out.println("BDO updated successfully.");
                        } else {
                            System.out.println("Failed to update BDO.");
                        }
                    } else {
                        System.out.println("BDO not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter BDO ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (bdoService.deleteBDO(deleteId)) {
                        System.out.println("BDO deleted successfully.");
                    } else {
                        System.out.println("Failed to delete BDO.");
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    private static void manageGramPanchayatMember(Scanner scanner, GramPanchayatMemberService memberService) {
        while (true) {
            System.out.println("\n--- Gram Panchayat Member Management ---");
            System.out.println("1. Add Member");
            System.out.println("2. View Member by ID");
            System.out.println("3. View Member by Email");
            System.out.println("4. View All Members");
            System.out.println("5. Update Member");
            System.out.println("6. Delete Member");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter member details: ");
                    scanner.nextLine();  // Consume newline

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    System.out.print("Contact Number: ");
                    String contactNumber = scanner.nextLine();

                    System.out.print("Address: ");
                    String address = scanner.nextLine();

                    GramPanchayatMember newMember = new GramPanchayatMember();
                    newMember.setName(name);
                    newMember.setEmail(email);
                    newMember.setPassword(password);
                    newMember.setContactNumber(contactNumber);
                    newMember.setAddress(address);
                    newMember.setCreatedAt(LocalDateTime.now());
                    newMember.setUpdatedAt(LocalDateTime.now());

                    if (memberService.addMember(newMember)) {
                        System.out.println("Member added successfully.");
                    } else {
                        System.out.println("Failed to add member.");
                    }
                    break;

                case 2:
                    System.out.print("Enter member ID: ");
                    int id = scanner.nextInt();
                    GramPanchayatMember memberById = memberService.getMemberById(id);
                    if (memberById != null) {
                        System.out.println("Member Details: " + memberById);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter member Email: ");
                    scanner.nextLine();  // Consume newline
                    String searchEmail = scanner.nextLine();
                    GramPanchayatMember memberByEmail = memberService.getMemberByEmail(searchEmail);
                    if (memberByEmail != null) {
                        System.out.println("Member Details: " + memberByEmail);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 4:
                    List<GramPanchayatMember> members = memberService.getAllMembers();
                    if (members.isEmpty()) {
                        System.out.println("No members found.");
                    } else {
                        System.out.println("All Members:");
                        for (GramPanchayatMember member : members) {
                            System.out.println(member);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter member ID to update: ");
                    int updateId = scanner.nextInt();
                    GramPanchayatMember updateMember = memberService.getMemberById(updateId);
                    if (updateMember != null) {
                        scanner.nextLine();  // Consume newline

                        System.out.print

                                ("Name (" + updateMember.getName() + "): ");
                        String updateName = scanner.nextLine();
                        if (!updateName.isEmpty()) updateMember.setName(updateName);

                        System.out.print("Email (" + updateMember.getEmail() + "): ");
                        String updateEmail = scanner.nextLine();
                        if (!updateEmail.isEmpty()) updateMember.setEmail(updateEmail);

                        System.out.print("Password: ");
                        String updatePassword = scanner.nextLine();
                        if (!updatePassword.isEmpty()) updateMember.setPassword(updatePassword);

                        System.out.print("Contact Number (" + updateMember.getContactNumber() + "): ");
                        String updateContactNumber = scanner.nextLine();
                        if (!updateContactNumber.isEmpty()) updateMember.setContactNumber(updateContactNumber);

                        System.out.print("Address (" + updateMember.getAddress() + "): ");
                        String updateAddress = scanner.nextLine();
                        if (!updateAddress.isEmpty()) updateMember.setAddress(updateAddress);

                        updateMember.setUpdatedAt(LocalDateTime.now());

                        if (memberService.updateMember(updateMember)) {
                            System.out.println("Member updated successfully.");
                        } else {
                            System.out.println("Failed to update member.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter member ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (memberService.deleteMember(deleteId)) {
                        System.out.println("Member deleted successfully.");
                    } else {
                        System.out.println("Failed to delete member.");
                    }
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    private static void manageProject(Scanner scanner, ProjectService projectService) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Expected format
        while (true) {
            System.out.println("\n--- Project Management ---");
            System.out.println("1. Add Project");
            System.out.println("2. View Project by ID");
            System.out.println("3. View All Projects");
            System.out.println("4. Update Project");
            System.out.println("5. Delete Project");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Project
                    System.out.print("Enter BDO ID: ");
                    int bdoId = scanner.nextInt();

                    System.out.print("Enter Project Name: ");
                    scanner.nextLine(); // Consume newline
                    String projectName = scanner.nextLine();

                    System.out.print("Enter Project Description: ");
                    String projectDescription = scanner.nextLine();

                    System.out.print("Enter Project Budget: ");
                    BigDecimal budget;
                    try {
                        budget = scanner.nextBigDecimal();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid budget format. Please enter a valid number.");
                        scanner.nextLine(); // Consume invalid input
                        break;
                    }

                    LocalDate startDate = null;
                    LocalDate endDate = null;

                    try {
                        System.out.print("Enter Start Date (YYYY-MM-DD): ");
                        startDate = LocalDate.parse(scanner.next(), formatter);

                        System.out.print("Enter End Date (YYYY-MM-DD): ");
                        endDate = LocalDate.parse(scanner.next(), formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                        scanner.nextLine(); // Consume invalid input
                        break;
                    }

                    System.out.print("Enter Project Status (Planned, Ongoing, Completed, Cancelled): ");
                    String status = scanner.next();

                    // Validate status
                    if (!status.matches("Planned|Ongoing|Completed|Cancelled")) {
                        System.out.println("Invalid status. Please enter one of the following: Planned, Ongoing, Completed, Cancelled.");
                        break;
                    }

                    Project project = new Project(0, bdoId, projectName, projectDescription, budget, startDate, endDate, status);
                    if (projectService.addProject(project)) {
                        System.out.println("Project added successfully.");
                    } else {
                        System.out.println("Failed to add project.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Project ID: ");
                    int projectId = scanner.nextInt();
                    Project projectById = projectService.getProjectById(projectId);
                    if (projectById != null) {
                        System.out.println("Project Details: " + projectById);
                    } else {
                        System.out.println("Project not found.");
                    }
                    break;

                case 3:
                    List<Project> projectList = projectService.getAllProjects();
                    if (projectList.isEmpty()) {
                        System.out.println("No projects found.");
                    } else {
                        System.out.println("All Projects:");
                        for (Project p : projectList) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Project ID to update: ");
                    int updateProjectId = scanner.nextInt();
                    Project updateProject = projectService.getProjectById(updateProjectId);
                    if (updateProject != null) {
                        scanner.nextLine(); // Consume newline

                        System.out.print("Name (" + updateProject.getProjectName() + "): ");
                        String updateName = scanner.nextLine();
                        if (!updateName.isEmpty()) updateProject.setProjectName(updateName);

                        System.out.print("Description (" + updateProject.getProjectDescription() + "): ");
                        String updateDescription = scanner.nextLine();
                        if (!updateDescription.isEmpty()) updateProject.setProjectDescription(updateDescription);

                        System.out.print("Budget (" + updateProject.getBudget() + "): ");
                        if (scanner.hasNextBigDecimal()) {
                            BigDecimal updateBudget = scanner.nextBigDecimal();
                            updateProject.setBudget(updateBudget);
                        }
                        scanner.nextLine(); // Consume newline

                        System.out.print("Start Date (" + updateProject.getStartDate() + "): ");
                        String updateStartDateStr = scanner.nextLine();
                        if (!updateStartDateStr.isEmpty()) {
                            LocalDate updateStartDate = LocalDate.parse(updateStartDateStr, formatter);
                            updateProject.setStartDate(updateStartDate);
                        }

                        System.out.print("End Date (" + updateProject.getEndDate() + "): ");
                        String updateEndDateStr = scanner.nextLine();
                        if (!updateEndDateStr.isEmpty()) {
                            LocalDate updateEndDate = LocalDate.parse(updateEndDateStr, formatter);
                            updateProject.setEndDate(updateEndDate);
                        }

                        System.out.print("Status (" + updateProject.getStatus() + "): ");
                        String updateStatus = scanner.nextLine();
                        if (!updateStatus.isEmpty()) {
                            if (updateStatus.matches("Planned|Ongoing|Completed|Cancelled")) {
                                updateProject.setStatus(updateStatus);
                            } else {
                                System.out.println("Invalid status. Status unchanged.");
                            }
                        }

                        if (projectService.updateProject(updateProject)) {
                            System.out.println("Project updated successfully.");
                        } else {
                            System.out.println("Failed to update project.");
                        }
                    } else {
                        System.out.println("Project not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Project ID to delete: ");
                    int deleteProjectId = scanner.nextInt();
                    if (projectService.deleteProject(deleteProjectId)) {
                        System.out.println("Project deleted successfully.");
                    } else {
                        System.out.println("Failed to delete project.");
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    private static void manageEmployee(Scanner scanner, EmployeeService employeeService) { // Add this method
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Expected format
        while (true) {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter GPM ID: ");
                    int gpmId = scanner.nextInt();

                    System.out.print("Enter Employee Name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();

                    System.out.print("Enter Gender (Male, Female, Other): ");
                    String gender = scanner.nextLine();

                    System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                    LocalDate dob = LocalDate.parse(scanner.nextLine(), formatter);

                    System.out.print("Enter Aadhaar Number: ");
                    String aadhaarNumber = scanner.nextLine();

                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();

                    System.out.print("Enter Wage Rate: ");
                    BigDecimal wageRate = scanner.nextBigDecimal();
                    scanner.nextLine(); // Consume newline

                    Employee employee = new Employee(0, gpmId, name, gender, dob, aadhaarNumber, address, contactNumber, wageRate);
                    if (employeeService.addEmployee(employee)) {
                        System.out.println("Employee added successfully.");
                    } else {
                        System.out.println("Failed to add employee.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();
                    Employee employeeById = employeeService.getEmployeeById(employeeId);
                    if (employeeById != null) {
                        System.out.println("Employee Details: " + employeeById);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    List<Employee> employeeList = employeeService.getAllEmployees();
                    if (employeeList.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("All Employees:");
                        for (Employee emp : employeeList) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to update: ");
                    int updateEmployeeId = scanner.nextInt();
                    Employee updateEmployee = employeeService.getEmployeeById(updateEmployeeId);
                    if (updateEmployee != null) {
                        scanner.nextLine(); // Consume newline

                        System.out.print("Name (" + updateEmployee.getName() + "): ");
                        String updateName = scanner.nextLine();
                        if (!updateName.isEmpty()) updateEmployee.setName(updateName);

                        System.out.print("Gender (" + updateEmployee.getGender() + "): ");
                        String updateGender = scanner.nextLine();
                        if (!updateGender.isEmpty() && updateGender.matches("Male|Female|Other"))
                            updateEmployee.setGender(updateGender);

                        System.out.print("Date of Birth (" + updateEmployee.getDob() + "): ");
                        String updateDobStr = scanner.nextLine();
                        if (!updateDobStr.isEmpty()) updateEmployee.setDob(LocalDate.parse(updateDobStr, formatter));

                        System.out.print("Aadhaar Number (" + updateEmployee.getAadhaarNumber() + "): ");
                        String updateAadhaarNumber = scanner.nextLine();
                        if (!updateAadhaarNumber.isEmpty()) updateEmployee.setAadhaarNumber(updateAadhaarNumber);

                        System.out.print("Address (" + updateEmployee.getAddress() + "): ");
                        String updateAddress = scanner.nextLine();
                        if (!updateAddress.isEmpty()) updateEmployee.setAddress(updateAddress);

                        System.out.print("Contact Number (" + updateEmployee.getContactNumber() + "): ");
                        String updateContactNumber = scanner.nextLine();
                        if (!updateContactNumber.isEmpty()) updateEmployee.setContactNumber(updateContactNumber);

                        System.out.print("Wage Rate (" + updateEmployee.getWageRate() + "): ");
                        if (scanner.hasNextBigDecimal()) {
                            BigDecimal updateWageRate = scanner.nextBigDecimal();
                            updateEmployee.setWageRate(updateWageRate);
                        }
                        scanner.nextLine(); // Consume newline

                        if (employeeService.updateEmployee(updateEmployee)) {
                            System.out.println("Employee updated successfully.");
                        } else {
                            System.out.println("Failed to update employee.");
                        }
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteEmployeeId = scanner.nextInt();
                    if (employeeService.deleteEmployee(deleteEmployeeId)) {
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("Failed to delete employee.");
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    private static void manageEmployeeProjectAssignment(Scanner scanner, EmployeeProjectAssignmentService assignmentService) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Expected format
        while (true) {
            System.out.println("\n--- Employee Project Assignment Management ---");
            System.out.println("1. Add Assignment");
            System.out.println("2. View Assignment by ID");
            System.out.println("3. View All Assignments");
            System.out.println("4. Update Assignment");
            System.out.println("5. Delete Assignment");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Assignment
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();

                    System.out.print("Enter Project ID: ");
                    int projectId = scanner.nextInt();

                    LocalDate assignedDate;
                    try {
                        System.out.print("Enter Assigned Date (YYYY-MM-DD): ");
                        assignedDate = LocalDate.parse(scanner.next(), formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                        scanner.nextLine(); // Consume invalid input
                        break;
                    }

                    System.out.print("Enter Days Worked: ");
                    int daysWorked = scanner.nextInt();

                    System.out.print("Enter Wages Earned: ");
                    BigDecimal wagesEarned;
                    try {
                        wagesEarned = scanner.nextBigDecimal();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid wages format. Please enter a valid number.");
                        scanner.nextLine(); // Consume invalid input
                        break;
                    }

                    System.out.print("Enter Assignment Status (Assigned, Completed): ");
                    String status = scanner.next();

                    // Validate status
                    if (!status.matches("Assigned|Completed")) {
                        System.out.println("Invalid status. Please enter one of the following: Assigned, Completed.");
                        break;
                    }

                    EmployeeProjectAssignment assignment = new EmployeeProjectAssignment(0, employeeId, projectId, assignedDate, daysWorked, wagesEarned, status);
                    if (assignmentService.addAssignment(assignment)) {
                        System.out.println("Assignment added successfully.");
                    } else {
                        System.out.println("Failed to add assignment.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Assignment ID: ");
                    int id = scanner.nextInt();
                    EmployeeProjectAssignment assignmentById = assignmentService.getAssignmentById(id);
                    if (assignmentById != null) {
                        System.out.println("Assignment Details: " + assignmentById);
                    } else {
                        System.out.println("Assignment not found.");
                    }
                    break;

                case 3:
                    List<EmployeeProjectAssignment> assignments = assignmentService.getAllAssignments();
                    if (assignments.isEmpty()) {
                        System.out.println("No assignments found.");
                    } else {
                        System.out.println("All Assignments:");
                        for (EmployeeProjectAssignment a : assignments) {
                            System.out.println(a);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Assignment ID to update: ");
                    int updateId = scanner.nextInt();
                    EmployeeProjectAssignment updateAssignment = assignmentService.getAssignmentById(updateId);
                    if (updateAssignment != null) {
                        scanner.nextLine();  // Consume newline

                        System.out.print("Employee ID (" + updateAssignment.getEmployeeId() + "): ");
                        String updateEmployeeId = scanner.nextLine();
                        if (!updateEmployeeId.isEmpty())
                            updateAssignment.setEmployeeId(Integer.parseInt(updateEmployeeId));

                        System.out.print("Project ID (" + updateAssignment.getProjectId() + "): ");
                        String updateProjectId = scanner.nextLine();
                        if (!updateProjectId.isEmpty())
                            updateAssignment.setProjectId(Integer.parseInt(updateProjectId));

                        System.out.print("Assigned Date (" + updateAssignment.getAssignedDate() + "): ");
                        String updateAssignedDate = scanner.nextLine();
                        if (!updateAssignedDate.isEmpty())
                            updateAssignment.setAssignedDate(LocalDate.parse(updateAssignedDate, formatter));

                        System.out.print("Days Worked (" + updateAssignment.getDaysWorked() + "): ");
                        String updateDaysWorked = scanner.nextLine();
                        if (!updateDaysWorked.isEmpty())
                            updateAssignment.setDaysWorked(Integer.parseInt(updateDaysWorked));

                        System.out.print("Wages Earned (" + updateAssignment.getWagesEarned() + "): ");
                        String updateWagesEarned = scanner.nextLine();
                        if (!updateWagesEarned.isEmpty())
                            updateAssignment.setWagesEarned(new BigDecimal(updateWagesEarned));

                        System.out.print("Status (" + updateAssignment.getStatus() + "): ");
                        String updateStatus = scanner.nextLine();
                        if (!updateStatus.isEmpty()) updateAssignment.setStatus(updateStatus);

                        updateAssignment.setUpdatedAt(LocalDateTime.now());

                        if (assignmentService.updateAssignment(updateAssignment)) {
                            System.out.println("Assignment updated successfully.");
                        } else {
                            System.out.println("Failed to update assignment.");
                        }
                    } else {
                        System.out.println("Assignment not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Assignment ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (assignmentService.deleteAssignment(deleteId)) {
                        System.out.println("Assignment deleted successfully.");
                    } else {
                        System.out.println("Failed to delete assignment.");
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }


}