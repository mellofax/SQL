import lombok.Data;

@Data
public class User {
    private String Name;
    private String Password;
    private String Mail;
    private int Id;

    public User(String name, String password, int id, String mail)
    {
        this.Name = name;
        this.Id = id;
        this.Mail = mail;
        this.Password = password;
    }

    @Override
    public String toString() {
        return "ID: " + this.Id + " | Name: " + this.Name + " | Password: " + this.Password + " | Mail: " + this.Mail;
    }
}
