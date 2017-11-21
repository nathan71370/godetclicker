import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by tbichot on 21/05/2017.
 */
public class ControlButton implements ActionListener {
    private View view;
    double i;
    double temp=1;
    double nbthune=0;
    /**
     * Créer un controller pour les boutons du menu
     * @param view la vue
     */
    public ControlButton(View view) {
        this.view = view;
        try {
            BufferedReader r = new BufferedReader(new FileReader("res/godet.txt"));
            String val = r.readLine();
            i = Integer.valueOf(val);
        }
        catch (Exception e){
            throw new Error(e);
        }
        if(i>=15){
            view.autoClick.setVisible(true);
            view.jlautoClick.setVisible(true);
            view.jlnbAutoclick.setVisible(true);
            view.jlprixautoclick.setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.makeGodet) {
            i++;
            view.nbGodet.setText(Double.toString(i));
        }
        if (e.getSource() == view.autoClick) {
            if(nbthune>=temp){
                view.nbAutoclick++;
                nbthune = nbthune - temp;
                temp++;
                view.thune.setText(Double.toString(nbthune)+"$");
                view.jlautoClick.setText(Integer.toString(view.nbAutoclick));
                view.jlprixautoclick.setText("Prix : "+Double.toString(temp)+" $");
            }
        }
        if(e.getSource()==view.raise){
            view.prixvente=view.prixvente+0.05;
            view.price.setText(Double.toString(view.prixvente));
        }
        if(e.getSource()==view.lower){
            if(view.prixvente>0) {
                view.prixvente = view.prixvente - 0.05;
            }
            view.price.setText(Double.toString(view.prixvente));
        }
    }
}
