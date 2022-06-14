package prototype;

import java.util.Random;

//Изделие
public class Product implements Cloneable {

    private static final Random RAND = new Random();

    private String productName;
    private PartOfProduct[] parts;

    public Product(final String productName, final int size) {
        this.productName = productName;
        this.parts = new PartOfProduct[size];
        for (int i = 0; i < size; i++) {
            this.parts[i] = new PartOfProduct();
        }
    }

    public int getPartsSize() {
        return parts.length;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setPartName(int index, String name) {
        parts[index].partName = name;
    }

    public String getPartName(int index) {
        return parts[index].partName;
    }

    public void setPartId(int index, int id) {
        parts[index].id = id;
    }

    public int getPartId(int index) {
        return parts[index].id;
    }

    @Override
    public Product clone() throws CloneNotSupportedException {
        Product product = (Product) super.clone();
        product.productName = new String(this.productName.getBytes());
        product.parts = new PartOfProduct[this.parts.length];
        for (int i = 0; i < this.parts.length; i++) {
            product.parts[i] = this.parts[i].clone();
        }
        return product;
    }

    //Деталь
    public static class PartOfProduct implements Cloneable {
        private String partName;
        private int id;

        public PartOfProduct() {
            this.id = RAND.nextInt();
            this.partName = "";
        }

        @Override
        public PartOfProduct clone() throws CloneNotSupportedException {
            final PartOfProduct pop = (PartOfProduct) super.clone();
            pop.id = this.id;
            pop.partName = new String(this.partName.getBytes());
            return pop;
        }
    }
}
