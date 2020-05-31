package domain.models;

import constants.Privacy;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.BASE_URL;

public class Board extends GeneratedId {

    private String name;
    private Privacy privacy = Privacy.PUBLIC;
    private String url;
    private List<Member> members;
    private List<BoardList> boardLists;

    public Board(String name){
        this.name = name;
        this.url = BASE_URL + "/" + id;
        this.members = new ArrayList<>();
        this.boardLists = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public String getUrl() {
        return url;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<BoardList> getBoardLists() {
        return boardLists;
    }


    public void addMember(Member member){
        members.add(member);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public void removeMember(Member member){
        members.remove(member);
    }

    public void addList(BoardList boardList){
        boardLists.add(boardList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Board{");
        stringBuilder.append(super.toString());
        stringBuilder.append(
                "name='" + name + '\'' +
                ", privacy=" + privacy +
                ", url='" + url + '\'' +
                ", members=" + members +
                ", boardLists=" + boardLists +
                '}');
        return stringBuilder.toString();
    }
}
