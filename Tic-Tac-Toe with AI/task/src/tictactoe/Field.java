package tictactoe;

public class Field {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean equals(Field other) {
        return other.getValue().equals(this.getValue());
    }

    public boolean isEmpty() {
        return this.getValue().equals("_");
    }

    public Field(String value) {
        setValue(value);
    }

    public Field() {
        this("_");
    }
}
