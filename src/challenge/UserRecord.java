package challenge;

public class UserRecord {
    private final int id;
    private final String fullName;
    private final String email;
    private final String role;
    private boolean active;

    public UserRecord(int id, String fullName, String email, String role, boolean active) {
        this.id = id;
        this.fullName = fullName == null ? null : fullName.trim();
        this.email = email == null ? null : email.trim();
        this.role = role == null ? null : role.trim();
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
            && fullName.length() >= 3
            && email != null
            && email.contains("@")
            && role != null
            && role.length() >= 4;
    }

    public void showUserSummary() {
        System.out.printf(
            "Id: %d | Full name: %s | Email: %s | Role: %s | Active: %b%n",
            id, fullName, email, role, active
        );
    }
}