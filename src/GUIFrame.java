import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Class for the JFrame of the GUI.
 */
@SuppressWarnings("serial")
public class GUIFrame extends JFrame {
	private GUITop top;
	private GUIBottom bottom;
	
	public GUIFrame(Controller controller, String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		getContentPane().setPreferredSize(new Dimension(Driver.getGUIWidth(), Driver.getGUIHeight()));
		
		//Note: we use contentPane because if it a JFrame
		
		//Add the top grid section to the GUI:
		top = new GUITop(controller);
		getContentPane().add(top, BorderLayout.NORTH);
		
		//Add the bottom text section to the GUI:
		bottom = new GUIBottom(controller);
		getContentPane().add(bottom, BorderLayout.SOUTH);
		
		//Pack to set the JFrame to its PreferredSize:
		pack();
		
		setVisible(true);
		
		//Set so that the GUI can't be resized by the user:
		setResizable(false);
	}
	
	/**
	 * Returns the GUITop.
	 */
	public GUITop getGUITop() {
		return top;
	}
	
	/**
	 * Returns the GUIBottom.
	 */
	public GUIBottom getGUIBottom() {
		return bottom;
	}
}
