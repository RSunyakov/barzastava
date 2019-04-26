package task02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SetOfPhones {
    private List<Phone> phoneList;

    public SetOfPhones() {
        this.phoneList = new ArrayList<>();
    }

    public List<Phone> top10(Comparator<Phone> comparator, int n) {
        for (int i = 0; i < n; i++) {
            phoneList.add(new Phone(i, i + "model", i*21));
        }
        phoneList.sort(comparator);
        return phoneList;
    }
}
