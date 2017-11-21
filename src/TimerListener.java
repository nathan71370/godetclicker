import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by thorx on 29/05/2017.
 */
public class TimerListener implements ActionListener {
    private View view;

    /**
     * Créer un listener pour le timer
     * @param view la vue
     */
    public TimerListener(View view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        this.view.incrementeTime();
        this.view.getJltime().setText(this.view.formatTime());
    }
}
