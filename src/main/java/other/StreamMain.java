package other;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class StreamMain {

    private static final String MILAN = "Milan";
    private static final String CAMBRIDGE = "Cambridge";
    private static final Trader RAULE = new Trader("Raule", CAMBRIDGE);
    private static final Transaction TRANSACTION_2 = new Transaction(RAULE, 2012, 1000);
    private static final Trader MARIO = new Trader("Mario", MILAN);
    private static final Transaction TRANSACTION_3 = new Transaction(MARIO, 2012, 710);
    private static final Transaction TRANSACTION_5 = new Transaction(MARIO, 2012, 700);
    private static final Trader ALAN = new Trader("Alan", CAMBRIDGE);
    private static final Transaction TRANSACTION_6 = new Transaction(ALAN, 2012, 950);
    private static final Trader BRIAN = new Trader("Brian", CAMBRIDGE);
    private static final Transaction TRANSACTION_1 = new Transaction(BRIAN, 2011, 300);
    private static final Transaction TRANSACTION_4 = new Transaction(BRIAN, 2011, 300);
    private static final List<Transaction> TRANSACTION_LIST =
            Arrays.asList(
                    TRANSACTION_1,
                    TRANSACTION_2,
                    TRANSACTION_3,
                    TRANSACTION_4,
                    TRANSACTION_5,
                    TRANSACTION_6
            );


    private record Trader(String name, String city) {
    }

    private record Transaction(Trader trader, int year, int value) {
    }

    public static List<Integer> transactionsIn2011SortedByValue() {
        return TRANSACTION_LIST.stream()
                .filter(transaction -> transaction.year() == 2011)
                .map(Transaction::value)
                .sorted()
                .toList();
    }

    public static List<String> traderCities() {
        return TRANSACTION_LIST.stream()
                .map(transaction -> transaction.trader().city())
                .distinct()
                .sorted()
                .toList();
    }

    public static List<String> cambridgeTraderNames() {
        return TRANSACTION_LIST.stream()
                .map(Transaction::trader)
                .filter(trader -> CAMBRIDGE.equals(trader.city()))
                .map(Trader::name)
                .distinct()
                .sorted()
                .toList();
    }

    public static boolean hasTraderInMilan() {
        return TRANSACTION_LIST.stream()
                .map(Transaction::trader)
                .anyMatch(trader -> MILAN.equals(trader.city()));
    }

    public static int highestTransactionValue() {
        return TRANSACTION_LIST.stream()
                .max(Comparator.comparingInt(Transaction::value))
                .orElseThrow()
                .value();
    }

    public static int totalValueFromCambridge() {
        return TRANSACTION_LIST.stream()
                .filter(transaction -> CAMBRIDGE.equals(transaction.trader().city()))
                .mapToInt(Transaction::value)
                .sum();
    }
}
