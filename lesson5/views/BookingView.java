package lesson5.views;

import lesson5.models.Table;
import lesson5.presenters.View;
import lesson5.presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

// предоставляет методы, которые будут визулизировать интерактив с конечным клиентом
public class BookingView implements View {


    private Collection<ViewObserver> observers; // хранит коллекцию наблюдателей. BookingView будет знать, кто за ним наблюдает

    // отобразить все столики
    public void showTables(Collection<Table> tables){ // Collection<Table> tables - коллекция наших столиков
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    // как только находится наблюдатель за BookingView - создаем коллекцию наблюдателей
    @Override
    public void registerObserver(ViewObserver observer) {
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(observer); // регистрируем нового наблюдателя
    }

    // визуализирует результат 
    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер брони: #%d\n", reservationNo);
        }
        else {
            System.out.println("Произошла ошибка при попытке забронировать столик.\nПовторите операцию позже.");
        }
    }

    // бронирование столика
    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observers != null)
        {
            for (ViewObserver observer : observers){ // проходимся по всем наблюдателям
                observer.onReservationTable(orderDate, tableNo, name); // и вызовем на каждом наблюдателе метод onReservationTable
            }
        }
    }

    // изменение бронирования

    // в TableService создать новый метод (изменить бронирование: удалить старое, добавить новое)
    // и по цепочке вернуть всё назад
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        if (observers != null)
        {
            for (ViewObserver observer : observers){ // проходимся по всем наблюдателям
                observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name); // и вызовем на каждом наблюдателе метод onChangeReservationTable
            }
        }
    }

}
