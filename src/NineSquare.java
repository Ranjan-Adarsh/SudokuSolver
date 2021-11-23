import java.awt.Dimension;
import javax.swing.text.PlainDocument;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;



public class NineSquare extends JPanel {
	
	/**
	 * @author adarsh
	 */
	public static final long serialVersionUID = 1L;
	private static final int BORDER_WIDTH=3;
	public JTextField c,n,s,e,w,nw,ne,sw,se;
	public JTextField[] sudokuFields= new JTextField[] {
			nw,n,ne,w,c,e,sw,s,se
	};
	public NineSquare(Color bgC)
	{
		setLayout(new GridLayout(3,3));
		initGui();
		setBackground(bgC);
	}
	//public getter
	private void initGui()
	{
		for (int k=0;k<sudokuFields.length;k++)
		{
			sudokuFields[k]= new JTextField(1);
			sudokuFields[k].setDocument(new NumericalDocument());
			add(sudokuFields[k]);
		}
		setBorder(BorderFactory.createMatteBorder(BORDER_WIDTH,BORDER_WIDTH,BORDER_WIDTH,BORDER_WIDTH,Color.BLACK));
	}
	public Dimension getPreferreddDimension()
	{
		return new Dimension(100,100);

	}
	
	public static class NumericalDocument extends PlainDocument
	{
		/**
		 * @author adarsh
		 */
		private static final long serialVersionUID = 1L;
		String digits="0123456789";
		@Override
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (getLength() == 0 && str.length() == 1 && digits.contains(str)) {
                super.insertString(offs, str, a);
            }
            else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
	}
}