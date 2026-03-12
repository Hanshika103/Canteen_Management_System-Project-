

package model;

public class Admin {
    private int adminId;
    private String adminName;
    private String email;
    private String password;

    public Admin(int adminId, String adminName, String email, String password) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.email = email;
        this.password = password;
    }

    public int getAdminId() { return adminId; }
    public String getAdminName() { return adminName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setAdminId(int adminId) { this.adminId = adminId; }
    public void setAdminName(String adminName) { this.adminName = adminName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}

