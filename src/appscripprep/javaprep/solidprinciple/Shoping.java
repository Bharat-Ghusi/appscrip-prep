package appscripprep.javaprep.solidprinciple;

public class Shoping {
	private BankCard card;
	Shoping(BankCard card){
		this.card=card;
	}
	public  void purchase(long amount) {
		this.card.doTransact(amount);
	}
	public static void main(String[] args) {
		BankCard card = new CreditCard();
		Shoping shoping = new Shoping(card );
		shoping.purchase(2000);
	}
}
