package stu.hi.HBV501GFhruturinn.Persistence.Entities;

//@Entitiy
public class User {
    private String userName;
    private String password;
    private String emailAddress;
    private boolean adminPrivilege;
    private int idUser;


    public User() {
    }

    public User(String userName, String password, String emailAddress, boolean adminprivilege, int idUser) {
        this.userName = userName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.adminPrivilege = adminprivilege;
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean getAdminPrivilege() {
        return adminPrivilege;
    }

    public void setAdminPrivilege(boolean adminPrivilege) {
        this.adminPrivilege = adminPrivilege;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
