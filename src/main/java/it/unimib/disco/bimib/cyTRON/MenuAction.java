package it.unimib.disco.bimib.cyTRON;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.cytoscape.app.swing.CySwingAppAdapter;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;


/**
 * Creates a new menu item under Apps menu section.
 *
 */
public class MenuAction extends AbstractCyAction {
	private CySwingAppAdapter adapter;
	private CommandExecutor commandExecutor;
	public MenuAction(CyApplicationManager cyApplicationManager, 
			CySwingAppAdapter adapter, 
			CommandExecutor commandExecutor,
			final String menuTitle) {
		super("cyTRON-2");
		//super(menuTitle, cyApplicationManager, null, null);
		setPreferredMenu("Apps");
		this.adapter = adapter;
		this.commandExecutor = commandExecutor;
	}

	public void actionPerformed(ActionEvent e) {
		/*int HEIGHT = 300;
		int WIDTH = 200;
		// Write your own function here.
		//JOptionPane.showMessageDialog(null, "Hello Cytoscape World!");
		
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		JLabel label = new JLabel("cacca");
		
		frame.add(label);
		WindowAdapter distruttore = new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				
			}
		};
		frame.addWindowListener(distruttore);
		frame.setVisible(true);*/
		JFrame frame = new JFrame();
		OptionPanel2 panel = new OptionPanel2(commandExecutor, frame);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
                
		//a = panel.script;
                //taskFactory.createTaskIterator(a)
		final JFrame desktop = adapter.getCySwingApplication().getJFrame();
		frame.setLocationRelativeTo(desktop);
		frame.setVisible(true);
	}
}