package myMath;
import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
//import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class LinePlotTest extends JFrame {
    /**
	 * Tomer and Ortal
	 * 
	 * Erich Seifert github https://github.com/eseifert/gral/wiki
	 */
	private static final long serialVersionUID = 1L;

	public LinePlotTest(Polynom a) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);

        @SuppressWarnings("unchecked")
		DataTable data = new DataTable(Double.class, Double.class);
        @SuppressWarnings("unchecked")
		DataTable data2 = new DataTable(Double.class, Double.class);
        
        for (double x = -2; x <= 6; x+=0.2) {	
        	double y = a.f(x);
            data.add(x, y);
            if(a.derivative().f(x-0.1)<0 && a.derivative().f(x+0.1)>0 ) {
            	System.out.println(x+","+a.f(x)+"min");
            	data2.add(x,a.f(x)); 
        
            }
            else if(a.derivative().f(x-0.1)>0 && a.derivative().f(x+0.1)<0 ) {
            	System.out.println(x+","+a.f(x)+"max");
            	data2.add(x,a.f(x));
            }
        }
        
        XYPlot plot = new XYPlot(data,data2);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
        Color color = new Color(0.3f, 1.0f, 0.0f);
        Color color2 = new Color(1.0f, 0.1f, 0.1f);  		
        plot.getPointRenderers(data2).get(0).setColor(color2);
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color);
       
    }

    public static void main(String[] args) {
       Polynom a = new Polynom("0.2x^4-1.5x^3+3x^2-1x-5");
    	LinePlotTest frame = new LinePlotTest(a);
        frame.setVisible(true);
    }
}