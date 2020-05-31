package domain.models;

public class Member extends GeneratedId {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
