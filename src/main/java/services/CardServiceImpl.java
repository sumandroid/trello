package services;

import domain.models.*;

import java.util.UUID;

public class CardServiceImpl implements CardService {

    private ListService listService;
    private Project project;

    public CardServiceImpl(ListService listService, Project project){
        this.listService = listService;
        this.project = project;
    }

    @Override
    public void create(UUID listId, String cardName) {
        BoardList boardList = listService.findById(listId);
        Card card = new Card(cardName, cardName);
        boardList.addCard(card);
    }

    @Override
    public void assign(UUID cardId, Member member) {
        Card card = findById(cardId);
        card.setAssignedUser(member);
    }

    @Override
    public Card findById(UUID cardId) {
        for(Board board : project.getBoards()){
            for(BoardList boardList : board.getBoardLists()){
                for(Card card : boardList.getCards()){
                    if(card.getId().equals(cardId)){
                        return card;
                    }
                }
            }
        }
        throw new RuntimeException("Card not found with id: " + cardId);
    }


}
