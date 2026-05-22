import javax.swing.JOptionPane;

public class EquationSolver {

    public static void main(String[] args) {
        String menu = "--- EQUATION SOLVER ---\n"
                + "1. Solve first-degree equation (ax + b = 0)\n"
                + "2. Solve system of first-degree equations\n"
                + "3. Solve second-degree equation (ax^2 + bx + c = 0)\n"
                + "0. Exit\n"
                + "Please enter your choice (0, 1, 2, or 3):";

        while (true) {
            // Hiện hộp thoại Menu
            String choiceStr = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.QUESTION_MESSAGE);

            // Nếu người dùng bấm Cancel hoặc nhập 0 thì thoát chương trình
            if (choiceStr == null || choiceStr.equals("0")) {
                break;
            }

            int choice = Integer.parseInt(choiceStr);

            if (choice == 1) {
                solveLinearEquation();
            } else if (choice == 2) {
                solveLinearSystem();
            } else if (choice == 3) {
                solveQuadraticEquation();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        System.exit(0);
    }

    // 1. Giải phương trình bậc nhất
    private static void solveLinearEquation() {
        String strA = JOptionPane.showInputDialog("Equation: ax + b = 0\nEnter a:");
        String strB = JOptionPane.showInputDialog("Equation: ax + b = 0\nEnter b:");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        String result;

        if (a == 0) {
            if (b == 0) {
                result = "The equation has infinitely many solutions.";
            } else {
                result = "The equation has no solution.";
            }
        } else {
            double x = -b / a;
            result = "The root is: x = " + x;
        }

        JOptionPane.showMessageDialog(null, result, "Linear Equation Result", JOptionPane.INFORMATION_MESSAGE);
    }

    // 2. Giải hệ phương trình bậc nhất
    private static void solveLinearSystem() {
        String strA11 = JOptionPane.showInputDialog("System of equations:\na11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2\n\nEnter a11:");
        String strA12 = JOptionPane.showInputDialog("Enter a12:");
        String strB1  = JOptionPane.showInputDialog("Enter b1:");
        String strA21 = JOptionPane.showInputDialog("Enter a21:");
        String strA22 = JOptionPane.showInputDialog("Enter a22:");
        String strB2  = JOptionPane.showInputDialog("Enter b2:");

        double a11 = Double.parseDouble(strA11); double a12 = Double.parseDouble(strA12); double b1 = Double.parseDouble(strB1);
        double a21 = Double.parseDouble(strA21); double a22 = Double.parseDouble(strA22); double b2 = Double.parseDouble(strB2);

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        String result;
        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            result = "The system has a unique solution:\nx1 = " + x1 + "\nx2 = " + x2;
        } else {
            if (D1 == 0 && D2 == 0) {
                result = "The system has infinitely many solutions.";
            } else {
                result = "The system has no solution.";
            }
        }

        JOptionPane.showMessageDialog(null, result, "Linear System Result", JOptionPane.INFORMATION_MESSAGE);
    }

    // 3. Giải phương trình bậc hai
    private static void solveQuadraticEquation() {
        String strA = JOptionPane.showInputDialog("Equation: ax^2 + bx + c = 0\nEnter a:");
        String strB = JOptionPane.showInputDialog("Equation: ax^2 + bx + c = 0\nEnter b:");
        String strC = JOptionPane.showInputDialog("Equation: ax^2 + bx + c = 0\nEnter c:");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double c = Double.parseDouble(strC);
        String result;

        if (a == 0) {
            if (b == 0) {
                result = (c == 0) ? "The equation has infinitely many solutions." : "The equation has no solution.";
            } else {
                result = "a = 0, solved as linear equation bx + c = 0.\nx = " + (-c / b);
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                result = "The equation has no real root.";
            } else if (delta == 0) {
                result = "The equation has a double root: x = " + (-b / (2 * a));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "The equation has two distinct real roots:\nx1 = " + x1 + "\nx2 = " + x2;
            }
        }

        JOptionPane.showMessageDialog(null, result, "Quadratic Equation Result", JOptionPane.INFORMATION_MESSAGE);
    }
}