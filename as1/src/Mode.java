public enum Mode {
    write ("write", 0),
    read ("read", 1);

    private String mode;
    private byte value;

    Mode(String s, int i) {
        mode = s;
        value = (byte) i;
    }

    public byte getValue() {
        return value;
    }

    public String getMode() {
        return mode;
    }
}
