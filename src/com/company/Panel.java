package com.company;

        import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.io.*;
        import java.util.Scanner;

public class Panel extends JPanel implements ActionListener {

    public JTextArea field_base = new JTextArea();
    private JButton b_add = new JButton("Add");
    private JButton b_search = new JButton("Search");
    private JButton b_delete = new JButton("Delete");
    private JButton b_list = new JButton("List");
    private JButton b_ok = new JButton("OK");



    private File file = new File("File1.txt");
    private File file1 = new File("File2.txt");




    private JLabel label1 = new JLabel("input name");
    private JTextField field1 = new JTextField();

    private JLabel label2 = new JLabel("input phone");
    private JTextField field2 = new JTextField();

    private JLabel label3 = new JLabel("input M_or_D");
    private JTextField field3 = new JTextField();

    private JLabel label4 = new JLabel("input email");
    private JTextField field4 = new JTextField();

    public Panel(){
        Add_TextField();
        Add_Button();
        Event();
        Label();
    }



    private void Add_TextField()
    {
        field_base.setBounds(10,10,390,150);        //390,200
        add(field_base);

        field1.setBounds(100,165,200,15);
        add(field1);

        field2.setBounds(100,190,200,15);
        add(field2);

        field3.setBounds(100,215,200,15);
        add(field3);

        field4.setBounds(100,240,200,15);
        add(field4);

        setLayout(null);
    }
    private void Add_Button()
    {
        b_add.setBounds(410,12,70,50);
        add(b_add);
        b_search.setBounds(410,74,70,50);
        add(b_search);
        b_delete.setBounds(410,136,70,50);
        add(b_delete);
        b_list.setBounds(410,198,70,50);
        add(b_list);

        b_ok.setBounds(320,190,60,60);
        add(b_ok);


    }
    private void Event()
    {
        b_add.addActionListener(this);
        b_list.addActionListener(this);
        b_search.addActionListener(this);
        b_delete.addActionListener(this);
        b_ok.addActionListener(this);
    }

    private void Label() {
        label1.setBounds(10,165,100,15);
        add(label1);

        label2.setBounds(10,190,100,15);
        add(label2);

        label3.setBounds(10,215,100,15);
        add(label3);

        label4.setBounds(10,240,100,15);
        add(label4);
    }



    private void Add_men()
    {

        //BufferedReader br = null;                   // объект класса
        try {//исключение
            if (file.exists())  {                    // условие для проверки: если файл не сущ, то создаем файл.
                file.createNewFile();}

            FileWriter writer = new FileWriter(file,true);
            Scanner w = new Scanner(System.in);
            /*field1.setText("Name :" );
            System.out.print("Name :" ); String name = w.nextLine();
            System.out.print("Phone: "); String phone = w.nextLine();
            System.out.print("M_or_D: "); String m_or_d = w.nextLine();
            System.out.print("Email: "); String email = w.nextLine();*/


            /*while (field1.getText().length()==0)
            {
                field_base.setText("Input info");
            }*/

            writer.write(field1.getText()+" "+field2.getText()+" "+field3.getText()+" "+field4.getText()+"\n");

            field_base.setText("Add rows");
            writer.close();
            //br.close();

        } catch (IOException e) {                   // если не удастся создать файл, то будет выдаваться исключчение
            System.out.println("Error: " + e);
        }

    }

    private void List_read() {
        //BufferedReader br = null;                   // объект класса
        try(FileReader reader = new FileReader("File1.txt")) {
            //br = new BufferedReader(new FileReader("File_spravochnik.txt"));


            /*String str1 ="";
            int n = br.readLine().length();
            while(br.readLine().length()>0){
                field1.setText(br.readLine());
                n--;
            }*/
            int c;
            String str1="";
            while((c=reader.read())!=-1){

                str1+=(char)c;
                field_base.setText(str1);

            }

            //field1.setText(s);


        } catch (IOException e) {                   // если не удастся создать файл, то будет выдаваться исключчение
            System.out.println("Error: " + e);
        }
        /*finally {                                   // блок для br
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }*/
    }



    private void Search() {
        BufferedReader br = null;                   // объект класса
        try (Scanner w = new Scanner(System.in)){
            br = new BufferedReader(new FileReader("File1.txt"));


            /*System.out.print("Введите имя:" ); String name = w.nextLine();*/
            String str1 ="";
            while((str1 = br.readLine())!=null){
                boolean start = str1.startsWith(field1.getText());
                if(start){
                    field_base.setText(str1+"");
                }
            }

        } catch (IOException e) {                   // если не удастся создать файл, то будет выдаваться исключчение
            System.out.println("Error: " + e);
        }
        /*finally {                                   // блок для br
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }*/
    }


    public void Delete()
    {
        //BufferedReader br = null;                   // объект класса
        try (Scanner w = new Scanner(System.in)){
            // br = new BufferedReader(new FileReader("File1.txt"));

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
            //System.out.print("Введите имя:" ); String name = w.nextLine();
            String str1 ="",str2="";
            while((str1 = reader.readLine())!=null){
                boolean start = str1.startsWith(field1.getText());
                if(start){
                    field_base.setText(str1+"");
                }
                if(!start){
                    writer.write(str1);
                    writer.newLine();
                }
            }
            str2=field_base.getText();
            field_base.setText(str2+ " --> Delete rows");
            reader.close();
            writer.close();
            file.delete();
            file1.renameTo(file);
        } catch (IOException e) {                   // если не удастся создать файл, то будет выдаваться исключчение
            System.out.println("Error: " + e);
        }



        /*try (Scanner w = new Scanner(System.in)){

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
            String line=null;
            System.out.print("Введите имя:" ); String name = w.nextLine();
            while ((line = reader.readLine()) != null) {
                boolean start = line.startsWith(name);
                if (!start) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
            file.delete();
            file1.renameTo(file);


        } catch (IOException e) {                   // если не удастся создать файл, то будет выдаваться исключчение
            System.out.println("Error: " + e);
        }

*/

    }

    private boolean flag = false;

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b_ok) {
            field_base.setText("");
            field1.setText("");
            field2.setText("");
            field3.setText("");
            field4.setText("");

        }
        if(e.getSource()==b_add) {
            Add_men();
        }
        if(e.getSource()==b_list){
            List_read();
        }
        if(e.getSource()==b_search){
            Search();
        }
        if(e.getSource()==b_delete){
            Delete();
        }


    }
}


