package services;

import domain.models.BoardList;

import java.util.UUID;

public interface ListService {

    BoardList create(String name);

    void show(UUID id);

    BoardList findById(UUID listId);
}
