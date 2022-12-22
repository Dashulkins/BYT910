import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class User {
    private String firstName;
    private String lastName;
    private String phone;
    private String email; //username = email
    //private String username;
    private String password;

    private final static String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$";
    private final static Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
    private final static String PHONE_REGEX = "^(\\d{3}[- .]?){2}\\d{3}$";
    private final static Pattern phonePattern = Pattern.compile(PHONE_REGEX);
    private final static String EMAIL_REGEX = "^(\\S+)@(\\S+)$";
    private final static Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
    private final static Pattern firstLastNamesPattern = Pattern.compile("^[A-Z][a-z]*$");


    public User(String fName, String lName, String phone, String email, String password) throws NameException, EmailException, PhoneException, PasswordException, SurnameException {
        setFirstName(fName);
        setLastName(lName);
        setPhone(phone);
        setEmail(email);
        setPassword(password);
    }

    public boolean isValidFirstName(String fName) {
        Matcher matcher = firstLastNamesPattern.matcher(fName);
        return matcher.matches();
    }

    public boolean isValidLastName(String lName) {
        Matcher matcher = firstLastNamesPattern.matcher(lName);
        return matcher.matches();
    }


    public boolean isValidEmail(String email) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPhone(String phone) {
        Matcher matcher = phonePattern.matcher(phone);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }


    //getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws NameException {
        if (isValidFirstName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new NameException();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws SurnameException {
        if (isValidLastName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new SurnameException();
        }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordException {
        if (isValidPassword(password)) {
            this.password = password;
        } else {
            throw new PasswordException();
        }
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new EmailException();
        }

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws PhoneException {
        if (isValidPhone(phone)) {
            this.phone = phone;
        } else {
            throw new PhoneException();
        }
    }

    public void editData(String fName, String lName, String email, String phone, String password) throws NameException, EmailException, PhoneException, PasswordException, SurnameException {//подумать надо ли писать change методы для всего
        if (fName != null) {
            setFirstName(fName);
        }
        if (lName != null) {
            setLastName(lName);
        }
        if (email != null) {
            setEmail(email);
        }
        if (phone != null) {
            setPhone(phone);
        }
        if (password != null) {
            setPassword(password);
        }
    }

    public boolean logIn() {
        return true;
    }


    public boolean signUp() {
        return true;
    }

    @Override
    public String toString() {
        return
                "First name : '" + firstName + '\'' +
                        "Last name : " + lastName + '\'' +
                        "Phone : " + phone + '\'' +
                        "Username(email) : " + email + '\'' +
                        "Password : " + password + '\'';
    }
}