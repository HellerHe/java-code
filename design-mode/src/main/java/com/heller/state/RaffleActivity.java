package com.heller.state;

/**
 * ----状态模式
 * 状态模式将每个状态的行为封装到对应的一个类中，状态之间可以相互转换
 */
public class RaffleActivity {
    private State state;
    private int count;
    private State noRaffleState;
    private State canRaffleState;
    private State dispenseState;
    private State dispensOutState;

    public RaffleActivity(int count) {
        noRaffleState = new NoRaffleState(this);
        canRaffleState = new CanRaffleState(this);
        dispenseState = new DispenseState(this);
        dispensOutState = new DispenseOutState(this);
        this.state = noRaffleState;
        this.count = count;
    }

    public void deductMoney() {
        state.deductMoney();
    }

    public void raffle() {
        if (state.raffle()) {
            state.dispense();
        }
    }

    public State getNoRaffleState() {
        return noRaffleState;
    }

    public void setNoRaffleState(State noRaffleState) {
        this.noRaffleState = noRaffleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispensOutState() {
        return dispensOutState;
    }

    public void setDispensOutState(State dispensOutState) {
        this.dispensOutState = dispensOutState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count--;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
