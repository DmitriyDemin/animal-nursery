package AnimalNursery.view;

import AnimalNursery.Controller.AnimalController;
import AnimalNursery.model.Animal;
import AnimalNursery.utill.Counter;

import java.util.List;
import java.util.Scanner;


public class ConsoleMenu {

    AnimalController animalCtr;
    int type_id = 0;

    public ConsoleMenu(AnimalController controller) {
        this.animalCtr = controller;
    }

    public void start() {

        System.out.print("\033[H\033[J"); //очистка терминала
        System.out.print("\t-- Система учета животных для питомника --\n");
        try (Scanner in = new Scanner(System.in, "UTF-8"); Counter count = new Counter()) {

            boolean flag = true;
            int id;
            int command_id;
            while (flag) {

                System.out.println(
                        "\n1 - Список всех животных\n2 - Завести новое животное\n3 - Cписок команд, которые выполняет животное " +
                                "\n4 - Обучить животное новой команде\n5 - Удалить запись \n0 - Выход");
                String key = in.next();
                switch (key) {
                    case "1":
                        animalCtr.getAllAnimal();
                        break;
                    case "2":
                        animalTypeChoiceMenu(in);
                        if (type_id != 0) {
                            try {
                                animalCtr.createAnimal(type_id);
                                count.add();
                                System.out.println("ОК");
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        break;
                    case "3":
                       while (true) {
                            id = animalChoiceMenu(in);
                            if (id != 0)
                                try {
                                    animalCtr.getCommandsByID(id);
                                } catch (RuntimeException e) {
                                    System.out.println(e.getMessage());
                                }
                            else
                                break;
                        }
                        break;
                    case "4":
                        id = animalChoiceMenu(in);
                        if (id != 0) {
                            command_id = CommadChoiceMenu(in);
                            if (id != 0) {
                                try {
                                    animalCtr.learnСommand(id, command_id);
                                } catch (RuntimeException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }else
                            break;
                    case "5":
                        id = animalChoiceMenu(in);
                        if (id != 0)
                            try {
                                animalCtr.delete(id);
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }else
                            break;

                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("Ошибка ввода!");
                        break;
                }
            }
        }
    }


    private void animalTypeChoiceMenu(Scanner in) {
        System.out.println("Завести животное, выберите вариант:\n1 - Собака \n2 - Кошка \n3 - Хомяк \n4 - Лошадь \n5 - Осел \n6 - Верблюд \n0 - Возврат в основное меню");
        while (true) {
            String key = in.next();
            switch (key) {
                case "1":
                    type_id = 1;
                    break;
                case "2":
                    type_id = 2;
                    break;
                case "3":
                    type_id = 3;
                    break;
                case "4":
                    type_id = 4;
                    break;
                case "5":
                    type_id = 5;
                    break;
                case "6":
                    type_id = 6;
                    break;
                case "0":
                    type_id = 0;
                    break;
                default:
                    System.out.println("Ошибка ввода, введите число от 0 до 6");
                    break;
            }
            break;
        }
    }


    private int animalChoiceMenu(Scanner in) {
        List<Integer> list_aminal_id = animalCtr.getAllAnimalId();
        System.out.println("\nДля выбора введите Id животного из списка \n0 - Возврат в основное меню");

        while (true) {
            int id = in.nextInt();
            if (id == 0) {
                return id;
            }
            if (!list_aminal_id.contains(id)) {
                System.out.println("\nЖивотного с таким номеров в списке нет, попробуйте снова  \n0 - Возврат в основное меню");
            } else
                return id;
        }
    }

    private int CommadChoiceMenu(Scanner in) {
        Scanner sc = in;
        System.out.println("Список команд для обучения");
        System.out.println(animalCtr.getAllCommands());
        int command;
        while (true) {
            System.out.println("Введите id команды из списка, 0 для возврата в основное меню: ");
            command = sc.nextInt();
            if (command == 0)
                return 0;
            else
                return command;
        }
    }
}


