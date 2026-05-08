import java.util.Objects;

public class Persona implements Financable {
    private int balance;
    private static int counter = 0;
    private int id;
    private String tittle;

    public Persona(int balance, String title){
        this.balance = balance;
        this.tittle = title;
        counter++;
        this.id = counter;
    }


    @Override
    public double checkBalance(){
        return this.balance;
    }
    @Override
    public boolean havelsNowMoney(double amount){
        return false;
    }
    @Override
    public String getFinancialStatus(){
        if(this.balance > 1000){
            return  "Богатый";
        } else{
            return "Нищий";
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "balance=" + balance +
                ", id=" + id +
                ", tittle='" + tittle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return balance == persona.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, id, tittle);
    }
}
