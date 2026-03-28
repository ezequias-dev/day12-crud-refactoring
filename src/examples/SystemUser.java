package examples;

public class SystemUser {
    private int id;
    private String fullName;
    private String email;
    private boolean active;

    public SystemUser(int id, String fullName, String email, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isValidUser() {
        return fullName.trim().length() >= 3 && email.contains("@");
    }

    public void showSummary() {
        System.out.println(
            "Id: " + id +
                " | Name: " + fullName +
                " | Email: " + email +
                " | Active: " + active
        );
    }
}