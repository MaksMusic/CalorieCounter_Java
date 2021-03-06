import java.util.Scanner;

public class Main {
    static StepTracker stepTracker = new StepTracker();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие");
        printMenu();
        int userInput = scanner.nextInt();
        int validationUserInput = validationUserInput(userInput);
        variant(validationUserInput);
    }

    private static void printMenu() {
        System.out.println("1.Внести количество шагов за определенный день");
        System.out.println("2.Напечатать статистику за определенный месяц");
        System.out.println("3.Изменить цель по количеству шагов в день");
        System.out.println("4.Выйти из приложения");
    }


    static int validationUserInput(int num) {
        if (!(num >= 1 && num <= 4)) {
            System.out.println("Вы ввели неверную команду, измените выбор");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            validationUserInput(userInput);
        }
        variant(num);

        return num;

    }

    static int inputUserSteps(int userInputSteps) {
        if (userInputSteps <= 0) {
            System.out.println("Повторите попытку. Введите число больше нуля");
            Scanner scanner = new Scanner(System.in);
            int userInputSteps2 = scanner.nextInt();
            inputUserSteps(userInputSteps2);
        }
        return userInputSteps;
    }

    static void variant (int punkMenu){

        if (punkMenu >= 1 && punkMenu <= 4) {
            if (punkMenu == 1) {

                Scanner scanner1 = new Scanner(System.in);
               // int userInputSteps = scanner1.nextInt();
                //  int result = inputUserSteps(userInputSteps);

                stepTracker.addSteps1();

                printMenu();                        //высветить меню обратно // надо будет только здесь и сканер добавить, чтобы считывать данные
                int change = scanner1.nextInt();
                int resultChange = validationUserInput(change);
                validationUserInput(resultChange);


            } else if (punkMenu == 2) {
                stepTracker.statistika1();
                // Scanner scanner1 = new Scanner(System.in);
               // int userInputSteps = scanner1.nextInt();
                // тут скорее всего надо еще проверять, что они вводят  в зависимости от того по какому варианту будет искать по названию или числу порядкового номера месяца
                // так же здесь нужно будет обратиться к функции или листу StepTracker и перебрать HasMap
                printMenu(); //высветить меню обратно // надо будет только здесь и сканер добавить, чтобы считывать данные
                Scanner scanner1 = new Scanner(System.in); // это времнное потом надо удалить, просто сейчас нет месяца
                // int userInputSteps = scanner1.nextInt();
                int change = scanner1.nextInt();
                int resultChange = validationUserInput(change);
                variant(resultChange);

            } else if (punkMenu == 3) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Введите новую цель по количеству шагов за месяц");
                 int userInputSteps = scanner1.nextInt();
                 if (userInputSteps>0){
                     stepTracker.setPlan(userInputSteps);
                     System.out.println("\033[0;92m" + "План на месяц успешно изменен" + "\033[0m" );
                 }else {
                     System.out.println("\033[0;91m" + "План изменить не удалось"+ "\033[0m");
                     //тут дописать запуск меню главного снова
                 }


                printMenu();
                scanner1 = new Scanner(System.in); // это времнное потом надо удалить, просто сейчас нет месяца
                int change = scanner1.nextInt();
                int resultChange = validationUserInput(change);
                variant(resultChange);
            } else {
                System.out.println("Программа завершила свою работу");
            }
        }
    }

}


