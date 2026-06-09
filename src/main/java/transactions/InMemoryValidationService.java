package transactions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

class InMemoryValidationService implements ValidationService {


    /**
     * In-memory validation rules for transaction batches:
     * 1. Process transactions ordered by id.
     * 2. Duplicate transaction ids are invalid.
     * 3. Transactions sharing orderId with any invalid transaction are invalid.
     * 4. BET decreases balance, WIN increases balance.
     * 5. BET that would make balance negative is marked invalid.
     */

    @Override
    public ValidationResult validate(List<Transaction> transactions, long balance) {
        // Processes transactions in deterministic id order, marks duplicate ids
        // and orderId-cascading invalid sequences, then applies BET/WIN business
        // rules to the balance.
        if (transactions == null || transactions.isEmpty() || balance < 0) {
            return ValidationResult.empty();
        }

        List<Transaction> sortedTransactions = transactions.stream()
                .sorted()
                .toList();

        Set<Long> transactionsIds = new HashSet<>();
        Set<Long> failedOrderIds = new HashSet<>();
        Set<Long> duplicateIds = findDuplicateIds(sortedTransactions);

        List<TransactionStatus> transactionStatuses = new ArrayList<>();

        for (Transaction transaction : sortedTransactions) {
            boolean alreadyInvalid = transactionsIds.contains(transaction.id())
                    || duplicateIds.contains(transaction.id())
                    || failedOrderIds.contains(transaction.orderId());

            if (alreadyInvalid) {
                transactionStatuses.add(new TransactionStatus(transaction, false));
                failedOrderIds.add(transaction.orderId());
                transactionsIds.add(transaction.id());
                continue;
            }

            if (transaction.type() == TransactionType.BET) {
                boolean negativeBalance = balance < transaction.amount();

                if (negativeBalance) {
                    transactionStatuses.add(new TransactionStatus(transaction, false));
                    failedOrderIds.add(transaction.orderId());
                } else {
                    balance -= transaction.amount();
                    transactionStatuses.add(new TransactionStatus(transaction, true));
                }
            }

            if (transaction.type() == TransactionType.WIN) {
                balance += transaction.amount();
                transactionStatuses.add(new TransactionStatus(transaction, true));
            }
            transactionsIds.add(transaction.id());

        }

        return new ValidationResult(transactionStatuses);
    }

    private static Set<Long> findDuplicateIds(List<Transaction> transactions) {
        // Finds all duplicate transaction ids up front so they are excluded from
        // valid results in a single deterministic pass.
        Map<Long, Integer> idCount = new HashMap<>();
        Set<Long> duplicateIds = new HashSet<>();

        for (Transaction transaction : transactions) {
            int occurrences = idCount.getOrDefault(transaction.id(), 0) + 1;
            idCount.put(transaction.id(), occurrences);
            if (occurrences > 1) {
                duplicateIds.add(transaction.id());
            }
        }

        return duplicateIds;
    }
}
