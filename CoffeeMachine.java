import java.util.Objects;
import java.util.Scanner;

enum CurrentState {
    CHOOSING_ACTION, CHOOSING_COFFEE, FILLING_MACHINE, GIVING_MONEY, PRINTING, FINISHED
}

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CurrentState state = CurrentState.CHOOSING_ACTION;
        int[] things = {400, 540, 120, 9, 550};
        // water, milk, coffee, cups, money

        while (!Objects.equals(state.toString(), "FINISHED")) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            state = CurrentState.valueOf(method(scanner.next()));
            switch (state) {
                case CHOOSING_COFFEE:
                    buy(things);
                    break;
                case FILLING_MACHINE:
                    fill(things);
                    break;
                case GIVING_MONEY:
                    take(things);
                    break;
                case PRINTING:
                    display(things);
                    break;
                default:
                    break;
            }
        }

    }

    public static String method(String op) {
        switch (op) {
            case "buy":
                return CurrentState.CHOOSING_COFFEE.name();
            case "fill":
                return CurrentState.FILLING_MACHINE.name();
            case "take":
                return CurrentState.GIVING_MONEY.name();
            case "remaining":
                return CurrentState.PRINTING.name();
            case "exit":
                return CurrentState.FINISHED.name();

        }
        return CurrentState.FINISHED.name();
    }

    public static void display(int[] thing) {
        System.out.println("The coffee machine has: ");
        System.out.printf("%d ml of water%n%d ml of milk%n%d g of coffee beans%n%d disposable cups%n", thing[0], thing[1], thing[2], thing[3]);
        System.out.printf("%d$ of money%n%n", thing[4]);
    }

    public static void buy(int[] thing) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String op = scanner.next();
        switch (op) {
            case "1":
                if (thing[0] - 250 >= 0 && thing[2] - 16 >= 0 && thing[3] - 1 >= 0) {
                    thing[0] -= 250;
                    thing[2] -= 16;
                    thing[3]--;
                    thing[4] += 4;
                    System.out.println("I have enough resources, making you a coffee!\n");
                    break;
                } else {
                    if (thing[0] - 250 < 0) {
                        String problem = "water";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    } else if (thing[2] - 16 < 0) {
                        String problem = "coffee";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    } else {
                        String problem = "cups";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    }
                }
            case "2":
                if (thing[0] - 350 >= 0 && thing[1] - 75 >= 0 &&thing[2] - 20 >= 0 && thing[3] - 1 >= 0) {
                    thing[0] -= 350;
                    thing[1] -= 75;
                    thing[2] -= 20;
                    thing[3]--;
                    thing[4] += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                } else {
                    if (thing[0] - 350 < 0) {
                        String problem = "water";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    } else if (thing[1] - 75 < 0) {
                        String problem = "milk";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    } else if (thing[2] - 20 < 0) {
                        String problem = "coffee";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    } else {
                        String problem = "cups";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    }
                }
            case "3":
                if (thing[0] - 200 >= 0 && thing[1] - 100 >= 0 &&thing[2] - 12 >= 0 && thing[3] - 1 >= 0) {
                    thing[0] -= 200;
                    thing[1] -= 100;
                    thing[2] -= 12;
                    thing[3]--;
                    thing[4] += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                } else {
                    if (thing[0] - 200 < 0) {
                        String problem = "water";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    } else if (thing[1] - 100 < 0) {
                        String problem = "milk";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    } else if (thing[2] - 12 < 0) {
                        String problem = "coffee";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    } else {
                        String problem = "cups";
                        System.out.printf("Sorry, not enough %s!%n", problem);
                        break;
                    }
                }
            default:
                break;
        }
    }

    public static void fill(int[] thing) {
        System.out.println("Write how many ml of water you want to add: ");
        thing[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        thing[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee you want to add: ");
        thing[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        thing[3] += scanner.nextInt();
    }

    public static void take(int[] thing) {
        System.out.printf("I gave you %d$", thing[4]);
        thing[4] = 0;
    }
}
