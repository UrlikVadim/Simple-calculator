import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalFrame extends JFrame {

	public static void main(String[] args) {		
		 CalFrame frame = new CalFrame();
		 frame.setVisible(true);
	}
	
	JTextField TextInput1,TextInput2,TextInput3;
	JButton Button1;
	JComboBox ComboBox1,ComboBox2,ComboBox3,ComboBox4;
	JLabel ltextbox1,ltextbox2,ltextbox3,lcombobox1,lcombobox2,lcombobox3,lcombobox4;
	
	public CalFrame() {	
		super("Калькулятор c разными системами счисления");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 200);
		this.setResizable(false);
		this.setLayout(null);
		
		TextInput1 = new JTextField();
		TextInput1.setLocation(10, 30);
		TextInput1.setSize(200, 30);
		TextInput1.setFont(new Font("Arial",10,20));		
		
		TextInput2 = new JTextField();
		TextInput2.setLocation(300, 30);
		TextInput2.setSize(200, 30);
		TextInput2.setFont(new Font("Arial",10,20));
		
		TextInput3 = new JTextField();
		TextInput3.setLocation(570, 30);
		TextInput3.setSize(200, 30);
		TextInput3.setFont(new Font("Arial",10,20));
		
		
		Button1 = new JButton("=");
		Button1.setLocation(500, 30);
		Button1.setSize(70, 29);
		Button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                Button1_Click(evt);
            }
        });
		
		ComboBox1 = new JComboBox();
		ComboBox1.setLocation(210, 30);
		ComboBox1.setSize(90, 30);
		ComboBox1.setFont(new Font("Arial",10,20));
		ComboBox1.addItem("+");
		ComboBox1.addItem("-");
		ComboBox1.addItem("/");
		ComboBox1.addItem("*");
		ComboBox1.addItem("sqrt");		
		ComboBox1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                ComboBox1ActionPerformed(evt);
            }
        });
		
		ComboBox2 = new JComboBox();
		ComboBox2.setLocation(150, 60);
		ComboBox2.setSize(60, 30);
		ComboBox2.setFont(new Font("Arial",10,20));
		for (int i = 2;i<17;i++)
		{
			ComboBox2.addItem(i);
		}
		ComboBox2.setSelectedItem(10);
	
		ComboBox3 = new JComboBox();
		ComboBox3.setLocation(440, 60);
		ComboBox3.setSize(60, 30);
		ComboBox3.setFont(new Font("Arial",10,20));
		for (int i = 2;i<17;i++)
		{
			ComboBox3.addItem(i);
		}
		ComboBox3.setSelectedItem(10);
		
		ComboBox4 = new JComboBox();
		ComboBox4.setLocation(710, 60);
		ComboBox4.setSize(60, 30);
		ComboBox4.setFont(new Font("Arial",10,20));
		for (int i = 2;i<17;i++)
		{
			ComboBox4.addItem(i);
		}
		ComboBox4.setSelectedItem(10);
		
		ltextbox1 = new JLabel();
		ltextbox1.setLocation(10, 0);
		ltextbox1.setSize(200, 30);
		ltextbox1.setFont(new Font("Arial",10,20));
		ltextbox1.setText("Первый операнд");
		ltextbox2 = new JLabel();
		ltextbox2.setLocation(300, 0);
		ltextbox2.setSize(200, 30);
		ltextbox2.setFont(new Font("Arial",10,20));
		ltextbox2.setText("Второй операнд");
		ltextbox3 = new JLabel();
		ltextbox3.setLocation(570, 0);
		ltextbox3.setSize(200, 30);
		ltextbox3.setFont(new Font("Arial",10,20));
		ltextbox3.setText("Ответ");
		
		lcombobox1 = new JLabel();
		lcombobox1.setLocation(210, 0);
		lcombobox1.setSize(90, 30);
		lcombobox1.setFont(new Font("Arial",10,10));
		lcombobox1.setText("Выбор операции");
		
		lcombobox2 = new JLabel();
		lcombobox2.setLocation(10, 60);
		lcombobox2.setSize(140, 30);
		lcombobox2.setFont(new Font("Arial",10,10));
		lcombobox2.setText("Выбор системы счисления");
		
		lcombobox3 = new JLabel();
		lcombobox3.setLocation(300, 60);
		lcombobox3.setSize(140, 30);
		lcombobox3.setFont(new Font("Arial",10,10));
		lcombobox3.setText("Выбор системы счисления");
		
		lcombobox4 = new JLabel();
		lcombobox4.setLocation(570, 60);
		lcombobox4.setSize(140, 30);
		lcombobox4.setFont(new Font("Arial",10,10));
		lcombobox4.setText("Выбор системы счисления");
		
		this.add(Button1);
		this.add(TextInput1);
		this.add(TextInput2);
		this.add(TextInput3);
		this.add(ltextbox1);
		this.add(ltextbox2);
		this.add(ltextbox3);
		this.add(lcombobox1);
		this.add(lcombobox2);
		this.add(lcombobox3);
		this.add(lcombobox4);
		this.add(ComboBox1);
		this.add(ComboBox2);
		this.add(ComboBox3);
		this.add(ComboBox4);
		textOperation = ComboBox1.getSelectedItem().toString();
	}

	private void ComboBox1ActionPerformed(ActionEvent evt) {     
		if(ComboBox1.getSelectedIndex() >= 4)
		{
			TextInput2.setText("");
	        TextInput2.setEditable(false);
		}
		else
		{
			TextInput2.setEditable(true);
		}
		textOperation = ComboBox1.getSelectedItem().toString();
		//TextInput3.setText(textOperation);
    }
	
	public double calcOperation(double op1,double op2)
	{
		double output = 0.0;
		if(textOperation == "sqrt")
		{		
			if(op1>0)
			output = Math.sqrt(op1);	
			else
				JOptionPane.showMessageDialog(this, "Нельзя вычислить корень при отрицательном числе");
		}		
		if(textOperation == "/")
		{
			output = op1/op2;
			Math.round(output);
		}
		if(textOperation == "*")
		{
			output = op1*op2;
		}
		if(textOperation == "-")
		{
			output = op1-op2;
		}
		if(textOperation == "+")
		{
			output = op1+op2;
		}
		
		return Double.parseDouble(String.format( Locale.US, "%.9f", output)) ;
	}
	
    String text1 = "";
    String text2 = "";
    String textOperation = "";
    int sys1 = 0;
    int sys2 = 0;
    int sys3 = 0;
	
	private void Button1_Click(ActionEvent evt) {
		text1 = TextInput1.getText();
		text2 = TextInput2.getText();
		sys1 = Integer.parseInt(ComboBox2.getSelectedItem().toString());
		sys2 = Integer.parseInt(ComboBox3.getSelectedItem().toString());
		sys3 = Integer.parseInt(ComboBox4.getSelectedItem().toString());
		if(check(text1,sys1)) {
			if(TextInput2.isEditable())
			{
				if(check(text2,sys2))
				{					
					String kek = calcOperation(ReturnDouble(text1,sys1),ReturnDouble(text2,sys2))+"";				
					String[] kek1 = kek.split("\\.");
					String output = translate(Integer.parseInt(kek1[0]),sys3)+"."+translate(Integer.parseInt(kek1[1]),sys3);
					TextInput3.setText(output);
				} 
				else
				{
					JOptionPane.showMessageDialog(this, "Ошибка проверьте правильность 2 операнда");
				}
			}
			else
			{					
				String kek = calcOperation(ReturnDouble(text1,sys1),0)+"";				
				String[] kek1 = kek.split("\\.");
				String output = translate(Integer.parseInt(kek1[0]),sys3)+"."+translate(Integer.parseInt(kek1[1]),sys3);
				TextInput3.setText(output);
			}
		} else
		{
			JOptionPane.showMessageDialog(this, "Ошибка проверьте правильность 1 операнда");
		}
		
	}	
	
	public double ReturnDouble(String text,int sys)
	{
		double output = 0.0;
		Pattern p = Pattern.compile(".+\\..+");
		Matcher m = p.matcher(text);		
		if(m.matches()) {
			String[] doubleText = text.split("\\.");
			double number1 = Double.parseDouble(Integer.parseInt(doubleText[0], sys)+"");
			double number2 = Double.parseDouble(Integer.parseInt(doubleText[1], sys)+"");
			for(;;)
			{
				if(number2>1)
				{
					number2/=10;
				}
				else
					break;
			}	
			if(number1 > 0) {
			output = number1+number2;
			}
			else
			{
				output = -1*(Math.abs(number1)+number2);
			}
		}else
		{
			output = Double.parseDouble(Integer.parseInt(text, sys)+"");			
		}
		return output;
	}
	
	public String translateSwitch(int kek)
	{
		String output = "";
		switch(kek)
		{
			case 10: 
				output ="A";
				break;
			case 11: 
				output ="B";
				break;
			case 12: 
				output ="C";
				break;
			case 13: 
				output ="D";
				break;
			case 14: 
				output ="E";
				break;
			case 15: 
				output ="F";
				break;
			default: 
				output = "";
			    break;		
		}
		return output;
	}
	
	public String translate(int out,int sys) {
		String output = "";
		boolean mines = false;
		if(out<0)
		{
			mines = true;
			out*=-1;
		}
		for(;;)
		{
			if(out<sys)
			{
				if(out<10)
				{
					output+=out+"";
				}
				else
				{
					output+=translateSwitch(out);
				}
				break;
			}
			if(out%sys<10)
			{
				output+=out%sys+"";
			}
			else
			{
				output+=translateSwitch(out%sys);
			}
			out = out/sys;
			
		}
		char[] outputchar = output.toCharArray();
		output = "";
		if(mines)
			output+="-";
		for(int i = outputchar.length-1;i>=0;i--)
		{
			output+=outputchar[i];
		}
		return output;
	}
	
	public boolean check(String ch, int system) {
		String pat = "-?([0-";		
		switch(system) {
	    case 2: 
		    pat+="1](\\.[0-1])?)+";
			break;
		case 3: 
			pat+="2](\\.[0-2])?)+";
			break;
		case 4: 
			pat+="3](\\.[0-3])?)+";
			break;
		case 5: 
			pat+="4](\\.[0-4])?)+";
			break;
		case 6: 
			pat+="5](\\.[0-5])?)+";
			break;
		case 7: 
			pat+="6](\\.[0-6])?)+";
			break;
		case 8: 
			pat+="7](\\.[0-7])?)+";
			break;
		case 9: 
			pat+="8](\\.[0-8])?)+";
			break;
		case 10: 
			pat+="9](\\.[0-9])?)+";
			break;
		case 11: 
			pat+="9A](\\.[0-9A])?)+";
			break;
		case 12: 
			pat+="9AB](\\.[0-9AB])?)+";
			break;
		case 13: 
			pat+="9A-C](\\.[0-9A-C])?)+";
			break;
		case 14: 
			pat+="9A-D](\\.[0-9A-D])?)+";
			break;
		case 15: 
			pat+="9A-E](\\.[0-9A-E])?)+";
			break;
		case 16: 
			pat+="9A-F](\\.[0-9A-F])?)+";
			break;
		default: 
		    pat = "";
		    break;		
		}
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(ch);		
		return m.matches();
	}
}
