package baseball.domain;

public enum Numeral {
    ZERO("0", 0),
    ONE("1", 1),
    TWO("2", 2),
    THREE("3", 3),
    NINE("9", 9);

    private String numberText;
    private int number;

    Numeral(String numberText, int number) {
        this.numberText = numberText;
        this.number = number;
    }

    public String numberText() {
        return this.numberText;
    }

    public int number() {
        return this.number;
    }
}
