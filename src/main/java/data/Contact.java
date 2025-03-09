package data;

public class Contact {
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String ConfirmPassword;

    public Contact() {}

    public Contact(String firstName, String lastName, String email, String password, String confirmPassword) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Password = password;
        this.ConfirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return FirstName;
    }

    public Contact setFirstName(String firstName) {
        this.FirstName = firstName;
        return this;
    }

    public String getLastName() {
        return LastName;
    }

    public Contact setLastName(String lastName) {
        this.LastName = lastName;
        return this;
    }

    public String getEmail() {
        return Email;
    }

    public Contact setEmail(String email) {
        this.Email = email;
        return this;
    }

    public String getPassword() {
        return Password;
    }

    public Contact setPassword(String password) {
        this.Password = password;
        return this;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public Contact setConfirmPassword(String confirmPassword) {
        this.ConfirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", ConfirmPassword='" + ConfirmPassword + '\'' +
                '}';
    }
}