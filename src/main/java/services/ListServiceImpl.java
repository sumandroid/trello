package services;

import domain.models.Board;
import domain.models.BoardList;
import domain.models.Project;

import java.util.List;
import java.util.UUID;

public class ListServiceImpl implements ListService {

    private Project project;

    public ListServiceImpl(Project project){
        this.project = project;
    }

    @Override
    public BoardList create(String name) {
        return new BoardList(name);
    }

    @Override
    public void show(UUID id) {
        BoardList boardList = findById(id);
        System.out.println(boardList.toString());
    }

    public BoardList findById(UUID id){
        for(Board board : project.getBoards()){
            for(BoardList boardList : board.getBoardLists()){
                if(boardList.getId().equals(id)){
                    return boardList;
                }
            }
        }
        throw new RuntimeException("List Not found with id " + id);
    }
}
