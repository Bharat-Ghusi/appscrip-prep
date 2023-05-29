package appscripprep.javaprep.solidprinciple.Bank;

public interface Bank {
	void sendMoney(long amount);

	void receiveMoney(long amount);

	void sentNotification(String medium);

	void loan(String medium);

	void creditCard(String medium);

	void DebitCard(String medium);
}
