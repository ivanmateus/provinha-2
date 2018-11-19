public class Customer {
    private String clientCPF;
    private float balance;

    public Customer(String cpf, float balance){
        this.clientCPF = cpf;
        this.balance = balance;
    }

    public String getClientCPF(){
        return clientCPF;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
