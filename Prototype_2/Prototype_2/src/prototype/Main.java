package prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product pr1 = new Product("name_pr", 3);
        pr1.setPartId(0, 111);
        pr1.setPartId(1, 222);
        pr1.setPartId(2, 333);

        pr1.setPartName(0, "name 1");
        pr1.setPartName(1, "name 2");
        pr1.setPartName(2, "name 3");


        Product pr2 = pr1.clone();

        pr2.setProductName("pr2_name");
        pr2.setPartId(0, 123);
        pr2.setPartId(1, 321);
        pr2.setPartId(2, 132);
        pr2.setPartName(0, "123");
        pr2.setPartName(1, "321");
        pr2.setPartName(2, "132");

        if (pr1.getPartsSize() != pr2.getPartsSize()) {
            System.out.println("Error of sizes");
            return;
        }

        System.out.println(pr1.getProductName());
        System.out.println(pr2.getProductName());

        int size = pr1.getPartsSize();
        for (int i = 0; i < size; i++) {
            System.out.println(pr1.getPartId(i) + " = " + pr1.getPartName(i));
            System.out.println(pr2.getPartId(i) + " = " + pr2.getPartName(i));
        }
    }
}
