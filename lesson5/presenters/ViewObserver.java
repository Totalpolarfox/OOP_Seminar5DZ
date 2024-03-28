package lesson5.presenters;

import java.util.Date;

// тот, кто имплементирует этот интерфейс - будет наблюдателем за представлением
// в нашем случае это - BookingPresenter
public interface ViewObserver {

    // обработчик возбуждаемого события
    void onReservationTable(Date orderDate, int tableNo, String name);

    // обработчик возбуждаемого события
    void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
