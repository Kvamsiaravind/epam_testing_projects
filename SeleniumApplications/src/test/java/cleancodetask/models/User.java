package cleancodetask.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utilities.Utility.isValidPassword;
import static utilities.Utility.isInvalidUsername;

public class User {

    private static final String DATE_PATTERN= "yyyy/MM/dd HH:mm:ss";
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;

        User user = (User) o;
        if (isInvalidUsername(getUsername(), user.getUsername()))
            return false;
        return isValidPassword(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }

    public String getCurrentDateAsString() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        Date date = new Date();
        return dateFormat.format(date);
    }
}
