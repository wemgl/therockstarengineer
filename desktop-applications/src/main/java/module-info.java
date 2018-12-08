module com.therockstarengineer.desktop {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    // FXML uses reflection to work so open up the controllers package
    // so FXML can access its internals.
    opens com.therockstarengineer.desktop.controllers to javafx.fxml;
    exports com.therockstarengineer.desktop;
}