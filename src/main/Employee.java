package main;

import java.time.*;

public class Employee extends User{

    private double hourly_rate;
    private static String pesel;
    private double salary;
    private double netSalary;
    LocalDate hire_date;
    LocalDate finish_date;

    public Employee(String fName, String lName, String phone, String email, String password) throws NameException, EmailException, PhoneException, PasswordException, SurnameException, EmpPeselException {
        super(fName, lName, phone, email, password);
        this.hourly_rate = hourly_rate;
        this.salary = salary;
        this.pesel = pesel;
        this.netSalary = netSalary;
        this.hire_date = hire_date;
        this.finish_date = finish_date;
    }


    public Double getHourly_rate() {return hourly_rate; }

    public static String getPesel() {return pesel;}

    public double getSalary() {return salary;}

    public double getNetSalary() {return netSalary;}

    public LocalDate getHire_date() {return hire_date;}

    public LocalDate getFinish_date() {return finish_date;}

    public void setHourly_rate(double v) {this.hourly_rate = hourly_rate;}

    public void setPesel(String pesel) {this.pesel = Employee.pesel;}

    public void setSalary(int i) {this.salary = salary;}

    public void setNetSalary(int i) {this.netSalary = netSalary;}

    public void setHire_date() {this.hire_date = hire_date;}

    public void setFinish_date() {this.finish_date = finish_date;}

    public boolean CalculateWorkingHours() {
        return true;
    }
    public void CalculateSalary(int pfppercentage) {
        double pfamount = salary * (pfppercentage / 100);
        netSalary = salary - pfamount;
    }

    public static boolean PeselValidation(String pesel) throws EmpPeselException {
            int psize = pesel.length();
            if (psize != 11) {return false;
            }else {
                return true;
            }}
}

