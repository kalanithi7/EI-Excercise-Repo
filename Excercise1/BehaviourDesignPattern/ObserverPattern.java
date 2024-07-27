package Excercise1.BehaviourDesignPattern;
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockData);
}

class StockMarket {
    private List<Observer> observers = new ArrayList<>();
    private String stockData;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockData);
        }
    }

    public void setStockData(String stockData) {
        this.stockData = stockData;
        notifyObservers();
    }
}

class StockClient implements Observer {
    private String name;

    public StockClient(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockData) {
        System.out.println(name + " received stock data: " + stockData);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        StockClient client1 = new StockClient("Client 1");
        StockClient client2 = new StockClient("Client 2");

        market.registerObserver(client1);
        market.registerObserver(client2);

        market.setStockData("AAPL: 150, GOOG: 2750");
    }
}
