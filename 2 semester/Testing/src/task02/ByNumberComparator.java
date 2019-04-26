package task02;

import java.util.Comparator;

public class ByNumberComparator implements Comparator<Phone> {
    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getNumber() -o2.getNumber();
    }
}
