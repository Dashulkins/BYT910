import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class User {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String username;
    private String password;

    private final static String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private final static Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
    private final static String USERNAME_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,10}$";
    private final static Pattern userPattern = Pattern.compile(USERNAME_REGEX);
    private final static String PHONE_REGEX = "^(\\d{3}[- .]?){2}\\d{3}$";
    private final static Pattern phonePattern = Pattern.compile(PHONE_REGEX);
    private final static String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
    private final static Pattern emailPattern = Pattern.compile(EMAIL_REGEX);


    public User(String fName, String lName, String phone, String username, String password) {

    }


    public void verifyPassword(String password) throws UserPasswordException {
        Matcher matcher = passwordPattern.matcher(password);
         if(!matcher.matches()) {
             throw new UserPasswordException();
         } else {
             this.password = password;
         }
    }


    public void verifyUsername(String username) throws UserUsernameException {
        Matcher matcher = userPattern.matcher(username);
        if(!matcher.matches()) {
            throw new UserUsernameException();
        }else {
            this.username = username;
        }
    }

    public void setEmail(String email) throws UserEmailException {
        Matcher matcher = emailPattern.matcher(email);
        if(!matcher.matches()) {
            throw new UserEmailException();
        } else {
            this.email = email;
        }

    }

    public void setPhone(String phone) throws UserPhoneException {
        Matcher matcher = phonePattern.matcher(phone);
        if (!matcher.matches()) {
            throw new UserPhoneException();
        } else {
            this.phone = phone;
        }
    }
}


