package cracking.coding.interview.ch3;

import java.util.LinkedList;

public class AnimalQueue {

    LinkedList <Dog> dogs = new LinkedList <>();
    LinkedList <Cat> cats = new LinkedList <>();
    private int order = 0;

    public void enqueue(Animal a) {
        a.order = order++;
        if (a instanceof Dog) {
            dogs.add((Dog) a);
        } else if (a instanceof Cat) {
            cats.add((Cat) a);
        }
    }

    public Animal dequeueAnimal() {
        if (dogs.size() == 0) {
            return dequeueCat();
        } else if (cats.size() == 0) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }


    }

    private Animal dequeueDog() {
        return dogs.poll();

    }

    private Animal dequeueCat() {
        return cats.poll();
    }


    class Animal {
        private int order;
        private String name;

        public Animal(String name) {
            this.name = name;

        }

        public int getOrder() {
            return this.order;
        }

        public String getName() {
            return this.name;
        }

        public boolean isOlderThan(Animal a) {
            return this.getOrder() < a.getOrder();
        }
    }

    class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

    class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }
}


