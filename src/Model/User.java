package Model;

public class User {

    private String code;
    private String name;
    private String pass;
    private String mail;
    private int permission;

    public User(String code, String name, String pass, String mail, int permission) {
        this.code = code;
        this.name = name;
        this.pass = pass;
        this.mail = mail;
        this.permission = permission;
    }

    public User(String code, String name, int permission) {
        this.code = code;
        this.name = name;
        this.permission = permission;
    }

    public User(String code, String pass) {
        this.code = code;
        this.pass = pass;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

}
