package china;

import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class Competitor {
    ChessMainFrame a_Chess;
    MouseEvent ME;

    private Competitor() {
    }


    private static class Instance {
        private static final Competitor c = new Competitor();
    }

    public void setA_Chess(ChessMainFrame a_Chess) {
        this.a_Chess = a_Chess;
    }

    public static Competitor getInstance() {
        return Instance.c;
    }

    public void run(Iterator<String> istr) {
        // ServerSocket s = null;
        // try {
        //     s = new ServerSocket(9001);
        // } catch (IOException ex1) {
        // }
        //-------------------------------------------------
        // while (true) {
        //     Socket socket = null;
        try {
            // socket = s.accept(); //��������ʼ����9000�˿�
            // BufferedReader in = new BufferedReader(new InputStreamReader(
            //         socket.getInputStream()));
            // PrintWriter out = new PrintWriter(new BufferedWriter(new
            //         OutputStreamWriter(socket.getOutputStream())), true);
            //
            // out.println("<Connection>");
            // if (in.readLine().equals("<Connection>")) {
            //     JOptionPane.showMessageDialog(null,
            //             socket.getInetAddress(),
            //             "�Ѿ����ӵ��ļ����Ϊ��",
            //             JOptionPane.
            //                     INFORMATION_MESSAGE);
            // }
            while (true) {
                String strMove = istr.next();
                String strTemp = istr.next();
                if (strMove.equals("<move>")) { //�ƶ�����
                    int Ex = Integer.valueOf(istr.next());
                    int Ey = Integer.valueOf(istr.next());
                    int Man = Integer.valueOf(istr.next());
                    System.out.println("<move>:" + strTemp + "," + Ex + "," + Ey + "," + Man);
                    ME = new MouseEvent(this.a_Chess, 500,
                            System.currentTimeMillis(), 16, Ex,
                            Ey, 1, false, 1);
                    if (strTemp == null) {
                        continue;
                    }
                    if (strTemp.equals("<Over>")) {
                        break;
                    } else if (strTemp.equals("<Red>")) {
//                        int Ex = Integer.valueOf(in.readLine()).intValue();
//                        int Ey = Integer.valueOf(in.readLine()).intValue();

                        //�����߳�
                        if (a_Chess.tmain == null) {
                            a_Chess.tmain = new Thread(a_Chess);
                            a_Chess.tmain.start();
                        }

                        //�ƶ��䡢��
                        if (Man > 15 && Man < 26) {
                            a_Chess.rule.armsRule(Man, a_Chess.play[Man],
                                    ME);
                        }

                        //�ƶ���
                        else if (Man > 25 && Man < 30) {
                            a_Chess.rule.cannonRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ���
                        else if (Man >= 0 && Man < 4) {
                            a_Chess.rule.cannonRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ���
                        else if (Man > 3 && Man < 8) {
                            a_Chess.rule.horseRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ��ࡢ��
                        else if (Man > 7 && Man < 12) {
                            a_Chess.rule.elephantRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ��ˡ�ʿ
                        else if (Man > 11 && Man < 16) {
                            a_Chess.rule.chapRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ�����˧
                        else if (Man == 30 || Man == 31) {
                            a_Chess.rule.willRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�Ƿ��������(�Ƿ���ԭ��û�ж�)
                        if (Ex == a_Chess.play[Man].getX() &&
                                Ey == a_Chess.play[Man].getY()) {
                            a_Chess.text.setText("               ��������");
                            a_Chess.chessPlayClick = 2;
                        } else {
                            a_Chess.text.setText("               ��������");
                            a_Chess.chessPlayClick = 1;
                        }
                    } else if (strTemp.equals("<Black>")) {
                        //�ƶ��䡢��
                        if (Man > 15 && Man < 26) {
                            a_Chess.rule.armsRule(Man, a_Chess.play[Man],
                                    ME);
                        }

                        //�ƶ���
                        else if (Man > 25 && Man < 30) {
                            a_Chess.rule.cannonRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ���
                        else if (Man >= 0 && Man < 4) {
                            a_Chess.rule.cannonRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ���
                        else if (Man > 3 && Man < 8) {
                            a_Chess.rule.horseRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ��ࡢ��
                        else if (Man > 7 && Man < 12) {
                            a_Chess.rule.elephantRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ��ˡ�ʿ
                        else if (Man > 11 && Man < 16) {
                            a_Chess.rule.chapRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�ƶ�����˧
                        else if (Man == 30 || Man == 31) {
                            a_Chess.rule.willRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //�Ƿ��������(�Ƿ���ԭ��û�ж�)
                        if (Ex == a_Chess.play[Man].getX() &&
                                Ey == a_Chess.play[Man].getY()) {
                            a_Chess.text.setText("               ��������");
                            a_Chess.chessPlayClick = 1;
                        } else {
                            a_Chess.text.setText("               ��������");
                            a_Chess.chessPlayClick = 2;
                        }
                    } //else black
                } else { //����
                    int Ex = 0, Ey = 0, Man = 0, i = 0;
                    String strEx = "", strEy = "", strI = "", strClick = "",
                            strMan = "";
                    //�ڶ��ε�������(������)
                    if (!Boolean.valueOf(strTemp)) {
                        this.a_Chess.Man = Integer.valueOf(istr.next());
                        //��ʼ��˸
                        a_Chess.chessManClick = true;
                    } else {

                        //��ǰû�в���(ֹͣ��˸)
                        strEx = istr.next();
                        strEy = istr.next();
                        strI = istr.next();
                        strClick = istr.next();
                        strMan = istr.next();

                        System.out.println(strEx + "," + strEy + "," +
                                strI + "," + strClick + "," +
                                strMan);
                        if (strEx.equals("<eat>") || strEx.equals("<move>")) continue;

                        i = Integer.valueOf(strI);
                        Man = Integer.valueOf(strMan);
                        int chessPlayClick = Integer.valueOf(strClick);
                        Ex = Integer.valueOf(strEx);
                        Ey = Integer.valueOf(strEy);
                        ME = new MouseEvent(this.a_Chess, 500,
                                System.currentTimeMillis(),
                                16,
                                Ex,
                                Ey, 1, false, 1);
                        //��ǰû�в���(ֹͣ��˸)
                        a_Chess.chessManClick = false;

                        //�ú�������ʱ��
                        if (chessPlayClick == 2 &&
                                a_Chess.play[Man].getName().charAt(1) == '2') {
                            Ex = a_Chess.play[Man].getX();
                            Ey = a_Chess.play[Man].getY();

                            //�䡢���Թ���
                            if (Man > 15 && Man < 26) {
                                a_Chess.rule.armsRule(a_Chess.play[Man],
                                        a_Chess.play[i]);
                            }

                            //�ڳԹ���
                            else if (Man > 25 && Man < 30) {
                                a_Chess.rule.cannonRule(0,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play, ME);
                            }

                            //���Թ���
                            else if (Man >= 0 && Man < 4) {
                                a_Chess.rule.cannonRule(1,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play, ME);
                            }

                            //��Թ���
                            else if (Man > 3 && Man < 8) {
                                a_Chess.rule.horseRule(a_Chess.play[Man],
                                        a_Chess.play[i],
                                        a_Chess.play, ME);
                            }

                            //�ࡢ��Թ���
                            else if (Man > 7 && Man < 12) {
                                a_Chess.rule.elephantRule(a_Chess.play[
                                                Man], a_Chess.play[i],
                                        a_Chess.play);
                            }

                            //ʿ���˳������
                            else if (Man > 11 && Man < 16) {
                                a_Chess.rule.chapRule(Man,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play);
                            }

                            //����˧�������
                            else if (Man == 30 || Man == 31) {
                                a_Chess.rule.willRule(Man,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play);
                                a_Chess.play[Man].setVisible(true);
                            }

                            //�Ƿ��������(�Ƿ���ԭ��û�ж�)
                            if (Ex == a_Chess.play[Man].getX() &&
                                    Ey == a_Chess.play[Man].getY()) {
                                a_Chess.text.setText(
                                        "               ��������");
                                a_Chess.chessPlayClick = 2;
                            } else {
                                a_Chess.text.setText(
                                        "               ��������");
                                a_Chess.chessPlayClick = 1;
                            }

                        } //if

                        //�ú�������ʱ��
                        else if (chessPlayClick == 1 &&
                                a_Chess.play[Man].getName().charAt(1) ==
                                        '1') {
                            Ex = a_Chess.play[Man].getX();
                            Ey = a_Chess.play[Man].getY();

                            //��Թ���
                            if (Man > 15 && Man < 26) {
                                a_Chess.rule.armsRule(a_Chess.play[Man],
                                        a_Chess.play[i]);
                            }

                            //�ڳԹ���
                            else if (Man > 25 && Man < 30) {
                                a_Chess.rule.cannonRule(0,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play, ME);
                            }

                            //���Թ���
                            else if (Man >= 0 && Man < 4) {
                                a_Chess.rule.cannonRule(1,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play, ME);
                            }

                            //��Թ���
                            else if (Man > 3 && Man < 8) {
                                a_Chess.rule.horseRule(a_Chess.play[Man],
                                        a_Chess.play[i],
                                        a_Chess.play, ME);
                            }

                            //�ࡢ��Թ���
                            else if (Man > 7 && Man < 12) {
                                a_Chess.rule.elephantRule(a_Chess.play[
                                                Man], a_Chess.play[i],
                                        a_Chess.play);
                            }

                            //ʿ���˳������
                            else if (Man > 11 && Man < 16) {
                                a_Chess.rule.chapRule(Man,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play);
                            }

                            //����˧�������
                            else if (Man == 30 || Man == 31) {
                                a_Chess.rule.willRule(Man,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play);
                                a_Chess.play[Man].setVisible(true);
                            }

                            //�Ƿ��������(�Ƿ���ԭ��û�ж�)
                            if (Ex == a_Chess.play[Man].getX() &&
                                    Ey == a_Chess.play[Man].getY()) {
                                a_Chess.text.setText(
                                        "               ��������");
                                a_Chess.chessPlayClick = 1;
                            } else {
                                a_Chess.text.setText(
                                        "               ��������");
                                a_Chess.chessPlayClick = 2;
                            }

                        } //else if

                        //�Ƿ�ʤ��
                        if (!a_Chess.play[31].isVisible()) {
                            JOptionPane.showConfirmDialog(
                                    this.a_Chess, "����ʤ��", "���һʤ��",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE);
                            //˫������������������
                            a_Chess.chessPlayClick = 3;
                            a_Chess.text.setText("  ����ʤ��");

                        } //if

                        else if (!a_Chess.play[30].isVisible()) {
                            JOptionPane.showConfirmDialog(
                                    this.a_Chess, "����ʤ��", "��Ҷ�ʤ��",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE);
                            a_Chess.chessPlayClick = 3;
                            a_Chess.text.setText("  ����ʤ��");
                        } //else if
                    }
                }
            } //while
            // socket.close();
        } catch (NullPointerException ex1) {
            ex1.printStackTrace();
            JOptionPane.showMessageDialog(null, "�ڱ�ϵͳ���Ѿ������˱����������������!");
            System.exit(0);
        } catch (Exception ex2) {
        }
    } //while(true){
}

