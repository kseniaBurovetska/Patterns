package iterator;

public class IteratorPattern {

    public static void main(String[] args) {
        TaskList c = new TaskList();
        Iterator iterator = c.getIterator();

        while(iterator.hasNext()){
            System.out.println((String)iterator.next());
        }
    }

}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Container {
    Iterator getIterator();
}

class TaskList implements Container {
    String[] tasks = {"Task1", "Task2", "Task3", "Task4"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {

        int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < tasks.length;
        }

        @Override
        public Object next() {
            return tasks[counter++];
        }
    }
}

