package productshash;


public class Product {

    private String name;
    private int price;
    private String category;

    public Product(String name, int price, String category) {
        setName(name);
        setPrice(price);
        setCategory(category);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
        this.name = name.toUpperCase();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0 || price == 0) {
            throw new IllegalArgumentException("Цена не может быть 0 или меньше 0!");
        }
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null) {
            throw new IllegalArgumentException("Категория не может быть пустой!");
        }
        this.category = category.toUpperCase();
    }

    @Override
    public int hashCode() {
        String id = name + category;
        return id.hashCode(); //id будет хэшем комбинации имя+категория
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; //если передали тот же объект, то тру, совпадает
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; //если null или не тот тип класса, то фолс, не совпадает
        }

        Product product = (Product) obj; //приведение типа объекта к Product, можно и сразу в ифах писать
        //вместо ифов пишу сразу что все должно быть тру или вернется фолс
        return (this.getPrice() == product.getPrice()) && (this.getCategory().equals(product.getCategory())) && (this.getName().equals(product.getName()));
    }

}
