package ca.sheridancollege.project;

public class Hand extends GroupOfCards{

    public Hand(){
        super(52);
    }

    public int getHandSize(){
        return cards.size();
    }

    private enum Position{
        TOP, BOT
    }
    private String top = ""+'\u2554'+'\u2550'+'\u2550'+'\u2550'+'\u2557';
    private String bot = ""+'\u255A'+'\u2550'+'\u2550'+'\u2550'+'\u255D';
    private String body = "\u2551vi\u2551";

    public String toIcon(Card card){
        switch(card.getSuite()){
            case CLUB:
                return ""+'\u2663';
            case HEART:
                return ""+'\u2661';
            case DIAMOND:
                return ""+'\u2662';
            default:
                return ""+'\u2660';
        }
    }

    public String toBody(Card card){
        String result = body.replace("i", toIcon(card));
        if (card.toSymbol() != "10"){
            result = result.replace("v"," "+card.toSymbol());
        } else {
            result = result.replace("v","10");
        }
        return result;
    }

    public String drawVertical(Position position){
        String result = "";
        String item = "";
        switch(position){
            case TOP:
                item = top;
                break;
            default:
                item = bot;
                break;
        }
        for (int i = 0; i < getHandSize(); i++){
            result = result + item+"  ";
        }   
        return result;
    }

    public String drawBodyVertical(){
        String result = "";
        for (Card card: cards){
            result += toBody(card) + "  ";
        }
        return result;
    }

    public String showHand(){
        return drawVertical(Position.TOP) +  "\n"+ drawBodyVertical() + "\n"+ drawVertical(Position.BOT);
    }
    public void clear(){
        cards.clear();
    }
}
