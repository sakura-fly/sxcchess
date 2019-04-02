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
            // socket = s.accept(); //服务器开始监听9000端口
            // BufferedReader in = new BufferedReader(new InputStreamReader(
            //         socket.getInputStream()));
            // PrintWriter out = new PrintWriter(new BufferedWriter(new
            //         OutputStreamWriter(socket.getOutputStream())), true);
            //
            // out.println("<Connection>");
            // if (in.readLine().equals("<Connection>")) {
            //     JOptionPane.showMessageDialog(null,
            //             socket.getInetAddress(),
            //             "已经连接到的计算机为：",
            //             JOptionPane.
            //                     INFORMATION_MESSAGE);
            // }
            while (true) {
                String strMove = istr.next();
                String strTemp = istr.next();
                if (strMove.equals("<move>")) { //移动棋子
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

                        //启动线程
                        if (a_Chess.tmain == null) {
                            a_Chess.tmain = new Thread(a_Chess);
                            a_Chess.tmain.start();
                        }

                        //移动卒、兵
                        if (Man > 15 && Man < 26) {
                            a_Chess.rule.armsRule(Man, a_Chess.play[Man],
                                    ME);
                        }

                        //移动炮
                        else if (Man > 25 && Man < 30) {
                            a_Chess.rule.cannonRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动车
                        else if (Man >= 0 && Man < 4) {
                            a_Chess.rule.cannonRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动马
                        else if (Man > 3 && Man < 8) {
                            a_Chess.rule.horseRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动相、象
                        else if (Man > 7 && Man < 12) {
                            a_Chess.rule.elephantRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动仕、士
                        else if (Man > 11 && Man < 16) {
                            a_Chess.rule.chapRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动将、帅
                        else if (Man == 30 || Man == 31) {
                            a_Chess.rule.willRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //是否走棋错误(是否在原地没有动)
                        if (Ex == a_Chess.play[Man].getX() &&
                                Ey == a_Chess.play[Man].getY()) {
                            a_Chess.text.setText("               红棋走棋");
                            a_Chess.chessPlayClick = 2;
                        } else {
                            a_Chess.text.setText("               黑棋走棋");
                            a_Chess.chessPlayClick = 1;
                        }
                    } else if (strTemp.equals("<Black>")) {
                        //移动卒、兵
                        if (Man > 15 && Man < 26) {
                            a_Chess.rule.armsRule(Man, a_Chess.play[Man],
                                    ME);
                        }

                        //移动炮
                        else if (Man > 25 && Man < 30) {
                            a_Chess.rule.cannonRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动车
                        else if (Man >= 0 && Man < 4) {
                            a_Chess.rule.cannonRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动马
                        else if (Man > 3 && Man < 8) {
                            a_Chess.rule.horseRule(a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动相、象
                        else if (Man > 7 && Man < 12) {
                            a_Chess.rule.elephantRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动仕、士
                        else if (Man > 11 && Man < 16) {
                            a_Chess.rule.chapRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //移动将、帅
                        else if (Man == 30 || Man == 31) {
                            a_Chess.rule.willRule(Man, a_Chess.play[Man],
                                    a_Chess.play, ME);
                        }

                        //是否走棋错误(是否在原地没有动)
                        if (Ex == a_Chess.play[Man].getX() &&
                                Ey == a_Chess.play[Man].getY()) {
                            a_Chess.text.setText("               黑棋走棋");
                            a_Chess.chessPlayClick = 1;
                        } else {
                            a_Chess.text.setText("               红棋走棋");
                            a_Chess.chessPlayClick = 2;
                        }
                    } //else black
                } else { //吃子
                    int Ex = 0, Ey = 0, Man = 0, i = 0;
                    String strEx = "", strEy = "", strI = "", strClick = "",
                            strMan = "";
                    //第二次单击棋子(吃棋子)
                    if (!Boolean.valueOf(strTemp)) {
                        this.a_Chess.Man = Integer.valueOf(istr.next());
                        //开始闪烁
                        a_Chess.chessManClick = true;
                    } else {

                        //当前没有操作(停止闪烁)
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
                        //当前没有操作(停止闪烁)
                        a_Chess.chessManClick = false;

                        //该红棋吃棋的时候
                        if (chessPlayClick == 2 &&
                                a_Chess.play[Man].getName().charAt(1) == '2') {
                            Ex = a_Chess.play[Man].getX();
                            Ey = a_Chess.play[Man].getY();

                            //卒、兵吃规则
                            if (Man > 15 && Man < 26) {
                                a_Chess.rule.armsRule(a_Chess.play[Man],
                                        a_Chess.play[i]);
                            }

                            //炮吃规则
                            else if (Man > 25 && Man < 30) {
                                a_Chess.rule.cannonRule(0,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play, ME);
                            }

                            //车吃规则
                            else if (Man >= 0 && Man < 4) {
                                a_Chess.rule.cannonRule(1,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play, ME);
                            }

                            //马吃规则
                            else if (Man > 3 && Man < 8) {
                                a_Chess.rule.horseRule(a_Chess.play[Man],
                                        a_Chess.play[i],
                                        a_Chess.play, ME);
                            }

                            //相、象吃规则
                            else if (Man > 7 && Man < 12) {
                                a_Chess.rule.elephantRule(a_Chess.play[
                                                Man], a_Chess.play[i],
                                        a_Chess.play);
                            }

                            //士、仕吃棋规则
                            else if (Man > 11 && Man < 16) {
                                a_Chess.rule.chapRule(Man,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play);
                            }

                            //将、帅吃棋规则
                            else if (Man == 30 || Man == 31) {
                                a_Chess.rule.willRule(Man,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play);
                                a_Chess.play[Man].setVisible(true);
                            }

                            //是否走棋错误(是否在原地没有动)
                            if (Ex == a_Chess.play[Man].getX() &&
                                    Ey == a_Chess.play[Man].getY()) {
                                a_Chess.text.setText(
                                        "               红棋走棋");
                                a_Chess.chessPlayClick = 2;
                            } else {
                                a_Chess.text.setText(
                                        "               黑棋走棋");
                                a_Chess.chessPlayClick = 1;
                            }

                        } //if

                        //该黑棋吃棋的时候
                        else if (chessPlayClick == 1 &&
                                a_Chess.play[Man].getName().charAt(1) ==
                                        '1') {
                            Ex = a_Chess.play[Man].getX();
                            Ey = a_Chess.play[Man].getY();

                            //卒吃规则
                            if (Man > 15 && Man < 26) {
                                a_Chess.rule.armsRule(a_Chess.play[Man],
                                        a_Chess.play[i]);
                            }

                            //炮吃规则
                            else if (Man > 25 && Man < 30) {
                                a_Chess.rule.cannonRule(0,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play, ME);
                            }

                            //车吃规则
                            else if (Man >= 0 && Man < 4) {
                                a_Chess.rule.cannonRule(1,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play, ME);
                            }

                            //马吃规则
                            else if (Man > 3 && Man < 8) {
                                a_Chess.rule.horseRule(a_Chess.play[Man],
                                        a_Chess.play[i],
                                        a_Chess.play, ME);
                            }

                            //相、象吃规则
                            else if (Man > 7 && Man < 12) {
                                a_Chess.rule.elephantRule(a_Chess.play[
                                                Man], a_Chess.play[i],
                                        a_Chess.play);
                            }

                            //士、仕吃棋规则
                            else if (Man > 11 && Man < 16) {
                                a_Chess.rule.chapRule(Man,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play);
                            }

                            //将、帅吃棋规则
                            else if (Man == 30 || Man == 31) {
                                a_Chess.rule.willRule(Man,
                                        a_Chess.play[Man],
                                        a_Chess.play[i], a_Chess.play);
                                a_Chess.play[Man].setVisible(true);
                            }

                            //是否走棋错误(是否在原地没有动)
                            if (Ex == a_Chess.play[Man].getX() &&
                                    Ey == a_Chess.play[Man].getY()) {
                                a_Chess.text.setText(
                                        "               黑棋走棋");
                                a_Chess.chessPlayClick = 1;
                            } else {
                                a_Chess.text.setText(
                                        "               红棋走棋");
                                a_Chess.chessPlayClick = 2;
                            }

                        } //else if

                        //是否胜利
                        if (!a_Chess.play[31].isVisible()) {
                            JOptionPane.showConfirmDialog(
                                    this.a_Chess, "黑棋胜利", "玩家一胜利",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE);
                            //双方都不可以在走棋了
                            a_Chess.chessPlayClick = 3;
                            a_Chess.text.setText("  黑棋胜利");

                        } //if

                        else if (!a_Chess.play[30].isVisible()) {
                            JOptionPane.showConfirmDialog(
                                    this.a_Chess, "红棋胜利", "玩家二胜利",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE);
                            a_Chess.chessPlayClick = 3;
                            a_Chess.text.setText("  红棋胜利");
                        } //else if
                    }
                }
            } //while
            // socket.close();
        } catch (NullPointerException ex1) {
            ex1.printStackTrace();
            JOptionPane.showMessageDialog(null, "在本系统中已经运行了本软件，不能再启动!");
            System.exit(0);
        } catch (Exception ex2) {
        }
    } //while(true){
}

