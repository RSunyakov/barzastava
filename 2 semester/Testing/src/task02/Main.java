package task02;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SetOfPhones sf = new SetOfPhones();
        List<Phone> phoneList = sf.top10(new ByNumberComparator(), 5);
        for (int i = 0; i < phoneList.size(); i++) {
            System.out.println(phoneList.get(i).getNumber());
        }
    }
}
