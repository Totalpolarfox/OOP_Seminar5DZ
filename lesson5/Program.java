package lesson5;

import lesson5.models.TableService;
import lesson5.presenters.BookingPresenter;
import lesson5.presenters.Model;
import lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Model model = new TableService(); // создаем модель
        BookingView view = new BookingView(); // создаем представление
        BookingPresenter presenter = new BookingPresenter(model, view); // связываем модель и представление
        presenter.updateTablesView(); // обновляем отображение столиков методом из BookingPresenter (выводим на экран)
        view.reservationTable(new Date(), 2, "Станислав"); // метод бронирования
        view.reservationTable(new Date(), 1, "Людмила");
        view.reservationTable(new Date(), 3, "Константин");
        view.reservationTable(new Date(), 5, "Виктор");
        view.reservationTable(new Date(), 4, "Анна");
        view.changeReservationTable(1001, new Date(), 4, "Станислав");
        

    }

}
