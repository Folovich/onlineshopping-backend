public class Factory {
    static void addStandartCategory(Catalog catalog){
        catalog.addCategory(new Category("electronics"));
        catalog.getCategory(0).addSubCategory("computer");
        catalog.getCategory(0).getSub(0).addProduct("HyperPc",100,1);

        catalog.addCategory(new Category("transport"));
        catalog.getCategory(1).addSubCategory("sport-car");
        catalog.getCategory(1).getSub(0).addProduct("Formula-1",100000,1);
    }

}
