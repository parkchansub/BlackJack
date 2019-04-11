package blackJack;

public class Card {
    private Pattern pattern;
    private String denomination;
    private int point; 
    
    
    //set함수를 통하여 객체 생성후 값을 넣는 방식이 아닌 생성자에 파라메터를 설저하여 해당 값으로 객체 생성하는 이유
    // 1. card.java 에서 마지막 숫자와 무늬를 마음대로 확용하더라도 CardDeck은 아무런 영향이 없다
    // 2. 객체 생성시 값을 넣는것을 강제화 시킬수있다.  
    public Card(Pattern pattern, int index){
    	this.pattern = pattern;
    	this.denomination = numberToDenomination(index);
    	this.point = numberToPoint(index);
    }
    
    private int numberToPoint(int number){
    	if(number>=11){
    		return 10;
    	}
    	return number;
    }
    
    // 처음 구현은 generateCards()에서 두가지 역활 즉 각 숫자와 페턴을 넣는 방식을 이행하는 것을 각각의 매소드로 분리하여 역활별로 메소드를 가지게 형성
    private String numberToDenomination(int number){
    		if(number==1){
    			return "A";
    		}else if(number==11){
    			return "J";
    		}else if(number==12){
    			return "Q";
    		}else if(number==13){
    			return "K";
    		}
   			return String.valueOf(number);
    }
    

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
    
    public enum Pattern{
    	SPADE("spade"),
    	HEART("heart"),
    	DIAMOND("diamond"),
    	CLUB("club");
    	
    	private String value;
    	
    	Pattern(){}
    	
    	Pattern(String value){
    		this.value=value;
    	}
    	
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }
    
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Card [pattern=" + pattern + ", denomination=" + denomination + "]";
	}
    
    
}
