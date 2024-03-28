package lesson5.presenters;

// import lesson5.models.TableService;
// import lesson5.views.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    // общается и с моделями и с представлениями
    private Model model;
    private View view;

    // взаимодействие на уровне абстракций (интерфейсов). 
    // осовобождает от привязки к конечным типам
    public BookingPresenter(Model model, View view) { // передаются интерфейсы
        this.model = model;
        this.view = view;
        view.registerObserver(this); // объявляем текущий объект BookingPresenter как наблюдателя за представлением
    }

    // обновить отображение столиков в рамках представления
    public void updateTablesView() {
        view.showTables(model.loadTables());
    }

    // обновить результаты бронирования столика
    private void updateReservationTableView(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    // вызываем тогда, когда возбуждено событие на представление
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        } catch (Exception e) {
            updateReservationTableView(-1);
        }

    }

    // вызываем тогда, когда возбуждено событие на представление
    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int newReservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateReservationTableView(newReservationNo);
        } catch (Exception e) {
            updateReservationTableView(-1);
        }

    }
}
