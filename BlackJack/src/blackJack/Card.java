package blackJack;

public class Card {
    private String pattern;
    private String denomination;
    private int point; 
    
    public Card(String pattern, int index){
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
    

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
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
