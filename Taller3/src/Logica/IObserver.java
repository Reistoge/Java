package Logica;

public interface IObserver {
	public void addSubscriber(Subscriber s);
	public void removeSubscriber(Subscriber s);
	public void notifySubscribers();
}
interface Subscriber{
	String notification();
}
