import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> books = new ArrayList<>();

        books.add("Дракула");
        books.add("Мизери");
        books.add("Бремя страстей человеческих");
        books.add("Превращение");
        books.add("Десять негритят");
        books.add("Таинственная история Билли Миллигана");
        books.add("Молчание ягнят");
        books.add("Сердце тьмы");
        books.add("Коллекционер");
        books.add("Братья Карамазовы");
        books.add("Анна Каренина");
        books.add("Грозовой перевал");
        books.add("Улисс");
        books.add("Граф Монте-Кристо");
        books.add("Большие надежды");
        books.add("Сто лет одиночества");
        books.add("Гроздья гнева");

        List<ArrayList<String>> result = setOutBooksOnShelves(books);
        result.stream()
                .forEach(System.out::println);
    }

    private static List<ArrayList<String>> setOutBooksOnShelves (List<String> books) {
        books = books.stream()
                .sorted()
                .collect(Collectors.toList());

        List<ArrayList<String>> shelves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<String> shelf = new ArrayList<>();
            shelves.add(shelf);
        }

        int booksNumberPerShelf = books.size() / shelves.size();
        int theRest = books.size() % shelves.size();

        int index = 0;
        for (List<String> shelf : shelves) {
            for (int i = 0; i < booksNumberPerShelf; i++) {
                shelf.add(books.get(index++));
            }
            if (theRest > 0) {
                shelf.add(books.get(index++));
                theRest--;
            }
        }

        return shelves;
    }
}