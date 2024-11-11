package univer_lesson.chainResponsibility;

import lombok.Getter;

@Getter
public class Currency {
    private int amount;

    public Currency(int amt) {
        this.amount = amt;
    }

}