package services;

import domain.models.Board;
import domain.models.Project;

import java.util.UUID;

public interface BoardService {

    void showBoard(UUID id);

    void showAllBoards();

    void createBoard(String name);

    void changeAttribute(UUID uid, String attrName, String val);

    void addMember(UUID id, UUID boardId);

    void removeMember(UUID memberId, UUID boardId);

    void addList(String listName, UUID boardId);
}
