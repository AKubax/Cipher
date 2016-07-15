/* Created on the 15 of Июль at 16:31 */

import javax.swing.*;

public class MainClass extends JFrame{
    public static void main(String[] args) {
        String code = cipher("LEHA TOP", "ag28Ha");
        System.out.println(code);
        String uncode = uncipher(code, "ag28Ha");
        System.out.println(uncode);
    }

    private static String cipher(String value, String password){                      //Кодировка
        String res = "";
        boolean plus = password.charAt(0) % 2 == 0;

        for(int i = 0; i < value.length(); i++){
            int c = value.charAt(i);
            for(int p = password.length() - 1; p >= 1; p -= 2){
                c += plus? password.charAt(p) : -password.charAt(p);
                c -= plus? password.charAt(p - 1) : -password.charAt(p - 1);

                char result = (char) c;
                res += result;
            }
        }

        return res;
    }

    private static String uncipher(String value, String password){                   //Откодировка
        String res = "";
        boolean plus = password.charAt(0) % 2 != 0;

        for(int i = 0; i < value.length(); i++){
            int c = value.charAt(i);
            for(int p = password.length() - 1; p >= 1; p -= 2){
                c += plus? password.charAt(p) : -password.charAt(p);
                c -= plus? password.charAt(p - 1) : -password.charAt(p - 1);

                char result = (char) c;
                res += result;
            }
        }

        return res;
    }

    public MainClass(){                                                              //Графика
        super("Cipher");

    }

}
