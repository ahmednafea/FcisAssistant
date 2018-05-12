package FcisAssistant;

public class GPA {
    protected String Symbol;
    protected int Count;

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public GPA(String symbol, int count) {
        Symbol = symbol;
        Count = count;
    }
}
