import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class ventana extends JFrame implements Runnable {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Canvas canvas;
    private Thread thread;

    public ventana() {
        setTitle("World Simulator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar y agregar el lienzo al JFrame
        canvas = new Canvas();
        canvas.setBackground(Color.BLUE);  // Puedes establecer el color de fondo según tus necesidades
        add(canvas);

        setVisible(true);

        // Inicializar el hilo y comenzar la ejecución
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // Este método se ejecutará en el hilo creado
        while (true) {

            Color newColor = new Color(
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256)
            ); 

            canvas.setBackground(newColor);

            repaint();  // Llama a repaint para redibujar la interfaz gráfica

            try {
                Thread.sleep(20);  // Espera un breve período de tiempo (aproximadamente 60 FPS)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Puedes realizar dibujos personalizados aquí si lo deseas
    }

    public static void main(String[] args) {
        new ventana();
    }
}
