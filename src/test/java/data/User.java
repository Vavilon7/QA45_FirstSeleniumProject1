package data;

public class User {
    private String email;
    private String password;

    // Пустой конструктор, чтобы можно было создать объект без параметров
    public User() {}

    // Конструктор с параметрами
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    // Теперь setEmail() возвращает объект User, что позволяет вызывать setPassword()
    public User setEmail(String email) {
        this.email = email;
        return this;  // Возвращает сам объект User
    }

    public String getPassword() {
        return password;
    }

    // Аналогично, setPassword() теперь возвращает объект User
    public User setPassword(String password) {
        this.password = password;
        return this;  // Возвращает сам объект User
    }
}