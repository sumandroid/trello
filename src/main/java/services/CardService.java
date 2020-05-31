package services;

import domain.models.Card;
import domain.models.Member;

import java.util.UUID;

public interface CardService {

    void create(UUID listId, String cardName);

    void assign(UUID cardId, Member member);

    Card findById(UUID cardId);
}
