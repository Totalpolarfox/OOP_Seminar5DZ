package lesson5.presenters;

import lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

// прослойка для взаимодействия любой модели с BookingPresenter
// необходимо имплементировать этот интерфейс в models/TableService

public interface Model {

    // получает столики, чтобы потом их визуализировать
    Collection<Table> loadTables();

    // результат (номер) бронирования
    int reservationTable(Date reservationDate, int tableNo, String name);

    // изменение бронирования
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

}
