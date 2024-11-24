//не делаю тут ниче, так как компаратор для тримэп только по ключам, а я и так сделал в ключ все

// package collection.hash.productstreemap;
//
//import java.util.Comparator;
//
///*
//пример с явараш
//class LengthComparator implements Comparator<String> {
//  public int compare(String o1, String o2) {
//    Integer lenghComparedResult = Integer.compare(o1.length(), o2.length());
//    return lenghComparedResult != 0 ? lenghComparedResult : o1.compareTo(o2);
//  }
//}
//
//SortedMap<String, Integer> lengthComaredMap = new TreeMap<String,Integer>(new LengthComparator());
//
//lengthComaredMap.put("Юрий",4);
//lengthComaredMap.put("Олег",5);
//lengthComaredMap.put("Руслан",4);
//lengthComaredMap.put("Ян",4);
//
//Последовательность будет следующая:
//lenghComaredMap: {Ян=4, Олег=5, Юрий=4, Руслан=4}
// */
//
//class ComparatorProducts implements Comparator<Product> {
//
//    @Override
//    public int compare(Product product1, Product product2) { //подаем два продукта
//
//        //Сначала сравним по категории, их явно больше, удобнее если по ним будет сортировка
//        //int будет 0, если категории равны, меньше 0, если категория 1ы меньше и больше 0, если цена 1 больше
//        int categoryComparison = product1.getCategory().compareTo(product2.getCategory());
//        if (categoryComparison != 0) {
//            return categoryComparison; // Если категории разные, возвращаем результат сравнения
//        }
//
//        //Потом по имени, так будет читабельнее
//        int nameComparison = product1.getName().compareTo(product2.getName());
//        if (nameComparison != 0) {
//            return nameComparison;
//        }
//
//        // Если категории одинаковые, сравниваем по имени
//        return Integer.compare(product1.getPrice(), product2.getPrice());
//
//    }
//}