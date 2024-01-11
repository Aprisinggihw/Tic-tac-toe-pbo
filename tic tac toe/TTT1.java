import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TTT1 extends JFrame implements ItemListener, ActionListener {
  int i, j, ii, jj, x, y, yesnull;
  int a[][] = { { 10, 1, 2, 3, 11 }, { 10, 1, 4, 7, 11 }, { 10, 1, 5, 9, 11 }, { 10, 2, 5, 8, 11 },
      { 10, 3, 5, 7, 11 }, { 10, 3, 6, 9, 11 }, { 10, 4, 5, 6, 11 }, { 10, 7, 8, 9, 11 } };
  int a1[][] = { { 10, 1, 2, 3, 11 }, { 10, 1, 4, 7, 11 }, { 10, 1, 5, 9, 11 }, { 10, 2, 5, 8, 11 },
      { 10, 3, 5, 7, 11 }, { 10, 3, 6, 9, 11 }, { 10, 4, 5, 6, 11 }, { 10, 7, 8, 9, 11 } };

  boolean state, type, set;

  Icon ic1, ic2, icon, ic11, ic22;
  JLabel judulGame;
  Checkbox c1, c2;
  JLabel l1, l2;
  JButton b[] = new JButton[9];
  JButton reset;
  String namePlayer1, namePlayer2;
  JLabel showNamePlayer;

  public void namePlayer() {
    if (type == true) {
      namePlayer1 = JOptionPane.showInputDialog("Masukan Nama Player 1:");
      namePlayer2 = JOptionPane.showInputDialog("Masukan Nama Player 2:");
    } else if (type == false) {
      namePlayer1 = JOptionPane.showInputDialog("Masukan Nama:");
    }
    repaint(0, 0, 345, 600);
    showButton();
  }

  public void showButton() {
    x = 10;
    y = 100;
    j = 0;

    if (type == true) {

      for (i = 0; i <= 8; i++, x += 103, j++) {
        b[i] = new JButton();
        if (j == 3) {
          j = 0;
          y += 103;
          x = 10;
        }
        b[i].setBounds(x, y, 100, 100);
        b[i].setBackground(Color.BLACK);
        add(b[i]);
        b[i].addActionListener(this);
      }

      showNamePlayer = new JLabel("GILIRAN " + namePlayer1 + " MAIN!");
      showNamePlayer.setBounds(110, 10, 450, 100);
      add(showNamePlayer);
      reset = new JButton("RESET");
      reset.setBounds(100, 450, 100, 50);
      reset.setBackground(Color.RED);
      add(reset);
      reset.addActionListener(this);

    } else {

      for (i = 0; i <= 8; i++, x += 103, j++) {
        b[i] = new JButton();
        if (j == 3) {
          j = 0;
          y += 103;
          x = 10;
        }
        b[i].setBounds(x, y, 100, 100);
        b[i].setBackground(Color.BLACK);
        add(b[i]);
        b[i].addActionListener(this);
      } // eof for
      showNamePlayer = new JLabel("GILIRAN " + namePlayer1 + " MAIN!");
      showNamePlayer.setBounds(110, 10, 450, 100);
      add(showNamePlayer);
      reset = new JButton("RESET");
      reset.setBounds(100, 450, 100, 50);
      reset.setBackground(Color.RED);
      add(reset);
      reset.addActionListener(this);
    }

  }

  public void check(int num1) {
    for (ii = 0; ii <= 7; ii++) {
      for (jj = 1; jj <= 3; jj++) {
        if (a[ii][jj] == num1) {
          a[ii][4] = 11;
        }

      }

    }
  }

  public void complogic(int num) {

    for (i = 0; i <= 7; i++) {
      for (j = 1; j <= 3; j++) {
        if (a[i][j] == num) {
          a[i][0] = 11;
          a[i][4] = 10;
        }
      }
    }
    for (i = 0; i <= 7; i++) {
      set = true;
      if (a[i][4] == 10) {
        int count = 0;
        for (j = 1; j <= 3; j++) {
          if (b[(a[i][j] - 1)].getIcon() != null) {
            count++;
          } else {
            yesnull = a[i][j];
          }
        }
        if (count == 2) {
          b[yesnull - 1].setIcon(ic2);
          this.check(yesnull);
          set = false;
          break;
        }
      } else if (a[i][0] == 10) {
        for (j = 1; j <= 3; j++) {
          if (b[(a[i][j] - 1)].getIcon() == null) {
            b[(a[i][j] - 1)].setIcon(ic2);
            this.check(a[i][j]);
            set = false;
            break;
          }
        }
        if (set == false)
          break;
      }

      if (set == false)
        break;
    }

  }

  public void setCheckBox() {
    c1.setBounds(100, 230, 140, 40);
    c2.setBounds(100, 300, 140, 40);
    Font labelFont = new Font("Sans", Font.BOLD, 18);
    c1.setFont(labelFont);
    c2.setFont(labelFont);
    c1.setBackground(Color.RED);
    c2.setBackground(Color.red);
  }

  public void setJudulGame() {
    judulGame.setBounds(40, 100, 260, 60);
    Font labelFont = new Font("Sans", Font.BOLD, 24);
    judulGame.setFont(labelFont);
    judulGame.setBackground(Color.WHITE);
    judulGame.setOpaque(true);
  }

  TTT1() {
    super("TIC TAC TOE BY APRI");

    judulGame = new JLabel("TIC TAC TOE LEGEND");
    setJudulGame();
    add(judulGame);
    CheckboxGroup cbg = new CheckboxGroup();
    c1 = new Checkbox("Vs Computer", cbg, false);
    c2 = new Checkbox("Vs Friend", cbg, false);
    setCheckBox();
    add(c1);
    add(c2);
    c1.addItemListener(this);
    c2.addItemListener(this);

    state = true;
    type = true;
    set = true;
    ic1 = new ImageIcon("c1.jpg");
    ic2 = new ImageIcon("c2.jpg");
    ic11 = new ImageIcon("c11.jpg");
    ic22 = new ImageIcon("c22.jpg");
    getContentPane().setBackground(Color.ORANGE);
    setLayout(null);
    setSize(345, 600);
    setVisible(true);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void itemStateChanged(ItemEvent e) {
    if (c1.getState()) {
      type = false;
    }

    else if (c2.getState()) {
      type = true;
    }
    remove(c1);
    remove(c2);
    remove(judulGame);
    namePlayer();
  }

  public void actionPerformed(ActionEvent e) {

    if (type == true) {
      if (e.getSource() == reset) {
        for (i = 0; i <= 8; i++) {
          showNamePlayer.setText("GILIRAN " + namePlayer1 + " MAIN!");
          b[i].setIcon(null);
        }
      } else {
        for (i = 0; i <= 8; i++) {
          if (e.getSource() == b[i]) {
            if (b[i].getIcon() == null) {
              if (state == true) {
                showNamePlayer.setText("GILIRAN " + namePlayer2 + " MAIN!");
                icon = ic1;
                state = false;
              } else {
                showNamePlayer.setText("GILIRAN " + namePlayer1 + " MAIN!");
                icon = ic2;
                state = true;
              }
              b[i].setIcon(icon);
            }
          }
        }
      }
    } else if (type == false) {
      if (e.getSource() == reset) {
        for (i = 0; i <= 8; i++) {
          showNamePlayer.setText("GILIRAN " + namePlayer1 + " MAIN!");
          b[i].setIcon(null);
        }
        for (i = 0; i <= 7; i++)
          for (j = 0; j <= 4; j++)
            a[i][j] = a1[i][j];
      } else {
        for (i = 0; i <= 8; i++) {
          if (e.getSource() == b[i]) {
            if (b[i].getIcon() == null) {
              showNamePlayer.setText("GILIRAN " + namePlayer1 + " MAIN!");
              b[i].setIcon(ic1);
              if (b[4].getIcon() == null) {
                b[4].setIcon(ic2);
                this.check(5);
              } else {
                this.complogic(i);
              }
            }
          }
        }
      }
    }

    for (i = 0; i <= 7; i++) {

      Icon icon1 = b[(a[i][1] - 1)].getIcon();
      Icon icon2 = b[(a[i][2] - 1)].getIcon();
      Icon icon3 = b[(a[i][3] - 1)].getIcon();
      if ((icon1 == icon2) && (icon2 == icon3) && (icon1 != null)) {
        if (icon1 == ic1) {
          b[(a[i][1] - 1)].setIcon(ic11);
          b[(a[i][2] - 1)].setIcon(ic11);
          b[(a[i][3] - 1)].setIcon(ic11);
          JOptionPane.showMessageDialog(TTT1.this, "!!! " + namePlayer1 + " WON !!! CLICK RESET!!!");
          break;
        } else if (icon1 == ic2) {
          b[(a[i][1] - 1)].setIcon(ic22);
          b[(a[i][2] - 1)].setIcon(ic22);
          b[(a[i][3] - 1)].setIcon(ic22);
          if (type == true) {
            JOptionPane.showMessageDialog(TTT1.this, "!!! " + namePlayer2 + " WON!!! CLICK RESET!!!");
            break;
          }
          JOptionPane.showMessageDialog(TTT1.this, "!!!AWK (COMPUTER) WON!!! CLICK RESET!!!");
          break;
        }
      }
    }

  }

  public static void main(String[] args) {
    new TTT1();
  }
}