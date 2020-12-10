package collection;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Item
 */
public class Item implements Comparable<Item> {

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(this.partNumber, o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }

    @Override
    public String toString() {
        return "[description=" + this.description + ", partNumber=" + this.partNumber + "]";
    }

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("A", 2));
        parts.add(new Item("B", 3));
        parts.add(new Item("C", 1));
        System.out.println("Sorted by partNumber: " + parts);

        // TreeSet(Comparator<? super E> comparator) 构造一个带比较器的树集
        NavigableSet<Item> descriptions = new TreeSet<>(Comparator.comparing(item -> item.getDescription()));
        descriptions.addAll(parts);
        System.out.println("Sorted by description: " + descriptions);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the partNumber
     */
    public int getPartNumber() {
        return partNumber;
    }

    /**
     * @param partNumber the partNumber to set
     */
    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    

}