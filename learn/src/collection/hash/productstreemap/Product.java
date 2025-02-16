package collection.hash.productstreemap;

public class Product {
    private String name;
    private int price;
    private String category;

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "[Имя=" + name + ", цена=" + price + ", категория=" + category + "]";
    }

    @Override
    public int hashCode() {
        String id = name.toUpperCase() + "," + category.toUpperCase();
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; //если передали тот же объект, то тру, совпадает
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; //если null или не тот тип класса, то фолс, не совпадает
        }

        //приведение типа объекта к Product, можно и сразу в ифах писать
        Product product = (Product) obj;
        //вместо ифов пишу сразу что все должно быть тру или вернется фолс, все, кроме цены
        return this.getCategory().equalsIgnoreCase(product.getCategory()) &&
                this.getName().equalsIgnoreCase(product.getName());
    }
}
