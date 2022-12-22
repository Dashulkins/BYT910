import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee extends User {
    private final List<Role> role;
    private Double hourlyRate;
    private String pesel;
    private LocalDateTime hireDate;
    private LocalDateTime finishDate;
    private final static double MIN_HOUR_RATE = 20.0;
    private final static int WORKING_DAYS = 22;
    private final static int WORKING_HOURS_PER_DAY = 8;
    private final static String PESEL_REGEX = "\\d{11}";
    private final static Pattern PESEL_PATTERN = Pattern.compile(PESEL_REGEX);

    public Employee(String fName, String lName, String phone, String email, String password, Double hourlyRate, String pesel, LocalDateTime hireDate, LocalDateTime finishDate) throws PasswordException, EmailException, PhoneException, SurnameException, NameException, EmpPeselException, HourlyRateException, TimeAfterNowException {
        super(fName, lName, phone, email, password);
        this.setHourlyRate(hourlyRate);
        this.setPesel(pesel);
        this.setHireDate(hireDate);
        this.setFinishDate(finishDate);
        role = new ArrayList<>();
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setHourlyRate(Double hourlyRate) throws HourlyRateException {
        if (hourlyRate < MIN_HOUR_RATE) {
            throw new HourlyRateException();
        } else {
            this.hourlyRate = hourlyRate;
        }
    }

    public void setPesel(String pesel) throws EmpPeselException {
        if (peselValidation(pesel)) {
            this.pesel = pesel;
        } else {
            throw new EmpPeselException();
        }
    }

    public void setHireDate(LocalDateTime hireDate) throws TimeAfterNowException {
        LocalDateTime now = LocalDateTime.now();
        if (hireDate.isAfter(now)) {
            throw new TimeAfterNowException();
        } else {
            this.hireDate = hireDate;
        }
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public int calculateWorkingHours() {
        return WORKING_DAYS * WORKING_HOURS_PER_DAY;
    }

    public Double calculateSalary() {
        return this.getHourlyRate() * calculateWorkingHours();
    }

    public static boolean peselValidation(String pesel) {
        Matcher matcher = PESEL_PATTERN.matcher(pesel);
        return matcher.matches();
    }
}
