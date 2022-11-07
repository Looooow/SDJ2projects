package Server;

import model.Timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.DataOutputStream;
import java.io.IOException;

public class BroadCastHandler implements PropertyChangeListener {

    private DataOutputStream out;

    public BroadCastHandler(DataOutputStream out, Timer timer) {
        this.out = out;
        timer.addListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        try {
            out.writeInt((Integer) evt.getNewValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
