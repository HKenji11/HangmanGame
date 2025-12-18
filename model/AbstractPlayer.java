package model;


public abstract class AbstractPlayer {

    protected int remainingAttempts;

    protected AbstractPlayer(int maxAttempts) {
        if (maxAttempts <= 0) {
            throw new IllegalArgumentException("maxAttempts must be positive.");
        }
        this.remainingAttempts = maxAttempts;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public void loseAttempt() {
        if (remainingAttempts > 0) {
            remainingAttempts--;
        }
    }
}
