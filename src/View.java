import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class View extends JFrame{
    JButton makeGodet, autoClick, raise,lower;
    JLabel nbGodet;
    ControlButton control;
    Timer timer;
    JLabel jltime, jlautoClick, thune, jlnbgodet, jlnbAutoclick, jlprixautoclick, jlthune, nbgodetsec, nbthunesec,price;
    int nbAutoclick=0;
    private int time;
    double prixvente=0;
    public View(){
        setTitle("Godet Clicker");
        initAttribut();
        createView();
        //pack();
        setLayout(new GridLayout(2,3));
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initAttribut(){
        jltime = new JLabel("00min 00s",SwingConstants.CENTER);
        autoClick= new JButton("Auto click (1/sec)");
        jlprixautoclick = new JLabel("Prix : "+"1 $",SwingConstants.CENTER);
        jlnbAutoclick = new JLabel("Nombre d'Autoclick:", SwingConstants.CENTER);
        jlautoClick = new JLabel("0",SwingConstants.CENTER);
        jlnbAutoclick.setVisible(false);
        autoClick.setVisible(false);
        jlautoClick.setVisible(false);
        jlprixautoclick.setVisible(false);
        control = new ControlButton(this);
        makeGodet = new JButton("Make godets");
        raise = new JButton("Raise");
        price = new JLabel(Double.toString(prixvente),SwingConstants.CENTER);
        lower = new JButton("Lower");
        nbgodetsec = new JLabel("Godet par click: 1 godet",SwingConstants.CENTER);
        nbthunesec = new JLabel("Thune par vente : 1$",SwingConstants.CENTER);
        jlthune = new JLabel("Nombre de thunes:", SwingConstants.CENTER);
        jlnbgodet = new JLabel("Nombre de godets:", SwingConstants.CENTER);
        nbGodet = new JLabel(Double.toString(control.i), SwingConstants.CENTER);
        thune = new JLabel("0$", SwingConstants.CENTER);
    }

    public void createView(){
        JPanel p1 = new JPanel();
        JPanel p5 = new JPanel(new GridLayout(3,1));
        JPanel p2 = new JPanel(new GridLayout(3,1));
        JPanel p3 = new JPanel(new GridLayout(3,1));
        JPanel p4 = new JPanel(new GridLayout(3,1));
        p1.add(makeGodet);
        p1.add(autoClick);
        p5.add(raise);
        p5.add(price);
        p5.add(lower);
        p1.add(p5);
        p2.add(nbgodetsec);
        p2.add(jlnbgodet);
        p2.add(nbGodet);
        p1.add(p2);
        p3.add(jlprixautoclick);
        p3.add(jlnbAutoclick);
        p3.add(jlautoClick);
        p1.add(p3);
        p4.add(nbthunesec);
        p4.add(jlthune);
        p4.add(thune);
        p1.add(p4);
        this.addTimer();
        setControlButton(control);
        setContentPane(p1);
    }

    public Timer getTimer() {
        return this.timer;
    }

    public String formatTime() {
        int minutes = this.time/60;
        int seconds = this.time%60;


        StringBuilder builder = new StringBuilder();

        if (minutes < 10)
            builder.append('0');

        builder.append(minutes);
        builder.append("min ");

        if(seconds < 10)
            builder.append('0');

        builder.append(seconds);
        builder.append('s');

        return builder.toString();
    }

    public void incrementeTime() {
        this.time++;
        if(nbAutoclick!=0) {
            control.i = control.i + nbAutoclick;
        }
        control.i=control.i-prixvente;
        control.nbthune=control.nbthune+prixvente;
        thune.setText(Double.toString(control.nbthune)+"$");
        nbGodet.setText(Double.toString(control.i));
    }

    public void addTimer() {
        this.timer = new Timer(1000, new TimerListener(this));
        this.timer.start();
    }

    public JLabel getJltime() {
        return jltime;
    }

    public void setControlButton(ControlButton listener) {
        makeGodet.addActionListener(listener);
        autoClick.addActionListener(listener);
        lower.addActionListener(listener);
        raise.addActionListener(listener);
    }
}
