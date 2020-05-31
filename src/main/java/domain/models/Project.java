package domain.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Project extends  GeneratedId{

    private String name = "suman project";
    private List<Board> boards;
    private List<Member> members;
    private static volatile Project project;

    public String getName() {
        return name;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public List<Member> getMembers() {
        return members;
    }

    private Project(){
        this.boards = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public static Project getInstance(){
        if(project == null){
            synchronized (Project.class){
                if(project == null){
                    project = new Project();
                }
            }
        }
        return project;
    }

    public void addMembers(List<Member> membersList){
        members.addAll(membersList);
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void removeMember(Member member){
        members.remove(member);
    }

    public void addBoard(Board board){
        this.boards.add(board);
    }

    public void removeBoard(Board board){
        this.boards.remove(board);
    }
}
