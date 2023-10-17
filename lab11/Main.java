package lab11;
import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        // Задание 1: Вывод информации о задании и датах
        displayDeveloperInfo();
        displayTaskDates();

        // Задание 2: Сравнение текущей даты с введенной пользователем датой
        compareDates();

        // Задание 3: Доработка класса Student
        Student student1 = new Student("Alice", "Johnson", "Computer Science", 3, "A101", 3.9, "2000-01-15");
        System.out.println(student1);

        // Задание 4: Создание объектов Date и Calendar с пользовательским вводом
        createCustomDateAndCalendar();

        // Задание 5: Сравнение производительности ArrayList и LinkedList
        compareListPerformance();
    }

    // Задание 1: Вывод информации о задании и датах
    public static void displayDeveloperInfo() {
        System.out.println("Фамилия разработчика: Старовойтов");
    }

    public static void displayTaskDates() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date taskReceivedDate = new Date(); // Дата получения задания
        taskReceivedDate.setTime(taskReceivedDate.getTime()); // Установка даты получения

        Date taskDueDate = new Date(); // Дата сдачи задания
        taskDueDate.setTime(taskReceivedDate.getTime() + 7 * 24 * 60 * 60 * 1000); // Добавляем 7 дней к дате получения

        System.out.println("Дата и время получения задания: " + dateFormat.format(taskReceivedDate));
        System.out.println("Дата и время сдачи задания: " + dateFormat.format(taskDueDate));
    }

    // Задание 2: Сравнение текущей даты с введенной пользователем датой
    public static void compareDates() throws ParseException  {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Введите дату в формате (yyyy-MM-dd): ");

            Date userDate = dateFormat.parse(scanner.nextLine());
            Date currentDate = new Date();

            if (userDate.before(currentDate)) {
                System.out.println("Введенная дата меньше текущей даты.");
            } else if (userDate.after(currentDate)) {
                System.out.println("Введенная дата больше текущей даты.");
            } else {
                System.out.println("Введенная дата равна текущей дате.");
            }

    }

    // Задание 3: Доработка класса Student с датой рождения
    public static class Student {
        private String firstName;
        private String lastName;
        private String specialty;
        private int course;
        private String group;
        private double GPA;
        private LocalDate birthDate;

        public Student(String firstName, String lastName, String specialty, int course, String group, double GPA, String birthDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.specialty = specialty;
            this.course = course;
            this.group = group;
            this.GPA = GPA;
            this.birthDate = LocalDate.parse(birthDate);
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return "Student: " + firstName + " " + lastName +
                    "\nSpecialty: " + specialty +
                    "\nCourse: " + course +
                    "\nGroup: " + group +
                    "\nGPA: " + GPA +
                    "\nBirth Date: " + birthDate.format(formatter);
        }
    }

    // Задание 4: Создание объектов Date и Calendar с пользовательским вводом
    public static void createCustomDateAndCalendar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        System.out.print("Введите месяц (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Введите день: ");
        int day = scanner.nextInt();

        System.out.print("Введите часы: ");
        int hours = scanner.nextInt();

        System.out.print("Введите минуты: ");
        int minutes = scanner.nextInt();

        // Создание объекта Date
        Date customDate = new Date(year - 1900, month - 1, day, hours, minutes);

        // Создание объекта Calendar
        Calendar customCalendar = Calendar.getInstance();
        customCalendar.set(year, month - 1, day, hours, minutes);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println("Созданный объект Date: " + dateFormat.format(customDate));
        System.out.println("Созданный объект Calendar: " + dateFormat.format(customCalendar.getTime()));
    }

    // Задание 5: Сравнение производительности ArrayList и LinkedList
    public static void compareListPerformance() {
        int n = 100000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Замер времени добавления элементов в ArrayList
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long arrayListInsertTime = endTime - startTime;

        // Замер времени добавления элементов в LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        long linkedListInsertTime = endTime - startTime;

        // Замер времени удаления элементов из ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.remove(0);
        }
        endTime = System.nanoTime();
        long arrayListRemoveTime = endTime - startTime;

        // Замер времени удаления элементов из LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.remove(0);
        }
        endTime = System.nanoTime();
        long linkedListRemoveTime = endTime - startTime;

        System.out.println("Производительность ArrayList:");
        System.out.println("Добавление элементов: " + arrayListInsertTime + " нс");
        System.out.println("Удаление элементов: " + arrayListRemoveTime + " нс");

        System.out.println("Производительность LinkedList:");
        System.out.println("Добавление элементов: " + linkedListInsertTime + " нс");
        System.out.println("Удаление элементов: " + linkedListRemoveTime + " нс");
    }
}


