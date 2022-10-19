import java.util.Scanner;

public class DepositCalculator {

    protected double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    protected double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    protected double round(double value, int accuracy) {
        double numberOfDecimalPlaces = Math.pow(10, accuracy);

        return Math.round(value * numberOfDecimalPlaces) / numberOfDecimalPlaces;
    }

    public void calculateDeposit() {
        int period;
        int userInput;
        int amount;
        double result = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        userInput = scanner.nextInt();
        if (userInput == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (userInput == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}