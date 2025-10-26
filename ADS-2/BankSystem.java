public class BankSystem {
    private long[] balance;

    public BankSystem(long[] balance) {
        this.balance = balance;
    }

    private boolean valid(int account) {
        return account >= 1 && account <= balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!valid(account1) || !valid(account2)) return false;
        if (balance[account1 - 1] < money) return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!valid(account)) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!valid(account)) return false;
        if (balance[account - 1] < money) return false;
        balance[account - 1] -= money;
        return true;
    }

    // A method to display all account balances
    public void showBalances() {
        System.out.println("Current Balances:");
        for (int i = 0; i < balance.length; i++) {
            System.out.println("Account " + (i + 1) + ": $" + balance[i]);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        long[] initialBalances = {1000, 2000, 3000, 4000};
        BankSystem bank = new BankSystem(initialBalances);

        System.out.println("Initial state:");
        bank.showBalances();

        System.out.println("\nDepositing $500 into Account 1...");
        bank.deposit(1, 500);
        bank.showBalances();

        System.out.println("\nWithdrawing $700 from Account 2...");
        bank.withdraw(2, 700);
        bank.showBalances();

        System.out.println("\nTransferring $1000 from Account 3 to Account 4...");
        bank.transfer(3, 4, 1000);
        bank.showBalances();

        System.out.println("\nAttempting invalid transfer (Account 5 doesn't exist):");
        boolean result = bank.transfer(1, 5, 100);
        System.out.println("Transfer success: " + result);
        bank.showBalances();
    }
}
