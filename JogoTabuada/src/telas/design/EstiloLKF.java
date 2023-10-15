package telas.design;

import javax.swing.*;

public final class EstiloLKF {
    public static void mudaLookAndFeel(String lkfName) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (lkfName.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (Exception e) {
            System.err.println("\nLook and Feel error: \n\t" + e.getMessage());
        }

    }
}
