package tdtu.edu.vn.lab4;

public class Item {
     public String title;

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                '}';
    }
}
