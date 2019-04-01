package blackJack;

import java.util.LinkedList;
import java.util.List;

public class CardDeck {
    private List<Card> cards; 
    private static final String[] PATTERNS = {"spade", "heart", "diamond", "club"};
    private static final int CARD_COUNT = 13;
    
    public CardDeck(){
    	cards = this.generateCards();
    }
    
    private List<Card> generateCards() {
    	cards = new LinkedList<>();
    	
    	for(String pattern : PATTERNS){
    		for(int i=1;i<=CARD_COUNT;i++){
        		//객체를 생성한 뒤에 set을 이용하여 값을 넣는 방식이 아닌 객체 생성과 동시에 값을 넣는 방식으로 수정
        		Card card = new Card(pattern ,i);
        		cards.add(card);		
    		}
    	}
    	return  cards;
    }
    

    public Card getCard(){
        return null;
    }
    
    public Card draw(){
    	Card selectedCard = getRandomCard();
    	cards.remove(selectedCard);
    	return selectedCard;
    }
    
    private Card getRandomCard(){
    	int size = cards.size();
    	
    	// Math.random() * size (여기서 size는 곱합는 값이 아닌 범위값을 나타낸다)
    	int select = (int)(Math.random()*size);
    	return cards.get(select);
    }
    
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		
		for(Card card : cards){
			sb.append(card.toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}
    
    
}
