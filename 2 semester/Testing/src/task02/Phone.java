package task02;

public class Phone implements Comparable<Phone> {
    private int number;
    private String model;
    private int IMEI;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getIMEI() {
        return IMEI;
    }

    public void setIMEI(int IMEI) {
        this.IMEI = IMEI;
    }

    public Phone(int number, String model, int IMEI) {
        this.number = number;
        this.model = model;
        this.IMEI = IMEI;
    }

    @Override
    public int compareTo(Phone o) {
        int tmp = this.getModel().compareTo(o.getModel());
        if (tmp != 0) {
            return tmp;
        } else {
            return this.getNumber() - o.getNumber();
        }
    }
    }
