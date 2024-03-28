package lesson5.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {

    private static int counter; // фиктивный счетчик
    private int no; // номер столика

    private Collection<Reservation> reservations = new ArrayList<>(); // ссылка на коллекцию бронирования

    public int getNo() { // геттер номера столика
        return no;
    }

    // получить все объекты бронирования
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public Table(){ // конструктор. при создании новых столиков - их номер будет увеличиваться
        no = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }

}
