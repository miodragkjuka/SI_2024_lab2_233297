import java.util.List;

class Item {
    String name;
    String barcode; // numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}

public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment) {
        if (allItems == null) {// 1
            throw new RuntimeException("allItems list can't be null!");// 2
        }

        float sum = 0;

        for (int i = 0; i < allItems.size(); i++) {// 3
            Item item = allItems.get(i);
            if (item.getName() == null || item.getName().length() == 0) {// 4
                item.setName("unknown");// 5
            }
            if (item.getBarcode() != null) {// 6
                String allowed = "0123456789";
                char chars[] = item.getBarcode().toCharArray();
                for (int j = 0; j < item.getBarcode().length(); j++) {// 7
                    char c = item.getBarcode().charAt(j);
                    if (allowed.indexOf(c) == -1) {// 8
                        throw new RuntimeException("Invalid character in item barcode!");// 9
                    }
                }
                if (item.getDiscount() > 0) {// 10
                    sum += item.getPrice() * item.getDiscount();// 11
                } else {// 12
                    sum += item.getPrice();
                }
            } else {// 13
                throw new RuntimeException("No barcode!");
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0') {// 15
                sum -= 30;// 16
            }
        } // 17
        if (sum <= payment) {// 18
            return true;// 19
        } else {// 20
            return false;
        }
    }// 21
}