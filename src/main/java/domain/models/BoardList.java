package domain.models;

import java.util.List;

public class BoardList extends GeneratedId {

    private String name;
    private List<Card> cards;

    public BoardList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List{");
        stringBuilder.append(super.toString());
        stringBuilder.append("BoardList{" +
                " name='" + name + '\'' +
                ", cards=" + cards +
                '}');
        return stringBuilder.toString();
    }
}
