package univer_lesson.chainResponsibility;

public class ATMDispenseChain {
    DispenseChain c1;

    public ATMDispenseChain() {
        this.c1 = new Dollar100Dispenser();
        DispenseChain c2 = new Dollar50Dispenser();
        DispenseChain c3 = new Dollar20Dispenser();
        DispenseChain c4 = new Dollar10Dispenser();
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
    }
}