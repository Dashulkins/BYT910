import java.time.*;

public class Employee extends User{
    private Role role;
    private Double hourlyRate;
    private static String pesel;
    private Double salary;
    private Double netSalary;
    LocalDateTime hireDate;
    LocalDateTime finishDate;
    private final static double MIN_HOUR_RATE = 20.0;
    private final static double WORKING_DAYS = 30;

    public Employee(Double hourlyRate, String pesel, Double salary, Double netSalary,LocalDateTime hireDate, LocalDateTime finishDate ) throws HourlyRateException{
        this.hourlyRate = hourlyRate;
        this.pesel = pesel;
        this.salary = salary;
        this.netSalary = netSalary;
        this.hireDate = hireDate;
        this.finishDate = finishDate;
    }

    public Employee(String fName, String lName, String phone, String email, String password) throws NameException, EmailException, PhoneException, PasswordException, SurnameException {
        super(fName, lName, phone, email, password);
    }

    public Double getHourlyRate() {return hourlyRate; }

    public String getPesel() {return pesel;}

    public Double getSalary() {return salary;}

    public Double getNetSalary() {return netSalary;}

    public LocalDateTime getHireDate() {return hireDate;}

    public LocalDateTime getFinishDate() {return finishDate;}

    public void setHourlyRate(double hourlyRate)  throws HourlyRateException{
        if (hourlyRate < MIN_HOUR_RATE){
            throw new HourlyRateException();
        }else {
            this.hourlyRate = hourlyRate;
        }
    }

    public boolean setPesel(String pesel) throws  EmpPeselException {
        if (!pesel.isEmpty()) {
            return PeselValidation("");
        } else {
            throw new EmpPeselException();
        }
    }

    public void setSalary() {
        double salary = hourlyRate * WORKING_DAYS;
    }

    public void setNetSalary(double netSalary, double taxAmount) {
        netSalary = salary - taxAmount;
    }

    public void setHireDate() {
    }

    public void setFinishDate() {
    }

    public boolean CalculateWorkingHours() {
        return true;
    }
    public void CalculateSalary(int taxPercentage) {
        double taxAmount = salary * (taxPercentage / 100.0);
        netSalary = salary - taxAmount;
    }

    public static boolean PeselValidation(String pesel) throws EmpPeselException {
        return pesel.length() == 11;
    }
}
