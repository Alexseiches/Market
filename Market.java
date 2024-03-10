import java.util.LinkedList;

interface QueueBehaviour {
    void enqueue(Person person);
    Person dequeue();
}

interface MarketBehaviour {
    void enterMarket(Person person);
    void leaveMarket(Person person);
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Market implements QueueBehaviour, MarketBehaviour {
    private LinkedList<Person> queue = new LinkedList<>();
    private int capacity;

    public Market(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void enqueue(Person person) {
        if (queue.size() < capacity) {
            queue.add(person);
            System.out.println(person.getName() + " entered the queue.");
        } else {
            System.out.println("Queue is full. " + person.getName() + " cannot enter.");
        }
    }

    @Override
    public Person dequeue() {
        if (!queue.isEmpty()) {
            Person person = queue.remove();
            System.out.println(person.getName() + " left the queue.");
            return person;
        } else {
            System.out.println("Queue is empty. No one to dequeue.");
            return null;
        }
    }

    public void enterMarket(Person person) {
        System.out.println(person.getName() + " entered the market.");
    }

    public void leaveMarket(Person person) {
        System.out.println(person.getName() + " left the market.");
    }

    public void update() {
        System.out.println("Market is updated.");
    }

    public static void main(String[] args) {
        Market market = new Market(5); 

        market.enqueue(new Person("Alice"));
        market.enqueue(new Person("Bob"));
        market.enqueue(new Person("Cris"));

        market.dequeue();

        market.enterMarket(new Person("David"));
        market.leaveMarket(new Person("Bob"));

        market.update();
    }
}
