// b) A melhor implementação para a classe ComplexBudgetItem
//é através de composição, pois não se pode dizer que
//um objeto dessa classe é um tipo especial de BudgetItem,
//mas sim depende desse objeto para funcionar (é composto)
//por ele

public class ComplexBudgetItem {
    private ComplexBudgetItem subitens[];

    public ComplexBudgetItem(ComplexBudgetItem subitens[]){
        this.subitens = subitens;
    }

    public float getValue(){
        int resultado = 0;
        for (ComplexBudgetItem subitem: subitens) {
            resultado = resultado + subitem.getValue();
        }
        return resultado;
    }

    public ComplexBudgetItem findItem(String historico){
        for (ComplexBudgetItem subitem: subitens) {
            if(subitem.getHistory().equals(historico)){
                return subitem;
            }
        }
        return null;
    }
}
