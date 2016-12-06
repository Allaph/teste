package allaphsamples.servegame.com.pedale.login.model;

/**
 * Created by Allaph on 03/12/2016.
 */
public class User {

    private String mEmail;
    private String mPassword;

    public User(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
    }
}
