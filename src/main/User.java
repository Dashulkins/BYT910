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
    private final static String EMAIL_REGEX = "^(.+)@(\\S+)$";
    private final static Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
    private final static Pattern firstLastNamesPattern = Pattern.compile("^[A-Z][a-z]*$");


    public User(String fName, String lName, String phone,String email, String password) throws UserNameException, UserEmailException, UserPhoneException, UserPasswordException, UserSurnameException {
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

    public boolean isValidPhone(String phone){
        Matcher matcher = phonePattern.matcher(phone);
        return matcher.matches();
    }
    public boolean isValidPassword(String password){
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }


    //getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws UserNameException{
        if(isValidFirstName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new UserNameException();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws UserSurnameException{
        if(isValidLastName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new UserSurnameException();
        }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws UserPasswordException {
        if(isValidPassword(password)) {
            this.password = password;
        } else {
            throw new UserPasswordException();
        }
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws UserEmailException {
        if (isValidEmail(email)) {
            this.email = email;
        }else {
            throw new UserEmailException();
        }

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws UserPhoneException {
        if(isValidPhone(phone)) {
            this.phone = phone;
        } else {
            throw new UserPhoneException();
        }
    }


    //if we can not validate new data -> saves old data
   /* public void changeFirstName(String newFName) {
        String old = this.firstName;
        try{
            setFirstName(newFName);
        }catch (UserNameException e) {
            this.firstName = old;
        }
    }

    public void changeLastName(String newLName) {
        String old = this.lastName;
        try{
            setLastName(newLName);
        }catch (UserNameException e) {
            this.lastName = old;
        }
    }

    public void changeEmail(String newEmail) {
        String old = this.email;
        try{
            setEmail(newEmail);
        }catch (UserEmailException e) {
            this.email = old;
        }
    }


    public void changePhone(String newPhone) {
        String old = this.phone;
        try{
            setPhone(newPhone);
        }catch (UserPhoneException e) {
            this.phone = old;
        }
    }


    public void changePassword(String newPassword) { //if we can't verify password -> password stay old
        String oldPassword = this.password;
        try {
            setPassword(newPassword);
        } catch(UserPasswordException e) {
            this.password = oldPassword;
        }
    }*/



    public void editData(String fName, String lName, String email, String phone, String password) throws UserNameException, UserEmailException, UserPhoneException, UserPasswordException, UserSurnameException {//подумать надо ли писать change методы для всего
        if (fName != null) {
            setFirstName(fName);
        }
        if(lName != null) {
            setLastName(lName);
        }
        if(email != null) {
            setEmail(email);
        }
        if(phone != null) {
            setPhone(phone);
        }
        if(password != null) {
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
                        "Password : " + password + '\'' ;
    }
}