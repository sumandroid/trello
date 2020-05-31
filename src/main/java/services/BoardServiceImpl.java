package services;

import constants.Privacy;
import domain.models.Board;
import domain.models.BoardList;
import domain.models.Member;
import domain.models.Project;

import java.util.Optional;
import java.util.UUID;

public class BoardServiceImpl implements BoardService {

    private Project project;
    private UserService userService;
    private ListService listService;

    public BoardServiceImpl(Project project){
        this.project = project;
        this.userService = new UserServiceImpl(project);
        this.listService = new ListServiceImpl(project);
    }

    @Override
    public void showBoard(UUID id) {
        Optional<Board> first = project.getBoards().stream().filter(b -> b.getId().equals(id)).findFirst();
        if(first.isPresent()){
            Board board = first.get();
            System.out.println(board.toString());
        }else{
            System.out.println("no Board foind with id: " + id);
        }
    }

    @Override
    public void showAllBoards() {
        if(project.getBoards().size() == 0){
            System.out.println("No Boards to show");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(Board board : project.getBoards()){
            stringBuilder.append(board.toString());
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void createBoard(String name) {
        Board board = new Board(name);
        project.getBoards().add(board);
        System.out.println("Created board: " + board.getId());
    }

    @Override
    public void changeAttribute(UUID id, String attrName, String val) {
        Board board = findById(id);
        if(attrName.equalsIgnoreCase("name")){
            board.setName(val);
        }else if(attrName.equalsIgnoreCase("privacy")){
            board.setPrivacy(Privacy.getEnum(val));
        }else{
            throw new IllegalArgumentException("Changing " + attrName + " is not allowed");
        }
    }

    @Override
    public void addMember(UUID id, UUID boardId) {
        Member member = userService.findById(id);
        Board board = findById(boardId);
        board.addMember(member);
        System.out.println("member added to board" + board.getName());
    }

    @Override
    public void removeMember(UUID memberId, UUID boardId) {
        Member member = userService.findById(memberId);
        Board board = findById(boardId);
        board.removeMember(member);
        System.out.println("member removed from board" + board.getName());
    }

    @Override
    public void addList(String listName, UUID boardId) {
        Board board = findById(boardId);
        BoardList boardList = listService.create(listName);
        board.addList(boardList);
        System.out.println("list : " + boardList.getName() + " has been added to board " + boardId);
    }

    private Board findById(UUID id){
        Optional<Board> first = project.getBoards().stream().filter(b -> b.getId().equals(id)).findFirst();
        if(!first.isPresent()){
            throw new RuntimeException("No board is found with id: " + id);
        }else{
            return first.get();
        }
    }


}
