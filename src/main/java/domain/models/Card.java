package domain.models;

public class Card extends GeneratedId {

    private String name;
    private String description;
    private Member assignedUser;

    public Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Member getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(Member member){
        this.assignedUser = member;
    }
}
