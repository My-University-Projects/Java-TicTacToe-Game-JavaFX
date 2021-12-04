module pl.polsl.tomasz.krypczyk.tictactoegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens pl.polsl.tomasz.krypczyk.tictactoegame to javafx.fxml;
    exports pl.polsl.tomasz.krypczyk.tictactoegame;
}
