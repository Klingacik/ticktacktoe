package tictactoe;

public enum PlayerType
{
    USER("user"),
    COMPUTER_EASY("easy"),
    COMPUTER_MEDIUM("medium"),
    NOT_EXISTING("not existing");

    private final String value;

    PlayerType(String playerType)
    {
        this.value = playerType;
    }

    public static PlayerType fromValue(String v) {
        for (PlayerType type: PlayerType.values()) {
            if (type.value.equalsIgnoreCase(v))
                return type;
        }
        return NOT_EXISTING;
    }

    @Override
    public String toString()
    {
        return value;
    }
}
