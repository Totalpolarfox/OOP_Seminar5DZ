package lesson5.models;

import lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class TableService implements Model {

    private Collection<Table> tables;
    // private Collection<Reservation> reservations;
    // private Reservation reservation;
    // private Collection<Reservation> reservations;
    
    // перегружаем из presenters/Model
    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>(); // создает новую коллекцию tables, когда обращаемся к этому методу

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) { // проходимся по всем столикам
            if (table.getNo() == tableNo) { // найдем нужный столик по номеру
                Reservation reservation = new Reservation(table, reservationDate, name); // создаем объект бронирования
                table.getReservations().add(reservation); // добавим объект бронирования к нашему столику                        
                return reservation.getId(); // возвращаем номер бронирования
            }
            
        }
        
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            for (Iterator<Reservation> it = table.getReservations().iterator(); it.hasNext(); ) {
                Reservation reservation = it.next();
                if (reservation.getId() == oldReservation) {
                    it.remove();
                    System.out.println("Бронирование #" + reservation.getId() + " удалено.");
                    int reservationId = reservationTable(reservationDate, tableNo, name);
                    System.out.println(getAllReservations());
                    return reservationId;
                }
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }      

    // просмотреть все бронирования
    public Collection<Reservation> getAllReservations() {
        Collection<Reservation> allReservations = new ArrayList<>();
        for (Table table : tables) {
            allReservations.addAll(table.getReservations());
        }
        return allReservations;
    }
}
