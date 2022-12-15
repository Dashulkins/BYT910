import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Employee extends User {
    private static final int START_OF_WORK = 9;
    private static final int END_OF_WORK = 18;
    private static final long MINUTES = 60;
    private static final long WORK_HOURS_PER_DAY = END_OF_WORK - START_OF_WORK;
    private static final long WORK_MINUTES_PER_DAY = WORK_HOURS_PER_DAY * MINUTES;
    private static final Pattern peselPattern = Pattern.compile("^[0-9]{11}$");

    private double hourly_rate;
    private String pesel;
    private double salary;
    //private double netSalary;
    private Timestamp hire_date;
    private Timestamp finish_date;
    private ArrayList<Role> roles; //aggregation with Role class

    public Employee(String fName, String lName, String phone, String email, String password,double hourly_rate, String pesel, double salary, Timestamp hire_date, Timestamp finish_date) throws EmpPeselException, PhoneException, PasswordException, NameException, EmailException, SurnameException {
        super(fName, lName, phone, email, password);
        this.hourly_rate = hourly_rate;
        setPesel(pesel);
        this.salary = salary;
        this.hire_date = hire_date;
        this.finish_date = finish_date;
        roles = new ArrayList<>();
    }

    public boolean isValidPesel(String pesel)  {
        Matcher matcher = peselPattern.matcher(pesel);
        return matcher.matches();
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) throws EmpPeselException {
        if(isValidPesel(pesel)) {
            this.pesel = pesel;
        }else {
            throw new EmpPeselException();
        }

    }

    public Timestamp getHire_date() {
        return hire_date;
    }

    public int getWorkMinuterFrom(final Timestamp hire_date, Timestamp now) {
        now = Timestamp.from(Instant.now());
        return getWorkMinuterFrom(hire_date, now);
    }

    public int CalculateWorkHours(final Timestamp hire_date, final Timestamp finish_date){
        if(null == hire_date || null == finish_date) {
            throw  new IllegalStateException();
        }
        if(finish_date.before(hire_date)) {
            return  0;
        }
        LocalDateTime from = hire_date.toLocalDateTime();
        LocalDateTime to = finish_date.toLocalDateTime();

        LocalDate fromDay = from.toLocalDate();
        LocalDate toDay = to.toLocalDate();

        int allDaysBetween = (int) (ChronoUnit.DAYS.between(fromDay,toDay)+1);
        long allWorkHours = IntStream.range(0, allDaysBetween)
                .filter(i -> isWorkingDay(from.plusDays(i)))
                .count() * WORK_HOURS_PER_DAY;

        //from- work day from start;
        long tailRedundantHours = 0;
        if (isWorkingDay(from)) {
            if(isWorkingHours(from)) {
                tailRedundantHours = Duration.between(fromDay.atTime(START_OF_WORK, 0), from).toHours();
            }else if (from.getHour() > START_OF_WORK) {
                tailRedundantHours = WORK_HOURS_PER_DAY;
            }
        }

        //work day en - to
        long headRedundanHours = 0;
        if( isWorkingDay(to)) {
            if(isWorkingHours(to)) {
                headRedundanHours = Duration.between(to, toDay.atTime(END_OF_WORK,0)).toHours();
            }else if(from.getHour() < START_OF_WORK) {
                headRedundanHours = WORK_HOURS_PER_DAY;
            }
        }
        return (int) (allWorkHours = tailRedundantHours - headRedundanHours);
    }

    private  boolean isWorkingDay(final  LocalDateTime time) {
        return  time.getDayOfWeek().getValue() < DayOfWeek.SATURDAY.getValue();
    }

    private boolean isWorkingHours( final LocalDateTime time) {
        int hour = time.getHour();
        return START_OF_WORK <= hour && hour <= END_OF_WORK;
    }

    //public void CalculateSalary(int pfppercentage){ // зарплата = рабочий час * часовая ставка
     //   double pfamount = salary*( pfppercentage / 100);
      //  netSalary = salary - pfamount;
    //}
}
