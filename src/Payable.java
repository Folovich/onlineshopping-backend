public interface Payable {

    double getFinalPrice();
    double pay(double amount);
    boolean isPaid();

}
