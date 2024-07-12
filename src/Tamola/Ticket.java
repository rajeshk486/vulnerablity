package Tamola;
import java.util.List;

public class Ticket {
    private List<List<Integer>> numbers;
    //constructor
    public Ticket(List<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    //getter for number
    public List<List<Integer>> getNumbers() {
        return numbers;
    }
}
