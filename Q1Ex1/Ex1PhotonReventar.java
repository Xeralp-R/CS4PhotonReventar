/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex01.photonreventar;

/**
 *
 * @author PHOTON
 */
public class Ex01PhotonReventar {

    private class Requirement {

        int number;
        String subject; // TODO: change to enum class
        String name;
        boolean is_finished;

        public Requirement(int num, String subj, String nam, boolean is_fin) {
            number = num;
            subject = subj;
            name = nam;
            is_finished = is_fin;
        }

        public void print() {
            System.out.printf("Requirement Number %d\n", this.number);
            System.out.printf("Subject: %s\n", this.subject);
            System.out.printf("Name: %s\n", this.name);
            System.out.printf("Finished? %s\n\n", this.is_finished ? "Yes" : "No");
        }
    }

    // A very unusual workaround?
    public void start() {
        var req1 = new Requirement(1, "Filipino", "FA1", true);
        var req2 = new Requirement(2, "Math", "FA1", false);
        var req3 = new Requirement(3, "CS", "Excersise 01", false);

        req1.print();
        req2.print();
        req3.print();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ex01PhotonReventar thingy = new Ex01PhotonReventar();
        thingy.start();
    }

}
