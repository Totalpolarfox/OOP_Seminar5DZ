package lesson5.presenters;

import lesson5.models.Table;

import java.util.Collection;


// прослойка для взаимодействия любого представления с BookingPresenter
// необходимо имплементировать этот интерфейс в views/BookingView

public interface View {

    // выводит информацию о столиках
    void showTables(Collection<Table> tables);

    // регистрация наблюдателя
    void registerObserver(ViewObserver observer);

    // отрисовка результата бронирования столика
    void showReservationTableResult(int reservationNo);

}
