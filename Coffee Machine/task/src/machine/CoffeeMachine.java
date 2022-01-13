package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int waterSupply = 400;
    static int milkSupply = 540;
    static int beansSupply = 120;
    static int earns = 550;
    static int cups = 9;

    static int [] espresso = new int[] {250, 0, 16, 4};
    static int [] latte = new int [] {350, 75, 20, 7};
    static int [] cappuccino = new int[] {200, 100, 12, 6};

    public static Scanner scanner;

    public static void main(String[] args) {
        boolean marker = true;
        Scanner scanner = new Scanner(System.in);
        String operation = "";

        while (marker){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            operation = scanner.next();
            if(operation.equals("exit")){
                break;
            }else if(operation.equals("buy")){
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String ct = scanner.next();
                if(ct.equals("back")){
                    System.out.println();
                }else {
                    int coffeeType = Integer.parseInt(ct);
                    if (coffeeType == 1) {
                        if (isEnough(espresso).equals("ok")) {
                            System.out.println("I have enough resources, making you a coffee!\n");
                            supplyCorrection(espresso[0], espresso[1], espresso[2], espresso[3]);
                        } else {
                            System.out.printf("Sorry, not enough %s!\n", isEnough(espresso));
                        }
                        System.out.println("");
                    } else if (coffeeType == 2) {
                        if (isEnough(espresso).equals("ok")) {
                            System.out.println("I have enough resources, making you a coffee!\n");
                            supplyCorrection(latte[0], latte[1], latte[2], latte[3]);
                        } else {
                            System.out.printf("Sorry, not enough %s!\n", isEnough(latte));
                        }
                        System.out.println("");
                    } else if (coffeeType == 3) {
                        if (isEnough(espresso).equals("ok")) {
                            System.out.println("I have enough resources, making you a coffee!\n");
                            supplyCorrection(cappuccino[0], cappuccino[1], cappuccino[2], cappuccino[3]);
                        } else {
                            System.out.printf("Sorry, not enough %s!\n", isEnough(cappuccino));
                        }
                        System.out.println("");
                    }
                }
            } else if(operation.equals("fill")){
                System.out.println("");
                System.out.println("Write how many ml of water you want to add:");
                waterSupply +=Integer.parseInt(scanner.next());
                System.out.println("Write how many ml of milk you want to add:");
                milkSupply +=Integer.parseInt(scanner.next());
                System.out.println("Write how many grams of coffee beans you want to add:");
                beansSupply +=Integer.parseInt(scanner.next());
                System.out.println("Write how many disposable cups of coffee you want to add:");
                cups +=Integer.parseInt(scanner.next());
            }else if(operation.equals("take")){
                System.out.println("");
                System.out.printf("I gave you $%d\n", earns);
                System.out.println("");
                earns = 0;
            }else if(operation.equals("remaining")){
                printingRemaining();
            }
        }

    }

    public static String isEnough(int [] coffeeType){
        if(waterSupply<coffeeType[0]){
            return "water";
        }else if(milkSupply<coffeeType[1]){
            return "milk";
        }else if(beansSupply < coffeeType[2]){
            return "coffee beans";
        }else{
            return "ok";
        }
    }


    public static void printingRemaining(){
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", waterSupply);
        System.out.printf("%d ml of milk\n", milkSupply);
        System.out.printf("%d g of coffee beans\n", beansSupply);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n", earns);
        System.out.println();
    }

    public static void supplyCorrection(int waterUsed, int milkUsed, int beansUsed, int revenue){
        waterSupply -= waterUsed;
        milkSupply -= milkUsed;
        beansSupply -= beansUsed;
        cups -= 1;
        earns += revenue;
    }
}