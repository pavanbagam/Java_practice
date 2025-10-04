import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayListPractice {
    public static void main(String[] args) {
        System.out.println("=== ARRAYLIST COMPLETE REFERENCE ===");
        
        // 1. Basic ArrayList Creation and Operations
        System.out.println("\n1. BASIC ARRAYLIST CREATION AND OPERATIONS");
        
        // Creating ArrayLists
        ArrayList<String> fruits = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        var cars = new ArrayList<String>(); // Using var (Java 10+)
        
        // add() method
        System.out.println("\n--- add() method ---");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add(1, "Mango"); // Insert at specific position
        System.out.println("After add operations: " + fruits);
        
        // addAll() method
        System.out.println("\n--- addAll() method ---");
        ArrayList<String> moreFruits = new ArrayList<>();
        moreFruits.add("Grapes");
        moreFruits.add("Pineapple");
        fruits.addAll(moreFruits);
        System.out.println("After addAll: " + fruits);
        
        fruits.addAll(2, Arrays.asList("Cherry", "Berry"));
        System.out.println("After addAll at index 2: " + fruits);
        
        // 2. Access and Search Operations
        System.out.println("\n2. ACCESS AND SEARCH OPERATIONS");
        
        // get() method
        System.out.println("\n--- get() method ---");
        System.out.println("Element at index 0: " + fruits.get(0));
        System.out.println("Element at index 3: " + fruits.get(3));
        
        // contains() method
        System.out.println("\n--- contains() method ---");
        System.out.println("Contains 'Apple': " + fruits.contains("Apple"));
        System.out.println("Contains 'Watermelon': " + fruits.contains("Watermelon"));
        
        // indexOf() and lastIndexOf() methods
        System.out.println("\n--- indexOf() and lastIndexOf() methods ---");
        fruits.add("Apple"); // Add duplicate
        System.out.println("First index of 'Apple': " + fruits.indexOf("Apple"));
        System.out.println("Last index of 'Apple': " + fruits.lastIndexOf("Apple"));
        System.out.println("Index of 'Nonexistent': " + fruits.indexOf("Nonexistent"));
        
        // 3. Modification Operations
        System.out.println("\n3. MODIFICATION OPERATIONS");
        
        // set() method
        System.out.println("\n--- set() method ---");
        String oldValue = fruits.set(2, "Blueberry");
        System.out.println("Replaced '" + oldValue + "' with 'Blueberry'");
        System.out.println("After set: " + fruits);
        
        // remove() method
        System.out.println("\n--- remove() method ---");
        fruits.remove("Berry"); // Remove by object
        System.out.println("After removing 'Berry': " + fruits);
        
        String removed = fruits.remove(1); // Remove by index
        System.out.println("Removed element at index 1: " + removed);
        System.out.println("After remove by index: " + fruits);
        
        // removeAll() method
        System.out.println("\n--- removeAll() method ---");
        ArrayList<String> toRemove = new ArrayList<>(Arrays.asList("Grapes", "Pineapple"));
        fruits.removeAll(toRemove);
        System.out.println("After removeAll: " + fruits);
        
        // retainAll() method
        System.out.println("\n--- retainAll() method ---");
        ArrayList<String> toRetain = new ArrayList<>(Arrays.asList("Apple", "Orange", "Mango"));
        fruits.retainAll(toRetain);
        System.out.println("After retainAll: " + fruits);
        
        // 4. Bulk Operations
        System.out.println("\n4. BULK OPERATIONS");
        
        // size() and isEmpty() methods
        System.out.println("\n--- size() and isEmpty() methods ---");
        System.out.println("Size: " + fruits.size());
        System.out.println("Is empty: " + fruits.isEmpty());
        
        // clear() method
        System.out.println("\n--- clear() method ---");
        ArrayList<String> tempList = new ArrayList<>(fruits);
        tempList.clear();
        System.out.println("After clear - Size: " + tempList.size() + ", Is empty: " + tempList.isEmpty());
        
        // 5. Conversion Methods
        System.out.println("\n5. CONVERSION METHODS");
        
        // toArray() method
        System.out.println("\n--- toArray() method ---");
        Object[] objectArray = fruits.toArray();
        System.out.println("Object array: " + Arrays.toString(objectArray));
        
        String[] stringArray = fruits.toArray(new String[0]);
        System.out.println("String array: " + Arrays.toString(stringArray));
        
        // 6. Iteration Methods
        System.out.println("\n6. ITERATION METHODS");
        
        // forEach() method
        System.out.println("\n--- forEach() method ---");
        System.out.print("Using forEach: ");
        fruits.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println();
        
        // iterator() method
        System.out.println("\n--- iterator() method ---");
        Iterator<String> iterator = fruits.iterator();
        System.out.print("Using iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // listIterator() method
        System.out.println("\n--- listIterator() method ---");
        ListIterator<String> listIterator = fruits.listIterator();
        System.out.print("Forward with listIterator: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.print("\nBackward with listIterator: ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        
        // 7. Advanced Operations
        System.out.println("\n7. ADVANCED OPERATIONS");
        
        // replaceAll() method
        System.out.println("\n--- replaceAll() method ---");
        ArrayList<String> fruitsCopy = new ArrayList<>(fruits);
        fruitsCopy.replaceAll(fruit -> fruit.toUpperCase());
        System.out.println("After replaceAll (uppercase): " + fruitsCopy);
        
        // removeIf() method
        System.out.println("\n--- removeIf() method ---");
        ArrayList<String> fruitsForRemoval = new ArrayList<>(Arrays.asList(
            "Apple", "Banana", "Avocado", "Apricot", "Cherry"));
        fruitsForRemoval.removeIf(fruit -> fruit.startsWith("A"));
        System.out.println("After removeIf (starts with 'A'): " + fruitsForRemoval);
        
        // sort() method
        System.out.println("\n--- sort() method ---");
        ArrayList<String> unsorted = new ArrayList<>(Arrays.asList(
            "Zucchini", "Apple", "Mango", "Banana", "Cherry"));
        unsorted.sort(Comparator.naturalOrder());
        System.out.println("After sort (natural order): " + unsorted);
        
        unsorted.sort(Comparator.reverseOrder());
        System.out.println("After sort (reverse order): " + unsorted);
        
        // 8. Utility Methods
        System.out.println("\n8. UTILITY METHODS");
        
        // clone() method
        System.out.println("\n--- clone() method ---");
        @SuppressWarnings("unchecked")
        ArrayList<String> cloned = (ArrayList<String>) fruits.clone();
        System.out.println("Original: " + fruits);
        System.out.println("Cloned: " + cloned);
        System.out.println("Are they same object? " + (fruits == cloned));
        System.out.println("Do they have same content? " + fruits.equals(cloned));
        
        // subList() method
        System.out.println("\n--- subList() method ---");
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> subList = numberList.subList(2, 7); // from index 2 to 6
        System.out.println("Original list: " + numberList);
        System.out.println("SubList (2-7): " + subList);
        
        // spliterator() method
        System.out.println("\n--- spliterator() method ---");
        Spliterator<String> spliterator = fruits.spliterator();
        System.out.println("Spliterator characteristics: " + spliterator.characteristics());
        System.out.println("Estimated size: " + spliterator.estimateSize());
        
        // 9. Capacity Methods
        System.out.println("\n9. CAPACITY METHODS");
        
        // ensureCapacity() and trimToSize() methods
        System.out.println("\n--- ensureCapacity() and trimToSize() methods ---");
        ArrayList<String> capacityList = new ArrayList<>();
        capacityList.ensureCapacity(100); // Ensure capacity for 100 elements
        System.out.println("Capacity ensured for 100 elements");
        
        // Add some elements
        for (int i = 0; i < 10; i++) {
            capacityList.add("Item " + i);
        }
        capacityList.trimToSize(); // Trim to actual size
        System.out.println("Trimmed to actual size");
        
        // 10. Working with Different Data Types
        System.out.println("\n10. WORKING WITH DIFFERENT DATA TYPES");
        
        // Integer ArrayList
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.add(40);
        System.out.println("Integer list: " + integers);
        
        // Double ArrayList
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(10.5);
        doubles.add(20.7);
        doubles.add(30.9);
        System.out.println("Double list: " + doubles);
        
        // Custom Object ArrayList
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 22));
        System.out.println("People list: " + people);
        
        // Sort custom objects
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println("Sorted by age: " + people);
        
        // 11. Common Patterns and Best Practices
        System.out.println("\n11. COMMON PATTERNS AND BEST PRACTICES");
        
        // Safe iteration with removal
        ArrayList<String> safeRemoveList = new ArrayList<>(Arrays.asList(
            "Keep", "Remove", "Keep", "Remove", "Keep"));
        System.out.println("Before safe removal: " + safeRemoveList);
        
        Iterator<String> safeIterator = safeRemoveList.iterator();
        while (safeIterator.hasNext()) {
            if ("Remove".equals(safeIterator.next())) {
                safeIterator.remove();
            }
        }
        System.out.println("After safe removal: " + safeRemoveList);
        
        // Bulk operations
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("C", "D", "E", "F"));
        
        // Union
        ArrayList<String> union = new ArrayList<>(list1);
        union.addAll(list2);
        System.out.println("Union: " + union);
        
        // Intersection
        ArrayList<String> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        System.out.println("Intersection: " + intersection);
        
        // Difference
        ArrayList<String> difference = new ArrayList<>(list1);
        difference.removeAll(list2);
        System.out.println("Difference (list1 - list2): " + difference);
        
        System.out.println("\n=== END OF ARRAYLIST REFERENCE ===");
    }
    
    // Custom class for demonstration
    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}