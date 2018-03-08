import models.Location;
import presenters.GetLocationInfoByLatlngPresenter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private Scanner scanner;

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void init() {
        while (true) {
            clearScreen();
            scanner = new Scanner(System.in);
            System.out.println("Please select running mode first:");
            System.out.println("1) Find place by latitude and longitude.");
            System.out.println("2) QUIT");

            System.out.print("---Your choice: ");
            int ans = scanner.nextInt();
            if (ans == 1) {
                showNameByPos();
            } else if (ans == 2) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    private void showNameByPos() {
        Location location = new Location(0.,0.);
        System.out.println("\nPlease enter the latitude and longitude");

        System.out.print("---Latitude: ");
        double temp = scanner.nextFloat();
        location.setLat(temp);

        System.out.print("---Longitude: ");
        temp = scanner.nextFloat();
        location.setLng(temp);
        GetLocationInfoByLatlngPresenter presenter = new GetLocationInfoByLatlngPresenter();
        System.out.println(location.getLat());
        System.out.println(location.getLng());
        System.out.println(location.toString());

        presenter.getInfoByLatlng(location);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
