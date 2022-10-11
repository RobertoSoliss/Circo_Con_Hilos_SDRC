package circo_hilos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Circo_Hilos extends Thread {

    int vendidos = 0;
    int sobrantes = 100;
    Index objI = new Index();

    public static void main(String[] args) {
        Index index = new Index();
        index.setTitle("CIRCO CECyT 9");
        index.setVisible(true);
        index.setResizable(false);
        index.setSize(750, 450);
        index.setLocationRelativeTo(null);
    }

    JLabel etiqueta;
    Index persona;

    public Circo_Hilos(JLabel etiqueta, Index persona) {
        this.etiqueta = etiqueta;
        this.persona = persona;
    }

    @Override
    public void run() {
        int persona1;
        while (true) {
            try {
                System.out.println("ESTÁ DENTRO DEL TRY");
                sleep((int) (Math.random() * 150));
                persona1 = persona.getpersonauno().getLocation().x;
                if (persona1 > persona.getentrada().getLocation().x + 50) {
                    System.out.println("ESTÁ EN EL IF");
                    etiqueta.setLocation(etiqueta.getLocation().x - 10, etiqueta.getLocation().y);
                    persona.repaint();
                    if (persona1 < 200) {
                        etiqueta.setLocation(630, etiqueta.getLocation().y);
                        vendidos = vendidos + 11;
                        sobrantes = sobrantes - 11;
                        objI.update(vendidos, sobrantes);
                        if (sobrantes < 2) {
                            sobrantes = 0;
                            vendidos = vendidos + 1;
                                                        JOptionPane.showMessageDialog(null, "SOLO ALCANZA BOLETO UNA PERSONA quién será unu");

                            JOptionPane.showMessageDialog(null, "EL NUMERO DE VENDIDOS ES DE: " + vendidos + "       EL NÚMERO DE SOBRANTES ES: " + sobrantes + "   No me funciona el SetText unu");
                            JOptionPane.showMessageDialog(null, "YA NO HAY BOLETOS  :C BAI");
                            System.exit(0);

                        }
                    }
                } else {
                    break;
                }

            } catch (Exception e) {
            }
        }
    }
}
