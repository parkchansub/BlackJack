package blackJack;

import java.util.Scanner;

public class Game {
	
	 public void play(){
	        System.out.println("========= Blackjack =========");
	        Scanner sc = new Scanner(System.in);
	        
	        Dealer dealer = new Dealer();
	        Gamer gamer = new Gamer();
	        Rule rule = new Rule();
	        CardDeck cardDeck = new CardDeck();
	        
	        initPhase(cardDeck, gamer, dealer);
	        playingPhase(sc, cardDeck, gamer, dealer);
	    }
	 
	 public void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer, Dealer dealer){
		 String gamerInput, dealerInput;
		 boolean isGamerTurn = false;
		 boolean isDealerTurn = false;
		 
		 while(true){
			 System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
			 gamerInput = sc.nextLine();
			 
			 if("0".equals(gamerInput)){
				 isGamerTurn = true;
			 }else{
				 // 중요한 내용 카드를 뽑을떄 Game이라는 객체에서는 카드를 어떤 로직으로 뽑는지 여부에 대해서는 알필요가 없고 받는 역활만 충실해야 함
				 Card gamerCard = cardDeck.draw();
				 gamer.receiveCard(gamerCard);
			 }
			 
			 System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
			 dealerInput = sc.nextLine();
			 
			 if("0".equals(dealerInput)){
				 isDealerTurn = true;
			 }else{
				 // 중요한 내용 카드를 뽑을떄 Game이라는 객체에서는 카드를 어떤 로직으로 뽑는지 여부에 대해서는 알필요가 없고 받는 역활만 충실해야 함
				 Card dealerCard = cardDeck.draw();
				 dealer.receiveCard(dealerCard);
			 }
			 
			 if(isDealerTurn && isGamerTurn){
				 break;
			 }
		 }
	 }

	
	// 따로 변수에 2를 담은 이유는   1. 해당 코드를 보고 이 값이 어떤값에 해당되는 값인이 알수있기 때문 
	//					    2. 같이 2라는 값을 사용하는 메소드가 존재할 경우에 2의 값이 변화가 있을 경우 두매소드 모두 변경해야하는지 1개만 해야하는 구분이 어렵기 때문에 변수에 담아서 변수로 명명을 하는것이 좋음 
	public static final int INIT_RECEIVE_CARD_COUNT = 2;
	public void initPhase(CardDeck cardDeck, Gamer gamer, Dealer dealer){
		System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
		for(int i=0;i<INIT_RECEIVE_CARD_COUNT;i++){
			Card gamerCard = cardDeck.draw();
			gamer.receiveCard(gamerCard);
			
			Card dealerCard = cardDeck.draw();
			dealer.receiveCard(dealerCard);
		}
	}
	
}
