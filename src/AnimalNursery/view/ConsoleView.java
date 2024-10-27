package AnimalNursery.view;

import AnimalNursery.model.Animal;

import java.util.List;
import java.util.Scanner;

public class ConsoleView  {

    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in, "UTF-8");
    }


    public String getName() {
        System.out.printf("Имя: ");
        return in.nextLine();
    }


    public String getBirthday() {
        System.out.printf("Введите дату рождения в формате 'dd.mm.yyyy': ");
        return in.nextLine();
    }


    public <T> void printAll(List<T> list, Class<T> clazz) {
        System.out.print("\033[H\033[J");
        if (list.isEmpty())
            System.out.println("Список пуст");
        else {
            if (clazz == Animal.class)
                System.out.println("\n          Список питомцев:");
            else
                System.out.println("\n          Список команд которым животное обучено:");
            for (T item : list) {
                System.out.println(item);
            }

        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}