import java.util.HashMap;

public abstract class Product {
    private long id;
    private String title;
    private double price;
    private HashMap<Integer, String> category;

//    Product(){}

    Product(long id, String title, double price, HashMap<Integer, String> category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
    }


    public long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public double getPrice(){
        return this.price;
    }
    public HashMap<Integer, String> getCategory(){
        return this.category;
    }

    public void setId(long setId){
        this.id = setId;
    }

    public void setTitle(String setTitle){
        this.title = setTitle;
    }

    public void setPrice(double setPrice){
        this.price = setPrice;
    }

    public void setCategory(HashMap<Integer,String> category){
        this.category = category;
    }



}
