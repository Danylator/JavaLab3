import java.util.*;
import java.util.stream.Collectors;

/**
 * Клас представляє навчальний заклад із базовими характеристиками.
 */
class EducationalInstitution {

    private String name; // Назва закладу
    private String city; // Місто, де знаходиться заклад
    private int studentsCount; // Кількість студентів
    private int yearEstablished; // Рік заснування
    private double rating; // Рейтинг закладу

    /**
     * Конструктор для ініціалізації об'єкта класу.
     *
     * @param name Назва закладу
     * @param city Місто
     * @param studentsCount Кількість студентів
     * @param yearEstablished Рік заснування
     * @param rating Рейтинг закладу
     */
    public EducationalInstitution(String name, String city, int studentsCount, int yearEstablished, double rating) {
        this.name = name;
        this.city = city;
        this.studentsCount = studentsCount;
        this.yearEstablished = yearEstablished;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EducationalInstitution that = (EducationalInstitution) obj;
        return studentsCount == that.studentsCount && yearEstablished == that.yearEstablished
                && Double.compare(that.rating, rating) == 0 && name.equals(that.name) && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, studentsCount, yearEstablished, rating);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, Students: %d, Year: %d, Rating: %.1f",
                name, city, studentsCount, yearEstablished, rating);
    }
}

/**
 * Головний клас програми.
 */
public class Main {

    public static void main(String[] args) {

        // Створення масиву об'єктів навчальних закладів
        List<EducationalInstitution> institutions = new ArrayList<>();
        institutions.add(new EducationalInstitution("University A", "Kyiv", 12000, 1920, 4.5));
        institutions.add(new EducationalInstitution("College B", "Lviv", 3000, 1970, 3.8));
        institutions.add(new EducationalInstitution("Institute C", "Kharkiv", 5000, 1950, 4.0));
        institutions.add(new EducationalInstitution("University D", "Odessa", 7000, 1900, 4.7));
        institutions.add(new EducationalInstitution("Academy E", "Dnipro", 2000, 2000, 4.2));

        // Сортування за кількістю студентів за зростанням та за рейтингом за спаданням
        institutions.sort(Comparator.comparingInt(EducationalInstitution::getStudentsCount)
                .thenComparing(Comparator.comparingDouble(EducationalInstitution::getRating).reversed()));

        // Вивід відсортованого списку
        System.out.println("Sorted Institutions:");
        institutions.forEach(System.out::println);

        // Пошук заданого об'єкта
        EducationalInstitution target = new EducationalInstitution("Institute C", "Kharkiv", 5000, 1950, 4.0);
        boolean found = institutions.stream().anyMatch(target::equals);

        // Результати пошуку
        System.out.println("\nSearch Result:");
        if (found) {
            System.out.println("Found: " + target);
        } else {
            System.out.println("Not Found: " + target);
        }
    }
}
