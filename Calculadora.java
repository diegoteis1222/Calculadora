package Personal.Calculadora;

//Todo esto es copiado de un tutorial de youtube, no es mio

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//TODO ver que hace implements ActionListener
public class Calculadora implements ActionListener {

    JFrame frame; //Ventana
    JTextField textField; 
    JButton[] numberButtons = new JButton[10]; //Cantidad de botones para numeros
    JButton[] functionButtons = new JButton[9]; //Cantidad de botones para funciones

    //Botones
    JButton addButton, subButton, mulButton, divButton; 
    JButton decButton, equButton, delButton, clrButton, negButton;

    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculadora(){

        frame = new JFrame("Calculadora"); //Titulo de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que se cierre la ventana
        frame.setSize(420, 550); //Tamaño de la ventana
        frame.setLayout(null); //Para que no se pongan los botones en orden

        textField = new JTextField(); //Para que se vea el texto
        textField.setBounds(50, 25, 300, 50); //Posicion y tamaño del texto
        textField.setFont(myFont); //Fuente del texto
        textField.setEditable(false); //Para que no se pueda editar el texto

        //Creaciond e los botones
        addButton = new JButton("+"); //Boton de suma
        subButton = new JButton("-"); //Boton de resta
        mulButton = new JButton("*"); //Boton de multiplicacion
        divButton = new JButton("/"); //Boton de division
        decButton = new JButton("."); //Boton de punto
        equButton = new JButton("="); //Boton de igual
        delButton = new JButton("Delete"); //Boton de borrar
        clrButton = new JButton("Clear"); //Boton de limpiar
        negButton = new JButton("(-)"); //Boton de negativo

        //Dar a los botones su funcion
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        //TODO ver que hace esto
        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this); //ActionListener se usa para detectar y manejar eventos
            functionButtons[i].setFont(myFont); //Fuente de los botones
            functionButtons[i].setFocusable(false); //Para que no se pueda seleccionar el boton
        }

        //TODO ver que hace esto
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); //Para que se vea el numero
            numberButtons[i].addActionListener(this); //ActionListener se usa para detectar y manejar eventos
            numberButtons[i].setFont(myFont); //Fuente de los botones
            numberButtons[i].setFocusable(false); //Para que no se pueda seleccionar el boton
        }

        negButton.setBounds(50, 430, 145, 50);
        delButton.setBounds(50, 430, 145, 50); 
        clrButton.setBounds(205, 430, 145, 50); 

        //Crea el panel
        panel = new JPanel(); 
        panel.setBounds(50, 100, 300, 300);  //dimensiones del panel
        panel.setLayout(new GridLayout(4,4,10,10)); //Cuantas columnas, filas y espacio entre botones
        // panel.setBackground(Color.gray); //Color del fondo panel

        //Fila de botones 1
        panel.add(numberButtons[1]); 
        panel.add(numberButtons[2]); 
        panel.add(numberButtons[3]); 
        panel.add(addButton); 

        //Fila de botones 2
        panel.add(numberButtons[4]); 
        panel.add(numberButtons[5]); 
        panel.add(numberButtons[6]); 
        panel.add(subButton); 

        //Fila de botones 3
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        //Fila de botones 4
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        //Añade el panel a la ventana
        frame.add(panel); 

        //Añade los botones a la ventana
        frame.add(delButton); 
        frame.add(clrButton);

        frame.add(textField); //Añade el texto a la ventana
        frame.setVisible(true); //Para que se vea la ventana
    }
    public static void main(String[] args) {
        
        Calculadora calc = new Calculadora();

    }


    //Se encarga de ver cuando alguien clicka en un boton
    @Override
    public void actionPerformed(ActionEvent e) {

        //TODO ver como funciona todo esto

        //e.getSource() nos devuelve que boton se ha clickado
        //textField.getText() escribe en pantalla lo que se ha clickado
        
        //Añade a la zona de texto el boton que se ah clickado
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) { //Si el boton que se ha clickado es igual a la posicion i del array
                textField.setText(textField.getText().concat(String.valueOf(i))); //Añade el numero a la zona de texto
            }
        }

        //Añade el punto decimal
        if(e.getSource() == decButton) { //Si el boton que se ha clickado es igual al boton de punto
            textField.setText(textField.getText().concat(".")); //Añade el punto a la zona de texto
        }

        //Añade la suma
        if(e.getSource() == addButton) { //Si el boton que se ha clickado es igual al boton de suma
            num1 = Double.parseDouble(textField.getText()); //Da a num1 el valor de lo que haya en la zona de texto conviertiendolo a double
            operator = '+'; //Da a operator el valor de suma
            textField.setText(""); //Limpia el texto
        }

        //Añade la resta
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-'; 
            textField.setText(""); 
        }

        //Añade la multiplicacion
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        //Añade la division
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        //Para selecionar la operacion que queramos realizar
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result)); //Muestra el resultado
            num1 = result; //Guarda el resultado en num1 por si queremos seguir operando
        }

        if(e.getSource() == clrButton) { //Si el boton que se ha clickado es igual al boton de limpiar
            textField.setText(""); //Limpia el texto
        }

        if(e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) { 
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        
    }
}//Fin class