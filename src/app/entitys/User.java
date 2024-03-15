package app.entitys;
import app.utils.GetTimestamp;
import app.utils.PasswordValidation;

public class User {
    private String username;
    private String passwordHash;
    private boolean isActive;
    private boolean isAdmin;
    private final String email;
    private String phone;
    private String name;
    private final String salt;
    private final Long createTimestamp;
    private Long updateTimestamp;



    public User(String email,
                String username,
                String phone,
                String name,
                String salt,
                String passwordHash,
                boolean isActive,
                boolean isAdmin,
                Long createTimestamp,
                Long updateTimestamp) {
        this.email = email;
        this.username = username;
        this.salt = salt;
        this.passwordHash = passwordHash;
        this.phone = phone;

        this.name = name;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.createTimestamp = createTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public Long getUpdateTimestamp() {
        return updateTimestamp;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getSalt() {
        return salt;
    }

    public void setUsername(String username) {
        this.username = username;
        this.updateTimestamp = GetTimestamp.getTimestamp();
    }

    public void setPasswordHash(String password) {
        this.passwordHash = PasswordValidation.hashPassword(
                password, this.salt
        );
        this.updateTimestamp = GetTimestamp.getTimestamp();
    }

    public void setActive(boolean active) {
        isActive = active;
        this.updateTimestamp = GetTimestamp.getTimestamp();
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
        this.updateTimestamp = GetTimestamp.getTimestamp();
    }

    public void setPhone(String phone) {
        this.phone = phone;
        this.updateTimestamp = GetTimestamp.getTimestamp();
    }

    public void setName(String name) {
        this.name = name;
        this.updateTimestamp = GetTimestamp.getTimestamp();
    }
}
