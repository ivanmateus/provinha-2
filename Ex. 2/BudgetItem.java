public class BudgetItem {
    private String history;
    private float value;

    public BudgetItem(String history, float value){
        this.history = history;
        this.value = value;
    }

    public String getHistory(){
        return history;
    }

    public float getValue() {
        return value;
    }
}
