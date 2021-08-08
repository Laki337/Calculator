package caclculator.Action;

public class Addition implements Action {
    public int invoke(int number1, int number2){
        return number1+number2;
    }
}