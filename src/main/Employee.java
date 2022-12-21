import java.time.*;

public class Employee extends User{

    private Double hourlyRate;
    private String pesel;
    private Double salary;
    private Double netSalary;
    LocalDate hireDate;
    LocalDate finishDate;

    public Employee(String fName, String lName, String phone, String email, String password) throws NameException, EmailException, PhoneException, PasswordException, SurnameException, EmpPeselException {
        super(fName, lName, phone, email, password);
        this.hourlyRate = hourlyRate;
        this.salary = salary;
        this.pesel = pesel;
        this.netSalary = netSalary;
        this.hireDate = hireDate;
        this.finishDate = finishDate;
    }


    public Double getHourlyRate() {return hourlyRate; }

    public String getPesel() {return pesel;}

    public Double getSalary() {return salary;}

    public Double getNetSalary() {return netSalary;}

    public LocalDate getHireDate() {return hireDate;}

    public LocalDate getFinishDate() {return finishDate;}

    public void setHourlyRate(double v) {this.hourlyRate = hourlyRate;}

    public void setPesel(String pesel) {this.pesel = Employee.pesel;}

    public void setSalary(int i) {this.salary = salary;}

    public void setNetSalary(int i) {this.netSalary = netSalary;}

    public void setHireDate() {this.hireDate = hireDate;}

    public void setFinishDate() {this.finishDate = finishDate;}

    public boolean CalculateWorkingHours() {
        return true;
    }
    public void CalculateSalary(int taxPercentage) {
        double taxAmount = salary * (taxPercentage / 100.0);
        netSalary = salary - taxAmount;
    }

    public static boolean PeselValidation(String pesel) throws EmpPeselException {
            return pesel.length() == 11;
            }}
}

