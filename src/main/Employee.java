import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

public class Employee {
    private static final int START_OF_WORK = 9;
    private static final int END_OF_WORK = 18;
    private static final long MINUTES = 60;
    private static final long WORK_HOURS_PER_DAY = END_OF_WORK - START_OF_WORK;
    private static final long WORK_MINUTES_PER_DAY = WORK_HOURS_PER_DAY * MINUTES;

    private double hourly_rate;
    private static int pesel;
    private double salary;
    private double netSalary;
    Timestamp hire_date;
    Timestamp finish_date;

    public Employee(Double hourly_rate, int pesel, double salary,double netSalary, Timestamp hire_date, Timestamp finish_date){
        this.hourly_rate = hourly_rate;
        this.pesel = pesel;
        this.salary = salary;
        this.netSalary = netSalary;
        this.hire_date = hire_date;
        this.finish_date = finish_date;
    }

    public  Double getHourly_rate() {
        return hourly_rate;
    }

    public static int getPesel() {
        return pesel;
    }

    public double  getSalary()  {
        return salary;
    }
    public double getNetSalary() {return netSalary;}

    public Timestamp getHire_date() {
        return hire_date;
    }

    public  Timestamp getFinish_date() {
        return finish_date;
    }


    public void setHourly_rate() {
        this.hourly_rate = hourly_rate;
    }

    public void setPesel() {
        this.pesel = pesel;
    }

    public void  setSalary() {
        this.salary = salary;
    }

    public void setNetSalary(){this.netSalary = netSalary;}

    public  void  setHire_date() {
        this.hire_date = hire_date;
    }

    public void  setFinish_date() {
        this.finish_date = finish_date;
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

        public void CalculateSalary(int pfppercentage){
        double pfamount = salary*( pfppercentage / 100);
        netSalary = salary - pfamount;
        }
}
