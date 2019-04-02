package blackJack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	 public void play(){
	        System.out.println("========= Blackjack =========");
	        Scanner sc = new Scanner(System.in);
	        Rule rule = new Rule();
	        CardDeck cardDeck = new CardDeck();
	        
	        List<Player> players = Arrays.asList(new Gamer("Gamer1"), new Dealer());
	        List<Player> initAfterPlayers = initPhase(cardDeck, players);
	        List<Player> playingAfterPlayers = playingPhase(sc, cardDeck, players);
	        
	        Player winner = rule.getWinner(playingAfterPlayers);
	        System.out.println("승자는 "+winner.getName());
	        
	    }
	 private List<Player> playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players){
		 List<Player> cardReceivedPlayers;
		 while(true){
			  cardReceivedPlayers = receiveCardAllPlayers(sc, cardDeck, players);
			 
			 if(isAllPlayerTurnOff(cardReceivedPlayers)){
				 break;
			 }
		 }
		 return cardReceivedPlayers;
	 }
	 
	 private List<Player> receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players){
		 for(Player player : players){
			 System.out.println(player.getName()+"님 차례입니다.");
			 if(isReceiveCard(sc)){
				 Card card = cardDeck.draw();
				 player.receiveCard(card);
				 player.turnOn();
			 }else{
				 player.turnOff();
			 }
		 }
		 return players;
	 }
	 
	 private boolean isAllPlayerTurnOff(List<Player> players){
		 for(Player player:players){
			 if(player.isTurn()){
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public static final String STOP_RECEIVE_CARD = "0";
	 private boolean isReceiveCard(Scanner sc){
		 System.out.println("카드를 뽑겠습니다까? 종료를 원하시면 0을 입력하세요.");
		 return !STOP_RECEIVE_CARD.equals(sc.nextLine());
	 }

	
	// 따로 변수에 2를 담은 이유는   1. 해당 코드를 보고 이 값이 어떤값에 해당되는 값인이 알수있기 때문 
	//					    2. 같이 2라는 값을 사용하는 메소드가 존재할 경우에 2의 값이 변화가 있을 경우 두매소드 모두 변경해야하는지 1개만 해야하는 구분이 어렵기 때문에 변수에 담아서 변수로 명명을 하는것이 좋음 
	public static final int INIT_RECEIVE_CARD_COUNT = 2;
	public List<Player> initPhase(CardDeck cardDeck,List<Player> players){
		System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
		for(int i=0;i<INIT_RECEIVE_CARD_COUNT;i++){
			for(Player player:players){
				Card card = cardDeck.draw();
				player.receiveCard(card);
			}
		}
		return players;
	}
}
