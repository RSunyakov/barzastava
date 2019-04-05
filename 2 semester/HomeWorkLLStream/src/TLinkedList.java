import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class TLinkedList<T> {
    private Node head;
    private int count = 0;

    public void add (T e) {
        Node newNode = new Node();
        newNode.setValue(e);
        newNode.setNext(null);
        if (head != null) {
            Node current = head;
            // по итогу цикла в current записана ссылка на последнюю Ноду
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        } else {
            head = newNode;
        }
        count++;
    }

    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return (T) current.getValue();
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            head = null;
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            Node beforeRemovable = head;
            for (int i = 0; i < index - 1; i++) {
                beforeRemovable = beforeRemovable.getNext();
            }
            Node nodeToRemove = beforeRemovable.getNext();
            beforeRemovable.setNext(nodeToRemove.getNext());
        }
        count--;
    }

    public void addAll(TLinkedList<T> list) {
        for (int i = 0; i < list.count; i++) {
            this.add(list.get(i));
            count++;
        }
    }
    public int size() {
        return count;
    }

    public Stream<T> stream() {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < this.size(); i++){
            arrayList.add(this.get(i));
        }
        return new MyStream(arrayList);
    }
    public class MyStream implements Stream<T> {
        private ArrayList<T> arrayList;
        private Stream<T> stream;

        public MyStream(ArrayList<T> arrayList) {
            this.arrayList = arrayList;
        }

        @Override
        public Stream<T> filter(Predicate<? super T> predicate) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (!predicate.test(arrayList.get(i))) {
                    arrayList.remove(i);
                }
            }
            return this;
        }

        @Override
        public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
            for (int i = 0; i < arrayList.size(); i++) {
                mapper.apply(arrayList.get(i));
            }
            return (Stream<R>) this;
        }

        @Override
        public IntStream mapToInt(ToIntFunction<? super T> mapper) {
            return null;
        }

        @Override
        public LongStream mapToLong(ToLongFunction<? super T> mapper) {
            return null;
        }

        @Override
        public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
            return null;
        }

        @Override
        public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
            return null;
        }

        @Override
        public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
            return null;
        }

        @Override
        public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
            return null;
        }

        @Override
        public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
            return null;
        }

        @Override
        public Stream<T> distinct() {
            return null;
        }

        @Override
        public Stream<T> sorted() {
            return null;
        }

        @Override
        public Stream<T> sorted(Comparator<? super T> comparator) {
            return null;
        }

        @Override
        public Stream<T> peek(Consumer<? super T> action) {
            return null;
        }

        @Override
        public Stream<T> limit(long maxSize) {
            return null;
        }

        @Override
        public Stream<T> skip(long n) {
            return null;
        }

        @Override
        public void forEach(Consumer<? super T> action) {
            for (int i = 0; i < arrayList.size(); i++) {
                action.accept(arrayList.get(i));
            }
        }

        @Override
        public void forEachOrdered(Consumer<? super T> action) {

        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <A> A[] toArray(IntFunction<A[]> generator) {
            return null;
        }

        @Override
        public T reduce(T identity, BinaryOperator<T> accumulator) {
            return null;
        }

        @Override
        public Optional<T> reduce(BinaryOperator<T> accumulator) {
            return Optional.empty();
        }

        @Override
        public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
            return null;
        }

        @Override
        public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
            return null;
        }

        @Override
        public <R, A> R collect(Collector<? super T, A, R> collector) {
            return null;
        }

        @Override
        public Optional<T> min(Comparator<? super T> comparator) {
            return Optional.empty();
        }

        @Override
        public Optional<T> max(Comparator<? super T> comparator) {
            return Optional.empty();
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public boolean anyMatch(Predicate<? super T> predicate) {
            return false;
        }

        @Override
        public boolean allMatch(Predicate<? super T> predicate) {
            return false;
        }

        @Override
        public boolean noneMatch(Predicate<? super T> predicate) {
            return false;
        }

        @Override
        public Optional<T> findFirst() {
            return Optional.empty();
        }

        @Override
        public Optional<T> findAny() {
            return Optional.empty();
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }

        @Override
        public Spliterator<T> spliterator() {
            return null;
        }

        @Override
        public boolean isParallel() {
            return false;
        }

        @Override
        public Stream<T> sequential() {
            return null;
        }

        @Override
        public Stream<T> parallel() {
            return null;
        }

        @Override
        public Stream<T> unordered() {
            return null;
        }

        @Override
        public Stream<T> onClose(Runnable closeHandler) {
            return null;
        }

        @Override
        public void close() {

        }
    }
}