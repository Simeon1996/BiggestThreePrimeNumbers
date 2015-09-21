import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiggestThreePrimeNumbers {
    public static Boolean isPrime(Integer number) {
        Integer counter = 0;
        Boolean isPrime = false;

        if (number == 1 || number == 2) {
            isPrime = false;
        } else {

            for (Integer i = 1; i <= number; i++) {
                if (number % i == 0) {
                    counter++;
                }
            }

            if (counter <= 2) {
                isPrime = true;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        TreeSet<Integer> numbers = new TreeSet<Integer>();

        String pattern = "\\d+";
        Pattern p = Pattern.compile(pattern);

        String[] input = reader.nextLine().split("[( )]+");

        for (String element : input) {
            Matcher m = p.matcher(element);

            if (m.find()) {
                Integer currentNumber = Integer.parseInt(m.group());
                numbers.add(currentNumber);
            }
        }

        Integer counter = 0;
        Integer biggestSum = 0;
        Integer maxElement = 0;

        for(Integer i = 0; i < 3;i++){
            for(Integer element : numbers){
                if(isPrime(element) && element > maxElement){
                    maxElement = element;
                    counter++;
                }
            }

            biggestSum += maxElement;
            numbers.remove(maxElement);
            maxElement = 0;
        }

        if(counter < 3){
            System.out.println("No");
        }else {
            System.out.println(biggestSum);
        }
    }
}
