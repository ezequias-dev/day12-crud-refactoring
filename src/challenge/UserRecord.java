package challenge;

public class UserRecord {
    private final int id;
    private final String fullName;
    private final String email;
    private final String role;
    private boolean active;

    public UserRecord(int id, String fullName, String email, String role, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isValidUser() {
        return fullName != null
            && fullName.trim().length() >= 3
            && email != null
            && email.contains("@")
            && role != null
            && role.trim().length() >= 4;
    }

    public void showUserSummary() {
        System.out.println(
            "Id: " + id +
            " | Full name: " + fullName +
            " | Email: " + email +
            " | Role: " + role +
            " | Active: " + active
        );
    }
}